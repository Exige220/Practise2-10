package CarVersion;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        ICarAdapter adapter;
        Scanner scanner = new  Scanner(System.in);

        System.out.println("Введіть тип автомобіля(Sedan, SUV, Truck): ");

        String carType = scanner.nextLine();
        scanner.nextLine();

        switch (carType) {
            case "Sedan":
                adapter = new SedanAdapter();
                break;
            case "SUV":
                adapter = new SUVAdapter();
                break;
            case "Truck":
                adapter = new TruckAdapter();
                break;
            default:
                throw new IllegalArgumentException("Невідомий тип автомобіля!");
        }

        ICarGarageProxy carGarageProxy = new CarGarageProxy(adapter);
        GarageController controller = new GarageController(carGarageProxy);
        controller.run();
    }
}
