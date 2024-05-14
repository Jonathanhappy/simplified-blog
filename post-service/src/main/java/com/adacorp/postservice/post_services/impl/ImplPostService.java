package com.adacorp.postservice.post_services.impl;

import com.adacorp.postservice.post_dto.PostDto;
import com.adacorp.postservice.post_modele.PostModel;
import com.adacorp.postservice.post_repository.PostRepository;
import com.adacorp.postservice.post_services.PostService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImplPostService implements PostService {

    private final PostRepository postRepository;


    @Override
    public PostDto save(PostDto postdto) {

        PostModel createdPost =  new PostModel();
        createdPost = postRepository.save(PostDto.DuDtoAuModel(postdto));

        return PostDto.DuModelAuDto(createdPost);
    }

    @Override
    public PostDto findBy(UUID postId) {
        return null;
    }

    @Override
    public List<PostDto> findAll() {
        return List.of();
    }

    @Override
    public void delete(UUID postId) {

    }

}
