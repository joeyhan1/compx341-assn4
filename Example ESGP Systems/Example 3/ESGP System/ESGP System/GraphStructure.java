
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

/*
 * This class is used to hold all the neccessary information required to create a GraphStream object
 */
public class GraphStructure {

    // Declare variables
    public String ESHD_FILE_PATH = "./datasets/Encost Smart Homes Dataset (bigger).csv";
    public String CSS_FILE_PATH = new Scanner(GraphStructure.class.getResourceAsStream("stylesheet.css"),
            "UTF-8").useDelimiter("\\A").next();
    public List<Household> householdList = new ArrayList<>();
    public Graph graph;

    /*
     * Creates graph object
     */
    public void createGraph() {

        this.graph = new SingleGraph("ESGP");
    }

    /*
     * Loop through the households and devices creating nodes and adding them to the
     * graph
     */
    public void addNodes() {

        // For each household and device in the device list create a node and add it to
        // the graph
        for (Household household : householdList) {
            for (Device device : household.deviceList) {
                Node node = graph.addNode(device.getDeviceId());

                node.setAttribute("ui.label", device.getDeviceId());
                if (device.getDeviceCat() == "Encost Smart Appliances") {
                    node.setAttribute("ui.class", "appliances");
                }

                if (device.getDeviceCat() == "Encost Smart Lighting") {
                    node.setAttribute("ui.class", "lighting");
                }

                if (device.getDeviceCat() == "Encost Hubs/Controllers") {
                    node.setAttribute("ui.class", "controllers");
                }

                if (device.getDeviceCat() == "Encost Wifi Routers") {
                    node.setAttribute("ui.class", "routers");
                }

                if (device.getDeviceCat() == "Encost Smart Whiteware") {
                    node.setAttribute("ui.class", "whiteware");
                }
            }
        }
    }

    /*
     * Set Graph properties as per GraphStream documentation
     */
    public void setGraphProperty() {

        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
    }

    /*
     * Loop through households and devices adding edges to the graph stream graph
     */
    public void addEdges() {

        // For each household and device in the house, crate edges and add them to the
        // graph
        for (Household household : householdList) {
            for (Device device : household.deviceList) {

                // Only process devices that are not routers
                if (device.getRouter().compareTo("-") != 0) {

                    // Get sends and receives
                    Boolean sends = device.getSends();
                    Boolean receives = device.getReceives();

                    // If sends is true add a directed edge from device to router
                    if (sends) {
                        Edge devToRouter = graph.addEdge(device.getDeviceId() + device.getRouter(),
                                device.getDeviceId(), device.getRouter(), true);
                        devToRouter.setAttribute("ui.class", "edge");
                    }

                    // If receives is true then add a directed edge from router to device
                    if (receives) {
                        Edge routerToDev = graph.addEdge(device.getRouter() + device.getDeviceId(),
                                device.getRouter(), device.getDeviceId(), true);
                        routerToDev.setAttribute("ui.class", "edge");
                    }
                }
            }
        }
    }

    /*
     * Generates the graph to be displayed
     */
    public void displayGraph() {

        graph.display();
    }

    /*
     * Load the graph stream objects
     */
    public void loadGraphStreamGraph() {

        createGraph();
        setGraphProperty();
        this.graph.addAttribute("ui.stylesheet", CSS_FILE_PATH);
        addNodes();
        addEdges();
    }

    /*
     * Checks if a device id has been seen already, else add it to the list
     */
    public boolean checkRepeatedDeviceID(String deviceId) {

        boolean result = false;
        outerLoop: for (Household house : householdList) {
            for (Device device : house.deviceList) {
                if (device.getDeviceId().compareTo(deviceId) == 0) {
                    result = true;
                    System.out.println(
                            "Error code 006 repeated device Id. Please contact the software owner for assistance.");
                    break outerLoop;
                }
            }
        }

        return result;
    }

    /*
     * Converts a string to a date
     * https://stackoverflow.com/questions/999172/how-to-parse-a-date
     */
    public Date dateParser(String input) {

        Date date = null;
        SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yy");
        try {
            date = parser.parse(input);
        } catch (ParseException e) {
            System.out.println("Error code 003 date format. Please contact the software owner for assistance.");
        }
        return date;
    }

    /*
     * Checks if the household id is already created, else creates a new household
     * and adds to the householdlist
     */
    public Household processHousehold(String householdId) {

        // Check the first 3 characters are letters
        String regex = "^([a-zA-Z]{3}).*";
        Household household = null;

        // If the householdID matches the pattern, then check if the household has
        // already been created previously
        if (householdId.matches(regex)) {
            boolean found = false;
            for (Household existingHousehold : householdList) {
                if (existingHousehold.houseId.compareTo(householdId) == 0) {
                    household = existingHousehold;
                    found = true;
                }
            }

            // Household is new, therefore create a new household and add it
            if (found == false) {
                household = new Household();
                household.houseId = householdId;
                householdList.add(household);
            }
        } else {
            System.out.println(
                    "Error code 005. Incorrect household ID. Please contact the software owner for assistance.");
        }

        return household;
    }

    /*
     * Processes the send and receive capabilities for device and converts to a
     * boolean
     */
    public Boolean processSendReceive(String input) {

        Boolean result = null;
        if (input.compareTo("Yes") == 0) {
            result = true;
        } else if (input.compareTo("No") == 0) {
            result = false;
        } else {
            System.out.println(
                    "Error code 004. Send/Receive data wrong. Please contact the software owner for assistance.");
        }
        return result;
    }

    /*
     * Checks that there are 8 columns in the file
     */
    public Boolean checkLineParts(String[] parts) {

        Boolean result = true;
        if (parts.length != 8) {
            result = false;
            System.out.println(
                    "Error code 002 incorrect field count. Please contact the software owner for assistance.");
        }
        return result;
    }

    /*
     * Derives a device's category based on the device type
     */
    public String deriveDeviceCategory(Device device) {

        String deviceCat = "";
        if (EncostWifiRouter.class.isAssignableFrom(device.getClass())) {
            deviceCat = "Encost Wifi Routers";
        } else if (EncostHubController.class.isAssignableFrom(device.getClass())) {
            deviceCat = "Encost Hubs/Controllers";
        } else if (EncostLighting.class.isAssignableFrom(device.getClass())) {
            deviceCat = "Encost Smart Lighting";
        } else if (EncostAppliance.class.isAssignableFrom(device.getClass())) {
            deviceCat = "Encost Smart Appliances";
        } else if (EncostWhiteware.class.isAssignableFrom(device.getClass())) {
            deviceCat = "Encost Smart Whiteware";
        }

        return deviceCat;
    }

    /*
     * Derives the device category and adds that to the device category attribute
     * for a device. The device is added to the household
     */
    public void processDeviceCategory(String[] parts, Date date, Household household, Boolean send, Boolean receive) {

        // Parse device type column 4
        switch (parts[3]) {
            case "Router":

                Router router = new Router(parts[0], date, parts[2], household, parts[5], send,
                        receive);
                router.setDeviceCategory(deriveDeviceCategory(router));
                household.deviceList.add(router);
                household.router = parts[0];
                break;
            case "Extender":

                Extender extender = new Extender(parts[0], date, parts[2], household, parts[5],
                        send, receive);
                extender.setDeviceCategory(deriveDeviceCategory(extender));
                household.deviceList.add(extender);
                household.router = parts[0];
                break;
            case "Hub/Controller":

                HubController hubController = new HubController(parts[0], date, parts[2],
                        household, parts[5], send, receive);
                hubController.setDeviceCategory(deriveDeviceCategory(hubController));
                household.deviceList.add(hubController);
                break;
            case "Light Bulb":

                LightBulb lightBulb = new LightBulb(parts[0], date, parts[2],
                        household, parts[5], send, receive);
                lightBulb.setDeviceCategory(deriveDeviceCategory(lightBulb));
                household.deviceList.add(lightBulb);
                break;

            case "Strip Lighting":

                StripLighting stripLighting = new StripLighting(parts[0], date, parts[2],
                        household, parts[5], send, receive);
                stripLighting.setDeviceCategory(deriveDeviceCategory(stripLighting));
                household.deviceList.add(stripLighting);
                break;
            case "Other Lighting":

                OtherLighting otherLighting = new OtherLighting(parts[0], date, parts[2],
                        household, parts[5], send, receive);
                otherLighting.setDeviceCategory(deriveDeviceCategory(otherLighting));
                household.deviceList.add(otherLighting);
                break;
            case "Kettle":

                Kettle kettle = new Kettle(parts[0], date, parts[2],
                        household, parts[5], send, receive);
                kettle.setDeviceCategory(deriveDeviceCategory(kettle));
                household.deviceList.add(kettle);
                break;
            case "Toaster":

                Toaster toaster = new Toaster(parts[0], date, parts[2],
                        household, parts[5], send, receive);
                toaster.setDeviceCategory(deriveDeviceCategory(toaster));
                household.deviceList.add(toaster);
                break;
            case "Coffee Maker":

                CoffeeMaker coffeeMaker = new CoffeeMaker(parts[0], date, parts[2],
                        household, parts[5], send, receive);
                coffeeMaker.setDeviceCategory(deriveDeviceCategory(coffeeMaker));
                household.deviceList.add(coffeeMaker);
                break;
            case "Washing Machine/Dryer":

                WashingMachineDryer washingMachineDryer = new WashingMachineDryer(parts[0],
                        date, parts[2], household, parts[5], send, receive);
                washingMachineDryer.setDeviceCategory(deriveDeviceCategory(washingMachineDryer));
                household.deviceList.add(washingMachineDryer);
                break;
            case "Refrigerator/Freezer":

                RefrigeratorFreezer refrigeratorFreezer = new RefrigeratorFreezer(parts[0],
                        date, parts[2], household, parts[5], send, receive);
                refrigeratorFreezer.setDeviceCategory(deriveDeviceCategory(refrigeratorFreezer));
                household.deviceList.add(refrigeratorFreezer);
                break;
            case "Dishwasher":

                Dishwasher dishwasher = new Dishwasher(parts[0],
                        date, parts[2], household, parts[5], send, receive);
                dishwasher.setDeviceCategory(deriveDeviceCategory(dishwasher));
                household.deviceList.add(dishwasher);
                break;
            default:
                break;
        }
    }

    /*
     * Load in file and create devices
     */
    public Boolean processFile(String filePath) {

        Boolean result = true;
        try {

            // Create a buffered reader
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

            // Read in the header line which we can discard
            bufferedReader.readLine();

            // Read line-by-line until end of file is reached
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {

                // Split the line by comma
                String[] parts = line.split(",");

                // Check that there are correct number of values
                Boolean resultLineParts = checkLineParts(parts);
                if (resultLineParts == false) {
                    result = false;
                    break;
                }

                // Process date
                Date date = dateParser(parts[1]);
                if (date == null) {
                    result = false;
                    break;
                }

                // Process household id
                Household household = processHousehold(parts[4]);
                if (household == null) {
                    result = false;
                    break;
                }

                // Process send and receive
                Boolean send = processSendReceive(parts[6]);
                Boolean receive = processSendReceive(parts[7]);
                if (send == null || receive == null) {
                    result = false;
                    break;
                }

                // Process repeating line
                Boolean resultRepeatingLine = checkRepeatedDeviceID(parts[0]);
                if (resultRepeatingLine) {
                    result = false;
                    break;
                }

                // Process devicecategory
                processDeviceCategory(parts, date, household, send, receive);

            }

            // Close the reader
            bufferedReader.close();

        } catch (Exception e) {
            result = false;
            System.out
                    .println("Error code 001 cannot load ESHD file. Please contact the software owner for assistance.");
        }

        return result;
    }

    // Getter
    public Graph getGraph() {

        return this.graph;
    }
}