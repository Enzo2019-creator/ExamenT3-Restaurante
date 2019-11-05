package pe.edu.upn.res.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.res.model.entity.Pedido;
import pe.edu.upn.res.model.repository.PedidoRepository;
import pe.edu.upn.res.service.PedidoService;


@Service
public class PedidoServiceImpl implements PedidoService{

	@Autowired
	private PedidoRepository pedidorepository;

	@Transactional(readOnly = true)
	@Override
	public List<Pedido> findAll() throws Exception {
		
		return pedidorepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Pedido> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return pedidorepository.findById(id);
	}
	@Transactional

	@Override
	public Pedido save(Pedido entity) throws Exception {
		// TODO Auto-generated method stub
		return pedidorepository.save(entity);
	}

	@Transactional
	@Override
	public Pedido update(Pedido entity) throws Exception {
		// TODO Auto-generated method stub
		return pedidorepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		pedidorepository.deleteById(id);
		
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		pedidorepository.deleteAll();
		
	}
	
	
}
