
import java.util.Date;

/*
 * This class is for the Extender device type which implements the Encost Wifi Router device category class
 */
public class Extender extends EncostWifiRouter {

    public Extender(String deviceId, Date connected, String deviceName, Household household, String router,
            Boolean sends,
            Boolean receives) {
        super(deviceId, connected, deviceName, household, router, sends, receives);
    }
}