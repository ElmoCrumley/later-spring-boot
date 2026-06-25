package ru.practicum.note;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class ItemNoteController {
    public static final String SHARER_USER_ID = "X-Later-User-Id";
    private final ItemNoteService itemNoteService;

    @GetMapping(params = "url")
    public List<ItemNoteDto> searchByUrl(@RequestHeader(SHARER_USER_ID) long userId,
                                         @RequestParam(name="url") String url) {
        // возвращает список пользовательских заметок к ссылкам, соответствующим переданному URL-адресу или его части
        return itemNoteService.searchNotesByUrl(url, userId);
    }

    @GetMapping(params = "tag")
    public List<ItemNoteDto> searchByTags(@RequestHeader(SHARER_USER_ID) long userId,
                                          @RequestParam(name = "tag") String tag) {
        // возвращает список заметок пользователя к ссылкам с указанным тегом
        return itemNoteService.searchNotesByTag(userId, tag);
    }

    @GetMapping
    public List<ItemNoteDto> listAllNotes(@RequestHeader(SHARER_USER_ID) long userId,
                                          @RequestParam(name = "from", defaultValue = "0") int from,
                                          @RequestParam(name = "size", defaultValue = "10") int size) {
        // возвращает набор пользовательских заметок, соответствующий указанным параметрам пагинации
        return itemNoteService.listAllItemsWithNotes(userId, from, size);
    }

    @PostMapping
    public ItemNoteDto add(@RequestHeader(SHARER_USER_ID) Long userId, @RequestBody ItemNoteDto itemNote) {
        // добавляет новую заметку к сохранённой ссылке
        return itemNoteService.addNewItemNote(userId, itemNote);
    }
}