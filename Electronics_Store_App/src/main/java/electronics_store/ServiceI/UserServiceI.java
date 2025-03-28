package electronics_store.ServiceI;

import electronics_store.Dto.UserDto;

import java.util.List;

public interface UserServiceI {

    //create

    UserDto createUser(UserDto userDto);

    //Update
    UserDto updateUser(UserDto userDto, String userId);

    //Delete
    void deleteUser(String userId);

    //Get All User
    List<UserDto> getAllUser();

    //Get Single User By id

    UserDto getUserBYId(String userId);

    //Get Single User By email
    UserDto getUserBYEmail(String userId);

    //search
    List<UserDto> searchUser(String keyword);

    //other User specific Features
}
