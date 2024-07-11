package AC.service;

import AC.domain.User;
import AC.dto.UserDTO;
import AC.dto.create.CreateUserDTO;
import AC.dto.update.UpdateUserDTO;

import java.util.List;

public interface UserService {


    User createUser(CreateUserDTO.Request request);

    UserDTO getUserById(Long userId);

    void deleteUserById(Long userId);

    User updateUserById(UpdateUserDTO.Request request);

    List<UserDTO> getAllUsers();
}
