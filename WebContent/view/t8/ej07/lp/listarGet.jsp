<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<div class="container">

<form class="form-group">
	<div class="row">
		<input class="col-sm-2" type="text" id="idFiltro" name="filtro">
		<input class="col-sm-1 btn-primary" type="submit" value="filtrar">
	</div>
</form>

<h3>Lista de lenguajes de programación</h3>

<table>

<tr>
<th>Nombre</th>
</tr>

<c:forEach var="lp" items="${lps}">
     <tr>
     	<td>${lp.nombre}</td>
     </tr>
</c:forEach>

</table>
</div>