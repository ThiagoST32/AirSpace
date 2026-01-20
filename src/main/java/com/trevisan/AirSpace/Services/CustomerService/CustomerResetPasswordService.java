package com.trevisan.AirSpace.Services.CustomerService;

import com.trevisan.AirSpace.Models.Customers.Customer;
import com.trevisan.AirSpace.Models.Customers.PasswordResetToken;
import com.trevisan.AirSpace.Repositories.CustomerRepository.CustomerRepository;
import com.trevisan.AirSpace.Repositories.CustomerRepository.PasswordResetTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class CustomerResetPasswordService {
    private final PasswordResetTokenRepository tokenRepository;
    private final CustomerRepository customerRepository;
    private final MailSender mailSender;

    @Autowired
    public CustomerResetPasswordService(PasswordResetTokenRepository tokenRepository, CustomerRepository customerRepository, MailSender mailSender) {
        this.tokenRepository = tokenRepository;
        this.customerRepository = customerRepository;
        this.mailSender = mailSender;
    }

    public String requestPasswordReset(String email){
        if (email.isEmpty()){
            //Tratar com nova exceção para ser capturada em handler
            throw new RuntimeException("Nenhum email foi apresentado!");
        }

        Customer customer = customerRepository.findCustomerByEmail(email).orElseThrow();
        PasswordResetToken newPass = new PasswordResetToken(customer);
        tokenRepository.save(newPass);
        sendEmailMessage(newPass.getToken(), customer.getEmail());

        return "Email enviado para reset da senha!";
    }

    private void sendEmailMessage(String token, String emailCustomer){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailCustomer);
        message.setSubject("Reset your password");
        message.setText("Link: http:localhost:8080/api/v1/pass/reset?=token" + token);
        System.err.println(token);
        mailSender.send(message);
    }

    @Async
    public String resetPassword(String token, String newPassword){
        isValidPassword(newPassword);

        PasswordResetToken resetToken = tokenRepository.findByToken(token).orElseThrow();

        if (resetToken.isExpired()){
            //Tratar com nova exceção para ser capturada em handler
            throw new RuntimeException("Token Expirado");
        }

        Customer customer = resetToken.getCustomer();
        customer.setPassword(newPassword);
        customerRepository.save(customer);
        tokenRepository.delete(resetToken);

        return "Senha alterada com sucesso!";
    }

    private void isValidPassword(String password){
        if (password.isEmpty()){
            //Tratar com nova exceção para ser capturada em handler
            throw new RuntimeException("Senha está vazia!");
        }

        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        if (!Pattern.compile(password).pattern().matches(regex)){
            //Tratar com nova exceção para ser capturada em handler
            throw new RuntimeException("Senha invalida");
        }
    }
}
