
import java.util.Date;

/*
 * This class is for the OtherLighting device type which implements the Encost Lighting device category class
 */
public class OtherLighting extends EncostLighting {

    public OtherLighting(String deviceId, Date connected, String deviceName, Household household, String router,
            Boolean sends,
            Boolean receives) {
        super(deviceId, connected, deviceName, household, router, sends, receives);
    }
}