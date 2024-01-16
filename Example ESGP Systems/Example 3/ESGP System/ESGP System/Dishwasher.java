
import java.util.Date;

/*
 * This class is for the Dishwasher device type which implements the Encost Whiteware device category class
 */
public class Dishwasher extends EncostWhiteware {

    public Dishwasher(String deviceId, Date connected, String deviceName, Household household, String router,
            Boolean sends,
            Boolean receives) {
        super(deviceId, connected, deviceName, household, router, sends, receives);
    }
}