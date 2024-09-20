package demos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class demotest {

	private demo demo;
	
	@BeforeEach
	public void setup() {
		demo = new demo();
	}
	
	@Test
	public void multiply() {
		assertEquals(20, demo.multiply(5, 4));
;
	}
}
