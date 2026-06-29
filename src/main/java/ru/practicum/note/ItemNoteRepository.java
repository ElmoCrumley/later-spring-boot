package ru.practicum.note;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemNoteRepository extends JpaRepository<ItemNote, Long> {

    // Запросный метод
    List<ItemNote> findByItem_User_IdAndItem_UrlContaining(Long userId, String url);

    // Аннотированный @Query метод c JPQL-запросом.
    // Можно заменить на ItemDTO с конструктором со всеми полями и
    // @Query("select new foler.folder.ItemDTO(i.id, i...) from Item i where...")
    // Можно также "join itn.item i"
    @Query("""
            select distinct itn
            from ItemNote itn
            where itn.item.user.id = ?1
            and ?2 member of itn.item.tags
            """)
    List<ItemNote> findByUserIdAndTag(Long userId, String tag);

    // PageRequest.of(from > 0 ? from / size : 0, size)
    Page<ItemNote> findByItem_User_Id(long userId, Pageable page);
}
