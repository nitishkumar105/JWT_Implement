package co.Nitish.JWT.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data@Getter@Setter
public class JwtResponseDto {
     private String token;
     private String type="Bearer";
     private String username;
      public JwtResponseDto(String token,String username){
           this.token=token;
           this .username=username;
      }
}
