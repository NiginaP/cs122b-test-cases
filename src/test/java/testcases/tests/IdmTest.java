package testcases.tests;

import edu.uci.ics.cs122b.test.common.Result;
import testcases.socket.IdmSocket;
import testcases.model.hw2.LoginResponseModel;
import testcases.model.hw2.RegisterResponseModel;
import edu.uci.ics.cs122b.test.util.ServiceResponse;
import edu.uci.ics.cs122b.test.common.Json;
import org.junit.Test;

import static org.junit.Assert.*;

public class IdmTest
{
    /*     Register Tests
     *
     *
     *
     *
     **/
    @Test
    public void registerSuccessfully()
    {
        Result expectedResult = Result.USER_REGISTERED_SUCCESSFULLY;
        RegisterResponseModel expectedModel = new RegisterResponseModel(expectedResult);
        String password = "AAAbbb111222";
        char[] passwordArray = password.toCharArray();
        ServiceResponse<RegisterResponseModel> response = IdmSocket.postRegister("hehehe@uci.edu", passwordArray);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void registerPasswordNotMeetLengthRequirementTooShort()
    {
        Result expectedResult = Result.PASSWORD_INVALID_LENGTH;
        RegisterResponseModel expectedModel = new RegisterResponseModel(expectedResult);
        String password = "Aa1";
        char[] passwordArray = password.toCharArray();
        ServiceResponse<RegisterResponseModel> response = IdmSocket.postRegister("peter@uci.edu", passwordArray);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void registerPasswordNotMeetLengthRequirementTooLong()
    {
        Result expectedResult = Result.PASSWORD_INVALID_LENGTH;
        RegisterResponseModel expectedModel = new RegisterResponseModel(expectedResult);
        String password = "Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1";
        char[] passwordArray = password.toCharArray();
        ServiceResponse<RegisterResponseModel> response = IdmSocket.postRegister("peter@uci.edu", passwordArray);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void registerEmailInvalidFormatNoEmail()
    {
        Result expectedResult = Result.EMAIL_ADDRESS_INVALID_FORMAT;
        RegisterResponseModel expectedModel = new RegisterResponseModel(expectedResult);
        String password = "AAAAAaaaaa111";
        char[] passwordArray = password.toCharArray();
        ServiceResponse<RegisterResponseModel> response = IdmSocket.postRegister("@uci.edu", passwordArray);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void registerEmailInvalidFormatNoAT()
    {
        Result expectedResult = Result.EMAIL_ADDRESS_INVALID_FORMAT;
        RegisterResponseModel expectedModel = new RegisterResponseModel(expectedResult);
        String password = "AAAAAaaaaa111";
        char[] passwordArray = password.toCharArray();
        ServiceResponse<RegisterResponseModel> response = IdmSocket.postRegister("peteruci.edu", passwordArray);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void registerEmailInvalidFormatNoDomain()
    {
        Result expectedResult = Result.EMAIL_ADDRESS_INVALID_FORMAT;
        RegisterResponseModel expectedModel = new RegisterResponseModel(expectedResult);
        String password = "AAAAAaaaaa111";
        char[] passwordArray = password.toCharArray();
        ServiceResponse<RegisterResponseModel> response = IdmSocket.postRegister("peter@.edu", passwordArray);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void registerEmailInvalidFormatNoExtension()
    {
        Result expectedResult = Result.EMAIL_ADDRESS_INVALID_FORMAT;
        RegisterResponseModel expectedModel = new RegisterResponseModel(expectedResult);
        String password = "AAAAAaaaaa111";
        char[] passwordArray = password.toCharArray();
        ServiceResponse<RegisterResponseModel> response = IdmSocket.postRegister("peter@uci.", passwordArray);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void registerEmailInvalidFormatContainsNotAlphanumericChar()
    {
        Result expectedResult = Result.EMAIL_ADDRESS_INVALID_FORMAT;
        RegisterResponseModel expectedModel = new RegisterResponseModel(expectedResult);
        String password = "AAAAAaaaaa111";
        char[] passwordArray = password.toCharArray();
        ServiceResponse<RegisterResponseModel> response = IdmSocket.postRegister("peter#$%^@uci.edu", passwordArray);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void registerEmailInvalidLengthEmptyString()
    {
        Result expectedResult = Result.EMAIL_ADDRESS_INVALID_LENGTH;
        RegisterResponseModel expectedModel = new RegisterResponseModel(expectedResult);
        String password = "AAAAAaaaaa111";
        char[] passwordArray = password.toCharArray();
        ServiceResponse<RegisterResponseModel> response = IdmSocket.postRegister("", passwordArray);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void registerEmailInvalidLengthNull()
    {
        Result expectedResult = Result.EMAIL_ADDRESS_INVALID_LENGTH;
        RegisterResponseModel expectedModel = new RegisterResponseModel(expectedResult);
        String password = "AAAAAaaaaa111";
        char[] passwordArray = password.toCharArray();
        ServiceResponse<RegisterResponseModel> response = IdmSocket.postRegister(null, passwordArray);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void registerParse()
    {
        Result expectedResult = Result.JSON_PARSE_EXCEPTION;
        RegisterResponseModel expectedModel = new RegisterResponseModel(expectedResult);

        ServiceResponse<RegisterResponseModel> response = IdmSocket.postRegister(Json.PARSE_EXCEP);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void registerMapping()
    {
        Result expectedResult = Result.JSON_MAPPING_EXCEPTION;
        RegisterResponseModel expectedModel = new RegisterResponseModel(expectedResult);

        ServiceResponse<RegisterResponseModel> response = IdmSocket.postRegister(Json.MAPPING_EXCEP);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void registerPasswordInvalidLengthEmpty()
    {
        Result expectedResult = Result.PASSWORD_INVALID_LENGTH;
        RegisterResponseModel expectedModel = new RegisterResponseModel(expectedResult);
        String password = "";
        char[] passwordArray = password.toCharArray();
        ServiceResponse<RegisterResponseModel> response = IdmSocket.postRegister("peter@uci.edu", passwordArray);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void registerPasswordInvalidLengthNull()
    {
        Result expectedResult = Result.PASSWORD_INVALID_LENGTH;
        RegisterResponseModel expectedModel = new RegisterResponseModel(expectedResult);
        ServiceResponse<RegisterResponseModel> response = IdmSocket.postRegister("peter@uci.edu", null);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void registerPasswordNotMeetCharacterRequirement_NoUpperCaseAlpha()
    {
        Result expectedResult = Result.PASSWORD_NOT_MEET_CHARACTER_REQUIREMENTS;
        RegisterResponseModel expectedModel = new RegisterResponseModel(expectedResult);
        String password = "aaabbb111222";
        char[] passwordArray = password.toCharArray();
        ServiceResponse<RegisterResponseModel> response = IdmSocket.postRegister("peter@uci.edu", passwordArray);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void registerPasswordNotMeetCharacterRequirement_NoLowerCaseAlpha()
    {
        Result expectedResult = Result.PASSWORD_NOT_MEET_CHARACTER_REQUIREMENTS;
        RegisterResponseModel expectedModel = new RegisterResponseModel(expectedResult);
        String password = "AAABBB111222";
        char[] passwordArray = password.toCharArray();
        ServiceResponse<RegisterResponseModel> response = IdmSocket.postRegister("peter@uci.edu", passwordArray);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void registerPasswordNotMeetCharacterRequirement_NoNumeric()
    {
        Result expectedResult = Result.PASSWORD_NOT_MEET_CHARACTER_REQUIREMENTS;
        RegisterResponseModel expectedModel = new RegisterResponseModel(expectedResult);
        String password = "AAABBBcccddd";
        char[] passwordArray = password.toCharArray();
        ServiceResponse<RegisterResponseModel> response = IdmSocket.postRegister("peter@uci.edu", passwordArray);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void registerEmailAlreadyInUse()
    {
        Result expectedResult = Result.EMAIL_ALREADY_IN_USE;
        RegisterResponseModel expectedModel = new RegisterResponseModel(expectedResult);
        String password = "AAAbbb111222";
        char[] passwordArray = password.toCharArray();
        ServiceResponse<RegisterResponseModel> response = IdmSocket.postRegister("hehehe@uci.edu", passwordArray);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    /*     Login Tests
     *
     *
     *
     *
     **/
    @Test
    public void loginSuccessfully()
    {
        Result expectedResult = Result.LOGGED_IN_SUCCESSFULLY;
        int expectedSessionIDLength = 64;
        //LoginResponseModel expectedModel = new LoginResponseModel(expectedResult, mockSessionID); //Mock the session? Or responseModel? Or the post function?
        String password = "AAAbbb111222";
        char[] passwordArray = password.toCharArray();
        ServiceResponse<LoginResponseModel> response = IdmSocket.postLogin("hehehe@uci.edu", passwordArray);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        //assertEquals(expectedModel, response.getEntity());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
        assertEquals(expectedSessionIDLength, response.getEntity().getSession_id().length());
    }

    @Test
    public void loginPasswordInvalidLength_EmptyString()
    {
        Result expectedResult = Result.PASSWORD_INVALID_LENGTH;
        int expectedSessionIDLength = 64;
        String password = "";
        char[] passwordArray = password.toCharArray();
        ServiceResponse<LoginResponseModel> response = IdmSocket.postLogin("hehehe@uci.edu", passwordArray);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
        assertEquals(expectedSessionIDLength, response.getEntity().getSession_id().length());
    }

    @Test
    public void loginPasswordInvalidLength_Null()
    {
        Result expectedResult = Result.PASSWORD_INVALID_LENGTH;
        int expectedSessionIDLength = 64;
        ServiceResponse<LoginResponseModel> response = IdmSocket.postLogin("hehehe@uci.edu", null);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
        assertEquals(expectedSessionIDLength, response.getEntity().getSession_id().length());
    }

    @Test
    public void loginEmailAddressInvalidLength_EmptyString()
    {
        Result expectedResult = Result.EMAIL_ADDRESS_INVALID_LENGTH;
        int expectedSessionIDLength = 64;
        String password = "AAAaaa111222";
        char[] passwordArray = password.toCharArray();
        ServiceResponse<LoginResponseModel> response = IdmSocket.postLogin("", passwordArray);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
        assertEquals(expectedSessionIDLength, response.getEntity().getSession_id().length());
    }

    @Test
    public void loginEmailAddressInvalidLength_Null()
    {
        Result expectedResult = Result.EMAIL_ADDRESS_INVALID_LENGTH;
        int expectedSessionIDLength = 64;
        String password = "AAAaaa111222";
        char[] passwordArray = password.toCharArray();
        ServiceResponse<LoginResponseModel> response = IdmSocket.postLogin(null, passwordArray);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
        assertEquals(expectedSessionIDLength, response.getEntity().getSession_id().length());
    }

    @Test
    public void loginEmailAddressInvalidFormat_NoEmail()
    {
        Result expectedResult = Result.EMAIL_ADDRESS_INVALID_FORMAT;
        int expectedSessionIDLength = 64;
        String password = "AAAaaa111222";
        char[] passwordArray = password.toCharArray();
        ServiceResponse<LoginResponseModel> response = IdmSocket.postLogin("@uci.edu", passwordArray);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
        assertEquals(expectedSessionIDLength, response.getEntity().getSession_id().length());
    }

    @Test
    public void loginEmailAddressInvalidFormat_NoAt()
    {
        Result expectedResult = Result.EMAIL_ADDRESS_INVALID_FORMAT;
        int expectedSessionIDLength = 64;
        String password = "AAAaaa111222";
        char[] passwordArray = password.toCharArray();
        ServiceResponse<LoginResponseModel> response = IdmSocket.postLogin("heheheuci.edu", passwordArray);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
        assertEquals(expectedSessionIDLength, response.getEntity().getSession_id().length());
    }

    @Test
    public void loginEmailAddressInvalidFormat_NoDomain()
    {
        Result expectedResult = Result.EMAIL_ADDRESS_INVALID_FORMAT;
        int expectedSessionIDLength = 64;
        String password = "AAAaaa111222";
        char[] passwordArray = password.toCharArray();
        ServiceResponse<LoginResponseModel> response = IdmSocket.postLogin("hehehe@.edu", passwordArray);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
        assertEquals(expectedSessionIDLength, response.getEntity().getSession_id().length());
    }

    @Test
    public void loginEmailAddressInvalidFormat_NoExtension()
    {
        Result expectedResult = Result.EMAIL_ADDRESS_INVALID_FORMAT;
        int expectedSessionIDLength = 64;
        String password = "AAAaaa111222";
        char[] passwordArray = password.toCharArray();
        ServiceResponse<LoginResponseModel> response = IdmSocket.postLogin("hehehe@uci.", passwordArray);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
        assertEquals(expectedSessionIDLength, response.getEntity().getSession_id().length());
    }

    @Test
    public void loginParse()
    {
        Result expectedResult = Result.JSON_PARSE_EXCEPTION;
        //int expectedSessionIDLength = 64;
        ServiceResponse<LoginResponseModel> response = IdmSocket.postLogin(Json.PARSE_EXCEP);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
        assertEquals(null, response.getEntity().getSession_id());
    }

    @Test
    public void loginMapping()
    {
        Result expectedResult = Result.JSON_MAPPING_EXCEPTION;
        //int expectedSessionIDLength = 64;
        LoginResponseModel expectedModel = new LoginResponseModel(expectedResult);
        ServiceResponse<LoginResponseModel> response = IdmSocket.postLogin(Json.MAPPING_EXCEP);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void loginPasswordNotMatch()
    {
        Result expectedResult = Result.PASSWORD_NOT_MATCH;
        LoginResponseModel expectedModel = new LoginResponseModel(expectedResult);
        String password = "BBBbbb333444";
        char[] passwordArray = password.toCharArray();
        ServiceResponse<LoginResponseModel> response = IdmSocket.postLogin("hehehe@uci.edu", passwordArray);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void loginUserNotFound()
    {
        Result expectedResult = Result.USER_NOT_FOUND;
        LoginResponseModel expectedModel = new LoginResponseModel(expectedResult);
        String password = "AAAbbb111222";
        char[] passwordArray = password.toCharArray();
        ServiceResponse<LoginResponseModel> response = IdmSocket.postLogin("hahaha233@uci.edu", passwordArray);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }
}
