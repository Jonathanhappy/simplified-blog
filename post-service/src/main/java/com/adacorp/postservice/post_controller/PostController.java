package com.adacorp.postservice.post_controller;


import com.adacorp.postservice.post_dto.PostDto;
import com.adacorp.postservice.post_services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("posts")
@RequiredArgsConstructor
public class PostController {

    /* Injection des dependances du service par un constructeur private*/
    private final PostService postService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("create")
    public PostDto newPost(@RequestBody PostDto postdto){
        return postService.save(postdto);
    }

    @GetMapping("get-all-posts")
    public List<PostDto> getAllPost(){

        return postService.findAll();
    }

    @GetMapping("get-post-by-ID")
    public PostDto findPostById(int postId){

        return postService.findById(postId);
    }

    @GetMapping("get-post-by-datePosted")
    public PostDto findPostByDate(LocalDate datePosted){

        return postService.findByDatePosted(datePosted);
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deletePost(int postId){

        postService.delete(postId);

        return ResponseEntity.ok("the post with ID "+postId+" was successfully deleted");
    }



}
