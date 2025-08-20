package co.Nitish.JWT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${app.frontend.url:http://localhost:3000}")  // Added default value
    private String frontendUrl;

    @Value("${spring.mail.username:no-reply@example.com}")  // Added default value
    private String fromEmail;

    public void sendPasswordResetEmail(String toEmail, String token, String username) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromEmail);
            message.setTo(toEmail);
            message.setSubject("Password Reset Request");

            String resetLink = frontendUrl + "/reset-password?token=" + token;

            message.setText("Hello " + username + ",\n\n"
                    + "You requested to reset your password. Please click the link below to reset your password:\n\n"
                    + resetLink + "\n\n"
                    + "This link will expire in 1 hour.\n\n"
                    + "If you didn't request this, please ignore this email.\n\n"
                    + "Thank you,\n"
                    + "Your App Team");

            mailSender.send(message);
            System.out.println("Password reset email sent to: " + toEmail);

        } catch (Exception e) {
            System.err.println("Failed to send email to " + toEmail + ": " + e.getMessage());
            // For development, print the reset link to console
            System.out.println("DEBUG - Reset link for " + username + ": " +
                    frontendUrl + "/reset-password?token=" + token);
        }
    }
}