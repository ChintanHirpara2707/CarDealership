import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Initialize Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Main menu loop
        boolean exit = false;
        while (!exit) {
            System.out.println("Car Dealership Menu:");
            System.out.println("1. Dealer");
            System.out.println("2. User");
            System.out.println("3. Exit");
            System.out.println("======================================");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            // Switch statement to handle user choices
            switch (choice) {
                case 1:
                    // Display dealer menu
                    dealerMenu();
                    break;
                case 2:
                    // Display user menu
                    userMenu();
                    break;
                case 3:
                    // Exit the application
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        // Close scanner
        scanner.close();
    }
    
    // Function to handle dealer menu
    private static void dealerMenu() {
        // Initialize Scanner for user input
        Scanner scanner = new Scanner(System.in);
        // Initialize CarDAO for database operations
        CarDAO carDAO = new CarDAO();        
        // Dealer menu loop
        boolean exit = false;
        while (!exit) {
            System.out.println("======================================");
            System.out.println("Dealer Menu:");
            System.out.println("1. Add a new car");
            System.out.println("2. Display all cars");
            System.out.println("3. Update a car");
            System.out.println("4. Delete a car");
            System.out.println("5. Back to main menu");
            System.out.println("======================================");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            // Switch statement to handle dealer choices
            switch (choice) {
                case 1:
                    // Add a new car
                    addNewCar(carDAO, scanner);
                    break;
                case 2:
                    // Display all cars
                    displayAllCars(carDAO);
                    break;
                case 3:
                    // Update a car
                    updateCar(carDAO, scanner);
                    break;
                case 4:
                    // Delete a car
                    deleteCar(carDAO, scanner);
                    break;
                case 5:
                    // Return to main menu
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        // Close scanner
        scanner.close();
    }
    
    // Function to handle user menu
    private static void userMenu() {
        // Initialize Scanner for user input
        Scanner scanner = new Scanner(System.in);
        // Initialize CarDAO for database operations
        CarDAO carDAO = new CarDAO();
        // Initialize User for user operations
        User user = new User(carDAO);
        
        // User menu loop
        boolean exit = false;
        while (!exit) {
            System.out.println("User Menu:");
            System.out.println("1. View Available Cars");
            System.out.println("2. Buy a Car");
            System.out.println("3. Back to main menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            // Switch statement to handle user choices
            switch (choice) {
                case 1:
                    // View available cars
                    user.showAvailableCars();
                    break;
                case 2:
                    // Buy a car
                    buyCar(user, scanner);
                    break;
                case 3:
                    // Return to main menu
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        // Close scanner
        scanner.close();
    }
    
    // Function to add a new car
    private static void addNewCar(CarDAO carDAO, Scanner scanner) {
        System.out.println("======================================");
        System.out.print("Enter company:");
        String make = scanner.nextLine();
        System.out.print("Enter model:");
        String model = scanner.nextLine();
        System.out.print("Enter year:");
        int year = scanner.nextInt();
        System.out.print("Enter price:");
        double price = scanner.nextDouble();
        Car newCar = new Car(0, make, model, year, price);
        carDAO.addCar(newCar);
        System.out.println("New car added successfully: " + newCar);
    }
    
    // Function to display all cars
    private static void displayAllCars(CarDAO carDAO) {
        System.out.println("=========List of all cars:=========");
        for (Car car : carDAO.getCars()) {
            System.out.println(car);
        }
    }
    
    // Function to update a car
    private static void updateCar(CarDAO carDAO, Scanner scanner) {
        System.out.println("======================================");
        System.out.println("Enter the ID of the car to update:");
        int carIdToUpdate = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Enter new company:");
        String make = scanner.nextLine();
        System.out.println("Enter new model:");
        String model = scanner.nextLine();
        System.out.println("Enter new year:");
        int year = scanner.nextInt();
        System.out.println("Enter new price:");
        double price = scanner.nextDouble();
        Car updatedCar = new Car(carIdToUpdate, make, model, year, price);
        carDAO.updateCar(updatedCar);
        System.out.println("Car updated successfully: " + updatedCar);
    }
    
    // Function to delete a car
    private static void deleteCar(CarDAO carDAO, Scanner scanner) {
        System.out.println("======================================");
        System.out.println("Enter the ID of the car to delete:");
        int carIdToDelete = scanner.nextInt();
        carDAO.deleteCar(carIdToDelete);
        System.out.println("Car deleted successfully with ID: " + carIdToDelete);
    }
    
    // Function to handle buying a car
    private static void buyCar(User user, Scanner scanner) {
        System.out.print("Enter the ID of the car you want to buy: ");
        int carId = scanner.nextInt();
        scanner.nextLine();
        user.buyCar(carId);
    }
}
