package com.example.dzSeminar6Ok.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Table
@Data
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    private LocalDateTime localDateTime = LocalDateTime.now();
}
