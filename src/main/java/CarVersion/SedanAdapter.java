package CarVersion;
import java.util.List;
public class SedanAdapter implements ICarAdapter{
    private boolean isConnected = false;

    @Override
    public void connect(String location) {
        isConnected = true;
        System.out.println("Гараж для седана відчинений: " + location);
    }

    @Override
    public void disconnect() {
        isConnected = false;
        System.out.println("Гараж для седанів зачинений.");
    }

    @Override
    public List<String> fetchCarData(String query) {
        if (!isConnected) throw new IllegalStateException("Гараж для кросовера не відчинений!");
        return List.of("Дані про седан: " + query);
    }

    @Override
    public void executeUpdate(String query) {
        if (!isConnected) throw new IllegalStateException("Гараж для кросовера не відчинений!");
        System.out.println("Оновлені дані про седан: " + query);
    }
}
