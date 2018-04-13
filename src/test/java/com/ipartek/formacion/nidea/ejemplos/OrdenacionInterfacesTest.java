package com.ipartek.formacion.nidea.ejemplos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.nidea.util.Utilidades;

public class OrdenacionInterfacesTest {

	static ArrayList<Ordenable> coleccion;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		coleccion = new ArrayList<Ordenable>();
	}

	@AfterClass
	public static void setDownAfterClass() throws Exception {
		coleccion = null;
	}

	@Before
	public void setUp() throws Exception {
		coleccion = new ArrayList<Ordenable>();

		Mesa e1 = new Mesa();
		e1.setPatas(3);

		Perro e2 = new Perro();
		e2.setVacunas(1);

		Mesa e3 = new Mesa();
		e3.setPatas(0);

		Perro e4 = new Perro();
		e4.setVacunas(9);

		coleccion.add(e1);
		coleccion.add(e2);
		coleccion.add(e3);
		coleccion.add(e4);
	}

	@After
	public void setDown() throws Exception {
		coleccion = null;
	}

	@Test
	public void testBubbleSort() {
		Utilidades.bubbleSort(coleccion);
		assertEquals(0, coleccion.get(0).getValor());
		assertEquals(1, coleccion.get(1).getValor());
		assertEquals(3, coleccion.get(2).getValor());
		assertEquals(9, coleccion.get(3).getValor());

		Ordenable elem = coleccion.get(0);
		if (elem instanceof Perro) {
			Perro p = (Perro) elem;
		} else if (elem instanceof Mesa) {
			Mesa m = (Mesa) elem;
		} else {
			fail("No esperamos esta clase de objetos");
		}
	}

	@Test
	public void testCollectionSort() {

		Collections.sort(coleccion, new ComparatorOrdenables());

		assertEquals(0, coleccion.get(0).getValor());
		assertEquals(1, coleccion.get(1).getValor());
		assertEquals(3, coleccion.get(2).getValor());
		assertEquals(9, coleccion.get(3).getValor());

		Collections.reverse(coleccion);

		assertEquals(9, coleccion.get(0).getValor());
		assertEquals(3, coleccion.get(1).getValor());
		assertEquals(1, coleccion.get(2).getValor());
		assertEquals(0, coleccion.get(3).getValor());

	}

}
