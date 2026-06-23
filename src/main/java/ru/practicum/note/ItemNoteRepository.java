package ru.practicum.note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemNoteRepository extends JpaRepository<ItemNote, Long> {

    // Запросный метод
    List<ItemNote> findByUserIdAndUrlContaining(Long userId, String url);

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
}
