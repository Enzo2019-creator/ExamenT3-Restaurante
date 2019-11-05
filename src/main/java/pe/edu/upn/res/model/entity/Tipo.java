package pe.edu.upn.res.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipo")
public class Tipo {

	@Id
	@Column(name = "codigo", length = 5)
	private String id;
	
	@Column(name = "nombre", length = 80)
	private String nombre;
	
	@OneToMany(mappedBy = "tipo", fetch = FetchType.LAZY)
	private List<Plato> platos;
	
	public Tipo() {
		this.platos = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Plato> getPlatos() {
		return platos;
	}

	public void setPlatos(List<Plato> platos) {
		this.platos = platos;
	}
	
}
