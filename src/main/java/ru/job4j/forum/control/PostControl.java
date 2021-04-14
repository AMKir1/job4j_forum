package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

@Controller
public class PostControl {

    private final PostService posts;

    public PostControl(PostService posts) {
        this.posts = posts;
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public String get(@PathVariable long id, Model model) {
        model.addAttribute("post", posts.getById(id));
        return "post";
    }

    @RequestMapping(value = "/post/create", method = RequestMethod.POST)
    public String create(@ModelAttribute Post post) {
        posts.save(post);
        return "redirect:/post/" + post.getId();
    }
}
