package t8.ej07.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Lp {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true)
	private String nombre;
	
	@ManyToMany(mappedBy="lps")
	private Set<Empleado> empleados;

	public Lp() {
	}
	
	public void addToEmpleados(Empleado empleado) {
		this.empleados.add(empleado);
	}
	
	public Lp(String nombre) {
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

	public Set<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}
	
}
