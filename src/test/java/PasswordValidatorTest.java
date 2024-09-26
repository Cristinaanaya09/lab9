import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import com.example.NotificationService;
import com.example.PasswordValidator;

public class PasswordValidatorTest {
    
    NotificationService mockNotification = mock(NotificationService.class);

    @Test
    public void testValidPassword(){
        //Arrange
        PasswordValidator password = new PasswordValidator(mockNotification);
        
        //Act
        boolean result = password.isValidPassword("HELLOironhacks");
        
        //Asset
        assertTrue(result);

    }

    @Test
    public void testInvalidPasswordLessThanEightCharacters(){
        //Arrange
        PasswordValidator password = new PasswordValidator(mockNotification);

        //Act
        boolean result = password.isValidPassword("ABfgr");
        
        //Asset
        assertFalse(result);
    }

    @Test
    public void testInvalidPasswordNoUpperCase(){
        //Arrange
        PasswordValidator password = new PasswordValidator(mockNotification);
        
        //Act
        boolean result = password.isValidPassword("fgrmmslkk");
        
        //Asset
        assertFalse(result);

    }
    
    @Test
    public void testInvalidPasswordNull(){
        //Arrange
        PasswordValidator password = new PasswordValidator(mockNotification);
        
        //Act
        boolean result = password.isValidPassword(null);
        
        //Asset
        assertFalse(result);

    }

    @Test
    public void testValidPasswordJustUppercase(){
        //Arrange
        PasswordValidator password = new PasswordValidator(mockNotification);
        
        //Act
        boolean result = password.isValidPassword("HOLAQUEUEU");
        
        //Asset
        assertTrue(result);

    }

    @Test
    public void testValidPasswordNotification(){
        //Arrange
        
        PasswordValidator password = new PasswordValidator(mockNotification);
        
        //Act
        password.isValidPassword("HOLAQUEUEU");
        
        //Asset
        verify(mockNotification).sendNotification("Password is correct.");

    }


}
