package co.Nitish.JWT.repository;

import co.Nitish.JWT.entity.PasswordResetToken;
import co.Nitish.JWT.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    Optional<PasswordResetToken> findByToken(String token);
    Optional<PasswordResetToken> findByUser(User user);
    void deleteByUser(User user); // This should work now
}