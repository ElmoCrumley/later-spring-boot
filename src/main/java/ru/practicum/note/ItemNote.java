package ru.practicum.note;

import jakarta.validation.constraints.Size;
import lombok.*;
import ru.practicum.item.Item;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.Instant;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter @Setter @ToString
@Entity
@Table(name = "item_notes", schema = "public")
public class ItemNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Size(max = 2000, message = "Максимальная длина text — 2000 символов")
    String text;

    @ManyToOne
    @JoinColumn(name = "item_id")
    Item item;

    @Column(name = "save_note_date")
    Timestamp saveNoteDate = Timestamp.from(Instant.now());

}
