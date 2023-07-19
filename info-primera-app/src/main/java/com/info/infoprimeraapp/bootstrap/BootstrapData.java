package com.info.infoprimeraapp.bootstrap;

import com.info.infoprimeraapp.domain.Category;
import com.info.infoprimeraapp.domain.Publisher;
import com.info.infoprimeraapp.domain.Review;
import com.info.infoprimeraapp.model.csv.PublisherCsvRecord;
import com.info.infoprimeraapp.model.csv.ReviewCsvRecord;
import com.info.infoprimeraapp.repository.BookRepository;
import com.info.infoprimeraapp.repository.CategoryRepository;
import com.info.infoprimeraapp.repository.PublisherRepository;
import com.info.infoprimeraapp.repository.ReviewRepository;
import com.info.infoprimeraapp.service.csv.BookCsvService;
import com.info.infoprimeraapp.service.csv.PublisherCsvService;
import com.info.infoprimeraapp.service.csv.ReviewCsvService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class BootstrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final BookCsvService bookCsvService;
    private final PublisherRepository publisherRepository;
    private final PublisherCsvService publisherCsvService;
    private final ReviewRepository reviewRepository;
    private final ReviewCsvService reviewCsvService;
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public void run(String... args) throws Exception {
        log.info("Running BootstrapData");

       // loadBookData();
        loadPublisherData();
        loadReviewData();
        loadCategoryData();
    }

 /*   private void loadBookData() throws IOException {
        if (bookRepository.count() < 100) {
            Resource resource = new ClassPathResource("csvdata/review_data.csv");
            File file = resource.getFile();
            List<BookCsvRecord> bookCsvRecordList = bookCsvService.convertCSV(file);

            if (!bookCsvRecordList.isEmpty()) {
                log.info("Loading books in the DB");
                for (BookCsvRecord bookCsvRecord : bookCsvRecordList) {
                    bookRepository.save(
                            Book.builder()
                                    .uuid(UUID.randomUUID())
                                    .isbn(bookCsvRecord.getIsbn())
                                    .title(bookCsvRecord.getTitle())
                                    .author(bookCsvRecord.getAuthor())
                                    .numberPage(Integer.parseInt(bookCsvRecord.getNumberPage()))
                                    .build()
                    );
                }
            }
        }
    } */

    private void loadPublisherData() throws IOException {
        if (publisherRepository.count() < 100) {
            Resource resource = new ClassPathResource("csvdata/publisher_data.csv");
            File file = resource.getFile();
            List<PublisherCsvRecord> publisherCsvRecordList = publisherCsvService.convertCSV(file);

            if (!publisherCsvRecordList.isEmpty()) {
                log.info("Loading publishers in the DB");
                for (PublisherCsvRecord publisherCsvRecord : publisherCsvRecordList) {
                    publisherRepository.save(
                            Publisher.builder()
                                    .id(UUID.randomUUID())
                                    .publisherName(publisherCsvRecord.getPublisherName())
                                    .address(publisherCsvRecord.getAddress())
                                    .city(publisherCsvRecord.getCity())
                                    .country(publisherCsvRecord.getCountry())
                                    .phone(publisherCsvRecord.getPhone())
                                    .web(publisherCsvRecord.getWeb())
                                    .build()

                    );
                }
            }
        }
    }

    private void loadReviewData() throws IOException {
        if (reviewRepository.count() < 100) {
            Resource resource = new ClassPathResource("csvdata/review_data.csv");
            File file = resource.getFile();
            List<ReviewCsvRecord> reviewCsvRecordList = reviewCsvService.convertCSV(file);

            if (!reviewCsvRecordList.isEmpty()) {
                log.info("Loading reviews in the DB");
                for (ReviewCsvRecord reviewCsvRecord : reviewCsvRecordList) {
                    reviewRepository.save(
                            Review.builder()
                                    .title(reviewCsvRecord.getTitle())
                                    .bookName(reviewCsvRecord.getBookName())
                                    .content(reviewCsvRecord.getContent())
                                    .rate(reviewCsvRecord.getRate())
                                    .date(reviewCsvRecord.getDate())
                                    .build()

                    );
                }
            }
        }
    }

    private void loadCategoryData() {
        if (categoryRepository.count() == 0) {
            Category category1  = Category.builder()
                    .id(UUID.randomUUID())
                    .categoryName("Ficcion")
                    .build();

            Category category2 = Category.builder()
                    .id(UUID.randomUUID())
                    .categoryName("Misterio")
                    .build();

            Category category3 = Category.builder()
                    .id(UUID.randomUUID())
                    .categoryName("Romance")
                    .build();

            categoryRepository.saveAll(List.of(category1,category2,category3));
        }
    }
}
