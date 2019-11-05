package pe.edu.upn.res.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upn.res.model.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{

}
