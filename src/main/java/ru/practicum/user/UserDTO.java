package ru.practicum.user;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@NoArgsConstructor
@Getter @Setter @ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {
    Long id;
    String name;
    String email;
    String registrationDate;
    String userStateNote;
    UserState state;

    public static UserDTO from(User user) {
        UserDTO dto = new UserDTO();
        dto.id = user.getId();
        dto.name = user.getFullName();
        dto.email = user.getEmail();
        dto.registrationDate = user.getRegistrationDateNote();
        dto.userStateNote = user.getUserStateNote();
        dto.state = user.getState();
        return dto;
    }

    public static List<UserDTO> fromList(List<User> items) {
        return items.stream().map(UserDTO::from).toList();
    }
}
