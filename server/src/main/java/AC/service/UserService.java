package AC.service;

import AC.domain.User;
import AC.dto.UserDTO;
import AC.dto.create.CreateUserDTO;

public interface UserService {


    User createUser(CreateUserDTO.Request request);

    UserDTO getUserById(Long userId);

    void deleteUserById(Long userId);
}
