package com.ohalfmoon.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		
		try(Connection connection =
				DriverManager.getConnection(
						"jdbc:oracle:",
						"",
						"")) {
			log.info(connection);
 		} catch (Exception e) {
			// TODO: handle exception
 			fail(e.getMessage());
		}
	}

}
