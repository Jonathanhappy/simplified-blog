package com.adacorp.postservice.post_modele;


import com.adacorp.postservice.enums.StatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "posts")
public class PostModel {

    @Id
    @GeneratedValue
    private int postId;
    private String title;
    private String postContent;
    private LocalDate datePosted;
    private StatusEnum status;

}
