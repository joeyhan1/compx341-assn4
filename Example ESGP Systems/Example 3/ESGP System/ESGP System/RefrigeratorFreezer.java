
import java.util.Date;

/*
 * This class is for the RefrigeratorFreezer device type which implements the Encost Whiteware device category class
 */
public class RefrigeratorFreezer extends EncostWhiteware {

    public RefrigeratorFreezer(String deviceId, Date connected, String deviceName, Household household, String router,
            Boolean sends,
            Boolean receives) {
        super(deviceId, connected, deviceName, household, router, sends, receives);
    }
}