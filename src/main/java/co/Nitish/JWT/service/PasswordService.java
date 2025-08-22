package co.Nitish.JWT.service;

import co.Nitish.JWT.entity.PasswordResetToken;
import co.Nitish.JWT.entity.User;
import co.Nitish.JWT.repository.PasswordResetTokenRepository;
import co.Nitish.JWT.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.RandomStringUtils; // ADD THIS IMPORT
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PasswordService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordResetTokenRepository tokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;
     @Transactional
    public boolean initiatePasswordReset(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // Delete any existing tokens for this user
            tokenRepository.deleteByUser(user);

            // Generate random token
            String token = RandomStringUtils.randomAlphanumeric(32);
            PasswordResetToken resetToken = new PasswordResetToken(token, user);
            tokenRepository.save(resetToken);

            // Send email
            emailService.sendPasswordResetEmail(user.getEmail(), token, user.getUsername());

            return true;
        }

        // Return true even if email not found (for security)
        return true;
    }
  @Transactional
    public boolean resetPassword(String token, String newPassword) {
        Optional<PasswordResetToken> resetToken = tokenRepository.findByToken(token);

        if (resetToken.isPresent() && !resetToken.get().isExpired()) {
            PasswordResetToken validToken = resetToken.get();
            User user = validToken.getUser();

            // Update password
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);

            // Delete the used token
            tokenRepository.delete(validToken);

            return true;
        }

        return false;
    }

    public boolean validateResetToken(String token) {
        Optional<PasswordResetToken> resetToken = tokenRepository.findByToken(token);
        return resetToken.isPresent() && !resetToken.get().isExpired();
    }
}