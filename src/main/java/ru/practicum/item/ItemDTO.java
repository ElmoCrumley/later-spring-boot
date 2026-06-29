package ru.practicum.item;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@NoArgsConstructor
@Getter @Setter @ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemDTO {
    Long id;
    String url;

    public static ItemDTO from(Item item) {
        ItemDTO dto = new ItemDTO();
        dto.id = item.getId();
        dto.url = item.getUrl();
        return dto;
    }

    public static List<ItemDTO> fromList(List<Item> items) {
        return items.stream().map(ItemDTO::from).toList();
    }
}
