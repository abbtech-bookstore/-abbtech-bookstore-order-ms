package org.abbtech.practice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "notificcation-client", url = "http://localhost:8084/abbtech-bookstore-notification-ms")
public interface NotificationClient {
    @GetMapping("/")
    void sendNotification();
}
