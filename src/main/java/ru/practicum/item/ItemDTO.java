package ru.practicum.item;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemDTO {
    long id;
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
