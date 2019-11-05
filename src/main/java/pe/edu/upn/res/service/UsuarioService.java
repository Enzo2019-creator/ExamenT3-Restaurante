package pe.edu.upn.res.service;

import java.util.Optional;

import pe.edu.upn.res.model.entity.Usuario;

public interface UsuarioService extends CrudService<Usuario, Long> {
	Optional<Usuario> findByUsername(String username) throws Exception;
}
