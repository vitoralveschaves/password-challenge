package br.com.challenge.password.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class PasswordService {
    public List<String> passwordCheck(String password) {
        List<String> failures = new ArrayList<>();

        validateLength(password, failures);
        validateUppercase(password, failures);
        validateLowercase(password, failures);
        validateCharacters(password, failures);
        validateNumber(password, failures);

        return failures;
    }

    private void validateNumber(String password, List<String> failures) {
        if(!Pattern.matches(".*[0-9].*", password)) {
            failures.add("Password must contain numbers");
        }
    }

    private void validateCharacters(String password, List<String> failures) {
        if(!Pattern.matches(".*\\W.*", password)) {
            failures.add("Password must contain special characters");
        }
    }

    private void validateLowercase(String password, List<String> failures) {
        if(!Pattern.matches(".*[a-z].*", password)) {
            failures.add("Password must contain lowercase characters");
        }
    }

    private void validateUppercase(String password, List<String> failures) {
        if(!Pattern.matches(".*[A-Z].*", password)) {
            failures.add("Password must contain uppercase characters");
        }
    }

    private void validateLength(String password, List<String> failures) {
        if(!password.isEmpty() && password.length() < 8) {
            failures.add("Password shall be longer than 8 characters");
        }
    }
}
