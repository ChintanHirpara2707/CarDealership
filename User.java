import java.util.*;

public class User {
    // CarDAO instance for accessing car data
    private CarDAO carDAO;

    // Constructor to initialize User with a CarDAO instance
    public User(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    // Function to display available cars
    public void showAvailableCars() {
        // Retrieve list of available cars from CarDAO
        List<Car> cars = carDAO.getCars();
        // Print available cars
        System.out.println("Available Cars:");
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    // Function to buy a car
    public void buyCar(int carId) {
        // Retrieve car by ID from CarDAO
        Car car = carDAO.getCarById(carId);
        // If car exists, delete it from inventory and notify user
        if (car != null) {
            carDAO.deleteCar(carId);
            System.out.println("........................................");
            System.out.println("Congratulations! You have purchased car:");
            System.out.println(car);
        } else { // If car does not exist, notify user
            System.out.println("........................................");
            System.out.println("Car not found with ID: " + carId);
        }
    }

    // Main method to run the Car Dealership application
    public static void main(String[] args) {
        // Initialize CarDAO and User instances
        CarDAO carDAO = new CarDAO();
        User user = new User(carDAO);
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // Main menu loop
        while (!exit) {
            System.out.println("======================================");
            System.out.println("Welcome to the Car Dealership!");
            System.out.println("1. View Available Cars");
            System.out.println("2. Buy a Car");
            System.out.println("3. Exit");
            System.out.println("======================================");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            // Switch statement to handle user choices
            switch (choice) {
                case 1:
                    // Display available cars
                    user.showAvailableCars();
                    break;
                case 2:
                    // Prompt user to buy a car
                    System.out.println("======================================");
                    System.out.print("Enter the ID of the car you want to buy: ");
                    int carId = scanner.nextInt();
                    scanner.nextLine();
                    user.buyCar(carId);
                    break;
                case 3:
                    // Exit the application
                    exit = true;
                    break;
                default:
                    // Handle invalid choice
                    System.out.println("Invalid choice.");
            }
        }

        // Close scanner
        scanner.close();
    }
}
