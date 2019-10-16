package testcases.socket;

import testcases.model.hw2.LoginRequestModel;
import testcases.model.hw2.RegisterRequestModel;
import testcases.model.hw2.LoginResponseModel;
import testcases.model.hw2.RegisterResponseModel;
import edu.uci.ics.cs122b.test.util.ServiceResponse;
import edu.uci.ics.cs122b.test.util.ServiceSocket;
import edu.uci.ics.cs122b.test.util.ServiceSocketFactory;

import java.net.URI;

public class IdmSocket
{
    private final static String SCHEME;
    private final static String ADDRESS;
    private final static String PORT;
    private final static String API_PATH;

    private final static URI FULL_URI;

    private final static String REGISTER_EP = "/register";
    private final static String LOGIN_EP = "/login";

    private final static ServiceSocketFactory SOCKET_FACTORY;

    static {
        SCHEME = "http://";
        ADDRESS = "127.0.0.1";
        PORT = ":12345";
        API_PATH = "/api/idm";

        FULL_URI = URI.create(SCHEME + ADDRESS + PORT + API_PATH);

        SOCKET_FACTORY = ServiceSocketFactory.createFactory(FULL_URI);
    }

    public static ServiceResponse<LoginResponseModel> postLogin(String email, char[] password)
    {
        LoginRequestModel requestModel = new LoginRequestModel(email, password);

        ServiceSocket serviceSocket = SOCKET_FACTORY.createSocket(LOGIN_EP);

        return serviceSocket.post(LoginResponseModel.class, requestModel);
    }

    public static ServiceResponse<LoginResponseModel> postLogin(String request)
    {
        ServiceSocket serviceSocket = SOCKET_FACTORY.createSocket(LOGIN_EP);

        return serviceSocket.post(LoginResponseModel.class, request);
    }

    public static ServiceResponse<RegisterResponseModel> postRegister(String email, char[] password)
    {
        RegisterRequestModel requestModel = new RegisterRequestModel(email, password);

        ServiceSocket serviceSocket = SOCKET_FACTORY.createSocket(REGISTER_EP);

        return serviceSocket.post(RegisterResponseModel.class, requestModel);
    }

    public static ServiceResponse<RegisterResponseModel> postRegister(String request)
    {
        ServiceSocket serviceSocket = SOCKET_FACTORY.createSocket(REGISTER_EP);

        return serviceSocket.post(RegisterResponseModel.class, request);
    }
}
