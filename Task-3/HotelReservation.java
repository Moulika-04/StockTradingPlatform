import java.util.*;
 public class HotelReservation
 {
    static class HotelRoom 
    {
        String roomType;
        boolean isBooked;
        double price;
        HotelRoom(String roomType, double price) 
        {
            this.roomType = roomType;
            this.price = price;
            this.isBooked = false;
        }
        public String toString() 
        {
            return roomType + " | Price per day: " + price + " | Status: " + (isBooked ? "Booked" : "Available");
        }
    }
    static ArrayList<HotelRoom> rooms = new ArrayList<>();
    public static void setupRooms()
    {
        rooms.add(new HotelRoom("Standard", 1500));
        rooms.add(new HotelRoom("Deluxe", 2500));
        rooms.add(new HotelRoom("Suite", 4000));
    }
    public static void showRooms() 
    {
        System.out.println("\n Room Details:");
        for (HotelRoom room :rooms)
        {
            System.out.println(room);
        }
    }
    public static void bookRoomByType(String type, int days) 
    {
        for(HotelRoom room :rooms)
        {
            if (room.roomType.equalsIgnoreCase(type)) 
            {
                if(!room.isBooked)
                {
                    room.isBooked=true;
                    double totalCost=room.price * days;
                    System.out.println(" "+ type + "room booked for"+ days +"day(s).");
                    System.out.println("Total cost: " + totalCost);
                    return;
                }
                else 
                {
                    System.out.println(" "+ type + "This room is already booked.");
                    return;
                }
            }
        }
        System.out.println(" Room type is not found.");
    }
    public static void cancelBookingByType(String type) 
    {
        for(HotelRoom room: rooms)
        {
            if (room.roomType.equalsIgnoreCase(type)) 
            {
                if (room.isBooked)
                {
                    room.isBooked = false;
                    System.out.println("Booking cancelled for: " + type);
                    return;
                }
                else 
                {
                    System.out.println(" " + type + "Room is not booked.");
                    return;
                }
            }
        }
        System.out.println("Room type not found.");
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int choice;
        setupRooms();
        System.out.println("Welcome to  Taj Hotel Reservation System!");
        do {
            System.out.println("\n====== MENU ======");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) 
            {
                case 1:
                    showRooms();
                    break;
                case 2:
                    System.out.println("Enter room type to book (Standard/Deluxe/Suite): ");
                    String type = sc.nextLine();
                    System.out.println("Enter number of days to stay: ");
                    int days = sc.nextInt();
                    bookRoomByType(type, days);
                    break;
                case 3:
                    System.out.println("Enter room type to cancel (Standard/Deluxe/Suite): ");
                    String cancelType = sc.nextLine();
                    cancelBookingByType(cancelType);
                    break;
                case 4:
                    System.out.println("Thank you for using our hotel. Visit again!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } 
        while (choice != 4);
        sc.close();
    }
}

