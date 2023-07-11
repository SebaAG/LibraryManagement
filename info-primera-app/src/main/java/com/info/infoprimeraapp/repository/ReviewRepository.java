package com.info.infoprimeraapp.repository;

import com.info.infoprimeraapp.domain.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReviewRepository extends CrudRepository<Review, UUID> {

    Optional<Review> findById(UUID id);
}
