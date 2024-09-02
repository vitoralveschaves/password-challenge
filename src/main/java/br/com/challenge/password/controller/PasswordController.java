package br.com.challenge.password.controller;

import br.com.challenge.password.controller.dto.FailuresResponse;
import br.com.challenge.password.controller.dto.PasswordRequest;
import br.com.challenge.password.service.PasswordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/password")
public class PasswordController {

    private final PasswordService service;

    public PasswordController(PasswordService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FailuresResponse> passwordCheck(@RequestBody PasswordRequest passwordRequest) {
        List<String> failures = service.passwordCheck(passwordRequest.password());
        if(failures.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailuresResponse(failures));
    }
}
