package br.com.feitozadev.authentication.repositories;

import br.com.feitozadev.authentication.domain.movies.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
