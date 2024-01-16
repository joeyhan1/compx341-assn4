
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class testCategorisingUsers {

    // Initiliase a new byte array output stream
    ConsoleInOut console = new ConsoleInOut();
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);

    // Reassign the standard output stream
    @BeforeEach
    public void setOut() {
        System.setOut(printStream);
    }

    // TESTING: instantiation of ConsoleInOut() class
    // EXPECTED: the welcome screen message is returned to the console
    @Test
    @DisplayName("Testing that the welcome message is displayed to the console on executing the program")
    public void testConsoleOutput() {

        // ACT
        new ConsoleInOut();

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        assertEquals(actualOutput,
                "Welcome to the Encost Smart Graph Project!\nAre you:\n(1) community member\n(2) a member of Encost");
    }

    // TESTING: input of digit 1 to the console
    // EXPECTED: user type updated to 'community' and user type is of class
    // community
    @Test
    @DisplayName("Testing inputting 1 to the console results in user type being updated ")
    public void validCommunityNumber() {

        // ARRANGE
        ConsoleInOut console = new ConsoleInOut();

        // ACT
        console.getState().receiveInput("1");
        String userTypeString = console.getUser().getUserType();
        User userTypeClass = console.getUser();

        // ASSERT
        assertEquals(userTypeString, "community");
        assertTrue(userTypeClass instanceof CommunityUser);
    }

    // TESTING: input of digit 1 to the console
    // EXPECTED: community user feature options output to the console
    @Test
    @DisplayName("Testing inputting 1 to the console results in community feature options")
    public void validCommunityNumberMessage() {

        // ACT
        console.getState().receiveInput("1");

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        assertEquals(actualOutput, "ESGP Feature options (Community Edition):\n(1) Data Graph Visualisation");
    }

    // TESTING: input of digit c to the console
    // EXPECTED: user type updated to 'community' and user type is of class
    // community
    @Test
    @DisplayName("Testing the input of the letter c for a community user")
    public void validCommunityLetter() {

        // ARRANGE
        ConsoleInOut console = new ConsoleInOut();

        // ACT
        console.getState().receiveInput("c");
        String userTypeString = console.getUser().getUserType();
        User userTypeClass = console.getUser();

        // ASSERT
        assertEquals(userTypeString, "community");
        assertTrue(userTypeClass instanceof CommunityUser);
    }

    // TESTING: input of digit c to the console
    // EXPECTED: community user feature options output to the console
    @Test
    @DisplayName("Testing the input of the letter c for a community user")
    public void validCommunityLetterMessage() {

        // ACT
        console.getState().receiveInput("c");

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        assertEquals(actualOutput, "ESGP Feature options (Community Edition):\n(1) Data Graph Visualisation");
    }

    // TESTING: input of digit C to the console
    // EXPECTED: user type updated to 'community' and user type is of class
    // community
    @Test
    @DisplayName("Testing the input of the letter C for a community user")
    public void validCommunityLetterUppercase() {

        // ARRANGE
        ConsoleInOut console = new ConsoleInOut();

        // ACT
        console.getState().receiveInput("C");
        String userTypeString = console.getUser().getUserType();
        User userTypeClass = console.getUser();

        // ASSERT
        assertEquals(userTypeString, "community");
        assertTrue(userTypeClass instanceof CommunityUser);
    }

    // TESTING: input of digit C to the console
    // EXPECTED: community user feature options output to the console
    @Test
    @DisplayName("Testing the input of the letter C for a community user")
    public void validCommunityLetterUppercaseMessage() {

        // ACT
        console.getState().receiveInput("C");

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        assertEquals(actualOutput, "ESGP Feature options (Community Edition):\n(1) Data Graph Visualisation");
    }

    // TESTING: input of word community to the console
    // EXPECTED: user type updated to 'community' and user type is of class
    // community
    @Test
    @DisplayName("Testing the input of the word community for a community user")
    public void validCommunityWord() {

        // ARRANGE
        ConsoleInOut console = new ConsoleInOut();

        // ACT
        console.getState().receiveInput("community");
        String userTypeString = console.getUser().getUserType();
        User userTypeClass = console.getUser();

        // ASSERT
        assertEquals(userTypeString, "community");
        assertTrue(userTypeClass instanceof CommunityUser);
    }

    // TESTING: input of word community to the console
    // EXPECTED: community user feature options output to the console
    @Test
    @DisplayName("Testing the input of the word community for a community user")
    public void validCommunityWordMessage() {

        // ACT
        console.getState().receiveInput("community");

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        assertEquals(actualOutput, "ESGP Feature options (Community Edition):\n(1) Data Graph Visualisation");
    }

    // TESTING: input of word COMMUNITY to the console
    // EXPECTED: community user feature options output to the console
    @Test
    @DisplayName("Testing the input of the word COMMUNITY for a community user")
    public void validCommunityWordUppercase() {

        // ACT
        console.getState().receiveInput("COMMUNITY");

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        assertEquals(actualOutput, "ESGP Feature options (Community Edition):\n(1) Data Graph Visualisation");
    }

    // TESTING: input of word COMMUNITY to the console
    // EXPECTED: user type updated to 'community' and user type is of class
    // community
    @Test
    @DisplayName("Testing the input of the word COMMUNITY for a community user")
    public void validCommunityWordUppercaseMessage() {

        // ARRANGE
        ConsoleInOut console = new ConsoleInOut();

        // ACT
        console.getState().receiveInput("COMMUNITY");
        String userTypeString = console.getUser().getUserType();
        User userTypeClass = console.getUser();

        // ASSERT
        assertEquals(userTypeString, "community");
        assertTrue(userTypeClass instanceof CommunityUser);
    }

    // TESTING: input of digit 2 to the console
    // EXPECTED: user type updated to 'encost-unverified' and user type is of class
    // encost
    @Test
    @DisplayName("Testing inputting 2 to the console results in user type being updated ")
    public void validEncostNumber() {

        // ARRANGE
        ConsoleInOut console = new ConsoleInOut();

        // ACT
        console.getState().receiveInput("2");
        String userTypeString = console.getUser().getUserType();
        User userTypeClass = console.getUser();

        // ASSERT
        assertEquals(userTypeString, "encost-unverified");
        assertTrue(userTypeClass instanceof EncostUser);
    }

    // TESTING: input of digit 2 to the console
    // EXPECTED: encost user feature options output to the console
    @Test
    @DisplayName("Testing the input of the digit 2 for an encost user")
    public void validEncostNumberMessage() {

        // ACT
        console.getState().receiveInput("2");

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        assertEquals(actualOutput, "Please enter your Encost username");
    }

    // TESTING: input of digit e to the console
    // EXPECTED: user type updated to 'encost-unverified' and user type is of class
    // encost
    @Test
    @DisplayName("Testing the input of the digit e for an encost user")
    public void validEncostLetter() {

        // ARRANGE
        ConsoleInOut console = new ConsoleInOut();

        // ACT
        console.getState().receiveInput("e");
        String userTypeString = console.getUser().getUserType();
        User userTypeClass = console.getUser();

        // ASSERT
        assertEquals(userTypeString, "encost-unverified");
        assertTrue(userTypeClass instanceof EncostUser);
    }

    // TESTING: input of digit e to the console
    // EXPECTED: encost user feature options output to the console
    @Test
    @DisplayName("Testing the input of the digit e for an encost user")
    public void validEncostLetterMessage() {

        // ACT
        console.getState().receiveInput("e");

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        assertEquals(actualOutput, "Please enter your Encost username");
    }

    // TESTING: input of digit E to the console
    // EXPECTED: user type updated to 'encost-unverified' and user type is of class
    // encost
    @Test
    @DisplayName("Testing the input of the digit E for an encost user")
    public void validEncostLetterUppercase() {

        // ARRANGE
        ConsoleInOut console = new ConsoleInOut();

        // ACT
        console.getState().receiveInput("E");
        String userTypeString = console.getUser().getUserType();
        User userTypeClass = console.getUser();

        // ASSERT
        assertEquals(userTypeString, "encost-unverified");
        assertTrue(userTypeClass instanceof EncostUser);
    }

    // TESTING: input of digit E to the console
    // EXPECTED: encost user feature options output to the console
    @Test
    @DisplayName("Testing the input of the digit E for an encost user")
    public void validEncostLetterUppercaseMessage() {

        // ACT
        console.getState().receiveInput("E");

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        assertEquals(actualOutput, "Please enter your Encost username");
    }

    // TESTING: input of the word encost to the console
    // EXPECTED: user type updated to 'encost-unverified' and user type is of class
    // encost
    @Test
    @DisplayName("Testing the input of the wortd encost for an encost user")
    public void validEncostWord() {

        // ARRANGE
        ConsoleInOut console = new ConsoleInOut();

        // ACT
        console.getState().receiveInput("encost");
        String userTypeString = console.getUser().getUserType();
        User userTypeClass = console.getUser();

        // ASSERT
        assertEquals(userTypeString, "encost-unverified");
        assertTrue(userTypeClass instanceof EncostUser);
    }

    // TESTING: input of the word encost to the console
    // EXPECTED: encost user feature options output to the console
    @Test
    @DisplayName("Testing the input of the wortd encost for an encost user")
    public void validEncostWordMessage() {

        // ACT
        console.getState().receiveInput("encost");

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        assertEquals(actualOutput, "Please enter your Encost username");
    }

    // TESTING: input of the word ENCOST to the console
    // EXPECTED: user type updated to 'encost-unverified' and user type is of class
    // encost
    @Test
    @DisplayName("Testing the input of the wortd ENCOST for an encost user")
    public void validEncostWordUppercase() {

        // ARRANGE
        ConsoleInOut console = new ConsoleInOut();

        // ACT
        console.getState().receiveInput("ENCOST");
        String userTypeString = console.getUser().getUserType();
        User userTypeClass = console.getUser();

        // ASSERT
        assertEquals(userTypeString, "encost-unverified");
        assertTrue(userTypeClass instanceof EncostUser);
    }

    // TESTING: input of the word ENCOST to the console
    // EXPECTED: encost user feature options output to the console
    @Test
    @DisplayName("Testing the input of the wortd ENCOST for an encost user")
    public void validEncostWordUppercaseMessage() {

        // ACT
        console.getState().receiveInput("ENCOST");

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        assertEquals(actualOutput, "Please enter your Encost username");
    }

    // TESTING: input of digit 3 to the console
    // EXPECTED: user type null and user type is of user
    @Test
    @DisplayName("Testing the input of the digit 3")
    public void invalidNumber() {

        // ARRANGE
        ConsoleInOut console = new ConsoleInOut();

        // ACT
        console.getState().receiveInput("3");
        String userTypeString = console.getUser().getUserType();
        User userTypeClass = console.getUser();

        // ASSERT
        assertEquals(userTypeString, null);
        assertTrue(userTypeClass instanceof User);
    }

    // TESTING: input of digit 3 to the console
    // EXPECTED: an error message is output to console and welcome message is
    // displayed again
    @Test
    @DisplayName("Testing the input of the digit 3")
    public void invalidNumberMessage() {

        // ACT
        console.getState().receiveInput("3");

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        assertEquals(actualOutput,
                "Error: unrecognised input.\nWelcome to the Encost Smart Graph Project!\nAre you:\n(1) community member\n(2) a member of Encost");
    }

    // TESTING: input of the word user to the console
    // EXPECTED: user type null and user type is of user
    @Test
    @DisplayName("Testing the input of the word user")
    public void invalidWord() {

        // ARRANGE
        ConsoleInOut console = new ConsoleInOut();

        // ACT
        console.getState().receiveInput("user");
        String userTypeString = console.getUser().getUserType();
        User userTypeClass = console.getUser();

        // ASSERT
        assertEquals(userTypeString, null);
        assertTrue(userTypeClass instanceof User);
    }

    // TESTING: input of the word user to the console
    // EXPECTED: an error message is output to console and welcome message is
    // displayed again
    @Test
    @DisplayName("Testing the input of the word user")
    public void invalidWordMessage() {

        // ACT
        console.getState().receiveInput("user");

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        assertEquals(actualOutput,
                "Error: unrecognised input.\nWelcome to the Encost Smart Graph Project!\nAre you:\n(1) community member\n(2) a member of Encost");
    }

    // TESTING: input of a blank string to the console
    // EXPECTED: user type null and user type is of user
    @Test
    @DisplayName("Testing the input of a blank string")
    public void invalidEmpty() {

        // ARRANGE
        ConsoleInOut console = new ConsoleInOut();

        // ACT
        console.getState().receiveInput("");
        String userTypeString = console.getUser().getUserType();
        User userTypeClass = console.getUser();

        // ASSERT
        assertEquals(userTypeString, null);
        assertTrue(userTypeClass instanceof User);
    }

    // TESTING: input of a blank string to the console
    // EXPECTED: an error message is output to console and welcome message is
    // displayed again
    @Test
    @DisplayName("Testing the input of a blank string")
    public void invalidEmptyMessage() {

        // ACT
        console.getState().receiveInput("");

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        assertEquals(actualOutput,
                "Error: unrecognised input.\nWelcome to the Encost Smart Graph Project!\nAre you:\n(1) community member\n(2) a member of Encost");
    }

    // TESTING: input of the word home to the console
    // EXPECTED: user type null and user type is of user
    @Test
    @DisplayName("Testing the input of the word home")
    public void invalidHome() {

        // ARRANGE
        ConsoleInOut console = new ConsoleInOut();

        // ACT
        console.getState().receiveInput("home");
        String userTypeString = console.getUser().getUserType();
        User userTypeClass = console.getUser();

        // ASSERT
        assertEquals(userTypeString, null);
        assertTrue(userTypeClass instanceof User);
    }

    // TESTING: input of the word home to the console
    // EXPECTED: an error message is output to console and welcome message is
    // displayed again
    @Test
    @DisplayName("Testing the input of the word home")
    public void invalidHomeMessage() {

        // ACT
        console.getState().receiveInput("home");

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        assertEquals(actualOutput,
                "Error: unrecognised input.\nWelcome to the Encost Smart Graph Project!\nAre you:\n(1) community member\n(2) a member of Encost");
    }

    // TESTING: input of any other characters
    // EXPECTED: user type null and user type is of user
    @Test
    @DisplayName("Testing the input of any characters not specified previously")
    public void invalidCharactersOther() {

        // ARRANGE
        ConsoleInOut console = new ConsoleInOut();

        // ACT
        console.getState().receiveInput("$#%^&&");
        String userTypeString = console.getUser().getUserType();
        User userTypeClass = console.getUser();

        // ASSERT
        assertEquals(userTypeString, null);
        assertTrue(userTypeClass instanceof User);
    }

    // TESTING: input of any other characters
    // EXPECTED: an error message is output to console and welcome message is
    // displayed again
    @Test
    @DisplayName("Testing the input of any characters not specified previously")
    public void invalidCharactersOtherMessage() {

        // ACT
        console.getState().receiveInput("$#");

        // ASSERT
        String actualOutput = outputStream.toString().trim();
        assertEquals(actualOutput,
                "Error: unrecognised input.\nWelcome to the Encost Smart Graph Project!\nAre you:\n(1) community member\n(2) a member of Encost");
    }
}