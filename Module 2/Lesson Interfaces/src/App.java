import java.util.Random;

public class App {
    /*public static void main(String[] args) {
        Vehicle truck = new Truck();
        Vehicle spaceship = new Spaceship();
        for (int i = 0; i < 7; i++){
            truck.accelerate();
            spaceship.accelerate();
        }

        System.out.println("truck: " + truck.getVelocityMessage());
        System.out.println("spaceship: " + spaceship.getVelocityMessage());
    }*/


    static Random random = new Random();

    public static void main(String[] args) {

        Vehicle[] vehicles = new Vehicle[10];

        for (int i = 0; i < vehicles.length; i++) {
            if (random.nextBoolean()) {
                vehicles[i] = new Truck();
            } else {
                vehicles[i] = new Spaceship();
            }
        }

        accelerateAllAndPrint(vehicles);
    }

    static void accelerateAllAndPrint(Vehicle[] vehicles) {

        for (int i = 0; i < vehicles.length; i++) {
            for (int accelIndex = 0; accelIndex < random.nextInt(8); accelIndex++) {
                vehicles[i].accelerate();
            }
        }

        for (int i = 0; i < vehicles.length; i++) {
            printVelocity(vehicles[i]);
        }
    }

    static void printVelocity(Vehicle vehicle) {
        System.out.println("Unknown vehicle velocity: " + vehicle.getVelocityMessage());
    }
}
