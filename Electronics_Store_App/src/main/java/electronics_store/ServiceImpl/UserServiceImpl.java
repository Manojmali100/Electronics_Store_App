package electronics_store.ServiceImpl;

import electronics_store.Dto.UserDto;
import electronics_store.Repository.UserRepository;
import electronics_store.ServiceI.UserServiceI;
import electronics_store.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServiceI {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = dtoToEntity(userDto);
        user.setUserId(UUID.randomUUID().toString());

        // Save user to database
        User savedUser = userRepository.save(user);

        // Convert and return DTO
        return entityToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        //Update user
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not found with given id..!!"));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setGender(userDto.getGender());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());
        user.setImageName(userDto.getImageName());

        //saveData
        User updatedUser = userRepository.save(user);
        UserDto updateDto = entityToDto(updatedUser);

        return updateDto;
    }

    @Override
    public void deleteUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not found with given id..!!"));
        //Delete User
        userRepository.delete(user);

    }

    @Override
    public List<UserDto> getAllUser() {
        //Get All user
        List<User> users = userRepository.findAll();
        List<UserDto> dtoList = users.stream().map(user -> entityToDto(user)).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public UserDto getUserBYId(String userId) {
        //Get UserById
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found With Given Id  !!"));
        return entityToDto(user);
    }

    @Override
    public UserDto getUserBYEmail(String email) {
        //Get User By Email
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User Not Found With Given Email Id And Password !!"));
        return entityToDto(user);
    }

    @Override
    public List<UserDto> searchUser(String keyword) {
        List<User> users = userRepository.findByNameContaining(keyword);
        return users.stream().map(this::entityToDto).collect(Collectors.toList());
    }


    private UserDto entityToDto(User savedUser) {
//        UserDto userDto = UserDto.builder()
//                .UserId(savedUser.getUserId())
//                .name(savedUser.getName())
//                .email(savedUser.getEmail())
//                .password(savedUser.getPassword())
//                .gender(savedUser.getGender())
//                .about(savedUser.getAbout())
//                .imageName(savedUser.getImageName()).build();

        return modelMapper.map(savedUser, UserDto.class);
    }

    private User dtoToEntity(UserDto userDto) {
//
//        User user = User.builder()
//                .userId(userDto.getUserId())
//                .name(userDto.getName())
//                .email(userDto.getEmail())
//                .password(userDto.getPassword())
//                .gender(userDto.getGender())
//                .about(userDto.getAbout())
//                .imageName(userDto.getImageName()).build();
        return modelMapper.map(userDto, User.class);
    }

}


