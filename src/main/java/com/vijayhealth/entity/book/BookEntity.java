package com.vijayhealth.entity.book;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "book")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "res_id")
    private Long resId;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "res_published_at")
    private LocalDateTime resPublishedAt;

    @Column(name = "res_updated_at")
    private LocalDateTime resUpdatedAt;

    @Column(name = "res_deleted_at")
    private LocalDateTime resDeletedAt;

    @Column(name = "res_deleted")
    private Boolean resDeleted;

}
