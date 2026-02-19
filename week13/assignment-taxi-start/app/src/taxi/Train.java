package taxi;

/**
 * Trains bring a number of passengers to a station in the Taxi simulation
 */
public class Train implements Runnable{
	private int nrOfPassengers;
	private final Station station;
	private int nrOfTrips = 0;
	private final int maxTrips = 10;
	private int nrTripsDone = 0;

	public Train(Station station) {
		this.station = station;
		this.nrOfPassengers = 0;

	}

	@Override
	public void run() {
		try {
			while(nrTripsDone < maxTrips){
                station.waitForEmptyStation();

				loadPassengers(Util.getRandomNumber(1, 10));
				nrTripsDone++;

				Thread.sleep(Util.getRandomNumber(100, 500));

				unloadPassengers();
			}
			closeStation();
		}
		catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}
	/**
	 * Populate this train with number nrOfPassengers
	 *
	 * @param number the number of passengers of this train
	 */
	public void loadPassengers(int number) {
		nrOfPassengers = number;
	}

	/**
	 * empties this train and augment the number of Passengers at the station with
	 * this nrOfPassenegers
	 */
	public void unloadPassengers() {
		nrOfTrips += 1;
		station.enterStation(nrOfPassengers);
		nrOfPassengers = 0;
	}

	public void closeStation() {
		station.close();
	}

	public int getNrOfTrips() {
		return nrOfTrips;
	}
}