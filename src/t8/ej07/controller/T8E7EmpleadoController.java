package t8.ej07.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.annotation.WebServlet;

import org.mvc.Controller;

import t8.ej07.beans.Ciudad;
import t8.ej07.beans.Empleado;
import t8.ej07.beans.Lp;
import t8.ej07.model.CiudadModel;
import t8.ej07.model.EmpleadoModel;
import t8.ej07.model.LpModel;

@SuppressWarnings("serial")
@WebServlet({"/t8/ej07/empleado","/t8/ej07/empleado/","/t8/ej07/empleado/*"})
public class T8E7EmpleadoController extends Controller {
	public void crearGet() {
		CiudadModel ciudadModel = new CiudadModel();
		LpModel lpModel = new LpModel();
		
		List<Ciudad> ciudades = ciudadModel.getTodas();
		List<Lp> lps = lpModel.getTodos();
		
		datos.put("lps", lps);
		datos.put("ciudades", ciudades);

		view("t8/ej07/empleado/crearGet.jsp");
	}
	
	public void crearPost() {
		String nombre = request.getParameter("nombre");
		String ape1 = request.getParameter("ape1");
		String ape2 = request.getParameter("ape2");
		String pwd = request.getParameter("pwd");
		String tlf = request.getParameter("tlf");
		
		Ciudad ciudad = new CiudadModel().getCiudadPorId(Long.parseLong(request.getParameter("idCiudad")));
		
		Set<Lp> lps = new HashSet<Lp>();
		LpModel lpModel = new LpModel();
		for (String idLpString : request.getParameterValues("idLp[]")) {
			Long  idLpLong = Long.parseLong(idLpString);
			Lp lp = lpModel.getLpPorId(idLpLong);
			lps.add(lp);
		}
		
		Empleado empleado = new Empleado(nombre,ape1,ape2,pwd,tlf,ciudad,lps);
		EmpleadoModel model = new EmpleadoModel();
		try {
			model.guardarEmpleado(empleado);
			request.getRequestDispatcher("/t8/ej07/empleado/listar").forward(request, response);
		}
		catch (Exception e) {
			view("t8/ej07/empleado/crearPostERROR.jsp");
		}
	}
	
	public void listarGet() {
		String filtro = request.getParameter("filtro");
		
		EmpleadoModel model = new EmpleadoModel();
		List<Empleado> empleados = model.getEmpleadosFiltrados(filtro==null?"":filtro);
		datos.put("empleados",empleados);
		view("t8/ej07/emeplado/listarGet.jsp");
	}
	
	public void listarPost() {
		this.listarGet();
	}
}
