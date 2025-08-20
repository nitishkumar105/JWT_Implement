package co.Nitish.JWT.dto;

import lombok.*;

@Data@AllArgsConstructor@NoArgsConstructor@Getter@Setter
public class ResetPasswordRequestDto {
    private String token;
    private String newPassword;
}
