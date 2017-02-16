package t8.ej07.model;

import java.util.List;

import org.hibernate.Transaction;
import org.mvc.Model;
import t8.ej07.beans.Empleado;

public class EmpleadoModel extends Model {
	public void guardarEmpleado(Empleado empleado) throws Exception {
		Transaction t =  ss.beginTransaction();
		ss.save(empleado);
		t.commit();
	}

	@SuppressWarnings("unchecked")
	public List<Empleado> getTodas() {
		return ss.createQuery("from Empleado").list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Empleado> getEmpleadosFiltrados(String filtro) {
		String patronFiltro = "%"+filtro+"%";
		return ss.createQuery("from Emeplado where nombre like :filtro")
				.setParameter("filtro", patronFiltro)
				.list();
	}
}
