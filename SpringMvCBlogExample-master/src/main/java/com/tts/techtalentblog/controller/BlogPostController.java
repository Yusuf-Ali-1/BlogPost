package com.tts.techtalentblog.controller;

import com.tts.techtalentblog.model.BlogPost;
import com.tts.techtalentblog.repo.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BlogPostController {

    //@Autowired allows us to implement dependency injection
    //dependency injection allows us to give certain objects the dependencies that they need
    @Autowired
    private BlogPostRepository blogPostRepository;
    private static List<BlogPost> posts = new ArrayList<>();

    //GetMapping annotation specifies the route to this URI, in this case
    @GetMapping(value="/")
    public String index(BlogPost blogPost, Model model){
        //because we are utilizing thymeleaf
        //our output will be generated in a template
        //returning a reference to that template
        //will allow us to show the data that we want
        model.addAttribute("posts", posts);
        return "blogpost/index";
    }

    //method to view new blog posts we have created
    //will allow us to show out blog posts
    @GetMapping(value = "/blogpost/new")
    public String newBlog (BlogPost blogPost) {
        return "blogpost/new";
    }

    //this is where we are mapping our post requests in our project
    private BlogPost blogPost;
    @PostMapping(value="/blogpost")
    public String addNewBlogPost(BlogPost blogPost, Model model){
        blogPostRepository.save(blogPost);
        //blogPost from our parameter is the object that we're getting from
        //the thymeleaf form, we can simply save it in our repository
        model.addAttribute( "title", blogPost.getTitle());
        model.addAttribute( "author", blogPost.getAuthor());
        model.addAttribute( "blogEntry", blogPost.getBlogEntry());
        return "blogpost/result";
    }



}
