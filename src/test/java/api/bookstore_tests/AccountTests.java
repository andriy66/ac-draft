package api.bookstore_tests;

import api.models.User;
import api.requests.AccountRequest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.UUID;

import static api.BaseApi.user;

public class AccountTests {
    private AccountRequest accountRequest = new AccountRequest();
    private User registerUser = new User();
    private String userUuid;
    @Test
    public void verifyAuthorization() {
        String authorized = accountRequest.checkAuthorization(user);
        Assert.assertTrue(Boolean.parseBoolean(authorized));
    }

    @Test
    public void verifyRegistration() {
        String userName = UUID.randomUUID() + "@gmail.com";
        String password = UUID.randomUUID() + "Pas1234%6$$";
        registerUser.setPassword(password);
        registerUser.setUserName(userName);
        User user = accountRequest.registerUser(registerUser);
        userUuid = user.getUserID();
        System.out.println(user);
    }

    @AfterTest
    public void close() {
        if(userUuid != null) {
            accountRequest.deleteUser(user, userUuid);
        }
    }
}
