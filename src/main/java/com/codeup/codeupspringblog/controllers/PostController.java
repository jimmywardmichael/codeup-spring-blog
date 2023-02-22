package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String showPosts(Model model){

        model.addAttribute("allPosts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.findById(id).get());
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String postCreateForm(){
        return "posts/create";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    public String postCreateSubmit(@RequestParam String title, @RequestParam String body){
        Post newPost = new Post(title, body);

        postDao.save(newPost);

        return "redirect:/posts";
    }


}
