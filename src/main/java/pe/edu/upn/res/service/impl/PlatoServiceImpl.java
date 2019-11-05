package pe.edu.upn.res.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.res.model.entity.Plato;
import pe.edu.upn.res.model.repository.PlatoRepository;
import pe.edu.upn.res.service.PlatoService;


@Service
public class PlatoServiceImpl implements PlatoService{

	@Autowired
	private PlatoRepository platorepository;

	@Transactional(readOnly = true)
	@Override
	public List<Plato> findAll() throws Exception {
	
		return platorepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Plato> findById(String id) throws Exception {
		
		return platorepository.findById(id);
	}

	@Transactional
	@Override
	public Plato save(Plato entity) throws Exception {
		
		return platorepository.save(entity);
	}

	@Transactional
	@Override
	public Plato update(Plato entity) throws Exception {
		
		return platorepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(String id) throws Exception {
		platorepository.deleteById(id);
		
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		platorepository.deleteAll();
		
	}
	
	
	
}
