package com.k1rard.projectwebservicetest.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.k1rard.projectwebservicetest.entities.Empleado;

/**
 * @author k1rard
 * 
 */
public class EmpleadoService {

	/**
	 * Meotod que permite consultar un empleado por su id
	 * @param id Identificador del empleado a consultar
	 * @return el empleado consultado.
	 */
	public Empleado consultarEmpleadoPorId(Long id) {
		return this.consultarEmpleados()
				.stream().filter(e -> e.getId().equals(id))
				.findFirst().orElse(null);
	}
	
	/**
	 * Metodo que simula la consulta de un empleado.
	 * @return empleado consultado
	 */
	public Empleado consultarEmpleado() {
		Empleado empleado = new Empleado();
		empleado.setId(1L);
		empleado.setNumeroEmpleado("123456");
		empleado.setNombre("Julio");
		empleado.setPrimerApellido("Rodriguez");
		empleado.setSegundoApellido("perez");
		empleado.setEdad(20);
		empleado.setFechaCreacion(LocalDateTime.now());
		
		return empleado;
	}
	
	/**
	 * Metodo que permite consultar una lista de empleados
	 * @return lista de empleados consultada.
	 */
	public List<Empleado> consultarEmpleados(){
		List<Empleado> empleados = new ArrayList<Empleado>();
		
		Empleado empleado = new Empleado();
		empleado.setId(1L);
		empleado.setNumeroEmpleado("123456");
		empleado.setNombre("Julio");
		empleado.setPrimerApellido("Rodriguez");
		empleado.setSegundoApellido("perez");
		empleado.setEdad(20);
		empleado.setFechaCreacion(LocalDateTime.now());
		
		Empleado empleado2 = new Empleado();
		empleado2.setId(2L);
		empleado2.setNumeroEmpleado("123456");
		empleado2.setNombre("Mario");
		empleado2.setPrimerApellido("Rodriguez");
		empleado2.setSegundoApellido("lopez");
		empleado2.setEdad(22);
		empleado2.setFechaCreacion(LocalDateTime.now());
		
		empleados.add(empleado);
		empleados.add(empleado2);
		
		return empleados;
	}
}
