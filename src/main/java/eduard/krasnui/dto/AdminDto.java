package eduard.krasnui.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import eduard.krasnui.model.User;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminDto {
    private String adminUsername;
    private String adminPassword;

    public User toUser(){
        User user = new User();
        user.setUsername(adminUsername);
        user.setPassword(adminPassword);
        return user;
    }
}
