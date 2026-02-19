package slidingGame;

import java.util.ArrayList;
import java.util.Collection;


/**
 * A template of a sliding game
 */
public class SlidingGame implements Configuration {

	public static final int N = 3, SIZE = N * N, HOLE = SIZE;
	/**
	 * The board is represented by a 2-dimensional array; the position of the hole
	 * is kept in 2 variables holeX and holeY
	 */
	private int[][] board;
	private int holeX, holeY;
	private int manhattanDist = 1337;
	private SlidingGame parent; 

	/**
	 * A constructor that initializes the board with the specified array
	 *
	 * @param start: a one dimensional array containing the initial board. The
	 *               elements of start are stored row-wise.
	 */
	public SlidingGame(int[] start) {
		board = new int[N][N];

		assert start.length == N * N : "Length of specified board incorrect";

		for (int p = 0; p < start.length; p++) {
			board[p % N][p / N] = start[p];
			if (start[p] == HOLE) {
				holeX = p % N;
				holeY = p / N;
			}
		}
	}

	public SlidingGame(int[][] board, int holeX, int holeY, SlidingGame parent) {
		this.board = board;
		this.holeX = holeX;
		this.holeY = holeY;
		this.parent = parent;
	}

	public int getManhattanDistance() {
		return manhattanDist;
	}
	
	public int[][] getBoard(){
		return board;
	}

	public int[][] copyBoard(){
		int[][] newBoard = new int[N][N];
		for(int x = 0; x < N; x++){
			for (int y = 0; y < N; y++) {
				newBoard[x][y] = board[x][y];
			}
		}
		return newBoard; 
	}

	/**
	 * Converts a board into a printable representation. The hole is displayed as a
	 * space
	 *
	 * @return the string representation
	 */
	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder();
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				int puzzel = board[col][row];
				buf.append(puzzel == HOLE ? "  " : puzzel + " ");
			}
			buf.append("\n");
		}
		return buf.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o){
			return true;
		} 

        if (o == null || !(o instanceof SlidingGame)){ 
			return false;
		}

        SlidingGame other = (SlidingGame) o;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (this.board[x][y] != other.board[x][y]) return false;
            }
        }
        return true;
	}

	@Override
	public boolean isSolution() {
		for(int x = 0; x < N; x++){
			for(int y = 0; y < N; y++){
				int expextedValue = y * N + x + 1;
				if(board[x][y] != expextedValue){
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public Collection<Configuration> successors() {
		ArrayList<Configuration> successors = new ArrayList<>();
		int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

		for(int i = 0; i < directions.length; i++){
			int newX = holeX + directions[i][0];
			int newY = holeY + directions[i][1];

			if(newX >= 0 && newX < N && newY >= 0 && newY < N ){
				int[][] newBoard = copyBoard();

				newBoard[holeX][holeY] = newBoard[newX][newY];
				newBoard[newX][newY] = HOLE;
				SlidingGame newConfGame = new SlidingGame(newBoard, newX, newY, this);
				successors.add(newConfGame);
			}
		}	
		
		return successors;
	}

	@Override
	public int compareTo(Configuration other) {
    if (other instanceof SlidingGame) {
        SlidingGame otherGame = (SlidingGame) other;
        return this.getManhattanDistance() - otherGame.getManhattanDistance();
    }
    return 0;
}

	@Override
	public Configuration getParent() {
		 return this.parent;
	}

	@Override
	public int hashCode() {
    int hash = 0;
    int factor = 1;
    for (int x = 0; x < N; x++) {
        for (int y = 0; y < N; y++) {
            hash += board[x][y] * factor;
            factor *= 31;
        }
    }
    return hash;
}

}
