package co.Nitish.JWT.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Getter
@Entity
@Table(name = "password_reset_tokens")
public class PasswordResetToken {

    private static final int EXPIRATION = 60 * 60 * 1000; // 1 hour

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    private Date expiryDate;

    // Default constructor (required by JPA)
    public PasswordResetToken() {
    }

    // Constructor with token and user
    public PasswordResetToken(String token, User user) {
        this.token = token;
        this.user = user;
        this.expiryDate = new Date(System.currentTimeMillis() + EXPIRATION);
    }

    public void setId(Long id) { this.id = id; }

    public void setToken(String token) { this.token = token; }

    public void setUser(User user) { this.user = user; }

    public void setExpiryDate(Date expiryDate) { this.expiryDate = expiryDate; }

    // Add the missing isExpired() method
    public boolean isExpired() {
        return new Date().after(this.expiryDate);
    }
}