package ru.practicum.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemServiceImpl implements ItemService {
    private final ItemRepository repository;

    @Override
    public List<ItemDTO> getItems(long userId) {
        return ItemDTO.fromList(repository.findByUserId(userId));
    }

    @Override
    @Transactional
    public ItemDTO addNewItem(long userId, Item item) {
        item.setUserId(userId);
        return ItemDTO.from(repository.save(item));
    }

    @Override
    @Transactional
    public void deleteItem(long userId, long itemId) {
        repository.deleteByUserIdAndItemId(userId, itemId);
    }
}
