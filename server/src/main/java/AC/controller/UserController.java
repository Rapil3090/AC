package AC.controller;

import AC.domain.User;
import AC.dto.UserDTO;
import AC.dto.create.CreateUserDTO;
import AC.dto.delete.DeleteDTO;
import AC.dto.update.UpdateUserDTO;
import AC.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/user")
    public ResponseEntity<CreateUserDTO.Response> createUser(
            @Valid @RequestBody CreateUserDTO.Request request) {

        return ResponseEntity.ok(CreateUserDTO.Response.from(
                userService.createUser(request)));
    }

    @GetMapping("/user")
    public ResponseEntity<UserDTO> getUserById(
            @RequestParam("userId") Long userId) {

        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PostMapping("/user/delete")
    public ResponseEntity<DeleteDTO.Response> deleteUserById(
            @RequestParam("userId") Long userId) {

        userService.deleteUserById(userId);

        return ResponseEntity.ok(DeleteDTO.Response.from());
    }

    @PutMapping("/user")
    public ResponseEntity<UpdateUserDTO.Response> updateUserById(
            @Valid @RequestBody UpdateUserDTO.Request request) {

        return ResponseEntity.ok(UpdateUserDTO.Response.from(
                userService.updateUserById(request)));
    }


}
