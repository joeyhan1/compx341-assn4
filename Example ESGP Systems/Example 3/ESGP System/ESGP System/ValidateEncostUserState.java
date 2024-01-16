
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Dictionary;
import java.util.Hashtable;

/*
 * This state is used to receive in the password for an encost user and processes the information
 */
public class ValidateEncostUserState extends State {

    // File that holds username and encrypted passwords
    private String USER_FILE = "users.txt";

    // Hashmap of usernames and passwords
    private Dictionary<String, String> users = new Hashtable<>();

    public ValidateEncostUserState(ConsoleInOut console) {

        super(console);
        render();
    }

    @Override
    void render() {

    }

    @Override
    void exit() {

        console.exit();
    }

    @Override
    public void receiveInput(String input) {

        // Encrypt the password
        String encryptedPassword = encrypt(input);

        // Get the EncostUser object
        EncostUser encostUser = (EncostUser) console.getUser();

        // Store enrypted password on the user object
        encostUser.setPassword(encryptedPassword);

        // Read in the users.text file with usernames and passowrds
        readUserFile();

        // Check that the username and password are valid and move to the next state,
        // else show an error message
        if (validateLogin(encostUser.getUsername(), input)) {

            encostUser.setUserType("encost-verified");
            console.changeState(new FeatureOptionsState(console));

        } else {

            System.err.println("Invalid username and/or password. Please enter again.");
            console.changeState(new LoginState(console));
        }
    }

    /*
     * Get the hashmap of users
     */
    public Dictionary<String, String> getUsers() {

        return this.users;
    }

    /*
     * Add a user to the hashmap
     */
    public void addUser(String username, String password) {

        this.users.put(username, password);
    }

    /*
     * Takes in a username and password, encrypts the password and compares it to
     * the saved details on the user object
     */
    public boolean validateLogin(String usernameIn, String passwordIn) {

        boolean result = false;

        // Encrypt the password
        String encryptedPassword = encrypt(passwordIn);

        // Check if username exists
        String password = users.get(usernameIn);
        if (password != null) {

            // Compare the password
            if (encryptedPassword.equals(password)) {
                result = true;
            }
        }

        return result;
    }

    /*
     * Reads in the user file and stores details in the hashmap
     */
    public void readUserFile() {

        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {

            String str = "";
            while ((str = reader.readLine()) != null) {

                String[] parts = str.split(",");
                addUser(parts[0], parts[1]);
            }

        } catch (IOException e) {

            System.err.print(
                    "Error: something went wrong with validating your login. Please contact the software owner.");
        }
    }

    /*
     * Hashes a password using MD5 algorithm. See
     * https://www.geeksforgeeks.org/md5-hash-in-java/
     */
    public String encrypt(String password) {

        String hashtext = "";
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(password.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return hashtext;
    }
}