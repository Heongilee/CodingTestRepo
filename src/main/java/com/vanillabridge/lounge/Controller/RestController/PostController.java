package com.vanillabridge.lounge.Controller.RestController;

import com.vanillabridge.lounge.Controller.Service.PostService;
import com.vanillabridge.lounge.Model.Post;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostService postSerivce;

    @PostMapping("")
    JSONObject createPost(@RequestBody JSONObject reqBody) {
        return postSerivce.createPost(reqBody);
    }

    @GetMapping("")
    List<Post> getPostsWithFilter(@RequestParam String region, @RequestParam String gender, @RequestParam int age) {
        return postSerivce.getPostsWithFilter(region, gender, age);
    }
}
