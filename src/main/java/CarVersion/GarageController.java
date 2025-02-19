package CarVersion;

public class GarageController {
    private ICarGarageProxy carGarageProxy;

    public GarageController(ICarGarageProxy carGarageProxy) {
        this.carGarageProxy = carGarageProxy;
    }

    public void run() {
        carGarageProxy.openGarage("Гараж в центрі міста");

        if (carGarageProxy.checkGarageStatus()) {
            int[] carIds = {101, 202, 303};
            System.out.println("Отримані дані: " + carGarageProxy.getCarInfo(carIds));
            carGarageProxy.updateCarStatus(carIds);
            carGarageProxy.commit();
        }

        carGarageProxy.closeGarage();
    }
}
