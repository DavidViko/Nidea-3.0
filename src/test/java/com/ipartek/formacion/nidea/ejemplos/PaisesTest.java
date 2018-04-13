package com.ipartek.formacion.nidea.ejemplos;

import java.util.ArrayList;

import org.junit.Test;

public class PaisesTest {

	ArrayList<String> listaPaises = new ArrayList<String>() {
		{
			add("España");
			add("Francia");
			add("Portugal");
		}
	};

	@Test
	public void test() {
		listaPaises.add(1, "Alemania");
	}

}
