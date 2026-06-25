package ru.practicum.item;

import java.util.List;

public interface ItemService {
    List<ItemDTO> getItems(long userId);
    ItemDTO addNewItem(long userId, Item item);
    void deleteItem(long userId, long itemId);
}
