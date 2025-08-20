package co.Nitish.JWT.dto;

import lombok.*;

@AllArgsConstructor@NoArgsConstructor@Getter@Setter
@Data
public class LoginRequestDto {
     private String username;
     private  String password;
}
