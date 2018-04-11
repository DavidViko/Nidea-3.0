package com.ipartek.formacion.nidea.ejemplos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.nidea.pojo.Bebida;

public class BebidaTest {
	static ValidatorFactory validatorFactory;
	static Validator validator;
	ConstraintViolation<Bebida> violation = null;
	Iterator<ConstraintViolation<Bebida>> it;
	Bebida b1 = new Bebida();
	Set<ConstraintViolation<Bebida>> violations;

	@BeforeClass
	public static void createValidator() {
		validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}

	@AfterClass
	public static void close() {
		validatorFactory = null;
		validator = null;
	}

	@Before
	public void setUp() throws Exception {
		b1 = new Bebida();
	}

	@After
	public void tearDown() throws Exception {
		b1 = null;
	}

	@Test
	public void validarNombre() {
		try {
			ConstraintViolation<Bebida> violation = null;
			Iterator<ConstraintViolation<Bebida>> it;

			Bebida b1 = new Bebida();

			violations = validator.validate(b1);

			assertTrue(violations.size() == 2);

			/**************************************************/

			b1.setNombre("prueba");
			b1.setPrecio(5.2f);

			violations = validator.validate(b1);
			assertTrue(violations.size() == 0);

			it = violations.iterator();

			/**************************************************/

			b1.setNombre("a");
			b1.setPrecio(0.2f);
			violations = validator.validate(b1);
			assertTrue(violations.size() == 1);

			it = violations.iterator();

			while (it.hasNext()) {
				violation = it.next();
				assertEquals("nombre", violation.getPropertyPath().toString());
				assertEquals("a", violation.getInvalidValue());
			}

			/**************************************************/

			b1.setNombre("pruebaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			b1.setPrecio(0);

			violations = validator.validate(b1);
			assertTrue(violations.size() == 2);

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void validarPrecio() {
		b1.setNombre("prueba");
		b1.setPrecio(-5);
		violations = validator.validate(b1);
		assertTrue(violations.size() == 1);

		while (it.hasNext()) {
			violation = it.next();
			assertEquals("precio", violation.getPropertyPath().toString());
			assertEquals(-5f, violation.getInvalidValue());
		}
	}

}
