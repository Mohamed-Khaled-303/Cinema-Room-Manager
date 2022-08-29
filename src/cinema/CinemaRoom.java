package cinema;

import java.util.Arrays;

public class CinemaRoom {
    private int row;
    private int seatsInRow;
    private char[][] cinemaRoom;
    String numberOfColumns = "";

    public CinemaRoom(int row, int seatsInRow) {
        this.row = row;
        this.seatsInRow = seatsInRow;
        cinemaRoom = new char[row][seatsInRow];
        emptyCinemaRoom();
    }

    private void emptyCinemaRoom() {
        for (char[] row : cinemaRoom) {
            Arrays.fill(row, 'S');
        }
    }

    public void print() {
        System.out.println("Cinema:");
        if (numberOfColumns == "") {
            for (var i = 1; i <= seatsInRow; i++) {
                numberOfColumns += i;
                numberOfColumns += " ";
            }
        }
        System.out.println("  " + numberOfColumns);
        for (int i = 0; i < cinemaRoom.length; i++) {
            System.out.print((i + 1) + " ");
            String seats = "";
            for (int j = 0; j < cinemaRoom[i].length; j++) {
                seats += cinemaRoom[i][j];
                seats += ' ';
            }
            System.out.print(seats + "\n");
        }
    }

    public int getNumberOfRows() {
        return row;
    }

    public int getNumberOfSeatsInRow() {
        return seatsInRow;
    }

    public int getNumberOfSeats() {
        return row * seatsInRow;
    }

    public boolean isSeatPurchased(int row, int seat) {
        return cinemaRoom[row - 1][seat - 1] == 'B';
    }
    public void updates(int row, int seat){
        cinemaRoom[row - 1][seat - 1] = 'B';

    }
}

