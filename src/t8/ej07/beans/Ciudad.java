package t8.ej07.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ciudad {
	@Id
	@GeneratedValue
	private Long id;
	private Set<Empleado> empleados;
	
	@Column(unique = true)
	private String nombre;

	public Ciudad() {
	}
	
	public void addToEmpleados(Empleado empleado) {
		this.empleados.add(empleado);
	}
	
	public Ciudad(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany (cascade = {CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="ciudad")
	public Set<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}
	
}
