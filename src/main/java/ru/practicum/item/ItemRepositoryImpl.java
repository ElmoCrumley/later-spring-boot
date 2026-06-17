//package ru.practicum.item;
//
//import org.springframework.stereotype.Repository;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Repository
//public class ItemRepositoryImpl implements ItemRepository {
//    private final Map<Long, Item> items = new HashMap<>();
//
//    @Override
//    public List<Item> findByUserId(long userId) {
//        return items.values().stream()
//                .filter(item -> item.getUserId() == userId)
//                .toList();
//    }
//
//    @Override
//    public Item save(Item item) {
//        item.setId(getNextId());
//        items.put(item.getUserId(), item);
//        return item; //ItemDto
//    }
//
//    @Override
//    public void deleteByUserIdAndItemId(long userId, long itemId) {
//        items.entrySet().removeIf(
//                entry -> entry.getValue().getId() == itemId && entry.getValue().getUserId() == userId
//        );
//    }
//
//    private long getNextId() {
//        long currentMaxId = items.keySet()
//                .stream()
//                .mapToLong(id -> id)
//                .max()
//                .orElse(0);
//        return ++currentMaxId;
//    }
//}
