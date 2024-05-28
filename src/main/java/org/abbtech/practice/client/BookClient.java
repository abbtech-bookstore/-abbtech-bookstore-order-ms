package org.abbtech.practice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.awt.print.Book;
import java.util.UUID;

@FeignClient(name = "book-client", url = "http://localhost:8082/api/abbtech-bookstore-inventory-ms")
public interface BookClient {
    @GetMapping("/{id}")
    Book getBookById(@PathVariable UUID id);
}

