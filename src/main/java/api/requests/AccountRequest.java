package api.requests;

import api.models.Token;
import api.models.User;
import api.models.UserID;
import api.settings.Endpoints;
import api.settings.Parser;

import io.restassured.response.Response;

public class AccountRequest {
    private final BaseRequest baseRequest = new BaseRequest();
    public String checkAuthorization(final User user) {
        return baseRequest.post(Endpoints.USER_AUTHORIZED.getUrl(), user).asString();
    }

    public User registerUser(final User user) {
        Response response = baseRequest.post(Endpoints.USER.getUrl(), user);
        Parser parser = new Parser(User.class);
        return (User) parser.parse(response);
    }

    public void deleteUser(final User user, String uuid) {
        Parser parser = new Parser(Token.class);
        Response tokenResponse = baseRequest.getToken(Endpoints.GET_TOKEN.getUrl(), user);
        Token token = (Token)parser.parse(tokenResponse);
        System.out.println("Token for deleting is " + token.getToken());
        UserID userID = new UserID();
        userID.setUserId(user.getUserID());
        Response response = baseRequest.delete(Endpoints.USER.addParamAndGet(uuid), token.getToken());
        System.out.println("The user was deleted with status code:" + response.statusCode());
    }
}
