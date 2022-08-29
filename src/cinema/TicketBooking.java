package cinema;

import java.util.Scanner;

public class TicketBooking {
    private CinemaRoom cinemaRoom;
    private Scanner scanner = new Scanner(System.in);

    private int numberOfRows;
    private int numberOfSeats;

    private int numberOfBookedSeats;

    private CinemaCalculator calculator;

    private void cinemaRoomSetting() {
        System.out.println("Enter the number of rows:");
        numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        numberOfSeats = scanner.nextInt();
        cinemaRoom = new CinemaRoom(numberOfRows, numberOfSeats);
        calculator = new CinemaCalculator(numberOfSeats, numberOfRows);
    }

    private void  bookingProcess() {
        while (true) {
            //ask abut the seat coordinates
            System.out.println("Enter a row number:");
            int row = scanner.nextInt();

            System.out.println("Enter a seat number in that row:");
            int seat = scanner.nextInt();
            //chick if it is in right posision
            if (row > numberOfRows || seat > numberOfSeats){
                System.out.println("Wrong input!");
                continue;
            }
            //check if it is already purchased
            if (cinemaRoom.isSeatPurchased(row, seat)){
                System.out.println("That ticket has already been purchased!");
                continue;
            }else {
                System.out.println("Ticket price: " + "$" +
                        calculator.calculateTicketPrice(numberOfRows, numberOfSeats, row));
                cinemaRoom.updates(row, seat);
                numberOfBookedSeats++;
                break;
            }
        }
    }

    private boolean isRightCoordinates(int row, int seat) {
        return row <= numberOfRows && seat <= numberOfSeats;
    }

    public void booking() {
        cinemaRoomSetting();
        while (true) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            int chooise = scanner.nextInt();
            if (chooise == 1)
                displayTheCinemaRoom();
            if (chooise == 2)
                bookingProcess();
            if (chooise == 3)
                statistics();
            if (chooise == 0)
                break;
        }
    }

    private void displayTheCinemaRoom() {
        cinemaRoom.print();
    }

    public void statistics() {
        System.out.println("Number of purchased tickets: " + numberOfBookedSeats);
        String s = String.format("percentage : %.2f",
                calculator.getPercentageOfPurchasedTickets(numberOfBookedSeats));
        System.out.println("Percentage : "+s+"%");

        System.out.println("Current income: " + "$" +calculator.getCurrentIncome());
        System.out.println("Total income: " + "$" + calculator.getTotalIncome());
    }
}

