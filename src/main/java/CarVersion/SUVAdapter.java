package CarVersion;
import java.util.List;
public class SUVAdapter implements ICarAdapter {
    private boolean isConnected = false;

    @Override
    public void connect(String location) {
        isConnected = true;
        System.out.println("Гараж для кросовера відчинений: " + location);
    }

    @Override
    public void disconnect() {
        isConnected = false;
        System.out.println("Гараж для кросовера зачинений.");
    }

    @Override
    public List<String> fetchCarData(String query) {
        if (!isConnected) throw new IllegalStateException("Гараж для кросовера не відчинений!");
        return List.of("Дані про кросовер: " + query);
    }

    @Override
    public void executeUpdate(String query) {
        if (!isConnected) throw new IllegalStateException("Гараж для кросовера не відчинений!");
        System.out.println("Оновлені дані про кросовер: " + query);
    }
}
