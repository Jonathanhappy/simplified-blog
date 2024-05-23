package com.adacorp.postservice.post_services.impl;

import com.adacorp.postservice.post_dto.PostDto;
import com.adacorp.postservice.post_modele.PostModel;
import com.adacorp.postservice.post_repository.PostRepository;
import com.adacorp.postservice.post_services.PostService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImplPostService implements PostService {

    @Autowired
    private PostRepository postRepository;


    @Override
    public PostDto save(PostDto postdto) {

        PostModel createdPost =  PostModel.builder()
                .postId(postdto.getPostId())
                .postContent(postdto.getPostContent())
                .datePosted(postdto.getDatePosted())
                .title(postdto.getTitle())
                .build();

        return PostDto.DuModelAuDto(postRepository
                .save(PostDto.DuDtoAuModel(postdto))
        );
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
    public List<PostDto> findBy(String keyword) {
        List<PostModel> allposts = postRepository.findAll();
//        List<PostDto> result = new ArrayList<>();

//        for (PostModel item:allposts){
//            if(item.getTitle().contains(keyword) || item.getPostContent().contains(keyword)){
//                result.add(PostDto.DuModelAuDto(item));
//            }
//        }
//
//        return result;
        return allposts.stream()
                .map(PostDto::DuModelAuDto)
                .filter(postDto -> postDto.getPostContent().contains(keyword) || postDto.getTitle().contains(keyword))
                .collect(Collectors.toList());
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
    public PostDto updatePostById(UUID postId, Map<String,String> champAmodifier) {

        //find the post to update
        PostModel modifiedPost = postRepository.findById(postId)
                .orElseThrow(()->new EntityNotFoundException("Aucun post trouvé avec l'Id "+postId));

        champAmodifier.forEach((key, value)->{
            //identifier le champ à modifier
            Field field = ReflectionUtils.findField(PostModel.class, key);

            //Activation du champ à modifier
            field.setAccessible(true);

            //Modification du champ
            ReflectionUtils.setField(field, modifiedPost, value);
        });

        return PostDto.DuModelAuDto(
                postRepository.save(modifiedPost)
        );
    }

    @Override
    public void delete(UUID postId) {

        postRepository.deleteById(postId);
    }

}
