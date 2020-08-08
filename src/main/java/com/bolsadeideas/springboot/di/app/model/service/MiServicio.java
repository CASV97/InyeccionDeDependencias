package com.bolsadeideas.springboot.di.app.model.service;

import org.springframework.stereotype.Service;

/**
 * <h1>adding service class</h1>
 * <p>
 * clase de sercicio que se encarga de la logica e negocio, operar con los datos
 * con los datos,interactua con los DAO ,con Repositories
 * </p>
 */
@Service("miServicio")
public class MiServicio {

	public String operacion() {
		return "ejecutando algún proceso importante...";
	}
}
