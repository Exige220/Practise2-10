package CarVersion;
import java.util.List;
public interface ICarGarageProxy {
    List<String> getCarInfo(int[] carIds);
    void updateCarStatus(int[] carIds);
    boolean checkGarageStatus();
    void openGarage(String location);
    void closeGarage();
    void commit();
    void rollback();
}
