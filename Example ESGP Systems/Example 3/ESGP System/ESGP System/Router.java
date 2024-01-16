


import java.util.Date;

/*
 * This class is for the Router device type which implements the Encost Wifi Router device category class
 */
public class Router extends EncostWifiRouter {

    public Router(String deviceId, Date connected, String deviceName, Household household, String router, Boolean sends,
            Boolean receives) {
        super(deviceId, connected, deviceName, household, router, sends, receives);
    }
}