package t8.ej07.beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Empleado {
	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	
	private String apellido1;
	private String apellido2;
	private String password;
	private String telefono;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Ciudad ciudad;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private Set<Lp> lps;
	

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Set<Lp> getLps() {
		return lps;
	}

	public void setLps(Set<Lp> lps) {
		this.lps = lps;
	}
	public Empleado(String nombre, String apellido1, String apellido2, String password, String telefono, Ciudad ciudad,
			Set<Lp> lps) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.password = password;
		this.telefono = telefono;
		
		this.ciudad = ciudad;
		this.ciudad.addToEmpleados(this);
		
		this.lps = lps;
		for (Lp lp:lps) {
			lp.addToEmpleados(this);
		}
	}

	public Empleado() {
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
	
}
