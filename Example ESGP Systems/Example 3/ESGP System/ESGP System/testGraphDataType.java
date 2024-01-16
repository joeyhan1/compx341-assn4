
import java.util.Date;

import org.graphstream.graph.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class testGraphDataType {

    // TESTING: 2 devices exist in the graph structure
    // EXPECTED: devices exist in graph structure
    @Test
    @DisplayName("Testing that 2 devices exist in the graph structure")
    public void checkDevices() {

        // ASSIGN
        GraphStructure graphStructure = new GraphStructure();

        // Create Device #1
        String[] parts = new String[8];
        parts[0] = "EWR-1357";
        parts[1] = "02/02/23";
        parts[2] = "Encost Router 360";
        parts[3] = "Router";
        parts[4] = "BOP-7654";
        parts[5] = "-";
        parts[6] = "Yes";
        parts[7] = "Yes";
        Date date = graphStructure.dateParser(parts[1]);
        Household household = graphStructure.processHousehold(parts[4]);
        Boolean send = graphStructure.processSendReceive(parts[6]);
        Boolean receive = graphStructure.processSendReceive(parts[7]);

        // Create Device #2
        String[] parts1 = new String[8];
        parts1[0] = "ELB-3579";
        parts1[1] = "02/02/23";
        parts1[2] = "Encost Novelty Light(giraffe)";
        parts1[3] = "Other Lighting";
        parts1[4] = "BOP-7654";
        parts1[5] = "EWR-1357";
        parts1[6] = "No";
        parts1[7] = "Yes";
        Date date1 = graphStructure.dateParser(parts1[1]);
        Household household1 = graphStructure.processHousehold(parts1[4]);
        Boolean send1 = graphStructure.processSendReceive(parts1[6]);
        Boolean receive1 = graphStructure.processSendReceive(parts1[7]);

        // Add devices to the household and device list
        graphStructure.processDeviceCategory(parts, date, household, send, receive);
        graphStructure.processDeviceCategory(parts1, date1, household1, send1,
                receive1);

        // ACT
        graphStructure.loadGraphStreamGraph();
        Node node1 = graphStructure.graph.getNode("ELB-3579");
        Node node2 = graphStructure.graph.getNode("EWR-1357");

        // ASSERT
        Assertions.assertNotNull(node1);
        Assertions.assertNotNull(node2);
    }

    // This method of checking a device category has already been tested thoroughly
    // in the derive device categories test suite.
    @Test
    public void checkCategories() {

        // Boolean passAll = true;

        // List<String> allTypes = new ArrayList<>();
        // allTypes.add("Router");
        // allTypes.add("Extender");
        // allTypes.add("Hub/Controller");
        // allTypes.add("Light Bulb");
        // allTypes.add("Strip Lighting");
        // allTypes.add("Other Lighting");
        // allTypes.add("Kettle");
        // allTypes.add("Toaster");
        // allTypes.add("Coffee Maker");
        // allTypes.add("Washing Machine/Dryer");
        // allTypes.add("Refrigerator/Freezer");
        // allTypes.add("Dishwasher");

        // List<String> categories = new ArrayList<>();
        // categories.add("Encost Wifi Routers");
        // categories.add("Encost Wifi Routers");
        // categories.add("Encost Hubs/Controllers");
        // categories.add("Encost Smart Lighting");
        // categories.add("Encost Smart Lighting");
        // categories.add("Encost Smart Lighting");
        // categories.add("Encost Smart Appliances");
        // categories.add("Encost Smart Appliances");
        // categories.add("Encost Smart Appliances");
        // categories.add("Encost Smart Whiteware");
        // categories.add("Encost Smart Whiteware");
        // categories.add("Encost Smart Whiteware");

        // for (int i = 0; i < allTypes.size(); i++) {
        // String category = getCategory(allTypes.get(i));
        // if (category != categories.get(i)) {
        // passAll = false;
        // }

        // }

        // Assertions.assertTrue(passAll);
        Assertions.assertTrue(false);
    }

}