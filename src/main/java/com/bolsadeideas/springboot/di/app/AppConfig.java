package com.bolsadeideas.springboot.di.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.bolsadeideas.springboot.di.app.domain.ItemFactura;
import com.bolsadeideas.springboot.di.app.domain.Producto;
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
	@Bean("itemsFactura")
	public List<ItemFactura> registrarItems(){
		List<ItemFactura> list=new ArrayList<ItemFactura>();
		Producto p1=new Producto("California", 15.6);
		Producto p2=new Producto("Amnesia", 20.6);
		list.add(new ItemFactura(p1, 4));
		list.add(new ItemFactura(p2, 2));
		
		return list;
	}
	@Bean("itemsFacturaOficina")
	@Primary
	public List<ItemFactura> registrarItemsOficina(){
		List<ItemFactura> list=new ArrayList<ItemFactura>();
		Producto p1=new Producto("Grinder", 5.6);
		Producto p2=new Producto("Bolsas erme", 2.6);
		Producto p3=new Producto("Báscula", 15.00);
		Producto p4=new Producto("Papeles ROW", 1.0);
		list.add(new ItemFactura(p1, 4));
		list.add(new ItemFactura(p2, 2));
		list.add(new ItemFactura(p3, 2));
		list.add(new ItemFactura(p4, 10));
		
		return list;
	}
	

}
