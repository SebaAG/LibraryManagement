package com.info.infoprimeraapp.service.sql;

import com.info.infoprimeraapp.domain.Publisher;
import com.info.infoprimeraapp.repository.PublisherRepository;
import com.info.infoprimeraapp.service.PublisherService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Service
@AllArgsConstructor
public class PublisherServiceSQL implements PublisherService {
    private final PublisherRepository pr;

    @Override
    public List<Publisher> getAllPublisher() {
        return (List<Publisher>) pr.findAll();
    }

    @Override
    public Publisher createPublisher(Publisher publisher) {
        return pr.save(publisher);
    }

    @Override
    public Optional<Publisher> updatePublisher(UUID uuidPublisher, Publisher publisherUpdated) {
        Optional<Publisher> existingReview = pr.findById(uuidPublisher);
        if (existingReview.isPresent()) {
            publisherUpdated.setId(uuidPublisher);
            return Optional.of(pr.save(publisherUpdated));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Publisher> findPublisherByUUID(UUID id) {
        return pr.findById(id);
    }

    @Override
    public boolean deletePublisher(UUID idPublisher) {
        if (pr.existsById(idPublisher)) {
            pr.deleteById(idPublisher);
            return true;
        }
        return false;
    }
}