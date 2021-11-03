package com.vanillabridge.lounge.Controller.Service;

import com.vanillabridge.lounge.Controller.Repository.PersonRepository;
import com.vanillabridge.lounge.Controller.Repository.PostRepository;
import com.vanillabridge.lounge.Model.Gender;
import com.vanillabridge.lounge.Model.Person;
import com.vanillabridge.lounge.Model.Post;
import com.vanillabridge.lounge.Model.Region;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PointPolicy pointPolicy;

    public List<Post> getPostsWithFilter(String region, String gender, int age) {
        List<Post> result = new ArrayList<>();
        List<Post> allPosts = postRepository.findAll();

        for (Post post : allPosts) {
            if(region == null || Region.valueOf(region) == null || Region.valueOf(region) != post.getPostAuthor().getPersonRegion()) {
                continue;
            } else if(gender == null || Gender.valueOf(gender) == null || Gender.valueOf(gender) != post.getPostAuthor().getPersonGender()) {
                continue;
            } else if(age != post.getPostAuthor().getPersonAge()) {
                continue;
            }

            result.add(post);
        }

        return result;
    }

    public JSONObject createPost(JSONObject reqBody) {
        JSONObject result = new JSONObject();
        // check Image Url
        if(reqBody.get("ImageUrl") == null) {
            result.put("Error", "No Image");
        } else {
            // find User
            Long myId = Long.valueOf((Integer) reqBody.get("personId"));
            Person personDto = personRepository.findById(myId).orElse(null);
            if (personDto == null) {
                result.put("Error", "No Person");
                return result;
            }
            if (! pointPolicy.writePost(personDto)) {
                result.put("Error", "lack of points");
                return result;
            }
            personDto.setPersonPointAmount(personDto.getPersonPointAmount() - pointPolicy.postFee);

            Post newPost = Post.builder()
                    .postTitle((String) reqBody.get("postTitle"))
                    .postContent((String) reqBody.get("postContent"))
                    .postAuthor(personDto)
                    .ImageUrl((String) reqBody.get("ImageUrl"))
                    .build();

            postRepository.save(newPost);
            result.put("Success", newPost.toString());
        }

        return result;
    }
}
