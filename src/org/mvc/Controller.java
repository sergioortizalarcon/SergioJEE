package org.mvc;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected String baseURL;
	protected Map<String,Object> datos=new HashMap<String,Object>();


	final protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ejecutar("get",request,response);
	}

	final protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ejecutar("post", request, response);
	}

	protected void ejecutar(String tipo, HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.request = request;
		this.response = response;
		
		this.baseURL = request.getRequestURL().toString().substring(0,
				request.getRequestURL().toString().length() - request.getRequestURI().length()) + request.getContextPath()
				+ "/";
		this.request.setAttribute("baseURL",this.baseURL);
		MenuHelper.getInstance(this).setBaseURL(this.baseURL);
		
		String[] partes = request.getPathInfo() != null ? request.getPathInfo().split("/") : null;
		String accion = (partes != null && partes.length > 0 ? partes[1] : "index")
				+ (tipo.equals("get") ? "Get" : "Post");
		//response.getWriter().println(accion);//DEBUG
		try {
			this.getClass().getMethod(accion).invoke(this);
		} catch (NoSuchMethodException e) {
			response.setContentType("text/html");
			response.getWriter().print("<h1>No existe el m�todo " + accion + "</h1>");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	protected void view(String rutaVista) {
		view(rutaVista,true);
	}
	
	protected void view(String rutaVista, boolean enmarcado) {
		try {
			request.setAttribute("rutaVista", "/view/"+rutaVista);
			request.setAttribute("baseURL", baseURL);
			
			for (String k:datos.keySet()) {
				request.setAttribute(k, datos.get(k));
			}
			
			request.getRequestDispatcher(
					enmarcado?
							"/view/_templates/_MASTER.jsp":
							"/view/"+rutaVista
					).forward(request, response);

		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
