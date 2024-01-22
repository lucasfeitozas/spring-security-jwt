package br.com.feitozadev.authentication.domain.users;

public record RegisterDTO(String login, String password, UserRole role) {
}
