package com.info.infoprimeraapp.service;

import com.info.infoprimeraapp.domain.Publisher;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PublisherService {
    List<Publisher> getAllPublisher();

    Publisher createPublisher(Publisher publisher);

    Optional<Publisher> updatePublisher(UUID uuidPublisher, Publisher publisherUpdated);

    Optional<Publisher> findPublisherByUUID(UUID id);

    boolean deletePublisher(UUID idPublisher);
}