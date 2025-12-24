package com.trevisan.AirSpace.Services.CustomerService;

import com.trevisan.AirSpace.Dtos.Customer.Requests.CreateCustomerRequestDTO;
import com.trevisan.AirSpace.Repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.regex.Pattern;

@Component
public class CustomerValidator {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerValidator(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void validationCustomerCreation(CreateCustomerRequestDTO requestDTO){
        checkIfEmailIsValid(requestDTO.email());
        checkIfEmailIsEmpty(requestDTO.email());
        checkIfEmailAlreadyExists(requestDTO.email());

        checkIfPhoneIsValid(requestDTO.phone());
        checkIfPhoneAlreadyExists(requestDTO.phone());
        checkIfPhoneIsEmpty(requestDTO.phone());

        checkIfPasswordIsValid(requestDTO.password());
        checkIfPasswordIsEmpty(requestDTO.password());

        checkIfDateOfBirthIsValid(requestDTO.dateOfBirth());
        checkIfDateOfBirthIsEmpty(requestDTO.dateOfBirth());
    }

    private void checkIfEmailIsValid(String email){
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (!Pattern.compile(emailRegex).matcher(email).matches()){
            throw new RuntimeException("Invalid Email!");
        }
    }

    private void checkIfPhoneIsValid(String phone) {
        String phoneRegex = "^\\s*(\\d{2}|\\d{0})[-. ]?(\\d{5}|\\d{4})[-. ]?(\\d{4})[-. ]?\\s*$";
        if (!Pattern.compile(phoneRegex).matcher(phone).matches()){
            throw new RuntimeException("Invalid Phone");
        }
    }

    private void checkIfPasswordIsValid(String password) {
        String passwordRegex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
        if (!Pattern.compile(passwordRegex).matcher(password).matches()){
            throw new RuntimeException("Password invalid!");
        }
        //Se passar na verificação chamar função para criptografar senha do customer
    }

    private void checkIfDateOfBirthIsValid(String dateOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy").withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate birthDate = LocalDate.parse(dateOfBirth);

            boolean birthDayIsAfterThisYear = birthDate.isAfter(ChronoLocalDate.from(Year.now()));
            if (birthDayIsAfterThisYear){
                throw new RuntimeException("Invalid date!");
            }

            boolean isOneValidDayInMonth = YearMonth.now().isValidDay(birthDate.getDayOfMonth());
            if (!isOneValidDayInMonth){
                throw new RuntimeException("Invalid date!");
            }

        } catch (DateTimeParseException ex) {
            throw new RuntimeException("Invalid date! " + ex.getMessage());
        }
    }

    private void checkIfEmailAlreadyExists(String email){
        if (customerRepository.existsCustomerByEmail(email)){
            throw new RuntimeException("This email already exists");
        }
    }

    private void checkIfPhoneAlreadyExists(String phone){
        if (customerRepository.existsCustomerByPhone(phone)){
            throw new RuntimeException("This phone already exists");
        }
    }

    private void checkIfEmailIsEmpty(String email){
        if (email.isEmpty()){
            throw new RuntimeException("Email cannot be empty!");
        }
    }

    private void checkIfPhoneIsEmpty(String phone) {
        if (phone.isEmpty()){
            throw new RuntimeException("Phone cannot be empty!");
        }
    }

    private void checkIfPasswordIsEmpty(String password) {
        if (password.isEmpty()){
            throw new RuntimeException("Password cannot be empty");
        }
    }

    private void checkIfDateOfBirthIsEmpty(String dateOfBirth) {
        if (dateOfBirth.isEmpty()){
            throw new RuntimeException("Date of birth cannot be empty!");
        }
    }
}
