package br.com.feitozadev.authentication.domain.movies;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movies")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Movie {

    public Movie(MovieRequestDTO data) {
        this.name = data.name();
        this.year = data.year();
        this.genre = data.genre();
        this.description = data.description();
        this.imageUri = data.imageUri();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer year;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private String description;

    private String imageUri;
}
