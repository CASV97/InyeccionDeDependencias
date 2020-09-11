package com.bolsadeideas.springboot.di.app.domain;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 * Podemos cambiar el contexto, para que en vez de que sea Singlenton, sea del
 * tipo Reaquest(Va a durar lo que dura una peticioin HTTP), por ejemplo cada
 * usuario que se conecte, va a tener una factura distinta y propia, y si se
 * modifica ese valor ese valor no se altera al resto se necesita que implemente
 * la interfaz serializable, por que conbierte el olbjeto en una secuencia de
 * bites y transportar en estos tipos de almacenamiento
 */
@Component
@RequestScope
public class Factura implements Serializable {

	private static final long serialVersionUID = 1L;
	@Value("${factura.descripcion}")
	private String descripcion;
	// Relacion etre clases
	// Tiene relacion con cliente
	@Autowired
	private Cliente cliente;
	// una factura tiene una o mas lineas o items podremos inyectar el componente
	// una vez agregado desde la clase de configuracion al contenedor de Spring
	@Autowired
	// @Qualifier("itemsFacturaOficina")
	private List<ItemFactura> items;

	/**
	 * <h1>ciclo de vida de los componentes</h1>
	 * <h2>Después de que se contruye el objeto</h2>
	 * <p>
	 * Con <code>@PostContruct </code>podemos modificar datos, tareas, o procesos
	 * justo después de que se contruya el objeto en el contenedor de Spring, por
	 * <b>ejemplo:<br>
	 * </b>
	 * <ul>
	 * <li>Inicializar recursos</li>
	 * <li>Inicializar Objetos</li>
	 * </ul>
	 * </p>
	 * <p>
	 * Es muy parecido a un contructor pero de una forma más elegante y permite que
	 * Spring maneje la contrucción del objeto y después nosotros en este método<br>
	 * inicializamos lo que queramos.
	 * </p>
	 * 
	 * @see javax.annotation.PostConstruct
	 * @see java.lang.String
	 * 
	 */
	@PostConstruct
	private void inicializar() {
		cliente.setNombre(cliente.getNombre().concat(" ").concat("Mujica"));
		descripcion = descripcion.concat(" ").concat("del cliente:").concat(cliente.getDni());
	}

	/**
	 * <h1>ciclo de vida de los componentes</h1>
	 * <h2>Cuando se destruye el objeto</h2>
	 * <p>
	 * Con <code>@PreDestroy</code>al contrario de <code>@PostContruct</code>
	 * podemos modificar datos, tareas, o procesos cuando se destruya el objeto en
	 * el contenedor de Spring, por <b>ejemplo:<br>
	 * </b>
	 * <ul>
	 * <li>Podemos cerrar recursos cuando son componentes con recursos</li>
	 * <li>Inicializar Objetos</li>
	 * </ul>
	 * </p>
	 * <p>
	 * El siclo de vida que dura nuestro componente en el contenedor por defecto es
	 * <code>Singlenton</code> tiene una sola instancia y va a durar toda la
	 * aplicacion , es decir hasta que <br>
	 * bajemos la aplicacion del servidor o hagamos un Undeploy
	 * </p>
	 * 
	 * @see javax.annotation.PreDestroy
	 * @see java.lang.String
	 * 
	 */
	@PreDestroy
	public void destruir() {
		System.out.println("Factura Destruida: ".concat("descripcion: ".concat(descripcion)));
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}

}
