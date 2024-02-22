import java.sql.*;
import java.util.*;

public class CarDAO {
    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/car_dealership";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    // Function to add a new car to the database
    public void addCar(Car car) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            // Construct SQL query to insert car details
            String sql = "INSERT INTO car_inventory (make, model, year, price) VALUES ('" + car.getMake() + "', '" + car.getModel() + "', " + car.getYear() + ", " + car.getPrice() + ")";
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Function to update an existing car's details in the database
    public void updateCar(Car updatedCar) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            // Construct SQL query to update car details based on car ID
            String sql = "UPDATE car_inventory SET make='" + updatedCar.getMake() + "', model='" + updatedCar.getModel() + "', year=" + updatedCar.getYear() + ", price=" + updatedCar.getPrice() + " WHERE car_id=" + updatedCar.getId();
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Function to delete a car from the database based on its ID
    public void deleteCar(int carIdToDelete) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            // Construct SQL query to delete a car based on its ID
            String sql = "DELETE FROM car_inventory WHERE car_id=" + carIdToDelete;
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Function to retrieve a list of all cars from the database
    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            // Construct SQL query to select all cars from the database
            String sql = "SELECT * FROM car_inventory";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                // Iterate through the result set and add each car to the list
                while (resultSet.next()) {
                    int id = resultSet.getInt("car_id");
                    String make = resultSet.getString("make");
                    String model = resultSet.getString("model");
                    int year = resultSet.getInt("year");
                    double price = resultSet.getDouble("price");
                    cars.add(new Car(id, make, model, year, price));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    // Function to retrieve a car from the database based on its ID
    public Car getCarById(int carId) {
        Car car = null;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            // Construct SQL query to select a car based on its ID
            String sql = "SELECT * FROM car_inventory WHERE car_id=" + carId;
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                // If a car with the specified ID exists, create a Car object with its details
                if (resultSet.next()) {
                    int id = resultSet.getInt("car_id");
                    String make = resultSet.getString("make");
                    String model = resultSet.getString("model");
                    int year = resultSet.getInt("year");
                    double price = resultSet.getDouble("price");
                    car = new Car(id, make, model, year, price);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }
}
