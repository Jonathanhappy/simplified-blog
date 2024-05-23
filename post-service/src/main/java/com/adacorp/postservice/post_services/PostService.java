package com.adacorp.postservice.post_services;

import com.adacorp.postservice.post_dto.PostDto;
import org.springframework.http.ResponseEntity;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface PostService {

    PostDto save(PostDto postDto);
    PostDto findById(UUID postId);
    PostDto findByDatePosted(LocalDate datePosted);
    List<PostDto> findBy(String keyword);
    List<PostDto> findAll();
    PostDto updatePostById(UUID postId, Map<String, String> champAmodifier);
    void delete (UUID postId);

}
