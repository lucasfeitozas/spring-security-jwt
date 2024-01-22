package br.com.feitozadev.authentication.controllers;

import br.com.feitozadev.authentication.configuration.TokenService;
import br.com.feitozadev.authentication.domain.users.AuthenticationDTO;
import br.com.feitozadev.authentication.domain.users.RegisterDTO;
import br.com.feitozadev.authentication.domain.users.User;
import br.com.feitozadev.authentication.domain.users.UserTokenResponseDTO;
import br.com.feitozadev.authentication.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final UserRepository repository;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<UserTokenResponseDTO> login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new UserTokenResponseDTO(token));

    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterDTO data) {
        if (this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(null, data.login(), encryptedPassword, data.role());

        repository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
