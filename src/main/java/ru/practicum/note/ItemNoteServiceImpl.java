package ru.practicum.note;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.practicum.item.Item;
import ru.practicum.item.ItemRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemNoteServiceImpl implements ItemNoteService {
    ItemNoteRepository repository;
    ItemRepository itemRepository;

    @Override
    public ItemNoteDto addNewItemNote(long userId, ItemNoteDto itemNoteDto) {
        Item item = itemRepository.findById(itemNoteDto.getItemId())
                .orElseThrow(() -> new RuntimeException("Item not found"));
        ItemNote itemNote = repository.save(ItemNoteMapper.mapToItemNote(itemNoteDto, item));

        return ItemNoteMapper.mapToItemNoteDto(itemNote);
    }

    @Override
    public List<ItemNoteDto> searchNotesByUrl(String url, Long userId) {
        List<ItemNote> itemNotes = repository.findByItem_User_IdAndItem_UrlContaining(userId, url);

        return ItemNoteMapper.mapToItemNoteDto(itemNotes);
    }

    @Override
    public List<ItemNoteDto> searchNotesByTag(long userId, String tag) {
        List<ItemNote> itemNotes = repository.findByUserIdAndTag(userId, tag);

        return ItemNoteMapper.mapToItemNoteDto(itemNotes);
    }

    @Override
    public List<ItemNoteDto> listAllItemsWithNotes(long userId, int from, int size) {
        return repository.findByItem_User_Id(userId, PageRequest.of(from > 0 ? from / size : 0, size))
                .map(ItemNoteMapper::mapToItemNoteDto)
                .getContent();
    }
}
