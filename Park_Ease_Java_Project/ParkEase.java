import java.io.*;
import java.util.Scanner;

// Interface for parking actions
interface ParkingOperations {
    void parkVehicle(String number, int wheels);
    void removeVehicle(int slotNumber, int hoursParked);
    void displaySlots();
}

// Abstract class for a vehicle (Encapsulated)
abstract class Vehicle {
    private String number;
    private int wheels;

    Vehicle(String number, int wheels) {
        this.number = number;
        this.wheels = wheels;
    }

    public String getNumber() {
        return number;
    }

    public int getWheels() {
        return wheels;
    }

    abstract String getType();
}

// Concrete class using inheritance
class SimpleVehicle extends Vehicle {
    SimpleVehicle(String number, int wheels) {
        super(number, wheels);
    }

    @Override
    String getType() {
        return (getWheels() == 2) ? "2-Wheeler" : "4-Wheeler";
    }
}

// Main Parking Lot class
class ParkingLot implements ParkingOperations {

    private static final int MAX_SLOTS = 5;
    private static int currentSlots = 0;

    // Nested Slot class (Encapsulated)
    class Slot {
        private int slotNumber;
        private Vehicle vehicle;

        Slot(int slotNumber, Vehicle vehicle) {
            this.slotNumber = slotNumber;
            this.vehicle = vehicle;
        }

        public int getSlotNumber() {
            return slotNumber;
        }

        public Vehicle getVehicle() {
            return vehicle;
        }
    }

    private Slot[] slots = new Slot[MAX_SLOTS];

    // Park a vehicle
    public void parkVehicle(String number, int wheels) {
        if (wheels != 2 && wheels != 4) {
            System.out.println("[ERROR] Only 2 or 4 wheelers allowed.");
            return;
        }

        if (currentSlots >= MAX_SLOTS) {
            System.out.println("[ERROR] Parking lot full.");
            return;
        }

        int emptyIndex = -1;
        for (int i = 0; i < MAX_SLOTS; i++) {
            if (slots[i] == null) {
                emptyIndex = i;
                break;
            }
        }

        if (emptyIndex == -1) {
            System.out.println("[ERROR] No empty slots found.");
            return;
        }

        Vehicle vehicle = new SimpleVehicle(number, wheels);
        slots[emptyIndex] = new Slot(emptyIndex + 1, vehicle);
        System.out.println("[SUCCESS] Parked at slot " + (emptyIndex + 1));
        currentSlots++;
    }

    // Remove a vehicle and write to CSV
    public void removeVehicle(int slotNumber, int hoursParked) {
        if (slotNumber < 1 || slotNumber > MAX_SLOTS || slots[slotNumber - 1] == null) {
            System.out.println("[ERROR] Invalid or empty slot.");
            return;
        }

        Slot slot = slots[slotNumber - 1];
        Vehicle vehicle = slot.getVehicle();

        int rate = (vehicle.getWheels() == 2) ? 5 : 10;
        int charge = rate * hoursParked;

        // Show basic charge info first
        System.out.println("Charge: Rs. " + charge);

        Scanner sc = new Scanner(System.in);
        System.out.print("Do you want to view the detailed receipt? (yes/no): ");
        String choice = sc.nextLine().trim().toLowerCase();

        if (choice.equals("yes")) {
            System.out.println("\n========== ParkEase Receipt ==========");
            System.out.println("Slot Number : " + slot.getSlotNumber());
            System.out.println("Vehicle Type: " + vehicle.getType());
            System.out.println("Vehicle No. : " + vehicle.getNumber());
            System.out.println("Hours Parked: " + hoursParked);
            System.out.println("Rate per Hr : Rs. " + rate);
            System.out.println("Total Charge: Rs. " + charge);
            System.out.println("======================================");
        }

        // Save to CSV
        File csvFile = new File("checkout_history.csv");
        boolean fileExists = csvFile.exists();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile, true))) {
            if (!fileExists) {
                writer.write("Vehicle Number,Type,Hours Parked,Charge");
                writer.newLine();
            }
            writer.write(vehicle.getNumber() + "," + vehicle.getType() + "," + hoursParked + "," + charge);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("[ERROR] Could not write to CSV. Please close the file if it's open and try again.");
        }

        slots[slotNumber - 1] = null;
        currentSlots--;
    }

    // Show parking slots
    public void displaySlots() {
        StringBuilder sb = new StringBuilder("Parking Slot Status:\n");
        for (int i = 0; i < MAX_SLOTS; i++) {
            if (slots[i] != null) {
                sb.append("Slot ").append(slots[i].getSlotNumber()).append(": ")
                        .append(slots[i].getVehicle().getType()).append(" - ")
                        .append(slots[i].getVehicle().getNumber()).append("\n");
            } else {
                sb.append("Slot ").append(i + 1).append(": Empty\n");
            }
        }
        System.out.println(sb);
    }
}

// Main application class
public class ParkEase{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingLot lot = new ParkingLot();

        while (true) {
            System.out.println("\n=== ParkEase Menu ===");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. Display Slots");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter vehicle number (e.g. 1223, KA 01 B 1234, KA 02 BA 1332): ");
                    sc.nextLine(); // clear buffer
                    String number = sc.nextLine().trim().toUpperCase();

                    String pattern = "^(\\d{3,4}|[A-Z]{2} \\d{2} [A-Z]{1,2} \\d{4})$";
                    if (!number.matches(pattern)) {
                        System.out.println("[ERROR] Invalid vehicle number format.");
                        break;
                    }

                    System.out.print("Enter number of wheels (2 or 4): ");
                    int wheels = sc.nextInt();
                    lot.parkVehicle(number, wheels);
                    break;

                case 2:
                    System.out.print("Enter slot number to remove: ");
                    int slot = sc.nextInt();
                    System.out.print("Enter number of hours parked: ");
                    int hours = sc.nextInt();
                    lot.removeVehicle(slot, hours);
                    break;

                case 3:
                    lot.displaySlots();
                    break;

                case 4:
                    System.out.println("Exiting system.");
                    return;

                default:
                    System.out.println("[ERROR] Invalid option. Try again.");
            }
        }
    }
}
