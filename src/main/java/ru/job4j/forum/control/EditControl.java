package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

@Controller
public class EditControl {

    private final PostService postService;

    public EditControl(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam int id, Model model) {
        model.addAttribute("post", postService.getById(id));
    return "edit";
    }

    @PostMapping("/edit")
    public String editPost(@ModelAttribute Post post, Model model) {
        if(post.getName() != null && post.getDesc() != null) {
            postService.save(post);
        }
        return "edit";
    }
}
