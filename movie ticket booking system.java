import java.util.ArrayList;
import java.util.Scanner;

class Ticket {
    int id;
    String movieName;
    String customerName;
    int seats;
    double price;

    Ticket(int id, String movieName, String customerName, int seats, double price) {
        this.id = id;
        this.movieName = movieName;
        this.customerName = customerName;
        this.seats = seats;
        this.price = price;
    }

    double getTotal() {
        return seats * price;
    }
}

public class MovieTicketBooking {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Ticket> tickets = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== MOVIE TICKET BOOKING SYSTEM =====");
            System.out.println("1. Book Ticket");
            System.out.println("2. View Bookings");
            System.out.println("3. Search Booking");
            System.out.println("4. Update Booking");
            System.out.println("5. Cancel Booking");
            System.out.println("6. Total Collection");
            System.out.println("7. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Booking ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Movie Name: ");
                    String movie = sc.nextLine();

                    System.out.print("Enter Customer Name: ");
                    String customer = sc.nextLine();

                    System.out.print("Enter Number of Seats: ");
                    int seats = sc.nextInt();

                    System.out.print("Enter Ticket Price: ");
                    double price = sc.nextDouble();

                    tickets.add(new Ticket(id, movie, customer, seats, price));
                    System.out.println("Ticket Booked Successfully!");
                    break;

                case 2:
                    if (tickets.isEmpty()) {
                        System.out.println("No Bookings Available.");
                    } else {
                        System.out.println("\nID\tMovie\tCustomer\tSeats\tPrice\tTotal");
                        for (Ticket t : tickets) {
                            System.out.println(t.id + "\t" + t.movieName + "\t" + t.customerName + "\t\t" + t.seats + "\t" + t.price + "\t" + t.getTotal());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Booking ID to Search: ");
                    int sid = sc.nextInt();
                    boolean found = false;

                    for (Ticket t : tickets) {
                        if (t.id == sid) {
                            System.out.println("Booking Found");
                            System.out.println("Movie: " + t.movieName);
                            System.out.println("Customer: " + t.customerName);
                            System.out.println("Seats: " + t.seats);
                            System.out.println("Total Amount: " + t.getTotal());
                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Booking Not Found.");
                    break;

                case 4:
                    System.out.print("Enter Booking ID to Update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    found = false;

                    for (Ticket t : tickets) {
                        if (t.id == uid) {

                            System.out.print("Enter New Movie Name: ");
                            t.movieName = sc.nextLine();

                            System.out.print("Enter New Customer Name: ");
                            t.customerName = sc.nextLine();

                            System.out.print("Enter New Seats: ");
                            t.seats = sc.nextInt();

                            System.out.print("Enter New Ticket Price: ");
                            t.price = sc.nextDouble();

                            System.out.println("Booking Updated Successfully!");
                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Booking Not Found.");
                    break;

                case 5:
                    System.out.print("Enter Booking ID to Cancel: ");
                    int did = sc.nextInt();

                    found = false;

                    for (int i = 0; i < tickets.size(); i++) {
                        if (tickets.get(i).id == did) {
                            tickets.remove(i);
                            System.out.println("Booking Cancelled Successfully!");
                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Booking Not Found.");
                    break;

                case 6:
                    double total = 0;

                    for (Ticket t : tickets) {
                        total += t.getTotal();
                    }

                    System.out.println("Total Collection = ₹" + total);
                    break;

                case 7:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}
