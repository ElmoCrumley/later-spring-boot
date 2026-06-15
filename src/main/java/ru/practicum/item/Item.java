package ru.practicum.item;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "items", schema = "public")
class Item {

    @Id
    private Long id;

    @Column(name = "userId", nullable = false)
    private Long userId;

    @Column(name = "url")
    private String url;
}