package primeur.back.controllers;

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

import primeur.back.entities.OffreVoyage;
import primeur.back.repositories.IOffreVoyage;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/offres")
public class OffreVoyageController {

	@Autowired
	private IOffreVoyage offreRepository;

	@GetMapping("/")
	public ResponseEntity findAll() {
		return ResponseEntity.ok(offreRepository.findAll());

	}

	@GetMapping("/{id}")
	public ResponseEntity<OffreVoyage> findById(@PathVariable Long id) {
		return offreRepository.findById(id).map(s -> ResponseEntity.ok().body(s))
				.orElse(ResponseEntity.notFound().build());

	}

	@PostMapping("/")
	public ResponseEntity createOffreVoyage(@RequestBody OffreVoyage OffreVoyage) {
		if (OffreVoyage == null) {
			return ResponseEntity.badRequest().body(null);
		}

		OffreVoyage createdOffreVoyage = offreRepository.save(OffreVoyage);

		return ResponseEntity.ok(createdOffreVoyage);

	}

	@PutMapping("/{id}")
	public ResponseEntity updateOffreVoyage(@PathVariable Long id, @RequestBody OffreVoyage newOffreVoyage) {
		if (id == null) {
			return ResponseEntity.badRequest().build();
		}
		OffreVoyage OffreVoyage = offreRepository.getOne(id);
		if (OffreVoyage == null) {
			return ResponseEntity.notFound().build();
		}
		if (newOffreVoyage.getDateDepart() != null) {
			OffreVoyage.setDateDepart(newOffreVoyage.getDateDepart());
		}
		if (newOffreVoyage.getDateRetour() != null) {
			OffreVoyage.setDateRetour(newOffreVoyage.getDateRetour());
		}
		if (newOffreVoyage.getLieuDepart() != null) {
			OffreVoyage.setLieuDepart(newOffreVoyage.getLieuDepart());
		}
		if (newOffreVoyage.getLieuDepart() != null) {
			OffreVoyage.setLieuArrivee(newOffreVoyage.getLieuDepart());
		}
		if (newOffreVoyage.getNbPlaces() != null) {
			OffreVoyage.setNbPlaces((newOffreVoyage.getNbPlaces()));
		}

		return ResponseEntity.ok(offreRepository.save(OffreVoyage));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteOffreVoyage(@PathVariable Long id) {
		if (id == null) {
			return ResponseEntity.badRequest().build();
		}
		OffreVoyage OffreVoyage = offreRepository.getOne(id);
		if (OffreVoyage == null) {
			return ResponseEntity.notFound().build();
		}
		offreRepository.delete(OffreVoyage);
		return ResponseEntity.ok().build();
	}
}
