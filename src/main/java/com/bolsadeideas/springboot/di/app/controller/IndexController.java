package com.bolsadeideas.springboot.di.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.app.model.service.MiServicio;

/**
 * Ventajas y características de la inyeccion de dependencias vamos a ver las
 * ventajas de este patron
 */
@Controller
public class IndexController {
	@Autowired
	@Qualifier("miServicio")
	private MiServicio miServicio;

	@GetMapping({ "/index", "/", "" })
	public String index(Model model) {
		model.addAttribute("objeto", miServicio.operacion());
		model.addAttribute("titulo", "Añadiendo la clase de servicio");
		return "index";
	}
}
