
import java.util.Date;

/*
 * This class is for the HubController device type which implements the Encost HubController device category class
 */
public class HubController extends EncostHubController {

    public HubController(String deviceId, Date connected, String deviceName, Household household, String router,
            Boolean sends,
            Boolean receives) {
        super(deviceId, connected, deviceName, household, router, sends, receives);
    }
}