package com.pruebatecnica.ws.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.pruebatecnica.ws.business.dao.conection.Conection;

public class TestConection {

	@Test
	public void test() throws Exception {

		assertNotNull(Conection.conection());

	}

}