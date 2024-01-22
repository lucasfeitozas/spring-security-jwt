package br.com.feitozadev.authentication.domain.movies;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record MovieRequestDTO(@NotBlank String name, @NotNull @Positive Integer year, @NotNull Genre genre,
                              String description, String imageUri) {
}
