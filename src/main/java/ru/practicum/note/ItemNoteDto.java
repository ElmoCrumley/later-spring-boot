package ru.practicum.note;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ItemNoteDto {

    Long id;
    Long itemId;
    String text;
    String dateOfNote;
    String itemUrl;
}