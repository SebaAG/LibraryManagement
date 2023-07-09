package com.info.infoprimeraapp.bootstrap;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.domain.Publisher;
import com.info.infoprimeraapp.domain.Review;
import com.info.infoprimeraapp.model.BookCsvRecord;
import com.info.infoprimeraapp.model.PublisherCsvRecord;
import com.info.infoprimeraapp.model.ReviewCsvRecord;
import com.info.infoprimeraapp.repository.book.BookRepository;
import com.info.infoprimeraapp.repository.publisher.PublisherRepository;
import com.info.infoprimeraapp.repository.review.ReviewRepository;
import com.info.infoprimeraapp.service.csv.book.BookCsvService;
import com.info.infoprimeraapp.service.csv.publisher.PublisherCsvService;
import com.info.infoprimeraapp.service.csv.review.ReviewCsvService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
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

    @Override
    public void run(String... args) throws Exception {
        log.info("Running BootstrapData");

        loadBookData();
        loadPublisherData();
        loadReviewData();
    }

    private void loadBookData() throws FileNotFoundException {
        if (bookRepository.count() < 100) {
            File file = ResourceUtils.getFile("classpath:csvdata/book_data.csv");
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
    }

    private void loadPublisherData() throws FileNotFoundException {
        if (publisherRepository.count() < 100) {
            File file = ResourceUtils.getFile("classpath:csvdata/publisher_data.csv");
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

    private void loadReviewData() throws FileNotFoundException {
        if (reviewRepository.count() < 100) {
            File file = ResourceUtils.getFile("classpath:csvdata/review_data.csv");
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
}
