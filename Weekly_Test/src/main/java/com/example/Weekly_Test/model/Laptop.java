package com.example.Weekly_Test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_laptop")
public class Laptop {

    @Id
    @Column(name = "laptop_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int laptopId;

    @Column(name = "laptop_name")
    private String laptopName;

    @Column(name = "laptop_brand")
    private String laptopBrand;

    @Column(name = "laptop_price")
    private int laptopPrice;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;


}
