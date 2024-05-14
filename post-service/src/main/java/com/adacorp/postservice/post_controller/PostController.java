package com.adacorp.postservice.post_controller;


import com.adacorp.postservice.post_dto.PostDto;
import com.adacorp.postservice.post_services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/posts/")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("create")
    public PostDto newPost(@RequestBody PostDto postdto){

        return postService.save(postdto);
    }

}
