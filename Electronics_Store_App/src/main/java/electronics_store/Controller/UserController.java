package electronics_store.Controller;

import electronics_store.Dto.ApiResponseMessage;
import electronics_store.Dto.UserDto;
import electronics_store.ServiceI.UserServiceI;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Builder
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceI userServiceI;

    //create
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {

        UserDto userDto1 = userServiceI.createUser(userDto);

        return new ResponseEntity<>(userDto1, HttpStatus.CREATED);
    }

    //Update
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("userId") String userId, @RequestBody UserDto userDto) {
        UserDto updatedUserDto = userServiceI.updateUser(userDto, userId);

        return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);
    }

    //Delete
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponseMessage> deleteUser(@PathVariable String userId) {
        userServiceI.deleteUser(userId);
        ApiResponseMessage message = ApiResponseMessage.builder()
                .message("User is deleted successfully!")
                .Success(true)
                .status(HttpStatus.OK)
                .build();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }


    //Get All
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {

        return new ResponseEntity<>(userServiceI.getAllUser(), HttpStatus.OK);
    }

    //Get By Single
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable String userId) {

        return new ResponseEntity<>(userServiceI.getUserBYId(userId), HttpStatus.OK);
    }

    //Get By Email

    @GetMapping("/email/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email) {
        return new ResponseEntity<>(userServiceI.getUserBYEmail(email), HttpStatus.OK);

    }

    //Search User
    @GetMapping("/search/{keywords}")
    public ResponseEntity<List<UserDto>> searchUserDto(@PathVariable String keywords) {
        return new ResponseEntity<>(userServiceI.searchUser(keywords), HttpStatus.OK);

    }
}