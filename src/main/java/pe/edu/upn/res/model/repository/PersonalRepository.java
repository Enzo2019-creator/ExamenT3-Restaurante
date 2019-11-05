package pe.edu.upn.res.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upn.res.model.entity.Personal;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, String> {

}
