package com.assignment.cabservice.controller;
import com.assignment.cabservice.model.User;
import org.springframework.stereotype.Controller;
import com.assignment.cabservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @RequestMapping(value="add-user",method= RequestMethod.GET)
    public String showNewUserPage(User user) {
        return "user";
    }

    @RequestMapping(value="add-user",method= RequestMethod.POST)
    public String addNewUser(User user) {
        user.setPassword("$2a$12$TLJOLK.QjLRdxOHew1XMT.eYa2Xr5HMHaT14fRoI3gMOIZijNu9F2");//123
        user.setRole("USER");
        userRepository.save(user);
        return "redirect:list-users";
    }

    @RequestMapping("list-users")
    public String listAllUsers(ModelMap modelMap) {
        List<User> users=userRepository.findAll();
        modelMap.put("users",users);
        return "listUsers";
    }
}
