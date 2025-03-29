package electronics_store.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
	private String UserId;
	@Size(min = 3, max = 20, message = "Invalid name !!")
	private String name;
	@Email(message = "Invalid User Email !!")
	//@Pattern(regexp = "",message="Invalid User Email ")
	@NotBlank(message = "Email is required !!")
	private String email;
	@NotBlank(message = "Password is required !!")
	private String password;
	@Size(min = 3, max = 6, message = "Invalid Gender !!")
	private String gender;
	@NotBlank(message = "Write Somthing YourSelf !!")
	private String about;

	private String imageName;
}