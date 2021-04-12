package ru.job4j.forum.service;


import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final List<Post> posts = new ArrayList<>();

    public PostService() {
        posts.add(Post.of("Продаю машину ладу 01."));
    }

    public List<Post> getAll() {
        return posts;
    }

    public Post getById(int id) {
        return posts.get(id);
    }

    public Post save(Post post) {
        if(posts.get(post.getId()) != null) {
            posts.add(post.getId(), post);
        } else {
            posts.add(post);
        }
        return post;
    }
}
