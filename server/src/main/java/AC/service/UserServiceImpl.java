package AC.service;

import AC.domain.User;
import AC.dto.UserDTO;
import AC.dto.create.CreateUserDTO;
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
}
