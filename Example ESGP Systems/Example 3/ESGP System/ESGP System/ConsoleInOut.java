
import java.io.Console;

/*
 * The purpose of this class is to hold the main input to the program through the System.Console() structure. 
 */
public class ConsoleInOut {

    // Declare variables
    private State state;
    private User user;
    private Console console = System.console();
    private GraphStructure graphStructure;

    /*
     * Constructor. Initilise the state to the Welcome State
     */
    public ConsoleInOut() {

        this.state = new WelcomeState(this);
        this.user = new CommunityUser();
        this.graphStructure = new GraphStructure();
    }

    /*
     * This method reads input from the console and passes it to whichever state is
     * active
     */
    public void readInput() {

        // Initialise a password char array
        char[] passwd;

        // Loop forever reading in the console input
        while (true) {

            // If we transition to the ValidateEncostUserState, then prompt to enter a
            // password
            if (state instanceof ValidateEncostUserState) {

                // Prompt the console for a password
                passwd = console.readPassword("[%s]", "Password:");

                // Recieve the password and pass to the state object
                state.receiveInput(String.valueOf(passwd));

                // Clear out the passwd variable from memory
                java.util.Arrays.fill(passwd, ' ');

            } else {

                // Read in the console information and pass it to the current active state
                String str = console.readLine();
                state.receiveInput(str);
            }
        }
    }

    /*
     * Transition from one state to another
     */
    public void changeState(State state) {

        this.state = state;
    }

    /*
     * Exit the console program
     */
    public void exit() {

        System.exit(0);
    }

    /*
     * Helper function to compare 2 strings
     */
    public boolean compareTo(String str, String compareString) {

        str = str.toLowerCase();
        boolean result = false;
        if (str.compareTo(compareString) == 0) {
            result = true;
        }
        return result;
    }

    // Getters and setters
    public State getState() {

        return this.state;
    }

    public GraphStructure getGraphStructure() {

        return this.graphStructure;
    }

    public User getUser() {

        return this.user;
    }

    public void setEncostUser(EncostUser encostUser) {

        this.user = encostUser;
    }

    public Console getConsole() {

        return this.console;
    }
}