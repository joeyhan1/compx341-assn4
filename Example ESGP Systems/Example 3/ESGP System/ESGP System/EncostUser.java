
/*
 * This class is used to identify an Encost User type
 */
public class EncostUser extends CommunityUser {

    // Declare variables
    private String username;
    private String password;

    /*
     * Retrieve a custom dataset
     */
    public void getCustomDataset(String path) {
        // Not implemented
    }

    /*
     * Initiate the viewing of summary statistics
     */
    public String viewSummaryStatistics() {

        // Not implemented
        String result = "";
        return result;
    }

    // Getters and setters
    public void setUserName(String input) {

        this.username = input;
    }

    public void setPassword(String input) {

        this.password = input;
    }

    public String getUsername() {

        return this.username;
    }

    public String getPassword() {

        return this.password;
    }
}