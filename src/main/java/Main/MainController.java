package Main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final LoggedInUserManagementService loggedInUserManagementService;

    public MainController(LoggedInUserManagementService loggedInUserManagementService) {
        this.loggedInUserManagementService = loggedInUserManagementService;
    }

    @GetMapping("/home")
    public String home(
            @RequestParam(required = false) String logout,
            Model model
    ) {
        String username = loggedInUserManagementService.getUsername();

        if (logout != null) {
            loggedInUserManagementService.setUsername(null);
        }

        if (username == null) {
            return "redirect:/";
        }

        model.addAttribute("username", username);
        return "home.html";
    }
}
