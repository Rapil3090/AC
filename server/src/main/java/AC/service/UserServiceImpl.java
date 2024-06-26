package AC.service;

import AC.domain.User;
import AC.dto.UserDTO;
import AC.dto.create.CreateUserDTO;
import AC.dto.update.UpdateUserDTO;
import AC.exception.UserException;
import AC.repository.UserRepository;
import AC.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    public User createUser(CreateUserDTO.Request request) {

        return userRepository.save(User.builder()
                .name(request.getName())
                .build());
    }

    public UserDTO getUserById(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserException(ErrorCode.USER_NOT_FOUND));

        return new UserDTO(user);
    }

    public void deleteUserById(Long userId) {

        userRepository.findById(userId).orElseThrow(
                () -> new UserException(ErrorCode.USER_NOT_FOUND));

        userRepository.deleteById(userId);
    }

    public User updateUserById(UpdateUserDTO.Request request) {

        User user = userRepository.findById(request.getId()).orElseThrow(
                () -> new UserException(ErrorCode.USER_NOT_FOUND));

        user.setName(request.getName());

        return userRepository.save(user);
    }
}
