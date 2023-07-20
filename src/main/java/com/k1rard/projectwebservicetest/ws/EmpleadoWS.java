/**
 * 
 */
package com.k1rard.projectwebservicetest.ws;

import java.util.List;

import com.k1rard.projectwebservicetest.entities.Empleado;
import com.k1rard.projectwebservicetest.service.EmpleadoService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * @author k1rard
 * Webservice generado con Jersey
 */
@Path("/empleadoWS")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmpleadoWS {
	
	EmpleadoService service = new EmpleadoService();
	
	@GET
	public String test() {
		return "Probando webservice con Jersey";
	}
	
	@GET
	@Path("/empleado")
	public Empleado consultarEmpleado() {
		return this.service.consultarEmpleado();
	}
	
	@POST
	@Path("/empleado")
	public Response guardarEmpleado(Empleado empleado) {
		if(empleado == null) {
			return Response.status(400)
			.entity("No se ingreso informacion del empleado, favor de capturar sus datos").build();
		}
		
		if(empleado.getNombre() == null || empleado.getNombre().isBlank()) {
			return Response.status(400).entity("El nombre del empleado es requerido").build();
		}
		
		GenericEntity<Empleado> empleadoGuardado = new GenericEntity<Empleado>(empleado, Empleado.class);
		
		return Response.ok(empleadoGuardado).build();
	}
	
	@GET
	@Path("/empleado/{id}")
	public Response consultarEmpleadoPorId(@PathParam("id") Long id) {
		Empleado empleadoConsultado =  this.service.consultarEmpleadoPorId(id);
		
		if(empleadoConsultado == null) {
			return Response.noContent().build();
		}
		
		GenericEntity<Empleado> empleadoGeneric = new GenericEntity<Empleado>(empleadoConsultado, Empleado.class);
		
		return Response.ok(empleadoGeneric).build();
	}
	
	@GET
	@Path("/empleados")
	public List<Empleado> consultarEmpleados(){
		return this.service.consultarEmpleados();
	}
}
