package CarVersion;
import java.util.List;
public class TruckAdapter implements ICarAdapter{
    private boolean isConnected = false;

    @Override
    public void connect(String location) {
        isConnected = true;
        System.out.println("Гараж для вантажівки відчинений: " + location);
    }

    @Override
    public void disconnect() {
        isConnected = false;
        System.out.println("Гараж для вантажівки зачинений.");
    }

    @Override
    public List<String> fetchCarData(String query) {
        if (!isConnected) throw new IllegalStateException("Гараж для вантажівки не відчинений!");
        return List.of("Дані про вантажівку: " + query);
    }

    @Override
    public void executeUpdate(String query) {
        if (!isConnected) throw new IllegalStateException("Гараж для вантажівки не відчинений!");
        System.out.println("Оновлені дані про вантажівку: " + query);
    }
}
