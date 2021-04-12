package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.service.PostService;

@Controller
public class PostControl {

    private final PostService postService;

    public PostControl(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post")
    public String postPage(@RequestParam int id, Model model) {
        model.addAttribute("post", postService.getById(id));
        return "edit";
    }

}