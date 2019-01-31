package pl.whitelines.repositories;

import org.springframework.data.repository.CrudRepository;

import pl.whitelines.entities.Notes;

public interface NotesRepository extends CrudRepository<Notes, Long> {
	public Notes findByIdAndTitle(Long id, String title);
}
