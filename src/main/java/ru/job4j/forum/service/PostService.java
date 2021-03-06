package ru.job4j.forum.service;


import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.store.PostRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final PostRepository posts;

    public PostService(PostRepository posts) {
        this.posts = posts;
    }

    public List<Post> getAll() {
        List<Post> rsl = new ArrayList<>();
        posts.findAll().forEach(rsl::add);
        return rsl;
    }

    public Post getById(Long id) {
        return this.posts.findById(id).get();
    }

    public void save(Post post) {
        this.posts.save(post);
    }

    public boolean update(Post post) {
        if (this.posts.findById(post.getId()).isPresent()) {
            Post p = this.posts.findById(post.getId()).get();
            p.setName(post.getName());
            p.setDesc(post.getDesc());
            p.setCreated(post.getCreated());
            this.posts.save(post);
            return true;
        }
        return false;
    }
}
