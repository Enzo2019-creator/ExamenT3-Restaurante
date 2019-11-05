package pe.edu.upn.res.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "personal")
public class Personal {

	@Id
	@Column(name = "id", length = 10)
	private String id;
	
	@Column(name = "nom_paciente", length = 25, nullable = false)
	private String nombre;
	
	@Column(name = "ape_paciente", length = 25, nullable = false)
	private String apellido;
	
	@Column(name = "edad", nullable = true)
	private Integer edad;
	
	@Column(name = "sexo", length = 50, nullable = true)
	private String sexo;
	
	@OneToMany(mappedBy = "personal", fetch = FetchType.LAZY)
	private List<Pedido> pedidos;
	
	@OneToMany(mappedBy = "personal", fetch = FetchType.LAZY)
	private List<Usuario> usuarios;
	
	public Personal() {
		this.pedidos=new ArrayList<>();
		this.usuarios=new ArrayList<>();
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
}
