
/*
 * This class is used to implement the feature options stateful interactions for both community and encost users
 */
public class FeatureOptionsState extends State {

    // Declare variables
    private boolean flagHome = false;
    private boolean flagCustomDataset = false;
    private boolean flagGraph = false;
    private boolean flagSummaryStats = false;

    public FeatureOptionsState(ConsoleInOut console) {

        super(console);
        render();
    }

    @Override
    void render() {

        // Check what kind of user and print the feature options
        if (console.getUser().getUserType() == "community") {

            System.out.println("ESGP Feature options (Community Edition):\n(1) Data Graph Visualisation");
        } else if (console.getUser().getUserType() == "encost-verified") {

            System.out.println("ESGP Feature options (Encost Verified Edition)\n" +
                    "(1) Load custom dataset\n" +
                    "(2) Data Graph Visualisation\n" +
                    "(3) View Summary Statistics");
        }
    }

    @Override
    void exit() {

        console.exit();
    }

    @Override
    public void receiveInput(String input) {

        // Check user type
        if (console.getUser().getUserType() == "community") {

            // Check input is valid
            if (communityFeatureSelection(input)) {

                // Valid input received
                if (flagHome) {

                    // Transition to home state
                    console.changeState(new WelcomeState(console));
                } else {

                    // Load graph
                    System.out.println("Loading Graph");
                    loadGraphStreamGraph();
                }
            } else {

                // Invalid input received
                System.out.println("Error: unrecognised input.");
                render();
            }
        } else if (console.getUser().getUserType() == "encost-verified") {

            // Check input is valid
            if (encostFeatureSelection(input)) {

                // Valid input received
                if (flagHome) {

                    // Transition to home state
                    console.changeState(new WelcomeState(console));
                } else if (flagGraph) {

                    // Load graph
                    System.out.println("Loading Graph");
                    loadGraphStreamGraph();
                } else if (flagCustomDataset) {

                    // Transition to loading customdataset (not implemented)
                } else if (flagSummaryStats) {

                    // Transition to summary statistics (not implemented)
                }
            } else {

                // Invalid input received
                System.out.println("Error: unrecognised input.");
                render();
            }
        }
    }

    /*
     * Load the graph stream graph, but first process the ESHD file
     */
    public void loadGraphStreamGraph() {

        // Process the ESHD file
        boolean result = console.getGraphStructure().processFile(console.getGraphStructure().ESHD_FILE_PATH);

        // If the file is okay, then display the graph, else show an error message and
        // exit the program
        if (result) {

            console.getGraphStructure().loadGraphStreamGraph();
            console.getGraphStructure().displayGraph();
        } else {

            System.out.println("Program shutting down.");
            exit();
        }
    }

    /*
     * Check the input to the console by encost users
     */
    public boolean encostFeatureSelection(String input) {

        flagHome = false;
        flagCustomDataset = false;
        flagGraph = false;
        flagSummaryStats = false;
        boolean result = false;
        if (console.compareTo(input, "1") ||
                console.compareTo(input, "load custom dataset") ||
                console.compareTo(input, "LOAD CUSTOM DATASET") ||
                console.compareTo(input, "load")) {
            result = true;
            flagCustomDataset = true;
        } else if (console.compareTo(input, "2") ||
                console.compareTo(input, "data graph visualisation") ||
                console.compareTo(input, "graph")) {
            result = true;
            flagGraph = true;
        } else if (console.compareTo(input, "3") ||
                console.compareTo(input, "view summary statistics") ||
                console.compareTo(input, "summary") ||
                console.compareTo(input, "back")) {
            result = true;
            flagSummaryStats = true;
        } else if (console.compareTo(input, "home") ||
                console.compareTo(input, "HOME") ||
                console.compareTo(input, "back")) {
            result = true;
            flagHome = true;
        } else if (console.compareTo(input, "4") || console.compareTo(input, "load graph")) {
            result = false;
        }

        return result;
    }

    /*
     * Check the input to the console by community users
     */
    public boolean communityFeatureSelection(String input) {

        flagHome = false;
        boolean result = false;
        if (console.compareTo(input, "1") ||
                console.compareTo(input, "data graph visualisation") ||
                console.compareTo(input, "DATA GRAPH VISUALISATION") ||
                console.compareTo(input, "graph")) {
            result = true;
        } else if (console.compareTo(input, "2") ||
                console.compareTo(input, "3") ||
                console.compareTo(input, "load custom dataset") ||
                console.compareTo(input, "load") ||
                console.compareTo(input, "view summary statistics")) {
            result = false;
        } else if (console.compareTo(input, "home") ||
                console.compareTo(input, "HOME") ||
                console.compareTo(input, "back")) {
            result = true;
            flagHome = true;
        }

        return result;
    }
}