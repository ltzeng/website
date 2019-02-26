package website.hello;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import website.dao.FileDBReader;
import website.domain.User;

@Controller
public class UsersListController {

	@GetMapping("/users")
	public String getUsers(Model model) {
	    
	    model.addAttribute("users", getUsers());
        return "hello";
    }
	
	private List<User> getUsers() {
	    FileDBReader dbReader = new FileDBReader();
	    List<User> users = dbReader.getAllUsers();
	    return users;
	}
}
