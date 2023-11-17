package com.denizkpln.basketservice.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "Basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double currentbalance;

    private LocalDate createDate;

    //@ElementCollection annotasyonu, koleksiyon icerigini ayri bir tabloda depolar. Bu durumda, kullanicinin
    // kitap isimleri ayri bir tabloda saklanir ve bu tablo User tablosu ile iliskilendirilir.
    @ElementCollection
    private List<Long> products;
}
