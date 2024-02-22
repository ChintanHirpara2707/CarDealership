import java.sql.*;

public class Car {
    // Private member variables
    private int id;
    private String make;
    private String model;
    private int year;
    private double price;

    // Constructor to initialize Car object
    public Car(int id, String make, String model, int year, double price) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    // Getter method for retrieving car ID
    public int getId() {
        return id;
    }

    // Getter method for retrieving car make
    public String getMake() {
        return make;
    }

    // Getter method for retrieving car model
    public String getModel() {
        return model;
    }

    // Getter method for retrieving car year
    public int getYear() {
        return year;
    }

    // Getter method for retrieving car price
    public double getPrice() {
        return price;
    }

    // Override toString() method to provide string representation of Car object
    public String toString() {
        return "Car ID: " + id + ", Make: " + make + ", Model: " + model + ", Year: " + year + ", Price: $" + price;
    }
}
