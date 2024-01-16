
import java.util.Date;

/*
 * This class is for the WashingMachineDryer device type which implements the Encost Whiteware device category class
 */
public class WashingMachineDryer extends EncostWhiteware {

    public WashingMachineDryer(String deviceId, Date connected, String deviceName, Household household, String router,
            Boolean sends,
            Boolean receives) {
        super(deviceId, connected, deviceName, household, router, sends, receives);
    }
}