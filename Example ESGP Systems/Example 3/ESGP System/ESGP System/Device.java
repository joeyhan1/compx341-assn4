
import java.util.Date;

/*
 * This class holds all the information related to a smart device
 */
public class Device {

    // Declare variables
    protected String deviceId;
    protected Date connected;
    protected Household household;
    protected String router;
    protected Boolean sends;
    protected Boolean receives;
    protected String deviceCategory;
    protected String deviceName;

    /*
     * Constructor
     */
    public Device(String deviceId, Date connected, String deviceName, Household household, String router, Boolean sends,
            Boolean receives) {

        this.deviceId = deviceId;
        this.connected = connected;
        this.household = household;
        this.router = router;
        this.sends = sends;
        this.receives = receives;
        this.deviceName = deviceName;
    }

    // Getters and setters
    public String getDeviceCat() {

        return this.deviceCategory;
    }

    public String getDeviceId() {

        return this.deviceId;
    }

    public Date getConnected() {

        return this.connected;
    }

    public Household getHouseHold() {

        return this.household;
    }

    public boolean getSends() {

        return this.sends;
    }

    public boolean getReceives() {

        return this.receives;
    }

    public String getRouter() {

        return this.router;
    }

    public void setDeviceCategory(String value) {

        this.deviceCategory = value;
    }
}