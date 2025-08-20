package co.Nitish.JWT.controller;

import co.Nitish.JWT.dto.ForgetPasswordRequestDto;
import co.Nitish.JWT.dto.ResetPasswordRequestDto;
import co.Nitish.JWT.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/password")
@RestController
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @PostMapping("/forget")
    public ResponseEntity<?> forgotPassword(@RequestBody ForgetPasswordRequestDto request) {
        boolean result = passwordService.initiatePasswordReset(request.getEmail());

        if (result) {
            return ResponseEntity.ok("Password reset instructions sent to your email");
        }

        return ResponseEntity.badRequest().body("Error processing your request");
    }

    @PostMapping("/reset")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequestDto request) {
        boolean result = passwordService.resetPassword(request.getToken(), request.getNewPassword());

        if (result) {
            return ResponseEntity.ok("Password reset successfully");
        }

        return ResponseEntity.badRequest().body("Invalid or expired reset token");
    }

    @GetMapping("/validate-token")
    public ResponseEntity<?> validateResetToken(@RequestParam String token) {
        boolean isValid = passwordService.validateResetToken(token);

        if (isValid) {
            return ResponseEntity.ok("Token is valid");
        }

        return ResponseEntity.badRequest().body("Invalid or expired token");
    }
}
