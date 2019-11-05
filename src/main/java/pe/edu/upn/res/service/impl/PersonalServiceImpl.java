package pe.edu.upn.res.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.res.model.entity.Personal;
import pe.edu.upn.res.model.repository.PersonalRepository;
import pe.edu.upn.res.service.PersonalService;



@Service
public class PersonalServiceImpl implements PersonalService{

	@Autowired
	private PersonalRepository personalrepository;

	@Transactional(readOnly = true)
	@Override
	public List<Personal> findAll() throws Exception {
		
		return personalrepository.findAll();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Optional<Personal> findById(String id) throws Exception {
		
		return personalrepository.findById(id);
	}

	@Transactional
	@Override
	public Personal save(Personal entity) throws Exception {
	
		return personalrepository.save(entity);
	}

	@Transactional
	@Override
	public Personal update(Personal entity) throws Exception {
		
		return personalrepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(String id) throws Exception {
		
		personalrepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		
		personalrepository.deleteAll();
		
	}
	
	

}
