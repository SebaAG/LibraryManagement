package com.info.infoprimeraapp.controller;

import com.info.infoprimeraapp.domain.Publisher;
import com.info.infoprimeraapp.service.publisher.PublisherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/publisher")
@Slf4j
public class PublisherController {
    private final PublisherService ps;

    public PublisherController(PublisherService ps) {
        this.ps = ps;
    }

    @GetMapping()
    public List<Publisher> getAllPublisher() {
        log.info("Requesting publisher");
        return ps.getAllPublisher();
    }

    @PostMapping()
    public Publisher createPublisher(@RequestBody Publisher publisher) {
        log.info("Creating a new publisher");
        return ps.createPublisher(publisher);
    }

    @DeleteMapping("{uuid}")
    public String deletePublisher(@PathVariable UUID id) {
        boolean del = ps.deletePublisher(id);

        if (del) {
            log.info("Publisher deleted");
            return "Publisher deleted";
        } else {
            log.info("Publisher not found");
            return "Publisher not found";
        }
    }

    @PutMapping("{idPublisher}")
    public String updatePublisher(@PathVariable(value = "idPublisher")UUID idPublisher,
                                  @RequestBody Publisher publisherUpdated){

        Optional<Publisher> publisher = ps.updatePublisher(idPublisher,publisherUpdated);

        if(publisher.isEmpty()){
            log.info("Publisher not found");
            return "Book not found";
        }else {
            log.info("Publisher updated");
            return "/api/v1/publisher/"+publisher.get().getId();
        }
    }
    @GetMapping("search")
    public Optional<Publisher> searchPublisherById(@RequestParam("id") UUID id) {
        log.info("Searching publisher by UUID");
        return ps.findPublisherByUUID(id);
    }
}
