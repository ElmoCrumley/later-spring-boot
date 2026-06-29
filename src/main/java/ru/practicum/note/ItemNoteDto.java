package ru.practicum.note;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemNoteDto {
    Long id;
    Long itemId;
    String text;
    String dateOfNote;
    String itemUrl;
}