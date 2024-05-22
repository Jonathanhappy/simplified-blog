package com.adacorp.postservice.post_dto;

import com.adacorp.postservice.post_modele.PostModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PostDto {

    private int postId;
    private String title;
    private String postContent;
    private LocalDate datePosted;

    public static PostModel DuDtoAuModel(PostDto postdto){

        if (postdto == null){
            return null;
        }

        PostModel postModel = new PostModel();
        postModel.setPostId(postdto.getPostId());
        postModel.setPostContent(postdto.getPostContent());
        postModel.setDatePosted(postdto.getDatePosted());
        postModel.setTitle(postdto.getTitle());

        return postModel;
    }


    public static PostDto DuModelAuDto(PostModel postmodel){

        if (postmodel == null){
            return null;
        }

        return PostDto.builder()
                .postId(postmodel.getPostId())
                .title(postmodel.getTitle())
                .datePosted(postmodel.getDatePosted())
                .postContent(postmodel.getPostContent())
                .build();
    }
}
