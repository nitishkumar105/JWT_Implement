package co.Nitish.JWT.dto;

import lombok.*;

@Data@Getter
@Setter@NoArgsConstructor@AllArgsConstructor
public class ForgetPasswordRequestDto {
    private String email;
}
