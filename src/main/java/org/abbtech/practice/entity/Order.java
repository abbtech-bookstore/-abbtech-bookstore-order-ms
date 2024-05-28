package org.abbtech.practice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Order {
    @Id
    private UUID id;
    private UUID bookId;
    private int quantity;
    private UUID userId;
}

