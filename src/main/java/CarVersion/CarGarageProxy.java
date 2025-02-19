package CarVersion;
import java.util.List;
public class CarGarageProxy implements ICarGarageProxy{
    private ICarAdapter carAdapter;

    public CarGarageProxy(ICarAdapter adapter) {
        this.carAdapter = adapter;
    }

    @Override
    public List<String> getCarInfo(int[] carIds) {
        return carAdapter.fetchCarData("Car_ID" + carIds.length );
    }

    @Override
    public void updateCarStatus(int[] carIds) {
        carAdapter.executeUpdate("Оновлене Car_ID" + carIds.length );
    }

    @Override
    public boolean checkGarageStatus() {
        return true;
    }

    @Override
    public void openGarage(String location) {
        carAdapter.connect(location);
    }

    @Override
    public void closeGarage() {
        carAdapter.disconnect();
    }

    @Override
    public void commit() {
        System.out.println("Оновлення автомобілів підтверджено.");
    }

    @Override
    public void rollback() {
        System.out.println("Відміна оновлення.");
    }
}
