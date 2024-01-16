
/*
 * State that is first initialised on starting the program
 */
public class WelcomeState extends State {

    public WelcomeState(ConsoleInOut console) {

        super(console);
        render();
    }

    @Override
    void render() {

        System.out.println(
                "Welcome to the Encost Smart Graph Project!\nAre you:\n(1) community member\n(2) a member of Encost");
    }

    @Override
    void exit() {

        console.exit();
    }

    @Override
    public void receiveInput(String input) {

        if (compareTo(input, "1") || compareTo(input, "c") || compareTo(input, "community")) {

            // Set user type to 'community'
            console.getUser().setUserType("community");

            // Transition to the featureoptions state
            console.changeState(new FeatureOptionsState(console));

        } else if (compareTo(input, "2") || compareTo(input, "e") || compareTo(input, "encost")) {

            // Create EncostUser and set
            EncostUser encostUser = new EncostUser();
            console.setEncostUser(encostUser);

            // Set user type to 'encost-unverified'
            console.getUser().setUserType("encost-unverified");

            // Transition to the login state
            console.changeState(new LoginState(console));

        } else if (compareTo(input, "3") || compareTo(input, "user") || compareTo(input, "")
                || compareTo(input, "home")) {

            // Output error message and welcome state message again
            System.out.print("Error: unrecognised input.\n");
            render();
        } else {

            // Output error message and welcome state message again
            System.out.print("Error: unrecognised input.\n");
            render();
        }
    }

    /*
     * Helper function to compare strings
     */
    public boolean compareTo(String str, String compareString) {

        str = str.toLowerCase();
        boolean result = false;
        if (str.compareTo(compareString) == 0) {
            result = true;
        }
        return result;
    }
}