
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Date;

public class testLoadingDefaultDataset {

    // Cannot test file loading with JUnit without significant structural changes to
    // the file loading mechanism. Manual testing with screenshots being provided
    // will be carried out instead.
    @Test
    public void unknownLocation() {

        // String filePath = null;
        // Boolean res = processFile(filePath);
        // Assertions.assertFalse(res);
        Assertions.assertTrue(false);
    }

    @Test
    public void fileNotFound() {

        // String filePath = "test.csv";
        // Boolean res = processFile(filePath);
        // Assertions.assertFalse(res);
        Assertions.assertTrue(false);
    }

    @Test
    public void fileWrongFormat() {

        // String filePath = "testingDataset1.txt";
        // Boolean res = processFile(filePath);
        // Assertions.assertFalse(res);
        Assertions.assertTrue(false);
    }

    @Test
    public void fileAlreadyOpen() {

        // // opens the file
        // String filePath = "testingDataset1.csv";
        // FileReader reader = new FileReader("testringDataset1.csv");
        // reader.read();

        // Boolean res = processFile(filePath);
        // Assertions.assertFalse(res);
        // reader.close();
        Assertions.assertTrue(false);
    }

    @Test
    public void correctFile() {

        // String filePath = "testingDataset1.csv";
        // Boolean res = processFile(filePath);
        // Assertions.assertTrue(res);
        Assertions.assertTrue(false);
    }

    // Tests rewritten. See new tests outlined below
    @Test
    public void lineNotEnoughArguments() {

        // String filePath = "invalidData1.csv";
        // Boolean res = processFile(filePath);
        // Assertions.assertTrue(res);
        // Assertions.assertEquals(2, devices.length());
        Assertions.assertTrue(false);
    }

    // Tests rewritten. See new tests outlined below
    @Test
    public void lineTooManyArguments() {

        // String filePath = "invalidData2.csv";
        // Boolean res = processFile(filePath);
        // Assertions.assertTrue(res);
        // Assertions.assertEquals(2, devices.length());
        Assertions.assertTrue(false);
    }

    // TESTING: checkLineParts() all valid fields
    // EXPECTED: all 8 fields are accounted for
    @Test
    @DisplayName("Testing checkLineParts() no missing fields")
    public void checkLinePartsNoMissingFields() {

        // ASSIGN
        String[] parts = new String[8];
        GraphStructure graphStructure = new GraphStructure();

        // ACT
        Boolean result = graphStructure.checkLineParts(parts);

        // ASSERT
        Assertions.assertTrue(result);
    }

    // TESTING: checkLineParts() missing fields
    // EXPECTED: not all 8 fields are accounted for
    @Test
    @DisplayName("Testing checkLineParts() missing fields")
    public void checkLinePartsMissingFields() {

        // ASSIGN
        String[] parts = new String[2];
        GraphStructure graphStructure = new GraphStructure();

        // ACT
        Boolean result = graphStructure.checkLineParts(parts);

        // ASSERT
        Assertions.assertFalse(result);
    }

    // TESTING: checkLineParts() too many fields
    // EXPECTED: extra fields are added to the file
    @Test
    @DisplayName("Testing checkLineParts() too many fields")
    public void checkLinePartsExtraFields() {

        // ASSIGN
        String[] parts = new String[10];
        GraphStructure graphStructure = new GraphStructure();

        // ACT
        Boolean result = graphStructure.checkLineParts(parts);

        // ASSERT
        Assertions.assertFalse(result);
    }

    // TESTING: checkLineParts() missing fields
    // EXPECTED: not all 8 fields are accounted for
    @Test
    @DisplayName("Testing checkLineParts() missing fields error message")
    public void checkLinePartsMissingFieldsErrorMessage() {

        // ASSIGN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        String[] parts = new String[2];
        GraphStructure graphStructure = new GraphStructure();

        // ACT
        graphStructure.checkLineParts(parts);

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        Assertions.assertEquals(actualOutput,
                "Error code 002 incorrect field count. Please contact the software owner for assistance.");
    }

    // Test rewritten. See created tests outlined below
    @Test
    public void lineInvalidDataType() {

        // String filePath = "invalidData3.csv";
        // Boolean res = processFile(filePath);
        // Assertions.assertTrue(res);
        // Assertions.assertEquals(2, devices.length());
        Assertions.assertTrue(false);
    }

    // TESTING: dateParser() valid date
    // EXPECTED: a date object is returned
    @Test
    @DisplayName("Testing dateParser() returns a correct date")
    public void dateParserValidDate() {

        // ASSIGN
        String date = "01/04/22";
        GraphStructure graphStructure = new GraphStructure();

        // ACT
        Date dateResult = graphStructure.dateParser(date);

        // ASSERT
        Assertions.assertEquals("Fri Apr 01 00:00:00 NZDT 2022", dateResult.toString());
    }

    // TESTING: dateParser() invalid date
    // EXPECTED: null is returned
    @Test
    @DisplayName("Testing dateParser() returns null")
    public void dateParserInvalidDateNullReturned() {

        // ASSIGN
        String date = "01a/04a/22a";
        GraphStructure graphStructure = new GraphStructure();

        // ACT
        Date dateResult = graphStructure.dateParser(date);

        // ASSERT
        Assertions.assertEquals(null, dateResult);
    }

    // TESTING: dateParser() invalid date
    // EXPECTED: error message is output to console
    @Test
    @DisplayName("Testing dateParser() error message")
    public void dateParserInvalidDateErrorMessage() {

        // ASSIGN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        String date = "01a/04a/22a";
        GraphStructure graphStructure = new GraphStructure();

        // ACT
        graphStructure.dateParser(date);

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        Assertions.assertEquals(actualOutput,
                "Error code 003 date format. Please contact the software owner for assistance.");
    }

    // Test rewritten. See created tests outlined below
    @Test
    public void lineInvalidDataType2() {

        // String filePath = "invalidData4.csv";
        // Boolean res = processFile(filePath);
        // Assertions.assertTrue(res);
        // Assertions.assertEquals(2, devices.length());
        Assertions.assertTrue(false);
    }

    // TESTING: processSendReceive() valid send output
    // EXPECTED: boolean true is returned
    @Test
    @DisplayName("Testing processSendReceive() valid send parameter")
    public void processSendReceiveValidSend() {

        // ASSIGN
        String input = "Yes";
        GraphStructure graphStructure = new GraphStructure();

        // ACT
        Boolean result = graphStructure.processSendReceive(input);

        // ASSERT
        Assertions.assertEquals(result, true);
    }

    // TESTING: processSendReceive() valid receive output
    // EXPECTED: boolean false is returned
    @Test
    @DisplayName("Testing processSendReceive() valid receive parameter")
    public void processSendReceiveValidReceive() {

        // ASSIGN
        String input = "No";
        GraphStructure graphStructure = new GraphStructure();

        // ACT
        Boolean result = graphStructure.processSendReceive(input);

        // ASSERT
        Assertions.assertEquals(result, false);
    }

    // TESTING: processSendReceive() invalid input
    // EXPECTED: null is returned
    @Test
    @DisplayName("Testing processSendReceive() invalid input")
    public void processSendReceiveInvalidReturnNull() {

        // ASSIGN
        String input = "abc";
        GraphStructure graphStructure = new GraphStructure();

        // ACT
        Boolean result = graphStructure.processSendReceive(input);

        // ASSERT
        Assertions.assertEquals(result, null);
    }

    // TESTING: processSendReceive() invalid input
    // EXPECTED: error message is output to console
    @Test
    @DisplayName("Testing processSendReceive() error output to console")
    public void processSendReceiveInvalidErrorMessage() {

        // ASSIGN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        String input = "abc";
        GraphStructure graphStructure = new GraphStructure();

        // ACT
        graphStructure.processSendReceive(input);

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        Assertions.assertEquals(actualOutput,
                "Error code 004. Send/Receive data wrong. Please contact the software owner for assistance.");
    }

    // Test rewritten. See created tests outlined below
    @Test
    public void lineRepeatingID() {

        // String filePath = "invalidData5.csv";
        // Boolean res = processFile(filePath);
        // Assertions.assertTrue(res);
        // Assertions.assertEquals(3, devices.length());
        Assertions.assertTrue(false);
    }

    // TESTING: checkRepeatedDeviceID() duplicate deviceId
    // EXPECTED: boolean true is returned
    @Test
    @DisplayName("Testing checkRepeatedDeviceID()")
    public void checkRepeatedDeviceIDReturnTrue() {

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
        graphStructure.processDeviceCategory(parts, date, household, send, receive);

        // ACT
        boolean result = graphStructure.checkRepeatedDeviceID("EWR-1234");

        // ASSERT
        Assertions.assertTrue(result);
    }

    // TESTING: checkRepeatedDeviceID() no duplicate
    // EXPECTED: boolean false is returned
    @Test
    @DisplayName("Testing checkRepeatedDeviceID()")
    public void checkRepeatedDeviceIDReturnFalse() {

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
        graphStructure.processDeviceCategory(parts, date, household, send, receive);

        // ACT
        boolean result = graphStructure.checkRepeatedDeviceID("EWR-1523");

        // ASSERT
        Assertions.assertFalse(result);
    }

    // TESTING: checkRepeatedDeviceID() duplicate device ID
    // EXPECTED: error message is displayed
    @Test
    @DisplayName("Testing checkRepeatedDeviceID()")
    public void checkRepeatedDeviceIDErrorMessage() {

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
        graphStructure.processDeviceCategory(parts, date, household, send, receive);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // ACT
        graphStructure.checkRepeatedDeviceID("EWR-1234");

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        Assertions.assertEquals(actualOutput,
                "Error code 006 repeated device Id. Please contact the software owner for assistance.");
    }

    // SEE TESTCATEGORISINGDEVICES FOR TESTING THE DEVICE CREATION AFTER A LINE IS
    // SUCCESSFULLY READ
    @Test
    public void lineValid() {

        // String filePath = "testingDataset1.csv";
        // Boolean res = processFile(filePath);
        // Assertions.assertTrue(res);
        // Assertions.assertEquals(7, devices.length());
        Assertions.assertTrue(false);
    }

    // TESTING: processHousehold() valid new household
    // EXPECTED: a household object is returned
    @Test
    @DisplayName("Testing processHousehold() returns a household")
    public void processHouseholdValidNewHousehold() {

        // ASSIGN
        String householdId = "WKO-1234";
        GraphStructure graphStructure = new GraphStructure();

        // ACT
        Household household = graphStructure.processHousehold(householdId);

        // ASSERT
        Assertions.assertEquals(household.houseId, householdId);
    }

    // TESTING: processHousehold() valid existing household
    // EXPECTED: a household object is returned
    @Test
    @DisplayName("Testing processHousehold() returns a household")
    public void processHouseholdValidExistingHousehold() {

        // ASSIGN
        String householdId = "WKO-1234";
        GraphStructure graphStructure = new GraphStructure();

        // ACT
        graphStructure.processHousehold(householdId);
        Household household2 = graphStructure.processHousehold(householdId);

        // ASSERT
        Assertions.assertEquals(household2.houseId, householdId);
    }

    // TESTING: processHousehold() invalid household
    // EXPECTED: null is returned
    @Test
    @DisplayName("Testing processHousehold() returns null")
    public void processHouseholdInvalidHousehold() {

        // ASSIGN
        String householdId = "WK-1234";
        GraphStructure graphStructure = new GraphStructure();

        // ACT
        Household household = graphStructure.processHousehold(householdId);

        // ASSERT
        Assertions.assertEquals(household, null);
    }

    // TESTING: processHousehold() invalid household message
    // EXPECTED: error message is output to console
    @Test
    @DisplayName("Testing processHousehold() error message")
    public void processHouseholdInvalidHouseholdErrorMessage() {

        // ASSIGN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        String householdId = "WK-1234";
        GraphStructure graphStructure = new GraphStructure();

        // ACT
        graphStructure.processHousehold(householdId);

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        Assertions.assertEquals(actualOutput,
                "Error code 005. Incorrect household ID. Please contact the software owner for assistance.");
    }
}