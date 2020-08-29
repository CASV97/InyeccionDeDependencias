package com.bolsadeideas.springboot.di.app.model.service;

import org.springframework.stereotype.Service;

/**
 * <h1>adding service class</h1>
 * <p>
 * clase de sercicio que se encarga de la <b>logica de negocio</b>, operar con
 * los datos con los datos,interactua con los DAO ,con Repositories
 * <code>@Service</code> aplica una semántica, se podria utilizar
 * <code>@Component</code>
 * </p>
 */
@Service("miServicioSimple")	
public class MiServicio implements IServicio{
	@Override
	public String operacion() {
		return "ejecutando algún proceso importante Simple...";
	}
	
}
