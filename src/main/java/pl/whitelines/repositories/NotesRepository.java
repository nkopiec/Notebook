package pl.whitelines.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.whitelines.entities.Note;

public interface NotesRepository extends JpaRepository<Note, Long> {
	public Optional<Note> findById(Long id);
}
