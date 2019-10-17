package testcases.tests.idm;

import edu.uci.ics.cs122b.test.common.Json;
import edu.uci.ics.cs122b.test.common.Result;
import edu.uci.ics.cs122b.test.util.ServiceResponse;
import org.junit.Test;
import testcases.model.hw2.response.*;
import testcases.socket.IdmSocket;

import static org.junit.Assert.*;

public class IdmTest
{
    //*********************************************
    //
    //                Register Tests
    //
    //*********************************************
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

    //*********************************************
    //
    //                 Login Tests
    //
    //*********************************************
    @Test
    public void loginSuccessfully()
    {
        Result expectedResult = Result.LOGGED_IN_SUCCESSFULLY;
        int expectedSessionIDLength = 64;
        String password = "AAAbbb111222";
        char[] passwordArray = password.toCharArray();

        ServiceResponse<LoginResponseModel> response = IdmSocket.postLogin("hehehe@uci.edu", passwordArray);

        assertEquals(expectedResult.getStatus(), response.getStatus());
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





    //*********************************************
    //
    //                 Session Tests
    //
    //*********************************************
    @Test
    public void tokenLengthTooShort()
    {
        Result expectedResult = Result.TOKEN_INVALID_LENGTH;
        int expectedSessionIDLength = 64;
        String session_id = "bbbb";

        ServiceResponse<SessionResponseModel> response = IdmSocket.postSession("peter@uci.edu", session_id);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
        assertEquals(expectedSessionIDLength, response.getEntity().getSession_id().length());
    }

    @Test
    public void tokenLengthTooLong()
    {
        Result expectedResult = Result.TOKEN_INVALID_LENGTH;
        int expectedSessionIDLength = 64;
        String session_id = "bbbbbbbbbbbbbbssjkbbbbbbbbbbbbssssssjasjdasdkasdassssssssssjjjjjjjjjjjubbbbbbbbbb1111111111890jdhsurnekw";

        ServiceResponse<SessionResponseModel> response = IdmSocket.postSession("peter@uci.edu", session_id);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
        assertEquals(expectedSessionIDLength, response.getEntity().getSession_id().length());
    }

    @Test
    public void sessionTokenInvalidLength_EmptyString()
    {
        Result expectedResult = Result.TOKEN_INVALID_LENGTH;
        int expectedSessionIDLength = 64;
        String session_id = "";

        ServiceResponse<SessionResponseModel> response = IdmSocket.postSession("hehehe@uci.edu", session_id);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
        assertEquals(expectedSessionIDLength, response.getEntity().getSession_id().length());
    }

    @Test
    public void sessionTokenInvalidLength_Null()
    {
        Result expectedResult = Result.TOKEN_INVALID_LENGTH;
        int expectedSessionIDLength = 64;

        ServiceResponse<SessionResponseModel> response = IdmSocket.postSession("hehehe@uci.edu", null);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
        assertEquals(expectedSessionIDLength, response.getEntity().getSession_id().length());
    }

    @Test
    public void sessionEmailAddressInvalidFormat_NoEmail()
    {
        Result expectedResult = Result.EMAIL_ADDRESS_INVALID_FORMAT;
        int expectedSessionIDLength = 64;
        String session_id = "bbbbbbbbbbbbbbssjkbbbbbbbbbbbbssssssjasjdasdkasd1312313123123123"; /* Len is 64 */

        ServiceResponse<SessionResponseModel> response = IdmSocket.postSession("@uci.edu", session_id);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
        assertEquals(expectedSessionIDLength, response.getEntity().getSession_id().length());
    }

    @Test
    public void sessionEmailAddressInvalidFormat_NoAt()
    {
        Result expectedResult = Result.EMAIL_ADDRESS_INVALID_FORMAT;
        int expectedSessionIDLength = 64;
        String session_id = "bbbbbbbbbbbbbbssjkbbbbbbbbbbbbssssssjasjdasdkasd1312313123123123"; /* Len is 64 */

        ServiceResponse<SessionResponseModel> response = IdmSocket.postSession("heheheuci.edu", session_id);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
        assertEquals(expectedSessionIDLength, response.getEntity().getSession_id().length());
    }

    @Test
    public void sessionEmailAddressInvalidFormat_NoDomain()
    {
        Result expectedResult = Result.EMAIL_ADDRESS_INVALID_FORMAT;
        int expectedSessionIDLength = 64;
        String session_id = "bbbbbbbbbbbbbbssjkbbbbbbbbbbbbssssssjasjdasdkasd1312313123123123"; /* Len is 64 */

        ServiceResponse<SessionResponseModel> response = IdmSocket.postSession("hehehe@.edu", session_id);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
        assertEquals(expectedSessionIDLength, response.getEntity().getSession_id().length());
    }

    @Test
    public void sessionEmailAddressInvalidFormat_NoExtension()
    {
        Result expectedResult = Result.EMAIL_ADDRESS_INVALID_FORMAT;
        int expectedSessionIDLength = 64;
        String session_id = "bbbbbbbbbbbbbbssjkbbbbbbbbbbbbssssssjasjdasdkasd1312313123123123"; /* Len is 64 */

        ServiceResponse<SessionResponseModel> response = IdmSocket.postSession("hehehe@uci.", session_id);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
        assertEquals(expectedSessionIDLength, response.getEntity().getSession_id().length());
    }


    @Test
    public void sessionEmailAddressInvalidLength_EmptyString()
    {
        Result expectedResult = Result.EMAIL_ADDRESS_INVALID_LENGTH;
        int expectedSessionIDLength = 64;
        String session_id = "bbbbbbbbbbbbbbssjkbbbbbbbbbbbbssssssjasjdasdkasd1312313123123123"; /* Len is 64 */

        ServiceResponse<SessionResponseModel> response = IdmSocket.postSession("", session_id);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
        assertEquals(expectedSessionIDLength, response.getEntity().getSession_id().length());
    }

    @Test
    public void sessionEmailAddressInvalidLength_Null()
    {
        Result expectedResult = Result.EMAIL_ADDRESS_INVALID_LENGTH;
        int expectedSessionIDLength = 64;
        String session_id = "bbbbbbbbbbbbbbssjkbbbbbbbbbbbbssssssjasjdasdkasd1312313123123123"; /* Len is 64 */

        ServiceResponse<SessionResponseModel> response = IdmSocket.postSession(null, session_id);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
        assertEquals(expectedSessionIDLength, response.getEntity().getSession_id().length());
    }

    @Test
    public void sessionParse()
    {
        Result expectedResult = Result.JSON_PARSE_EXCEPTION;

        ServiceResponse<SessionResponseModel> response = IdmSocket.postSession(Json.PARSE_EXCEP);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
        assertEquals(null, response.getEntity().getSession_id());
    }

    @Test
    public void sessionMapping()
    {
        Result expectedResult = Result.JSON_MAPPING_EXCEPTION;
        SessionResponseModel expectedModel = new SessionResponseModel(expectedResult);

        ServiceResponse<SessionResponseModel> response = IdmSocket.postSession(Json.MAPPING_EXCEP);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void sessionUserNotFound()
    {
        Result expectedResult = Result.USER_NOT_FOUND;
        String session_id = "bbbbbbbbbbbbbbssjkbbbbbbbbbbbbssssssjasjdasdkasd1312313123123123"; /* Len is 64 */

        ServiceResponse<SessionResponseModel> response = IdmSocket.postSession("hahaha233@uci.edu", session_id);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
    }

    @Test
    public void sessionActive()
    {
        Result expectedResult = Result.SESSION_ACTIVE;
        SessionResponseModel expectedModel = new SessionResponseModel(expectedResult);
        String session_id = "bbbbbbbbbbbbbbssjkbbbbbbbbbbbbssssssjasjdasdkasd1312313123123123"; /* Len is 64 */

        ServiceResponse<SessionResponseModel> response = IdmSocket.postSession("hahaha233@uci.edu", session_id);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void sessionExpired()
    {
        Result expectedResult = Result.SESSION_EXPIRED;
        SessionResponseModel expectedModel = new SessionResponseModel(expectedResult);
        String session_id = "bbbbbbbbbbbbbbssjkbbbbbbbbbbbbssssssjasjdasdkasd1312313123123124"; /* Len is 64 */

        ServiceResponse<SessionResponseModel> response = IdmSocket.postSession("hahaha234@uci.edu", session_id);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void sessionClosed()
    {
        Result expectedResult = Result.SESSION_CLOSED;
        SessionResponseModel expectedModel = new SessionResponseModel(expectedResult);
        String session_id = "bbbbbbbbbbbbbbssjkbbbbbbbbbbbbssssssjasjdasdkasd1312313123123125"; /* Len is 64 */

        ServiceResponse<SessionResponseModel> response = IdmSocket.postSession("hahaha235@uci.edu", session_id);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void sessionRevoked()
    {
        Result expectedResult = Result.SESSION_REVOKED;
        SessionResponseModel expectedModel = new SessionResponseModel(expectedResult);
        String session_id = "bbbbbbbbbbbbbbssjkbbbbbbbbbbbbssssssjasjdasdkasd1312313123123126"; /* Len is 64 */

        ServiceResponse<SessionResponseModel> response = IdmSocket.postSession("hahaha236@uci.edu", session_id);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void sessionNotFound()
    {
        Result expectedResult = Result.SESSION_NOT_FOUND;
        SessionResponseModel expectedModel = new SessionResponseModel(expectedResult);
        String session_id = "bbbbbbbbbbbbbbssjkbbbbbbbbbbbbssssssjasjdasdkasd1312313123123127"; /* Len is 64 */

        ServiceResponse<SessionResponseModel> response = IdmSocket.postSession("hahaha237@uci.edu", session_id);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
    }





    //*********************************************
    //
    //                 Privilege Tests
    //
    //*********************************************
    @Test
    public void privilegeLevelOutOfRange()
    {
        Result expectedResult = Result.PLEVEL_OUT_OF_RANGE;
        int plevel = 0;

        ServiceResponse<PrivilegeResponseModel> response = IdmSocket.postPrivilege("peter@uci.edu", plevel);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
    }

    @Test
    public void privilegeLevelOutOfRange2()
    {
        Result expectedResult = Result.PLEVEL_OUT_OF_RANGE;
        int plevel = 6;

        ServiceResponse<PrivilegeResponseModel> response = IdmSocket.postPrivilege("peter@uci.edu", plevel);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
    }

    @Test
    public void privilegeEmailAddressInvalidFormat_NoEmail()
    {
        Result expectedResult = Result.EMAIL_ADDRESS_INVALID_FORMAT;
        int plevel = 5;

        ServiceResponse<PrivilegeResponseModel> response = IdmSocket.postPrivilege("@uci.edu", plevel);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
    }

    @Test
    public void privilegeEmailAddressInvalidFormat_NoAt()
    {
        Result expectedResult = Result.EMAIL_ADDRESS_INVALID_FORMAT;
        int plevel = 5;

        ServiceResponse<PrivilegeResponseModel> response = IdmSocket.postPrivilege("heheheuci.edu", plevel);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
    }

    @Test
    public void privilegeEmailAddressInvalidFormat_NoDomain()
    {
        Result expectedResult = Result.EMAIL_ADDRESS_INVALID_FORMAT;
        int plevel = 5;

        ServiceResponse<PrivilegeResponseModel> response = IdmSocket.postPrivilege("hehehe@.edu", plevel);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
    }

    @Test
    public void privilegeEmailAddressInvalidFormat_NoExtension()
    {
        Result expectedResult = Result.EMAIL_ADDRESS_INVALID_FORMAT;
        int plevel = 5;

        ServiceResponse<PrivilegeResponseModel> response = IdmSocket.postPrivilege("hehehe@uci.", plevel);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
    }


    @Test
    public void privilegeEmailAddressInvalidLength_EmptyString()
    {
        Result expectedResult = Result.EMAIL_ADDRESS_INVALID_LENGTH;
        int plevel = 5;

        ServiceResponse<PrivilegeResponseModel> response = IdmSocket.postPrivilege("", plevel);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
    }

    @Test
    public void privilegeEmailAddressInvalidLength_Null()
    {
        Result expectedResult = Result.EMAIL_ADDRESS_INVALID_LENGTH;
        int plevel = 5;

        ServiceResponse<PrivilegeResponseModel> response = IdmSocket.postPrivilege(null, plevel);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
    }

    @Test
    public void privilegeParse()
    {
        Result expectedResult = Result.JSON_PARSE_EXCEPTION;
        ServiceResponse<PrivilegeResponseModel> response = IdmSocket.postPrivilege(Json.PARSE_EXCEP);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
    }

    @Test
    public void privilegeMapping()
    {
        Result expectedResult = Result.JSON_MAPPING_EXCEPTION;
        PrivilegeResponseModel expectedModel = new PrivilegeResponseModel(expectedResult);

        ServiceResponse<PrivilegeResponseModel> response = IdmSocket.postPrivilege(Json.MAPPING_EXCEP);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void privilegeUserNotFound()
    {
        Result expectedResult = Result.USER_NOT_FOUND;
        int plevel = 5;

        ServiceResponse<PrivilegeResponseModel> response = IdmSocket.postPrivilege("hahaha233@uci.edu", plevel);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
    }

    @Test
    public void privilegeUserHasSufficient()
    {
        Result expectedResult = Result.SUFFICIENT_PRIVILEGE;
        int plevel = 5;

        ServiceResponse<PrivilegeResponseModel> response = IdmSocket.postPrivilege("hahaha233@uci.edu", plevel);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
    }

    @Test
    public void privilegeUserDoesNotHaveSufficient()
    {
        Result expectedResult = Result.INSUFFICIENT_PRIVILEGE;
        int plevel = 1;

        ServiceResponse<PrivilegeResponseModel> response = IdmSocket.postPrivilege("hahaha233@uci.edu", plevel);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResult.getResultCode(), response.getEntity().getResultCode());
        assertEquals(expectedResult.getMessage(), response.getEntity().getMessage());
    }
}
