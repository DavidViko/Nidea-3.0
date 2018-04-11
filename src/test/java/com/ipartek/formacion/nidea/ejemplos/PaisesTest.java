package com.ipartek.formacion.nidea.ejemplos;

import java.util.ArrayList;

import org.junit.Test;

public class PaisesTest {

	ArrayList<String> listaPaises = new ArrayList<String>() {
		{
			add("A");
			add("B");
			add("C");
		}
	};

	@Test
	public void test() {
		listaPaises.add(3, "Alemania");
	}

}
