package ru.practicum.note;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.practicum.item.Item;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemNoteMapper {

    public static ItemNoteDto mapToItemNoteDto(ItemNote itemNote) {
        return new ItemNoteDto(
                itemNote.getId(),
                itemNote.getItem().getId(),
                itemNote.getText(),
                itemNote.getFormatSaveNoteDate(),
                itemNote.getItem().getUrl()
        );
    }

    public static ItemNote mapToItemNote(ItemNoteDto itemNoteDto, Item item) {
        return new ItemNote(item, itemNoteDto.getText());
    }

    public static List<ItemNoteDto> mapToItemNoteDto(List<ItemNote> itemNotes) {
        return itemNotes.stream().map(ItemNoteMapper::mapToItemNoteDto).toList();
    }
}
