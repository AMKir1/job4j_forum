package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

@Controller
public class EditControl {

    private final PostService postService;

    public EditControl(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam long id, Model model) {
        model.addAttribute("post", postService.getById(id));
    return "edit";
    }

    @RequestMapping(value="/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute Post post) {
        if(post.getName() != null) {
            postService.update(post);
        }
        return "redirect:/post/" + post.getId();
    }
}
