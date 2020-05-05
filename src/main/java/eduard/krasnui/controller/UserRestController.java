package eduard.krasnui.controller;

import eduard.krasnui.dto.UserDto;
import eduard.krasnui.model.User;
import eduard.krasnui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/users/")
public class UserRestController {
    private final UserService userService;


    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody UserDto requestDto) {
        Map<Object, Object> response = new HashMap<>();

        if(userService.checkUsername(requestDto.getUsername())){
            response.put("message", "Incorrect username");
            return ResponseEntity.ok(response);
        }

        User user = userService.login(requestDto.toUser());
        if(user!=null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        response.put("message", "Incorrect username or password");
        return ResponseEntity.ok(response);
    }

    @PostMapping("register")
    public ResponseEntity register(@RequestBody UserDto userDto) {
        String username = userDto.getUsername();
        User checkUser = userService.findByUsername(userDto.getUsername());

        if (checkUser != null) {
            throw new UsernameNotFoundException("Username: " + username + " is not available");
        }

        User user = userService.register(userDto.toUser());

        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + username + " can't register");
        }

        return new ResponseEntity<>(user, HttpStatus.OK);

    }


}