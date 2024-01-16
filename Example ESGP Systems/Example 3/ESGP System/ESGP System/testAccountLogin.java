
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class testAccountLogin {

    // Create global objects
    ConsoleInOut console = new ConsoleInOut();
    ValidateEncostUserState validateEncostUserState = new ValidateEncostUserState(console);

    // Reassign the standard output stream
    @BeforeEach
    public void setUsers() {
        validateEncostUserState.addUser("encostUserA", "7d347cf0ee68174a3588f6cba31b8a67");
        validateEncostUserState.addUser("encostUserB", "a21992c8f0aca8b8961b06c8e30eff6c");
        validateEncostUserState.addUser("encostUserC", "96b33694c4bb7dbd07391e0be54745fb");
        validateEncostUserState.addUser("encostUserD", "707feb80cb13a4aee7fe4b237809c75f");
        validateEncostUserState.addUser("encostUserE", "c9f4b9f9b86009864ab88de7a2285613");
        validateEncostUserState.addUser("encostUserF", "8ccdd982db9aabb935033f4100336ebc");
        validateEncostUserState.addUser("encostUserG", "b29d2953c56077a5ef8b2ad193ec240f");
        validateEncostUserState.addUser("encorstUserH", "f536a1f408e71227780f6d5ac41dd9d2");
        validateEncostUserState.addUser("encostUserI", "482c811da5d5b4bc6d497ffa98491e38");
        validateEncostUserState.addUser("encostUserJ", "e9fefd79797362d62e22f99be2c5249f");
    }

    // TESTING: validateLogin() method
    // EXPECTED: true is returned
    @Test
    @DisplayName("Testing validateLogin() for a valid login")
    public void validUsername_validPassword() {

        // ACT
        String inputUsername = "encostUserB";
        String inputPassword = "password234";
        boolean result = validateEncostUserState.validateLogin(inputUsername, inputPassword);

        // ASSERT
        Assertions.assertTrue(result);
    }

    // TESTING: validateLogin() method
    // EXPECTED: false is returned
    @Test
    @DisplayName("Testing validateLogin() for an invalid username")
    public void invalidUsername_validPassword() {

        // ACT
        String inputUsername = "encostUserX";
        String inputPassword = "password234";
        boolean result = validateEncostUserState.validateLogin(inputUsername, inputPassword);

        // ASSERT
        Assertions.assertFalse(result);
    }

    // TESTING: validateLogin() method
    // EXPECTED: false is returned
    @Test
    @DisplayName("Testing validateLogin() for an invalid password")
    public void validUsername_invalidPassword() {

        // ACT
        String inputUsername = "encostUserB";
        String inputPassword = "password";
        boolean result = validateEncostUserState.validateLogin(inputUsername, inputPassword);

        // ASSERT
        Assertions.assertFalse(result);
    }

    // TESTING: validateLogin() method
    // EXPECTED: false is returned
    @Test
    @DisplayName("Testing validateLogin() for an invalid password and username")
    public void invalidUsername_invalidPassword() {

        // ACT
        String inputUsername = "encostUser";
        String inputPassword = "password";
        boolean result = validateEncostUserState.validateLogin(inputUsername, inputPassword);

        // ASSERT
        Assertions.assertFalse(result);
    }

    // TESTING: encrypt() method
    // EXPECTED: encrypted string returned is correct
    @Test
    @DisplayName("Testing encrypt()")
    public void encrypt() {

        // ASSIGN
        String passwordRaw = "teststring";
        String passwordMD5Hashed = "d67c5cbf5b01c9f91932e3b8def5e5f8"; // https://www.md5hashgenerator.com/

        // ACT
        String encryptedPassword = validateEncostUserState.encrypt(passwordRaw);

        // ASSERT
        Assertions.assertEquals(encryptedPassword, passwordMD5Hashed);
    }
}