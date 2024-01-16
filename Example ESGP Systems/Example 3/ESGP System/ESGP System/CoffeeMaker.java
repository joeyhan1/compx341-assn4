
import java.util.Date;

/*
 * This class is for the Coffee Maker device type which implements the Encost Appliance device category class
 */
public class CoffeeMaker extends EncostAppliance {

    public CoffeeMaker(String deviceId, Date connected, String deviceName, Household household, String router,
            Boolean sends,
            Boolean receives) {
        super(deviceId, connected, deviceName, household, router, sends, receives);
    }
}