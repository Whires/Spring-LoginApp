package Main;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {

    private String username;
    private String password;

    private final LoggedInUserManagementService loggedInUserManagementService;

    public LoginProcessor(LoggedInUserManagementService loggedInUserManagementService) {
        this.loggedInUserManagementService = loggedInUserManagementService;
    }

    public boolean login() {
        String username = this.getUsername();
        String password = this.getPassword();

        if ("natalie".equals(username) && "password".equals(password)) {
            loggedInUserManagementService.setUsername(username);
            return true;
        }else {
            return false;
        }
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
