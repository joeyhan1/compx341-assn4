
/*
 * This class is used to define the abstract methods 
 */
abstract public class State {

    // Declare state
    protected ConsoleInOut console;

    public State(ConsoleInOut console) {

        this.console = console;
    }

    /*
     * This method is primarily used to render a message when the state is first
     * transtioned to
     */
    abstract void render();

    /*
     * This method will exit the console program
     */
    abstract void exit();

    /*
     * This method receives input the console and processes
     */
    public abstract void receiveInput(String input);
}