
import java.util.Date;

/*
 * This class is for the Encost Appliance device category class that implements the Device class
 */
public class EncostAppliance extends Device {

    public EncostAppliance(
            String deviceId,
            Date connected,
            String deviceName,
            Household household,
            String router,
            Boolean sends,
            Boolean receives) {
        super(deviceId, connected, deviceName, household, router, sends, receives);
    }
}