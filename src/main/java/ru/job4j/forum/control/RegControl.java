package ru.job4j.forum.control;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;
import ru.job4j.forum.store.AuthorityRepository;

@Controller
public class RegControl {

    private final UserService userService;
    private final PasswordEncoder encoder;
    private final AuthorityRepository authorityRepository;

    public RegControl(UserService userService, PasswordEncoder encoder, AuthorityRepository authorityRepository) {
        this.userService = userService;
        this.encoder = encoder;
        this.authorityRepository = authorityRepository;
    }

    @GetMapping("/reg")
    public String regPage() {
        return "reg";
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user, Model model) {
        if(userService.getUserByName(user.getUsername())) {
            model.addAttribute("errorMessage","This user already exists!");
            return "reg";
        } else {
            user.setEnabled(true);
            user.setPassword(encoder.encode(user.getPassword()));
            user.setAuthority(authorityRepository.findByAuthority("USER"));
            userService.addUser(user);
            return "redirect:/login";
        }
    }
}
