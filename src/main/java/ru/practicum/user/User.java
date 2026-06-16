package ru.practicum.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Getter @Setter @ToString
@Entity
@Table(name = "users", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    private String email;

    @Column(name = "registration_date")
    private Instant registrationDate = Instant.now();

    @Enumerated(EnumType.STRING)
    private UserState state;

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
}