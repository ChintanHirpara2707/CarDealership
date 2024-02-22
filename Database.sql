//Create a Databse car_dealership
//After add a Table car_inventory


CREATE TABLE car_inventory (
    car_id INT AUTO_INCREMENT PRIMARY KEY,
    make VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    year INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);
