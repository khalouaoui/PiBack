package primeur.back.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import primeur.back.entities.User;

public interface IUser extends JpaRepository<User, Long> {
	List<User> findByNom(String Nom);

	List<User> findByPrenom(String Prenom);

}
