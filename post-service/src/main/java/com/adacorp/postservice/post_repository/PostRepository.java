package com.adacorp.postservice.post_repository;

import com.adacorp.postservice.post_modele.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Integer> {
    Optional<PostModel> findByDatePosted(LocalDate datePosted);
}
