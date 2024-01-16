
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import java.io.*;

public class testCommunityFeatures {

    // Initiliase a new byte array output stream
    ConsoleInOut console = new ConsoleInOut();
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);

    // Reassign the standard output stream
    @BeforeEach
    public void setOut() {
        System.setOut(printStream);
    }

    // TESTING: communityFeatureSelection() valid input
    // EXPECTED: true is returned
    @Test
    @DisplayName("Testing the input of the words 'data graph visualisation'")
    public void validOptionFull() {

        // ASSIGN
        FeatureOptionsState featureOptionsState = new FeatureOptionsState(console);

        // ACT
        Boolean result = featureOptionsState.communityFeatureSelection("data graph visualisation");

        // ASSERT
        Assertions.assertTrue(result);
    }

    // TESTING: input of words 'data graph visualisation' to the console
    // EXPECTED: Loading graph message is shown. NOTE: JUnit is failing because the
    // ESHD file is not loading
    @Test
    @DisplayName("Testing the input of the words 'data graph visualisation'")
    public void validOptionFullMessage() {

        // ACT
        console.getState().receiveInput("1");
        console.getState().receiveInput("data graph visualisation");

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        assertEquals(actualOutput,
                "ESGP Feature options (Community Edition):\n(1) Data Graph Visualisation\r\n" + "Loading Graph");
    }

    // TESTING: communityFeatureSelection() valid input
    // EXPECTED: true is returned
    @Test
    @DisplayName("Testing the input of the words 'DATA GRAPH VISUALISATION'")
    public void validOptionFullCapital() {

        // ASSIGN
        FeatureOptionsState featureOptionsState = new FeatureOptionsState(console);

        // ACT
        Boolean result = featureOptionsState.communityFeatureSelection("DATA GRAPH VISUALISATION");

        // ASSERT
        Assertions.assertTrue(result);
    }

    // TESTING: input of words 'DATA GRAPH VISUALISATION' to the console
    /// EXPECTED: Loading graph message is shown. NOTE: JUnit is failing because the
    // ESHD file is not loading
    @Test
    @DisplayName("Testing the input of the words 'DATA GRAPH VISUALISATION'")
    public void validOptionFullCapitalMessage() {

        // ACT
        console.getState().receiveInput("1");
        console.getState().receiveInput("DATA GRAPH VISUALISATION");

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        assertEquals(actualOutput,
                "ESGP Feature options (Community Edition):\n(1) Data Graph Visualisation\r\n" + "Loading Graph");
    }

    // TESTING: communityFeatureSelection() valid input
    // EXPECTED: true is returned
    @Test
    @DisplayName("Testing the input of the words 'graph'")
    public void validOptionWord() {

        // ASSIGN
        FeatureOptionsState featureOptionsState = new FeatureOptionsState(console);

        // ACT
        Boolean result = featureOptionsState.communityFeatureSelection("graph");

        // ASSERT
        Assertions.assertTrue(result);
    }

    // TESTING: input of words 'graph' to the console
    // EXPECTED: Loading graph message is shown. NOTE: JUnit is failing because the
    // ESHD file is not loading
    @Test
    @DisplayName("Testing the input of the words 'graph'")
    public void validOptionWordMessage() {

        // ACT
        console.getState().receiveInput("1");
        console.getState().receiveInput("graph");

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        assertEquals(actualOutput,
                "ESGP Feature options (Community Edition):\n(1) Data Graph Visualisation\r\n" + "Loading Graph");
    }

    // TESTING: communityFeatureSelection()
    // EXPECTED: false is returned
    @Test
    @DisplayName("Testing the input of invalid options")
    public void invalidOptionNumber() {

        // ASSIGN
        FeatureOptionsState featureOptionsState = new FeatureOptionsState(console);

        // ACT
        Boolean result = featureOptionsState.communityFeatureSelection("2");

        // ASSERT
        Assertions.assertFalse(result);
    }

    // TESTING: input of words '2' to the console
    // EXPECTED: error message is displayed
    @Test
    @DisplayName("Testing the input of 2")
    public void invalidOptionNumberMessage() {

        // ACT
        console.getState().receiveInput("1");
        console.getState().receiveInput("2");

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        assertEquals(actualOutput,
                "ESGP Feature options (Community Edition):\n(1) Data Graph Visualisation\r\n"
                        + "Error: unrecognised input.\r\n"
                        + "ESGP Feature options (Community Edition):\n(1) Data Graph Visualisation");
    }

    // TESTING: communityFeatureSelection()
    // EXPECTED: false is returned
    @Test
    @DisplayName("Testing the input of 3")
    public void invalidOptionNumber2() {

        // ASSIGN
        FeatureOptionsState featureOptionsState = new FeatureOptionsState(console);

        // ACT
        Boolean result = featureOptionsState.communityFeatureSelection("3");

        // ASSERT
        Assertions.assertFalse(result);
    }

    // TESTING: input of words '3' to the console
    // EXPECTED: error message is displayed
    @Test
    @DisplayName("Testing the input of 3")
    public void invalidOptionNumber2Message() {

        // ACT
        console.getState().receiveInput("1");
        console.getState().receiveInput("3");

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        assertEquals(actualOutput,
                "ESGP Feature options (Community Edition):\n(1) Data Graph Visualisation\r\n"
                        + "Error: unrecognised input.\r\n"
                        + "ESGP Feature options (Community Edition):\n(1) Data Graph Visualisation");
    }

    // TESTING: communityFeatureSelection()
    // EXPECTED: false is returned
    @Test
    @DisplayName("Testing the input of load custom dataset")
    public void invalidOptionFull() {

        // ASSIGN
        FeatureOptionsState featureOptionsState = new FeatureOptionsState(console);

        // ACT
        Boolean result = featureOptionsState.communityFeatureSelection("load custom dataset");

        // ASSERT
        Assertions.assertFalse(result);
    }

    // TESTING: input of words 'load custom dataset' to the console
    // EXPECTED: error message is displayed
    @Test
    @DisplayName("Testing the input of load custom dataset")
    public void invalidOptionFullMessage() {

        // ACT
        console.getState().receiveInput("1");
        console.getState().receiveInput("load custom dataset");

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        assertEquals(actualOutput,
                "ESGP Feature options (Community Edition):\n(1) Data Graph Visualisation\r\n"
                        + "Error: unrecognised input.\r\n"
                        + "ESGP Feature options (Community Edition):\n(1) Data Graph Visualisation");
    }

    // TESTING: communityFeatureSelection()
    // EXPECTED: false is returned
    @Test
    @DisplayName("Testing the input of 'load'")
    public void invalidOptionWord() {

        // ASSIGN
        FeatureOptionsState featureOptionsState = new FeatureOptionsState(console);

        // ACT
        Boolean result = featureOptionsState.communityFeatureSelection("load");

        // ASSERT
        Assertions.assertFalse(result);
    }

    // TESTING: input of words 'load' to the console
    // EXPECTED: error message is displayed
    @Test
    @DisplayName("Testing the input of 'load'")
    public void invalidOptionWordMessage() {

        // ACT
        console.getState().receiveInput("1");
        console.getState().receiveInput("load");

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        assertEquals(actualOutput,
                "ESGP Feature options (Community Edition):\n(1) Data Graph Visualisation\r\n"
                        + "Error: unrecognised input.\r\n"
                        + "ESGP Feature options (Community Edition):\n(1) Data Graph Visualisation");
    }

    // TESTING: communityFeatureSelection()
    // EXPECTED: false is returned
    @Test
    @DisplayName("Testing the input of 'view summary statistics'")
    public void invalidOptionFull2() {

        // ASSIGN
        FeatureOptionsState featureOptionsState = new FeatureOptionsState(console);

        // ACT
        Boolean result = featureOptionsState.communityFeatureSelection("view summary statistics");

        // ASSERT
        Assertions.assertFalse(result);
    }

    // TESTING: input of words 'view summary statistics' to the console
    // EXPECTED: error message is displayed
    @Test
    @DisplayName("Testing the input of 'view summary statistics'")
    public void invalidOptionFull2Message() {

        // ACT
        console.getState().receiveInput("1");
        console.getState().receiveInput("view summary statistics");

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        assertEquals(actualOutput,
                "ESGP Feature options (Community Edition):\n(1) Data Graph Visualisation\r\n"
                        + "Error: unrecognised input.\r\n"
                        + "ESGP Feature options (Community Edition):\n(1) Data Graph Visualisation");
    }

    // TESTING: communityFeatureSelection()
    // EXPECTED: true is returned
    @Test
    @DisplayName("Testing the input of 'home'")
    public void validHome() {

        // ASSIGN
        FeatureOptionsState featureOptionsState = new FeatureOptionsState(console);

        // ACT
        Boolean result = featureOptionsState.communityFeatureSelection("home");

        // ASSERT
        Assertions.assertTrue(result);
    }

    // TESTING: input of words 'home' to the console
    // EXPECTED: home message is displayed
    @Test
    @DisplayName("Testing the input of 'home'")
    public void validHomeMessage() {

        // ACT
        console.getState().receiveInput("1");
        console.getState().receiveInput("home");

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        assertEquals(actualOutput,
                "ESGP Feature options (Community Edition):\n(1) Data Graph Visualisation\r\n"
                        + "Welcome to the Encost Smart Graph Project!\nAre you:\n(1) community member\n(2) a member of Encost");
    }

    // TESTING: communityFeatureSelection()
    // EXPECTED: true is returned
    @DisplayName("Testing the input of 'HOME'")
    @Test
    public void validHomeCapital() {

        // ASSIGN
        FeatureOptionsState featureOptionsState = new FeatureOptionsState(console);

        // ACT
        Boolean result = featureOptionsState.communityFeatureSelection("HOME");

        // ASSERT
        Assertions.assertTrue(result);
    }

    // TESTING: communityFeatureSelection()
    // EXPECTED: home message is displayed
    @DisplayName("Testing the input of 'HOME'")
    @Test
    public void validHomeCapitalMessage() {

        // ACT
        console.getState().receiveInput("1");
        console.getState().receiveInput("HOME");

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        assertEquals(actualOutput,
                "ESGP Feature options (Community Edition):\n(1) Data Graph Visualisation\r\n"
                        + "Welcome to the Encost Smart Graph Project!\nAre you:\n(1) community member\n(2) a member of Encost");
    }

    // TESTING: communityFeatureSelection()
    // EXPECTED: true is returned
    @DisplayName("Testing the input of 'back'")
    @Test
    public void validBack() {

        // ASSIGN
        FeatureOptionsState featureOptionsState = new FeatureOptionsState(console);

        // ACT
        Boolean result = featureOptionsState.communityFeatureSelection("back");

        // ASSERT
        Assertions.assertTrue(result);
    }

    // TESTING: communityFeatureSelection()
    // EXPECTED: home message is displayed
    @DisplayName("Testing the input of 'back'")
    @Test
    public void validBackMessage() {

        // ACT
        console.getState().receiveInput("1");
        console.getState().receiveInput("back");

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        assertEquals(actualOutput,
                "ESGP Feature options (Community Edition):\n(1) Data Graph Visualisation\r\n"
                        + "Welcome to the Encost Smart Graph Project!\nAre you:\n(1) community member\n(2) a member of Encost");
    }
}
