package ru.practicum.user;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.item.Item;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@NoArgsConstructor
@Getter @Setter @ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity @Table(name = "users", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "firstName", nullable = false)
    String firstName;

    @Column(name = "lastName")
    String lastName;

    String email;

    @Column(name = "registration_date")
    Instant registrationDate = Instant.now();

    @Enumerated(EnumType.STRING)
    UserState state;

    String getFullName() {
        return firstName + " " + lastName;
    }

    void setFullName(String fullName) {
        if (!fullName.isEmpty()) {
            String[] fullNameCut = Arrays.copyOf(fullName.trim().split("\\s+"), 2);
            this.firstName = fullNameCut[0];
            this.lastName = fullNameCut[1];
        }
    }

    String getRegistrationDateNote() {
        return DateTimeFormatter
                .ofPattern("yyyy.MM.dd, hh:mm:ss")
                .withZone(ZoneOffset.UTC)
                .format(registrationDate);
    }

    void setRegistrationDateNote(String registrationDateNote) {
        this.registrationDate = LocalDateTime.parse(
                registrationDateNote,
                DateTimeFormatter.ofPattern("yyyy.MM.dd, HH:mm:ss")
        ).toInstant(ZoneOffset.UTC);
    }

    String getUserStateNote() {
        return state.name();
    }

    void setUserStateNote(String stateNote) {
        this.state = UserState.valueOf(stateNote);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        return id != null && id.equals(((Item) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}