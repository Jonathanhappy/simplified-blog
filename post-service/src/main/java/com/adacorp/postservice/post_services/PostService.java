package com.adacorp.postservice.post_services;

import com.adacorp.postservice.post_dto.PostDto;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface PostService {

    PostDto save(PostDto postDto);
    PostDto findById(UUID postId);
    PostDto findByDatePosted(LocalDate datePosted);
    List<PostDto> findAll();
    void delete (UUID postId);

}
