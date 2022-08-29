package cinema;

import java.util.Scanner;

public class CinemaCalculator {
    private int totalNumberOFSeats;
    private int numberOfSeats;
    private int numberOfRows;

    private int currentIncome;

    public CinemaCalculator(int numberOfSeats, int numberOfRows) {
        this.numberOfRows = numberOfRows;
        this.numberOfSeats = numberOfSeats;
        totalNumberOFSeats = numberOfRows * numberOfSeats;
    }
    public int getTotalIncome() {
        if (totalNumberOFSeats <= 60)
            return getTotalNumberOfSeats() * 10;
        else {
            return frontHalfRows() * numberOfSeats * 10 + backHalfRows() * numberOfSeats * 8;
        }
    }

    public int calculateTicketPrice(int numberOfRows, int numberOfSeats, int row) {
        Scanner scanner = new Scanner(System.in);
        this.numberOfSeats = numberOfSeats;
        this.numberOfRows = numberOfRows;

        totalNumberOFSeats = numberOfRows * numberOfSeats;
        if (totalNumberOFSeats < 60) {
            currentIncome += 10;
            return 10;
        }
        if (row <= frontHalfRows()){
            currentIncome += 10;
            return 10;
        }
        currentIncome += 8;
        return 8;
    }

    public int getCurrentIncome() {
        return currentIncome;
    }

    private int getTotalNumberOfSeats() {
        return numberOfRows * numberOfSeats;
    }

    private int frontHalfRows() {
        return numberOfRows / 2;
    }

    private int backHalfRows() {
        return numberOfRows - frontHalfRows();
    }

    public int getTotalNumberOFSeats() {
        return totalNumberOFSeats;
    }

    public float getPercentageOfPurchasedTickets(int numberOfBookedSeats) {
        if (numberOfBookedSeats == 0)
            return 0;
        return (float) (numberOfBookedSeats * 100) / totalNumberOFSeats;
    }

}

