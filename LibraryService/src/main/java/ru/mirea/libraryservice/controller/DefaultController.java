package ru.mirea.libraryservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mirea.libraryservice.repository.BookRepo;


@RestController
public class DefaultController {

    @Autowired
    BookRepo bookRepo;
    private static final Logger LOG = LoggerFactory.getLogger("KafkaApp");
    private String accessToken = null;

    @GetMapping("/book/get/{id}")
    public String getBookById(@PathVariable Long id, @RequestParam("access_token") String token){
        if (accessToken == null || !accessToken.equals(token)) return "Not valit token";
        return bookRepo.getBookById(id).toString();
    }

    @KafkaListener(topics = "library-topic", groupId = "jcg-group")
    public String listener(String message){
       accessToken = message;
        LOG.info("Received message in JCG group: {}", accessToken);
       return accessToken;
   }
}
