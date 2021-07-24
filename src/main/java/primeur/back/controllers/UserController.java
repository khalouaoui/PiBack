package primeur.back.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import primeur.back.entities.User;
import primeur.back.repositories.IUser;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/users")
public class UserController {
	@Autowired
	private IUser userRepositroy;

	/*
	 * @Autowired private PasswordEncoder passwordEncoder ;
	 */
	@GetMapping("/")
	public ResponseEntity findAll() {
		return ResponseEntity.ok(userRepositroy.findAll());

	}

	/*
	 * @GetMapping("/{id}") public ResponseEntity findById(@PathVariable(name="id")
	 * Long id) { if (id == null) { return ResponseEntity.badRequest().body("null");
	 * } User user = userRepositroy.getOne(id); if (user == null) { return
	 * ResponseEntity.notFound().build(); } List list=new ArrayList<>() ;
	 * list.add("id " + user.getId()) ; list.add("nom " + user.getNom()) ;
	 * list.add("prenom " + user.getPrenom()) ; list.add("equipe " +
	 * user.getEquipe()) ; list.add("fonction " + user.getFonction()) ; return
	 * ResponseEntity.ok(list) ;
	 * 
	 * 
	 * }
	 */
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		return userRepositroy.findById(id).map(s -> ResponseEntity.ok().body(s))
				.orElse(ResponseEntity.notFound().build());

	}

	@GetMapping("/last/{nom}")
	public ResponseEntity findByNom(@PathVariable String nom) {
		if (nom == null) {
			return ResponseEntity.badRequest().build();
		}
		List<User> user = userRepositroy.findByNom(nom);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);

	}

	@GetMapping("/first/{prenom}")
	public ResponseEntity findByPrenom(@PathVariable String prenom) {
		if (prenom == null) {
			return ResponseEntity.badRequest().build();
		}
		List<User> user = userRepositroy.findByPrenom(prenom);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);

	}

	@PostMapping("/")
	public ResponseEntity createUser(@RequestBody User user) {
		if (user == null) {
			return ResponseEntity.badRequest().body(null);
		}

		User createdUser = userRepositroy.save(user);

		return ResponseEntity.ok(createdUser);

	}

	@PutMapping("/{id}")
	public ResponseEntity updateUser(@PathVariable Long id, @RequestBody User newUser) {
		if (id == null) {
			return ResponseEntity.badRequest().build();
		}
		User user = userRepositroy.getOne(id);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		if (newUser.getNom() != null) {
			user.setNom(newUser.getNom());
		}
		if (newUser.getPrenom() != null) {
			user.setPrenom(newUser.getPrenom());
		}
		if (newUser.getPassword() != null) {
			user.setPassword(newUser.getPassword());
		}
		if (newUser.getEquipe() != null) {
			user.setEquipe(newUser.getEquipe());
		}
		if (newUser.getFonction() != null) {
			user.setFonction((newUser.getFonction()));
		}

		return ResponseEntity.ok(userRepositroy.save(user));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteUser(@PathVariable Long id) {
		if (id == null) {
			return ResponseEntity.badRequest().build();
		}
		User user = userRepositroy.getOne(id);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		userRepositroy.delete(user);
		return ResponseEntity.ok().build();
	}

	/*---------------------------------------------------------------------------------*/
//    @GetMapping("/allsoft/{id}")
//    public ResponseEntity findAllUserSkills(@PathVariable Long id) {
//        if (id == null) {
//            return ResponseEntity.badRequest().body("Cannot find skill with null user");
//        }
//        User user=userRepositroy.getOne(id) ;
//        //User user = userRepository.getOne(id);
//        if (user == null) {
//            return ResponseEntity.notFound().build();
//        }
//        List<SoftSkills> userSkill= softSkillsRepository.findByUser(user);
//        return ResponseEntity.ok(userSkill) ;
//    }

}
