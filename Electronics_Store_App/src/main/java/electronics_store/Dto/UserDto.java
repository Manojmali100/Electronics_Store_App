package electronics_store.Dto;

import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private String UserId;

    private String name;

    private String email;

    private String password;

    private String gender;

    private String about;

    private String imageName;
}