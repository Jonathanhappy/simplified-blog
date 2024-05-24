package com.adacorp.postservice.post_controller;


import com.adacorp.postservice.enums.StatusEnum;
import com.adacorp.postservice.post_dto.PostDto;
import com.adacorp.postservice.post_services.PostService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("posts")
@RequiredArgsConstructor
public class PostController {

    /* Injection des dependances du service par un constructeur private*/
    private final PostService postService;

    @PostMapping("createAndSave")
    public PostDto createAndSave(@RequestBody PostDto postdto){

        postdto.setStatus(StatusEnum.SAVED);

        return postService.save(postdto);
    }

    @PostMapping("createAndDraft")
    public PostDto createAndDraft(@RequestBody PostDto postdto){

        postdto.setStatus(StatusEnum.DRAFTED);
        return postService.save(postdto);
    }

    @Operation(summary = "Afficher la liste des posts")
    @GetMapping("get-all-posts")
    public List<PostDto> getAllPost(){

        return postService.findAll();
    }

    @Operation(summary = "Afficher un post à partir de son identifiant")
    @GetMapping("get-post-by-ID")
    public PostDto findPostById(int postId){

        return postService.findById(postId);
    }

    @Operation(summary = "Afficher un post à partir de la date")
    @GetMapping("get-post-by-datePosted")
    public PostDto findPostByDate(LocalDate datePosted){

        return postService.findByDatePosted(datePosted);
    }

    @Operation(summary = "Afficher un post à partir d'un mot clé")
    @GetMapping("get-post-by-keyword/{keyword}")
    public List<PostDto>findByKeyword(String keyword){

        return postService.findBy(keyword);
    }

    @Operation(summary = "Modifier un post à partir de son identifiant")
    @PatchMapping("change-post/{postId}")
    public PostDto changePostById(@PathVariable UUID postId, @RequestBody Map<String, String> champAmodifier){

        return postService.updatePostById(postId, champAmodifier);
    }

    @Operation(summary = "Supprimer un post")
    @DeleteMapping("delete")
    public ResponseEntity<String> deletePost(int postId){

        postService.delete(postId);

        return ResponseEntity.ok("the post with ID "+postId+" was successfully deleted");
    }


}
