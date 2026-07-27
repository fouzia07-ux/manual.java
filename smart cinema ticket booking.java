import java.util.Scanner;

public class MovieTicketBookingSystem {

    static int totalSeats;
    static int availableSeats;
    static int bookedSeats = 0;

    public static void bookTickets(int seats) {
        if (seats <= availableSeats) {
            availableSeats -= seats;
            bookedSeats += seats;
            System.out.println("Booking Successful!");
        } else {
            System.out.println("Booking Failed! Not enough seats available.");
        }
    }

    public static void cancelTickets(int seats) {
        if (seats <= bookedSeats) {
            bookedSeats -= seats;
            availableSeats += seats;
            System.out.println("Cancellation Successful!");
        } else {
            System.out.println("Cancellation Failed! You cannot cancel more tickets than booked.");
        }
    }

    public static void displaySeats() {
        System.out.println("Total Seats     : " + totalSeats);
        System.out.println("Booked Seats    : " + bookedSeats);
        System.out.println("Available Seats : " + availableSeats);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("     MOVIE TICKET BOOKING SYSTEM");
        System.out.println("====================================");

        System.out.print("Enter Total Number of Seats: ");
        totalSeats = sc.nextInt();
        availableSeats = totalSeats;

        int choice;

        do {
            System.out.println("\n---------- MENU ----------");
            System.out.println("1. Book Tickets");
            System.out.println("2. Cancel Tickets");
            System.out.println("3. View Available Seats");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter number of tickets to book: ");
                    int book = sc.nextInt();
                    bookTickets(book);
                    break;

                case 2:
                    System.out.print("Enter number of tickets to cancel: ");
                    int cancel = sc.nextInt();
                    cancelTickets(cancel);
                    break;

                case 3:
                    displaySeats();
                    break;

                case 4:
                    System.out.println("Thank you for using Movie Ticket Booking System!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}

