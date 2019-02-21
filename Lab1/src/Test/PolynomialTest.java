package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Polynomial;

class PolynomialTest {
	
	Polynomial poly;
	
	private void Scene1() {
		poly = new Polynomial("14 13 8 10 3 7", 5);
	}
	private void Scene2() {
		poly = new Polynomial("0 7 0 2 0", 4);
	}
	private void Scene3() {
		poly = new Polynomial("-2 0.2 -5 0.5", 3);
	}
	private void Scene4() {
		poly = new Polynomial("3 b 4", 2);
	}
	private void Scene5() {
		poly = new Polynomial("0 0 -2 2 -2 2", 5);
	}
	private void Scene6() {
		poly = new Polynomial("0 7 0 2 0", 4);
	}
	private void Scene7() {
		poly = new Polynomial("3 -5.5 -1.5 1", 3);
	}
	

	@Test
	void testBairstow1() {
		Scene1();
		String expe = "-0.4442187426766947 + 1.1024962736738961i\n" + 
					  "-0.4442187426766947 - 1.1024962736738961i\n" + 
					  "0.6705816268377994 + 1.0754482993677987i\n" + 
					  "0.6705816268377994 - 1.0754482993677987i\n" + 
					  "-0.881297196881951";
		poly.startBairstow();
		String[] a = poly.getDate().split("\n");
		String[] b = expe.split("\n");
		for (int i = 0; i < b.length; i++) {	
			assertEquals(b[i], a[i]);
		}
	}
	@Test
	void testBairstow2() {
		Scene2();
		String expe = "0.0 + 1.8708286933869707i\n" + 
				  	  "0.0 - 1.8708286933869707i\n" + 
				  	  "NaN\n" + 
				  	  "NaN";
		poly.startBairstow();
		String[] a = poly.getDate().split("\n");
		String[] b = expe.split("\n");
		for (int i = 0; i < b.length; i++) {	
			assertEquals(b[i], a[i]);
		}
	}
	@Test
	void testBairstow3() {
		Scene3();
		String expe = "1.6586997379857915E-18 + 0.6324555320336759i\n" + 
					  "1.6586997379857915E-18 - 0.6324555320336759i\n" + 
					  "10.0";
		poly.startBairstow();
		String[] a = poly.getDate().split("\n");
		String[] b = expe.split("\n");
		for (int i = 0; i < b.length; i++) {	
			assertEquals(b[i], a[i]);
		}
	}
	@Test
	void testRootFinder1() {
		Scene5();
		String expe = "9.526013417899038E-9\n" + 
					  "-9.526013863709285E-9\n" + 
					  "1.0000000000000002\n" + 
					  "4.733186280107525E-16 1.0i\n" + 
					  "4.733186280107525E-16 -1.0i";
		poly.startRootFinder();
		String[] a = poly.getDate().split("\n");
		String[] b = expe.split("\n");
		for (int i = 0; i < b.length; i++) {
			assertEquals(b[i], a[i]);
		}
	}
	@Test
	void testRootFinder2() {
		Scene6();
		String expe = "0.0\n" + 
					  "0.0\n" + 
					  "0.0\n" + 
					  "0.0";
		poly.startRootFinder();
		String[] a = poly.getDate().split("\n");
		String[] b = expe.split("\n");
		for (int i = 0; i < b.length; i++) {	
			assertEquals(b[i], a[i]);
		}
	}
	@Test
	void testRootFinder3() {
		Scene7();
		String expe = "-1.9999999999999973\n" + 
					  "2.999999999999999\n" + 
					  "0.5";
		poly.startRootFinder();
		String[] a = poly.getDate().split("\n");
		String[] b = expe.split("\n");
		for (int i = 0; i < b.length; i++) {	
			assertEquals(b[i], a[i]);
		}
	}
}
