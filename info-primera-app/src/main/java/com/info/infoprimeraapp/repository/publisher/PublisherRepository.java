package com.info.infoprimeraapp.repository.publisher;

import com.info.infoprimeraapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, UUID> {

    Optional<Publisher> findById(UUID id);
}
