package co.Nitish.JWT.dto;

import lombok.*;

@Data@NoArgsConstructor@AllArgsConstructor@Getter@Setter
public class RegisterUserDto {
     private String username;
     private String email;
     private String password;
}
