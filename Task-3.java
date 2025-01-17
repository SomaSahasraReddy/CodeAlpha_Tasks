import java.util.ArrayList;
import java.util.Scanner;

class Room {
    private String roomNumber;
    private String category;
    private double price;
    private boolean isAvailable;

    public Room(String roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.isAvailable = true; // Room is available by default
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void reserve() {
        isAvailable = false; // Mark room as reserved
    }

    public void release() {
        isAvailable = true; // Mark room as available
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNumber + ", Category: " + category + ", Price: $" + price + ", Available: " + isAvailable;
    }
}

class Reservation {
    private Room room;
    private String customerName;

    public Reservation(Room room, String customerName) {
        this.room = room;
        this.customerName = customerName;
    }

    public Room getRoom() {
        return room;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public String toString() {
        return "Reservation for " + customerName + " - " + room.toString();
    }
}

public class HotelReservationSystem {
    private ArrayList<Room> rooms;
    private ArrayList<Reservation> reservations;

    public HotelReservationSystem() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        initializeRooms();
    }

    private void initializeRooms() {
        rooms.add(new Room("101", "Single", 100.0));
        rooms.add(new Room("102", "Double", 150.0));
        rooms.add(new Room("201", "Suite", 250.0));
        rooms.add(new Room("202", "Deluxe", 300.0));
    }

    public void searchAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room);
            }
        }
    }

    public void makeReservation(String customerName, String roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(roomNumber) && room.isAvailable()) {
                room.reserve();
                Reservation reservation = new Reservation(room, customerName);
                reservations.add(reservation);
                System.out.println("Reservation successful: " + reservation);
                return;
            }
        }
        System.out.println("Room not available or does not exist.");
    }

    public void viewReservations() {
        System.out.println("Current Reservations:");
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HotelReservationSystem hotel = new HotelReservationSystem();
        int choice;

        do {
            System.out.println("\n--- Hotel Reservation System ---");
            System.out.println("1. Search Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    hotel.searchAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter room number to reserve: ");
                    String roomNumber = scanner.nextLine();
                    hotel.makeReservation(name, roomNumber);
                    break;
                case 3:
                    hotel.viewReservations();
                    break;
                case 4:
                    System.out.println("Exiting the application. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}