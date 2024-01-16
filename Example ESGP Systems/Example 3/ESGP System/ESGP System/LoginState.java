
/*
 * This state is used to handle the input with the username for Encost users
 */
public class LoginState extends State {

    public LoginState(ConsoleInOut console) {

        super(console);
        render();
    }

    @Override
    void render() {

        System.out.println("Please enter your Encost username");
    }

    @Override
    void exit() {

        console.exit();
    }

    @Override
    public void receiveInput(String input) {

        // Update the username to the EncostUser object
        EncostUser encostUser = (EncostUser) console.getUser();
        encostUser.setUserName(input);

        // Transition to the validate state to receive the password
        console.changeState(new ValidateEncostUserState(console));
    }
}
