package electronics_store.Dto;

<<<<<<< HEAD
import lombok.*;
=======
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

>>>>>>> a536eb9 ( Validetion apply in project)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
<<<<<<< HEAD
    private String UserId;

    private String name;

    private String email;

    private String password;

    private String gender;

    private String about;

    private String imageName;
=======
	private String UserId;
	@Size(min = 3, max = 15, message = "Invalid name !!")
	private String name;
	@Email(message = "Invalid User Email !!")
	private String email;
	@NotBlank(message = "Password is required !!")
	private String password;
	@Size(min = 3, max = 6, message = "Invalid Gender !!")
	private String gender;
	@NotBlank(message="Write Somthing YourSelf !!")
	private String about;

	private String imageName;
>>>>>>> a536eb9 ( Validetion apply in project)
}