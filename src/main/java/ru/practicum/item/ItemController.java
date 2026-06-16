package ru.practicum.item;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
    public static final String SHARER_USER_ID = "X-Later-User-Id";
    private final ItemService itemService;

    @GetMapping
    public List<ItemDTO> get(@RequestHeader(SHARER_USER_ID) long userId) {
        return itemService.getItems(userId);
    }

    @PostMapping
    public ItemDTO add(@RequestHeader(SHARER_USER_ID) Long userId,
                    @RequestBody Item item) {
        return itemService.addNewItem(userId, item);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@RequestHeader(SHARER_USER_ID) long userId,
                           @PathVariable(name="itemId") long itemId) {
        itemService.deleteItem(userId, itemId);
    }
}