package com.bolsadeideas.springboot.di.app.model.service;

/**
 * <h1>adding service class</h1>
 * <p>
 * clase de sercicio que se encarga de la <b>logica de negocio</b>, operar con
 * los datos ,interactua con los <b>DAO</b> ,con Repositories
 * (<b><code>@Repository</code></b>), (<b><code>@Service</code></b>) aplica una
 * semántica, se podria utilizar (<b><code>@Component</code></b>), si llegamos a
 * tener mas de una implementacion del servicio o componente con el decorador
 * (<b><code>@Primary</code></b>) diremos a Spring que esta será la clase por
 * defecto a inyectar
 * </p>
 */
public class MiServicioComplejo implements IServicio {
	@Override
	public String operacion() {
		return "ejecutando algún proceso importante complicado ...";
	}

}
