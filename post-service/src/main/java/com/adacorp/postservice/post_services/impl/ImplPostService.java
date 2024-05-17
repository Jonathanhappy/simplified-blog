package com.adacorp.postservice.post_services.impl;

import com.adacorp.postservice.post_dto.PostDto;
import com.adacorp.postservice.post_modele.PostModel;
import com.adacorp.postservice.post_repository.PostRepository;
import com.adacorp.postservice.post_services.PostService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public PostDto findById(UUID postId) {

        PostModel myPost = postRepository.findById(postId)
                .orElseThrow(()->new EntityNotFoundException("aucun post trouvé avec l'ID "+ postId));

        return PostDto.DuModelAuDto(myPost);
    }

    @Override
    public PostDto findByDatePosted(LocalDate datePosted) {

        PostModel myPost = postRepository.findByDatePosted(datePosted)
                .orElseThrow(()->new EntityNotFoundException("aucun post trouvé à la date du "+datePosted));
        return PostDto.DuModelAuDto(myPost);
    }

    @Override
    public List<PostDto> findAll() {

        List<PostModel> allPost = postRepository.findAll();
        List<PostDto> postTodisplay = new ArrayList<>();

        for (PostModel item: allPost){
            postTodisplay.add(PostDto.DuModelAuDto(item));
        }

        return postTodisplay;
    }

    @Override
    public void delete(UUID postId) {

        postRepository.deleteById(postId);
    }

}
