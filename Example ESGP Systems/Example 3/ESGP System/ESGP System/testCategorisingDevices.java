
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class testCategorisingDevices {

    // This test has been rewritten as the software has been developed to implement
    // the deriving of device category through class inheritance as outlined in the
    // SDS document. Deriving device category by device ID is not possible.
    @Test
    @DisplayName("Manually failed test. See comments for explanation")
    public void checkingData() {

        // // insert FULL filepath of the dataset: testingDataset4.csv
        // String filepath = "testingDataset4.csv";

        // // set the default data path
        // eshDatasetPath = filepath;

        // Dictionary<String, String> dict = new Hashtable<>();
        // dict.put("EWR-1234", "Encost Wifi Routers");
        // dict.put("ELB-4567", "Encost Smart Lighting");
        // dict.put("EK-9876", "Encost Smart Appliances");
        // dict.put("EHC-2468", "Encost Hubs/Controllers");
        // dict.put("ESW-5555", "Encost Smartware");
        // dict.put("EWR-2345", "Encost Wifi Routers");
        // dict.put("ESW-3333", "Encost Smartware");

        // for(int i = 0; i < devices.length; i++)
        // {
        // String category = dict.get(devices.get(i).device_id());
        // Assertions.assertEquals(category, devices.get(i).getCategory());
        // }
        Assertions.assertTrue(false);
    }

    // TESTING: deriveDeviceCategory() checking correct category is derived
    // EXPECTED: router derives wifi router category
    @Test
    @DisplayName("Testing deriveDeviceCategory() derives correct category")
    public void deriveDeviceCategoryRouter() {

        // ASSIGN
        GraphStructure graphStructure = new GraphStructure();
        Date date = graphStructure.dateParser("01/04/22");
        Household household = graphStructure.processHousehold("WKO-1234");
        Router router = new Router("Test", date, "Test", household, "-", true, true);

        // ACT
        String result = graphStructure.deriveDeviceCategory(router);

        // ASSERT
        Assertions.assertEquals(result, "Encost Wifi Routers");
    }

    // TESTING: deriveDeviceCategory() checking correct category is derived
    // EXPECTED: extender derives wifi router category
    @Test
    @DisplayName("Testing deriveDeviceCategory() derives correct category")
    public void deriveDeviceCategoryExtender() {

        // ASSIGN
        GraphStructure graphStructure = new GraphStructure();
        Date date = graphStructure.dateParser("01/04/22");
        Household household = graphStructure.processHousehold("WKO-1234");
        Extender router = new Extender("Test", date, "Test", household, "-", true, true);

        // ACT
        String result = graphStructure.deriveDeviceCategory(router);

        // ASSERT
        Assertions.assertEquals(result, "Encost Wifi Routers");
    }

    // TESTING: deriveDeviceCategory() checking correct category is derived
    // EXPECTED: hubcontroller derives hub/controller category
    @Test
    @DisplayName("Testing deriveDeviceCategory() derives correct category")
    public void deriveDeviceCategoryHubController() {

        // ASSIGN
        GraphStructure graphStructure = new GraphStructure();
        Date date = graphStructure.dateParser("01/04/22");
        Household household = graphStructure.processHousehold("WKO-1234");
        HubController router = new HubController("Test", date, "Test", household, "-", true, true);

        // ACT
        String result = graphStructure.deriveDeviceCategory(router);

        // ASSERT
        Assertions.assertEquals(result, "Encost Hubs/Controllers");
    }

    // TESTING: deriveDeviceCategory() checking correct category is derived
    // EXPECTED: light bulb derives Encost Smart Lighting category
    @Test
    @DisplayName("Testing deriveDeviceCategory() derives correct category")
    public void deriveDeviceCategoryLightBulb() {

        // ASSIGN
        GraphStructure graphStructure = new GraphStructure();
        Date date = graphStructure.dateParser("01/04/22");
        Household household = graphStructure.processHousehold("WKO-1234");
        LightBulb router = new LightBulb("Test", date, "Test", household, "-", true, true);

        // ACT
        String result = graphStructure.deriveDeviceCategory(router);

        // ASSERT
        Assertions.assertEquals(result, "Encost Smart Lighting");
    }

    // TESTING: deriveDeviceCategory() checking correct category is derived
    // EXPECTED: Strip Lighting derives Encost Smart Lighting category
    @Test
    @DisplayName("Testing deriveDeviceCategory() derives correct category")
    public void deriveDeviceCategoryStripLighting() {

        // ASSIGN
        GraphStructure graphStructure = new GraphStructure();
        Date date = graphStructure.dateParser("01/04/22");
        Household household = graphStructure.processHousehold("WKO-1234");
        StripLighting router = new StripLighting("Test", date, "Test", household, "-", true, true);

        // ACT
        String result = graphStructure.deriveDeviceCategory(router);

        // ASSERT
        Assertions.assertEquals(result, "Encost Smart Lighting");
    }

    // TESTING: deriveDeviceCategory() checking correct category is derived
    // EXPECTED: other lighting derives Encost Smart Lighting category
    @Test
    @DisplayName("Testing deriveDeviceCategory() derives correct category")
    public void deriveDeviceCategoryOtherLighting() {

        // ASSIGN
        GraphStructure graphStructure = new GraphStructure();
        Date date = graphStructure.dateParser("01/04/22");
        Household household = graphStructure.processHousehold("WKO-1234");
        OtherLighting router = new OtherLighting("Test", date, "Test", household, "-", true, true);

        // ACT
        String result = graphStructure.deriveDeviceCategory(router);

        // ASSERT
        Assertions.assertEquals(result, "Encost Smart Lighting");
    }

    // TESTING: deriveDeviceCategory() checking correct category is derived
    // EXPECTED: kettle derives Encost Smart Appliances category
    @Test
    @DisplayName("Testing deriveDeviceCategory() derives correct category")
    public void deriveDeviceCategoryKettle() {

        // ASSIGN
        GraphStructure graphStructure = new GraphStructure();
        Date date = graphStructure.dateParser("01/04/22");
        Household household = graphStructure.processHousehold("WKO-1234");
        Kettle router = new Kettle("Test", date, "Test", household, "-", true, true);

        // ACT
        String result = graphStructure.deriveDeviceCategory(router);

        // ASSERT
        Assertions.assertEquals(result, "Encost Smart Appliances");
    }

    // TESTING: deriveDeviceCategory() checking correct category is derived
    // EXPECTED: toaster derives Encost Smart Appliances category
    @Test
    @DisplayName("Testing deriveDeviceCategory() derives correct category")
    public void deriveDeviceCategoryToaster() {

        // ASSIGN
        GraphStructure graphStructure = new GraphStructure();
        Date date = graphStructure.dateParser("01/04/22");
        Household household = graphStructure.processHousehold("WKO-1234");
        Toaster router = new Toaster("Test", date, "Test", household, "-", true, true);

        // ACT
        String result = graphStructure.deriveDeviceCategory(router);

        // ASSERT
        Assertions.assertEquals(result, "Encost Smart Appliances");
    }

    // TESTING: deriveDeviceCategory() checking correct category is derived
    // EXPECTED: coffee maker derives Encost Smart Appliances category
    @Test
    @DisplayName("Testing deriveDeviceCategory() derives correct category")
    public void deriveDeviceCategoryCoffeeMaker() {

        // ASSIGN
        GraphStructure graphStructure = new GraphStructure();
        Date date = graphStructure.dateParser("01/04/22");
        Household household = graphStructure.processHousehold("WKO-1234");
        CoffeeMaker router = new CoffeeMaker("Test", date, "Test", household, "-", true, true);

        // ACT
        String result = graphStructure.deriveDeviceCategory(router);

        // ASSERT
        Assertions.assertEquals(result, "Encost Smart Appliances");
    }

    // TESTING: deriveDeviceCategory() checking correct category is derived
    // EXPECTED: washing machine dryer derives Encost Smart Whiteware category
    @Test
    @DisplayName("Testing deriveDeviceCategory() derives correct category")
    public void deriveDeviceCategoryWashingMachineDryer() {

        // ASSIGN
        GraphStructure graphStructure = new GraphStructure();
        Date date = graphStructure.dateParser("01/04/22");
        Household household = graphStructure.processHousehold("WKO-1234");
        WashingMachineDryer router = new WashingMachineDryer("Test", date, "Test", household, "-", true, true);

        // ACT
        String result = graphStructure.deriveDeviceCategory(router);

        // ASSERT
        Assertions.assertEquals(result, "Encost Smart Whiteware");
    }

    // TESTING: deriveDeviceCategory() checking correct category is derived
    // EXPECTED: refrigerator freezer derives Encost Smart Whiteware category
    @Test
    @DisplayName("Testing deriveDeviceCategory() derives correct category")
    public void deriveDeviceCategoryRefrigeratorFreezer() {

        // ASSIGN
        GraphStructure graphStructure = new GraphStructure();
        Date date = graphStructure.dateParser("01/04/22");
        Household household = graphStructure.processHousehold("WKO-1234");
        RefrigeratorFreezer router = new RefrigeratorFreezer("Test", date, "Test", household, "-", true, true);

        // ACT
        String result = graphStructure.deriveDeviceCategory(router);

        // ASSERT
        Assertions.assertEquals(result, "Encost Smart Whiteware");
    }

    // TESTING: deriveDeviceCategory() checking correct category is derived
    // EXPECTED: dishwasher derives Encost Smart Whiteware category
    @Test
    @DisplayName("Testing deriveDeviceCategory() derives correct category")
    public void deriveDeviceCategoryDishwasher() {

        // ASSIGN
        GraphStructure graphStructure = new GraphStructure();
        Date date = graphStructure.dateParser("01/04/22");
        Household household = graphStructure.processHousehold("WKO-1234");
        Dishwasher router = new Dishwasher("Test", date, "Test", household, "-", true, true);

        // ACT
        String result = graphStructure.deriveDeviceCategory(router);

        // ASSERT
        Assertions.assertEquals(result, "Encost Smart Whiteware");
    }

    // TESTING: deriveDeviceCategory() checking correct category is derived
    // EXPECTED: empty string is returned for an unknown device
    @Test
    @DisplayName("Testing deriveDeviceCategory() unknown device")
    public void deriveDeviceCategoryUknownDevice() {

        // ASSIGN
        GraphStructure graphStructure = new GraphStructure();
        Date date = graphStructure.dateParser("01/04/22");
        Household household = graphStructure.processHousehold("WKO-1234");
        Device device = new Device("Test", date, "Test", household, "-", true, true);

        // ACT
        String result = graphStructure.deriveDeviceCategory(device);

        // ASSERT
        Assertions.assertEquals(result, "");
    }

    // TESTING: processDeviceCategory() device category and household
    // EXPECTED: device category is set correctly and household is added to list for
    // a Router device type
    @Test
    @DisplayName("Testing processDeviceCategory()")
    public void processDeviceCategoryRouter() {

        // ASSIGN
        GraphStructure graphStructure = new GraphStructure();
        String[] parts = new String[8];
        parts[0] = "EWR-1234";
        parts[1] = "01/04/22";
        parts[2] = "Encost Router 360";
        parts[3] = "Router";
        parts[4] = "WKO-1234";
        parts[5] = "-";
        parts[6] = "Yes";
        parts[7] = "Yes";
        Date date = graphStructure.dateParser(parts[1]);
        Household household = graphStructure.processHousehold(parts[4]);
        Boolean send = graphStructure.processSendReceive(parts[6]);
        Boolean receive = graphStructure.processSendReceive(parts[7]);

        // ACT
        graphStructure.processDeviceCategory(parts, date, household, send, receive);

        // ASSERT
        String deviceCat = household.deviceList.get(0).getDeviceCat();
        Device device = household.deviceList.get(0);
        String routerName = household.router;
        Assertions.assertEquals(deviceCat, "Encost Wifi Routers");
        Assertions.assertEquals(routerName, "EWR-1234");
        Assertions.assertTrue(device instanceof Router);
    }

    // TESTING: processDeviceCategory() device category and household
    // EXPECTED: device category is set correctly and household is added to list for
    // a Extender device type
    @Test
    @DisplayName("Testing processDeviceCategory()")
    public void processDeviceCategoryExtender() {

        // ASSIGN
        GraphStructure graphStructure = new GraphStructure();
        String[] parts = new String[8];
        parts[0] = "EWR-1234";
        parts[1] = "01/04/22";
        parts[2] = "Encost Router 360";
        parts[3] = "Extender";
        parts[4] = "WKO-1234";
        parts[5] = "-";
        parts[6] = "Yes";
        parts[7] = "Yes";
        Date date = graphStructure.dateParser(parts[1]);
        Household household = graphStructure.processHousehold(parts[4]);
        Boolean send = graphStructure.processSendReceive(parts[6]);
        Boolean receive = graphStructure.processSendReceive(parts[7]);

        // ACT
        graphStructure.processDeviceCategory(parts, date, household, send, receive);

        // ASSERT
        String deviceCat = household.deviceList.get(0).getDeviceCat();
        Device device = household.deviceList.get(0);
        String routerName = household.router;
        Assertions.assertEquals(deviceCat, "Encost Wifi Routers");
        Assertions.assertEquals(routerName, "EWR-1234");
        Assertions.assertTrue(device instanceof Extender);
    }

    // TESTING: processDeviceCategory() device category and household
    // EXPECTED: device category is set correctly and household is added to list for
    // a HubController device type
    @Test
    @DisplayName("Testing processDeviceCategory()")
    public void processDeviceCategoryHubController() {

        // ASSIGN
        GraphStructure graphStructure = new GraphStructure();
        String[] parts = new String[8];
        parts[0] = "EWR-1234";
        parts[1] = "01/04/22";
        parts[2] = "Encost Router 360";
        parts[3] = "Hub/Controller";
        parts[4] = "WKO-1234";
        parts[5] = "-";
        parts[6] = "Yes";
        parts[7] = "Yes";
        Date date = graphStructure.dateParser(parts[1]);
        Household household = graphStructure.processHousehold(parts[4]);
        Boolean send = graphStructure.processSendReceive(parts[6]);
        Boolean receive = graphStructure.processSendReceive(parts[7]);

        // ACT
        graphStructure.processDeviceCategory(parts, date, household, send, receive);

        // ASSERT
        String deviceCat = household.deviceList.get(0).getDeviceCat();
        Device device = household.deviceList.get(0);
        Assertions.assertEquals(deviceCat, "Encost Hubs/Controllers");
        Assertions.assertTrue(device instanceof HubController);
    }

    // TESTING: processDeviceCategory() device category and household
    // EXPECTED: device category is set correctly and household is added to list for
    // a LightBulb device type
    @Test
    @DisplayName("Testing processDeviceCategory()")
    public void processDeviceCategoryLightBulb() {

        // ASSIGN
        GraphStructure graphStructure = new GraphStructure();
        String[] parts = new String[8];
        parts[0] = "EWR-1234";
        parts[1] = "01/04/22";
        parts[2] = "Encost Router 360";
        parts[3] = "Light Bulb";
        parts[4] = "WKO-1234";
        parts[5] = "-";
        parts[6] = "Yes";
        parts[7] = "Yes";
        Date date = graphStructure.dateParser(parts[1]);
        Household household = graphStructure.processHousehold(parts[4]);
        Boolean send = graphStructure.processSendReceive(parts[6]);
        Boolean receive = graphStructure.processSendReceive(parts[7]);

        // ACT
        graphStructure.processDeviceCategory(parts, date, household, send, receive);

        // ASSERT
        String deviceCat = household.deviceList.get(0).getDeviceCat();
        Device device = household.deviceList.get(0);
        Assertions.assertEquals(deviceCat, "Encost Smart Lighting");
        Assertions.assertTrue(device instanceof LightBulb);
    }

    // TESTING: processDeviceCategory() device category and household
    // EXPECTED: device category is set correctly and household is added to list for
    // a StripLighting device type
    @Test
    @DisplayName("Testing processDeviceCategory()")
    public void processDeviceCategoryStripLighting() {

        // ASSIGN
        GraphStructure graphStructure = new GraphStructure();
        String[] parts = new String[8];
        parts[0] = "EWR-1234";
        parts[1] = "01/04/22";
        parts[2] = "Encost Router 360";
        parts[3] = "Strip Lighting";
        parts[4] = "WKO-1234";
        parts[5] = "-";
        parts[6] = "Yes";
        parts[7] = "Yes";
        Date date = graphStructure.dateParser(parts[1]);
        Household household = graphStructure.processHousehold(parts[4]);
        Boolean send = graphStructure.processSendReceive(parts[6]);
        Boolean receive = graphStructure.processSendReceive(parts[7]);

        // ACT
        graphStructure.processDeviceCategory(parts, date, household, send, receive);

        // ASSERT
        String deviceCat = household.deviceList.get(0).getDeviceCat();
        Device device = household.deviceList.get(0);
        Assertions.assertEquals(deviceCat, "Encost Smart Lighting");
        Assertions.assertTrue(device instanceof StripLighting);
    }

    // TESTING: processDeviceCategory() device category and household
    // EXPECTED: device category is set correctly and household is added to list for
    // a OtherLighting device type
    @Test
    @DisplayName("Testing processDeviceCategory()")
    public void processDeviceCategoryOtherLighting() {

        // ASSIGN
        GraphStructure graphStructure = new GraphStructure();
        String[] parts = new String[8];
        parts[0] = "EWR-1234";
        parts[1] = "01/04/22";
        parts[2] = "Encost Router 360";
        parts[3] = "Other Lighting";
        parts[4] = "WKO-1234";
        parts[5] = "-";
        parts[6] = "Yes";
        parts[7] = "Yes";
        Date date = graphStructure.dateParser(parts[1]);
        Household household = graphStructure.processHousehold(parts[4]);
        Boolean send = graphStructure.processSendReceive(parts[6]);
        Boolean receive = graphStructure.processSendReceive(parts[7]);

        // ACT
        graphStructure.processDeviceCategory(parts, date, household, send, receive);

        // ASSERT
        String deviceCat = household.deviceList.get(0).getDeviceCat();
        Device device = household.deviceList.get(0);
        Assertions.assertEquals(deviceCat, "Encost Smart Lighting");
        Assertions.assertTrue(device instanceof OtherLighting);
    }

    // TESTING: processDeviceCategory() device category and household
    // EXPECTED: device category is set correctly and household is added to list for
    // a Kettle device type
    @Test
    @DisplayName("Testing processDeviceCategory()")
    public void processDeviceCategoryKettle() {

        // ASSIGN
        GraphStructure graphStructure = new GraphStructure();
        String[] parts = new String[8];
        parts[0] = "EWR-1234";
        parts[1] = "01/04/22";
        parts[2] = "Encost Router 360";
        parts[3] = "Kettle";
        parts[4] = "WKO-1234";
        parts[5] = "-";
        parts[6] = "Yes";
        parts[7] = "Yes";
        Date date = graphStructure.dateParser(parts[1]);
        Household household = graphStructure.processHousehold(parts[4]);
        Boolean send = graphStructure.processSendReceive(parts[6]);
        Boolean receive = graphStructure.processSendReceive(parts[7]);

        // ACT
        graphStructure.processDeviceCategory(parts, date, household, send, receive);

        // ASSERT
        String deviceCat = household.deviceList.get(0).getDeviceCat();
        Device device = household.deviceList.get(0);
        Assertions.assertEquals(deviceCat, "Encost Smart Appliances");
        Assertions.assertTrue(device instanceof Kettle);
    }

    // TESTING: processDeviceCategory() device category and household
    // EXPECTED: device category is set correctly and household is added to list for
    // a Toaster device type
    @Test
    @DisplayName("Testing processDeviceCategory()")
    public void processDeviceCategoryToaster() {

        // ASSIGN
        GraphStructure graphStructure = new GraphStructure();
        String[] parts = new String[8];
        parts[0] = "EWR-1234";
        parts[1] = "01/04/22";
        parts[2] = "Encost Router 360";
        parts[3] = "Toaster";
        parts[4] = "WKO-1234";
        parts[5] = "-";
        parts[6] = "Yes";
        parts[7] = "Yes";
        Date date = graphStructure.dateParser(parts[1]);
        Household household = graphStructure.processHousehold(parts[4]);
        Boolean send = graphStructure.processSendReceive(parts[6]);
        Boolean receive = graphStructure.processSendReceive(parts[7]);

        // ACT
        graphStructure.processDeviceCategory(parts, date, household, send, receive);

        // ASSERT
        String deviceCat = household.deviceList.get(0).getDeviceCat();
        Device device = household.deviceList.get(0);
        Assertions.assertEquals(deviceCat, "Encost Smart Appliances");
        Assertions.assertTrue(device instanceof Toaster);
    }

    // TESTING: processDeviceCategory() device category and household
    // EXPECTED: device category is set correctly and household is added to list for
    // a CoffeeMaker device type
    @Test
    @DisplayName("Testing processDeviceCategory()")
    public void processDeviceCategoryCoffeeMaker() {

        // ASSIGN
        GraphStructure graphStructure = new GraphStructure();
        String[] parts = new String[8];
        parts[0] = "EWR-1234";
        parts[1] = "01/04/22";
        parts[2] = "Encost Router 360";
        parts[3] = "Coffee Maker";
        parts[4] = "WKO-1234";
        parts[5] = "-";
        parts[6] = "Yes";
        parts[7] = "Yes";
        Date date = graphStructure.dateParser(parts[1]);
        Household household = graphStructure.processHousehold(parts[4]);
        Boolean send = graphStructure.processSendReceive(parts[6]);
        Boolean receive = graphStructure.processSendReceive(parts[7]);

        // ACT
        graphStructure.processDeviceCategory(parts, date, household, send, receive);

        // ASSERT
        String deviceCat = household.deviceList.get(0).getDeviceCat();
        Device device = household.deviceList.get(0);
        Assertions.assertEquals(deviceCat, "Encost Smart Appliances");
        Assertions.assertTrue(device instanceof CoffeeMaker);
    }

    // TESTING: processDeviceCategory() device category and household
    // EXPECTED: device category is set correctly and household is added to list for
    // a WashingMachineDryer device type
    @Test
    @DisplayName("Testing processDeviceCategory()")
    public void processDeviceCategoryWashingMachineDryer() {

        // ASSIGN
        GraphStructure graphStructure = new GraphStructure();
        String[] parts = new String[8];
        parts[0] = "EWR-1234";
        parts[1] = "01/04/22";
        parts[2] = "Encost Router 360";
        parts[3] = "Washing Machine/Dryer";
        parts[4] = "WKO-1234";
        parts[5] = "-";
        parts[6] = "Yes";
        parts[7] = "Yes";
        Date date = graphStructure.dateParser(parts[1]);
        Household household = graphStructure.processHousehold(parts[4]);
        Boolean send = graphStructure.processSendReceive(parts[6]);
        Boolean receive = graphStructure.processSendReceive(parts[7]);

        // ACT
        graphStructure.processDeviceCategory(parts, date, household, send, receive);

        // ASSERT
        String deviceCat = household.deviceList.get(0).getDeviceCat();
        Device device = household.deviceList.get(0);
        Assertions.assertEquals(deviceCat, "Encost Smart Whiteware");
        Assertions.assertTrue(device instanceof WashingMachineDryer);
    }

    // TESTING: processDeviceCategory() device category and household
    // EXPECTED: device category is set correctly and household is added to list for
    // a RefrigeratorFreezer device type
    @Test
    @DisplayName("Testing processDeviceCategory()")
    public void processDeviceCategoryRefrigeratorFreezer() {

        // ASSIGN
        GraphStructure graphStructure = new GraphStructure();
        String[] parts = new String[8];
        parts[0] = "EWR-1234";
        parts[1] = "01/04/22";
        parts[2] = "Encost Router 360";
        parts[3] = "Refrigerator/Freezer";
        parts[4] = "WKO-1234";
        parts[5] = "-";
        parts[6] = "Yes";
        parts[7] = "Yes";
        Date date = graphStructure.dateParser(parts[1]);
        Household household = graphStructure.processHousehold(parts[4]);
        Boolean send = graphStructure.processSendReceive(parts[6]);
        Boolean receive = graphStructure.processSendReceive(parts[7]);

        // ACT
        graphStructure.processDeviceCategory(parts, date, household, send, receive);

        // ASSERT
        String deviceCat = household.deviceList.get(0).getDeviceCat();
        Device device = household.deviceList.get(0);
        Assertions.assertEquals(deviceCat, "Encost Smart Whiteware");
        Assertions.assertTrue(device instanceof RefrigeratorFreezer);
    }

    // TESTING: processDeviceCategory() device category and household
    // EXPECTED: device category is set correctly and household is added to list for
    // a Dishwasher device type
    @Test
    @DisplayName("Testing processDeviceCategory()")
    public void processDeviceCategoryDishwasher() {

        // ASSIGN
        GraphStructure graphStructure = new GraphStructure();
        String[] parts = new String[8];
        parts[0] = "EWR-1234";
        parts[1] = "01/04/22";
        parts[2] = "Encost Router 360";
        parts[3] = "Dishwasher";
        parts[4] = "WKO-1234";
        parts[5] = "-";
        parts[6] = "Yes";
        parts[7] = "Yes";
        Date date = graphStructure.dateParser(parts[1]);
        Household household = graphStructure.processHousehold(parts[4]);
        Boolean send = graphStructure.processSendReceive(parts[6]);
        Boolean receive = graphStructure.processSendReceive(parts[7]);

        // ACT
        graphStructure.processDeviceCategory(parts, date, household, send, receive);

        // ASSERT
        String deviceCat = household.deviceList.get(0).getDeviceCat();
        Device device = household.deviceList.get(0);
        Assertions.assertEquals(deviceCat, "Encost Smart Whiteware");
        Assertions.assertTrue(device instanceof Dishwasher);
    }

    // TESTING: processDeviceCategory() device category and household
    // EXPECTED: no device is created
    @Test
    @DisplayName("Testing processDeviceCategory()")
    public void processDeviceCategoryUnknownDeviceType() {

        // ASSIGN
        GraphStructure graphStructure = new GraphStructure();
        String[] parts = new String[8];
        parts[0] = "EWR-1234";
        parts[1] = "01/04/22";
        parts[2] = "Encost Router 360";
        parts[3] = "&IHGIYER";
        parts[4] = "WKO-1234";
        parts[5] = "-";
        parts[6] = "Yes";
        parts[7] = "Yes";
        Date date = graphStructure.dateParser(parts[1]);
        Household household = graphStructure.processHousehold(parts[4]);
        Boolean send = graphStructure.processSendReceive(parts[6]);
        Boolean receive = graphStructure.processSendReceive(parts[7]);

        // ACT
        graphStructure.processDeviceCategory(parts, date, household, send, receive);

        // ASSERT
        Assertions.assertTrue(household.deviceList.isEmpty());
    }
}