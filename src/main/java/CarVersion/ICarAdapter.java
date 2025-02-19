package CarVersion;
import java.util.List;
public interface ICarAdapter {
    void connect(String location);
    void disconnect();
    List<String> fetchCarData(String query);
    void executeUpdate(String query);
}
