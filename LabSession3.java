class Vehicle {
    String brand;

    Vehicle(String brand) {
        this.brand = brand;
    }

    void displayInfo() {
        System.out.println("Vehicle Brand: " + brand);
    }
}

class Car extends Vehicle {
    int wheels;

    Car(String brand, int wheels) {
        super(brand);
        this.wheels = wheels;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Wheels: " + wheels);
    }
}

class ElectricCar extends Car {
    int batteryCapacity;

    ElectricCar(String brand, int wheels, int batteryCapacity) {
        super(brand, wheels);
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Battery Capacity (kWh): " + batteryCapacity);
    }
}

public class LabSession3 {
    public static void main(String[] args) {
        Vehicle v = new Vehicle("Generic Vehicle");
        Car c = new Car("Toyota", 4);
        ElectricCar e = new ElectricCar("Tesla", 4, 100);

        v.displayInfo();
        System.out.println();
        c.displayInfo();
        System.out.println();
        e.displayInfo();
    }
}