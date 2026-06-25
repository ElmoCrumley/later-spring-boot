package ru.practicum.note;

import jakarta.validation.constraints.Size;
import lombok.*;
import ru.practicum.item.Item;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    Item item;

    @Column(name = "save_note_date")
    Timestamp saveNoteDate = Timestamp.from(Instant.now());

    public ItemNote(Item item, String text) {
        this.item = item;
        this.text = text;
    }

    String getFormatSaveNoteDate() {
        return DateTimeFormatter
                .ofPattern("yyyy.MM.dd, hh:mm:ss")
                .withZone(ZoneOffset.UTC)
                .format(saveNoteDate.toInstant());
    }

    void setFormatSaveNoteDate(String formatSaveNoteDate) {
        saveNoteDate = Timestamp.from(LocalDateTime.parse(
                formatSaveNoteDate,
                DateTimeFormatter.ofPattern("yyyy.MM.dd, HH:mm:ss")
        ).toInstant(ZoneOffset.UTC));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        return id != null && id.equals(((Item) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
