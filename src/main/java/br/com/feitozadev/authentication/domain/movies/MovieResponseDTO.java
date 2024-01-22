package br.com.feitozadev.authentication.domain.movies;

public record MovieResponseDTO(Long id, String name, Integer year, Genre genre, String description, String imageUri) {
    public MovieResponseDTO(Movie movie) {
        this(movie.getId(), movie.getName(), movie.getYear(), movie.getGenre(), movie.getDescription(), movie.getImageUri());
    }
}
