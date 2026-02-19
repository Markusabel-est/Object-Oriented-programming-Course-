package taxi;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

/**
 * Class that holds the number of persons arriving by train at the station and
 * waiting for a taxi
 */
public class Station {

	private int nrOfPassengersAtStation = 0;
	private int totalNrOfPassengers = 0;
	private boolean isClosed = false;
	private final Lock lock = new ReentrantLock();
	private final Condition hasPassenger = lock.newCondition();
	private final Condition noPassenger = lock.newCondition();

	public void enterStation(int nrOfPassengers) {
		lock.lock();
		try {
			if (isClosed) {
				return;
			}
			nrOfPassengersAtStation += nrOfPassengers;
			totalNrOfPassengers += nrOfPassengers;
			System.out.println(nrOfPassengers + " passengers arrived at station");
			hasPassenger.signalAll();
		}
		finally {
			lock.unlock();
		}
	}
	public void waitForEmptyStation() {
		lock.lock();
		try {
			while (nrOfPassengersAtStation > 0 && !isClosed) {
				noPassenger.await();
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}finally {
			lock.unlock();
		}
	}

	/**
	 * Ask for nrOfPassengers Passengers to leave the station
	 *
	 * @param requestedNrOfPassengers
	 * @return number of passengers actually leaving
	 */
	public int leaveStation(int requestedNrOfPassengers) {
		lock.lock();
		try {
			while (nrOfPassengersAtStation == 0 && !isClosed) {
				hasPassenger.await();
			}
			if(nrOfPassengersAtStation == 0 && isClosed){
				return 0;
			}

			int actuallyLeaving = Math.min(requestedNrOfPassengers, nrOfPassengersAtStation);
			nrOfPassengersAtStation -= actuallyLeaving;

			if (nrOfPassengersAtStation == 0) {
				noPassenger.signal();
			}
			return actuallyLeaving;

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		finally {
			lock.unlock();
		}
	}


	public int waitingPassengers() {
		lock.lock();
		try {
			return nrOfPassengersAtStation;
		}finally {
			lock.unlock();
		}
	}

	public void close() {
		lock.lock();
		try {
			isClosed = true;
			hasPassenger.signalAll();
			noPassenger.signalAll();

		}finally {
			lock.unlock();
		}
	}

	public boolean isClosed() {
		lock.lock();
		try {
			return isClosed;
		}finally {
			lock.unlock();
		}
	}

	public int getTotalNrOfPassengers() {
		lock.lock();
		try {
			return totalNrOfPassengers;
		}finally {
			lock.unlock();
		}
	}
}