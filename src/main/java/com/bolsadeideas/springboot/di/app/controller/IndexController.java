package com.bolsadeideas.springboot.di.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.app.model.service.IServicio;

/**
 * Ventajas y características de la inyeccion de dependencias vamos a ver las
 * ventajas de este patron
 */
@Controller
public class IndexController {
	/*
	 * @Autorided queda ambigüo si existen mas de una implementacion de la interfaz
	 * a implementar, dará error, si queremos que por defecto inyecte una
	 * implementacion, esta deberá llevar el decorador @Primary en la clase
	 * 
	 * @Qualifier("NomImplementacion") se hara uso para especificar una
	 * implementacion en específico
	 */
	@Autowired
	private IServicio miServicioComplejo;

//no hace falta agregar @Autowired por que el parám
//	public IndexController(IServicio miServicio) {
//		super();
//		this.miServicio = miServicio;
//	}

	@GetMapping({ "/index", "/", "" })
	public String index(Model model) {
		model.addAttribute("objeto", miServicioComplejo.operacion());
		model.addAttribute("titulo", "Añadiendo la clase de servicio");
		return "index";
	}

	// Cómo inyectar mediante el método SET y trambien contructor, un alternativa a
	// inyectar mediante el atributo, en vez de tener e
//	@Autowired
//	public void setMiServicio(IServicio miServicio) { 
//		this.miServicio = miServicio;
//	}
//	

}
