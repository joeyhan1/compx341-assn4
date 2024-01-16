
import java.util.ArrayList;
import java.util.List;

/*
 * This class is used to hold all the devices for a household
 */
public class Household {

    // Declare variables
    public List<Device> deviceList;
    public String houseId;
    public String router;
    public String location;

    /*
     * Constructor
     */
    public Household() {
        this.deviceList = new ArrayList<>();
    }

    // Getters and setters
    public List<Device> getDevices() {
        return deviceList;
    }

    public String getId() {
        return houseId;
    }

    public String getLocation() {
        return location;
    }

    public String getRouter() {
        return router;
    }

    public void addDevice(Device device) {
        deviceList.add(device);
    }
}