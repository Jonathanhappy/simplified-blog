package com.adacorp.postservice.post_services;

import com.adacorp.postservice.post_dto.PostDto;
import com.adacorp.postservice.post_modele.PostModel;


import java.util.List;
import java.util.UUID;

public interface PostService {

    PostDto save(PostDto postDto);
    PostDto findBy(UUID postId);
    List<PostDto> findAll();
    void delete (UUID postId);


}
