package com.example.Weekly_Test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_book")
public class Book {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;

    @Column(name = "book_title")
    private String bookTitle;

    @Column(name = "book_author")
    private String author;

    @Column(name = "book_description")
    private String bookDescription;

    @Column(name = "book_price")
    private String bookPrice;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}

