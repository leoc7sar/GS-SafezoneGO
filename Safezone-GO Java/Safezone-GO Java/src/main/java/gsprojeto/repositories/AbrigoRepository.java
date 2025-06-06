package gsprojeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gsprojeto.model.Abrigo;

public interface AbrigoRepository extends JpaRepository<Abrigo, Long> {

	}

//*Page<AbrigoResponseDTO> findAll(Pageable pageable);
	

