package modelo;
/** 
 * Proyecto: Juego de la vida.
 * Clase JUnit5 de prueba automatizada de las características de la clase Usuario según el modelo1.
 * @since: prototipo1
 * @source: TestUsuario.java 
 * @version: 1.0 - 2018.11.21
 * @author: ajp
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Usuario;
import util.Fecha;

public class UsuarioTest {
	private static Usuario usuario1; 
	private Usuario usuario2; 

	/**
	 * Método que se ejecuta antes de cada @Test para preparar datos de prueba.
	 * @throws DatosException 
	 */
	@BeforeAll
	public static void iniciarlizarDatosFijos() {
		// Objetos no modicados en las pruebas.
		usuario1 =new Usuario(new Nif("00000001R"), 
				"Luis", "Roca Mora",
				new DireccionPostal("Roncal", "10", "30130","Murcia"), 
				new Correo("luis@gmail.com"), 
				new Fecha(2000, 03, 21),
				new Fecha(2018, 10, 17), 
				new ClaveAcceso("Miau#12"), 
				Usuario.ROLES[1]);
	}

	/**
	 * Método que se ejecuta una sola vez al final del conjunto pruebas.
	 * No es necesario en este caso.
	 */
	@AfterAll
	public static void limpiarDatosFijos() {
		usuario1 = null;
	}

	/**
	 * Método que se ejecuta antes de cada pruebas.
	 */
	@BeforeEach
	public void iniciarlizarDatosVariables() {	
		usuario2 = new Usuario();
	}

	/**
	 * Método que se ejecuta después de cada @Test para limpiar datos de prueba.
	 */
	@AfterEach
	public void borrarDatosPrueba() {
		usuario2 = null;
	}

	// Test's CON DATOS VALIDOS
	
	@Test
	public void testUsuarioConvencional() {	
		assertEquals(usuario1.getNif().getnif(), "00000001R");
		assertEquals(usuario1.getNombre(), "Luis");
		assertEquals(usuario1.getApellidos(), "Roca Mora");
		assertEquals(usuario1.getDireccionPostal().toString(), "Roncal, 10, 30130, Murcia");
		assertEquals(usuario1.getCorreo().getCorreoTexto(), "luis@gmail.com");
		assertEquals(usuario1.getFechaNacimiento(), new Fecha(2000, 03, 21));
		assertEquals(usuario1.getFechaAlta(), new Fecha(2018, 10, 17));
		assertEquals(usuario1.getClaveAcceso().getTexto(), "Miau#12");
		assertEquals(usuario1.getRol(), Usuario.ROLES[1]);
	}

	@Test
	public void testUsuarioDefecto() {
		assertEquals(usuario2.getNif().getnif(), "00000001R");
		assertEquals(usuario2.getNombre(), "Nombre");
		assertEquals(usuario2.getApellidos(), "Apellido Apellido");
		assertEquals(usuario2.getDireccionPostal().toString(), "Roncal, 10, 30130, Murcia");
		assertEquals(usuario2.getCorreo().getCorreoTexto(), "correo@correo.es");
		assertEquals(usuario2.getFechaNacimiento().getAño(), new Fecha().getAño());
		assertEquals(usuario2.getFechaNacimiento().getMes(), new Fecha().getMes());
		assertEquals(usuario2.getFechaNacimiento().getDia(), new Fecha().getDia());
		assertEquals(usuario2.getFechaAlta().getAño(), new Fecha().getAño());
		assertEquals(usuario2.getFechaAlta().getMes(), new Fecha().getMes());
		assertEquals(usuario2.getFechaAlta().getDia(), new Fecha().getDia());
		assertEquals(usuario2.getClaveAcceso().getTexto(), "Miau#0");
		assertEquals(usuario2.getRol(), Usuario.ROLES[1]);
	}

	@Test
	public void testUsuarioCopia() {
		Usuario usuario = new Usuario(usuario1);
		assertNotSame(usuario, usuario1);
		assertNotSame(usuario.getNif(), usuario1.getNif());
		assertNotSame(usuario.getNombre(), usuario1.getNombre());
		assertNotSame(usuario.getApellidos(), usuario1.getApellidos());
		assertNotSame(usuario.getDireccionPostal(), usuario1.getDireccionPostal());
		assertNotSame(usuario.getCorreo(), usuario1.getCorreo());
		assertNotSame(usuario.getFechaNacimiento(), usuario1.getFechaNacimiento());
		assertNotSame(usuario.getFechaAlta(), usuario1.getFechaAlta());
		assertNotSame(usuario.getClaveAcceso(), usuario1.getClaveAcceso());
		assertNotSame(usuario.getRol(), usuario1.getRol());
	}
	
	@Test
	public void testSetNombre() {
		usuario2.setNombre("Luis");
		assertEquals(usuario2.getNombre(), "Luis");
	}
	
	@Test
	public void testSetApellidos() {
		usuario2.setApellidos("Roca Mora");
		assertEquals(usuario2.getApellidos(), "Roca Mora");
	}
	
	@Test
	public void testSetDomicilio() {
		usuario2.setDireccionPostal(new DireccionPostal("Roncal", "10", "30130", "Murcia"));
		assertEquals(usuario2.getDireccionPostal().toString(), "Roncal, 10, 30130, Murcia");
	}
	
	@Test
	public void testSetCorreo() {
		usuario2.setCorreo(new Correo("luis@gmail.com"));
		assertEquals(usuario2.getCorreo().getCorreoTexto(), "luis@gmail.com");
	}
	@Test
	public void testSetFechaNacimiento() {
		usuario2.setFechaNacimiento(new Fecha(2000, 3, 21));
		assertEquals(usuario2.getFechaNacimiento(), new Fecha(2000, 3, 21));
	}
	
	@Test
	public void testSetFechaAlta() {
		usuario2.setFechaAlta(new Fecha(2017,9,17));
		assertEquals(usuario2.getFechaAlta(), new Fecha(2017,9,17));
	}

	@Test
	public void testSetClaveAcceso() {
		usuario2.setClaveAcceso(new ClaveAcceso("Miau#12"));
		assertEquals(usuario2.getClaveAcceso().getTexto(), "Miau#12");
	}

	@Test
	public void testSetRol() {
		usuario2.setRol(Usuario.ROLES[1]);
		assertEquals(usuario1.getRol(), Usuario.ROLES[1]);
	}

	@Test
	public void testToString() {
		System.out.println(usuario1.toString());
		assertEquals(usuario1.toString(), 
				"nif:             00000001R\n" +
				"nombre:          Luis\n" +
				"apellidos:       Roca Mora\n" +
				"domicilio:       Roncal, 10, 30130, Murcia\n" +
				"correo:          luis@gmail.com\n" +
				"fechaNacimiento: 2000.3.21\n" +
				"fechaAlta:       2018.10.17\n" +
				"claveAcceso:     Miau#12\n" +
				"rol:             NORMAL\n"
			);
	}

	
	// Test's CON DATOS NO VALIDOS

	@Test
	public void testUsuarioConvencionalBlanco() {
		
		Usuario usuario =		
				new Usuario(new Nif(" "), 
						" ", 
						" ",
						new DireccionPostal(" ", " ", " " ," "),
						new Correo(" "), 
						new Fecha(2000, 03, 21),
						new Fecha(2018,10,17), 
						new ClaveAcceso(" "), 
						" ");

		assertNotNull(usuario.getNif());
		assertNotNull(usuario.getNombre());
		assertNotNull(usuario.getApellidos());
		assertNotNull(usuario.getDireccionPostal());
		assertNotNull(usuario.getCorreo());
		assertNotNull(usuario.getFechaNacimiento());
		assertNotNull(usuario.getFechaAlta());
		assertNotNull(usuario.getClaveAcceso());
		assertNotNull(usuario.getRol());
	}
	
	@Test
	public void testSetNifNull() {
		try {
			usuario2.setNif(null);
			fail("No debe llegar aquí...");
		} 
		catch (AssertionError e) { 
			assertTrue(usuario2.getNif() != null);
		}
	}
	
	@Test
	public void testSetNifBlanco() {
			usuario2.setNif(new Nif("  "));	
			assertEquals(usuario2.getNif().getnif(), "00000001R");
	}
	
	@Test
	public void testSetNombreNull() {
		try {
			usuario2.setNombre(null);
			fail("No debe llegar aquí...");
		} 
		catch (AssertionError e) { 
			assertTrue(usuario2.getNombre() != null);
		}
	}
	
	@Test
	public void testSetNombreBlanco() {
			usuario2.setNombre("  ");	
			assertEquals(usuario2.getNombre(), "Nombre");
	}
	
	@Test
	public void testSetApellidosNull() {
		try {
			usuario2.setApellidos(null);
			fail("No debe llegar aquí...");
		} 
		catch (AssertionError e) { 
			assertTrue(usuario2.getApellidos() != null);
		}
	}
	
	@Test
	public void testSetApellidosBlanco() {
			usuario2.setApellidos("  ");	
			assertEquals(usuario2.getApellidos(), "Apellido Apellido");
	}
	
	@Test
	public void testSetDireccionPostalNull() {
		try {
			usuario2.setDireccionPostal(null);
			fail("No debe llegar aquí...");
		} 
		catch (AssertionError e) { 
			assertTrue(usuario2.getDireccionPostal() != null);
		}
	}
	
	@Test
	public void testSetDomicilioBlanco() {
			usuario2.setDireccionPostal(new DireccionPostal(" ", " ", " ", " "));	
			assertEquals(usuario2.getDireccionPostal().toString(), "Roncal, 10, 30130, Murcia");
	}
	
	@Test
	public void testSetCorreoNull() {
		try {
			usuario2.setCorreo(null);
			fail("No debe llegar aquí...");
		} 
		catch (AssertionError e) { 
			assertTrue(usuario2.getCorreo() != null);
		}
	}
	
	@Test
	public void testSetCorreoBlanco() {
			usuario2.setCorreo(new Correo("  "));	
			assertEquals(usuario2.getCorreo().getCorreoTexto(), "correo@correo.es");
	}
	
	@Test
	public void testSetFechaNacimientoNull() {
		try {
			usuario2.setFechaNacimiento(null);
			fail("No debe llegar aquí...");
		} 
		catch (AssertionError e) { 
			assertTrue(usuario2.getFechaNacimiento() != null);
		}
	}
	
	@Test
	public void testSetFechaNacimientoFuturo() {	
			usuario1.setFechaNacimiento(new Fecha(3020, 9, 10));
			assertEquals(usuario1.getFechaNacimiento(), new Fecha(2000, 3, 21));
	}
	
	@Test
	public void testSetFechaAltaNull() {
		try {
			usuario2.setFechaAlta(null);
			fail("No debe llegar aquí...");
		} 
		catch (AssertionError e) {	
			assertTrue(usuario2.getFechaAlta() != null);
		}
	}

	@Test
	public void testSetFechaAltaFuturo() {	
			usuario1.setFechaAlta(new Fecha(3020, 9, 10));
			assertEquals(usuario1.getFechaAlta(), new Fecha(2018, 10, 17));
	}
	
	@Test
	public void testSetClaveAccesoNull() {
		try {
			usuario2.setClaveAcceso(null);
			fail("No debe llegar aquí...");
		} 
		catch (AssertionError e) { 
			assertTrue(usuario2.getClaveAcceso() != null);
		}
	}

	@Test
	public void testSetClaveAccesoBlanco() {
			usuario2.setClaveAcceso(new ClaveAcceso("  "));	
			assertEquals(usuario2.getClaveAcceso().getTexto(), "Miau#0");
	}
	
	@Test
	public void testSetRolNull() {
		try {
			usuario2.setRol(null);
			fail("No debe llegar aquí...");
		} 
		catch (AssertionError e) { 		
			assertTrue(usuario2.getRol() != null);
		}
	}

} // class
