package ru.practicum.user;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDTO {
    long id;
    String name;
    String email;
    String registrationDate;
    String userStateNote;

    public static UserDTO from(User user) {
        UserDTO dto = new UserDTO();
        dto.id = user.getId();
        dto.name = user.getFullName();
        dto.email = user.getEmail();
        dto.registrationDate = user.getRegistrationDateNote();
        dto.userStateNote = user.getUserStateNote();
        return dto;
    }

    public static List<UserDTO> fromList(List<User> items) {
        return items.stream().map(UserDTO::from).toList();
    }
}
