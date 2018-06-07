package design.hustlelikeaboss.web.application;

import design.hustlelikeaboss.data.entity.Role;
import design.hustlelikeaboss.data.entity.User;
import design.hustlelikeaboss.data.repository.RoleRepository;
import design.hustlelikeaboss.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashSet;

@RequestMapping("/")
@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/registration")
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registerNewUser(Model model, @ModelAttribute @Valid User user, Errors errors) {

        // validate inputs
        if (errors.hasErrors()) {
            model.addAttribute("user", user);
            model.addAttribute("errors", errors);
            return "registration";
        }

        // check if email has been registered
        if (userRepository.findByEmail(user.getEmail()) != null) {
            model.addAttribute("user", user);
            model.addAttribute("isDuplicate", true);
            return "registration";
        }

        // prepare user to save
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));

        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/admin")
    public String showHome(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByEmail(auth.getName());

        model.addAttribute("userName", user.getName()); // first name

        return "admin/home";
    }
}
