package com.bolsadeideas.springboot.di.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.bolsadeideas.springboot.di.app.model.service.IServicio;
import com.bolsadeideas.springboot.di.app.model.service.MiServicio;
import com.bolsadeideas.springboot.di.app.model.service.MiServicioComplejo;

/**
 * <h1>Registrando <code>Components</code> usando clase de configuración y
 * anotación <code>@Bean</code>*</h1> <b>nota</b>: para agregar un controlador o
 * Servlet Como en cualquier aplicación con Spring Web Framework, debemos
 * configurar nuestro web.xml para que tenga el Servlet propio de Spring Web
 * Framework (org.springframework.web.servlet.DispatcherServlet).<br>
 * <a href=
 * "http://chuwiki.chuidiang.org/index.php?title=Controladores_con_anotaciones_en_Spring_MVC_Framework">Cómo
 * agregar un Controller manualmente</a>
 * 
 */
@Configuration
public class AppConfig {
	/**
	 * Coon @Bean agregamos la instancia de una clase o componente
	 */
	@Bean("miServicioComplejo")
	public IServicio registrarMiServicioComplejo() {
		return new MiServicioComplejo();
	}

	@Bean("miServicioSimple")
	@Primary
	public MiServicio registrarMiServicioSimple() {
		return new MiServicio();
	}
	

}
