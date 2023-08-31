package Conta.main;

import Conta.main.Service.RecebidoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;

@SpringBootTest
class MainApplicationTests {



	@Test
	void testMedia() {

		RecebidoService service = new RecebidoService();

		List<Double> numeros = new ArrayList<>();

		numeros.add(10.0);
		numeros.add(20.0);
		numeros.add(5.0);

		Double num = 11.666666666666666;

		Double aux = service.media(numeros);

		Assert.assertEquals(num, aux);
	}

	@Test
	void testDesvioPadrao(){

		RecebidoService service = new RecebidoService();

		List<Double> numeros = new ArrayList<>();
		numeros.add(10.0);
		numeros.add(20.0);
		numeros.add(5.0);

		Double num = 6.236095644623235;

		Double aux = service.desvioPadrao(numeros);

		Assert.assertEquals(num, aux);

	}

	@Test
	void testQntNumeros(){

		RecebidoService service = new RecebidoService();

		List<Double> numeros = new ArrayList<>();
		numeros.add(10.0);
		numeros.add(20.0);
		numeros.add(5.0);

		Double num = 3.00;

		Double aux = service.qntRecebido(numeros);

		Assert.assertEquals(num, aux);

	}

	@Test
	void testMediana(){

		RecebidoService service = new RecebidoService();

		List<Double> numeros = new ArrayList<>();
		numeros.add(10.0);
		numeros.add(20.0);
		numeros.add(5.0);

		Double num = 10.00;

		Double aux = service.mediana(numeros);

		Assert.assertEquals(num, aux);

	}

	@Test
	void testMinimo(){
		RecebidoService service = new RecebidoService();

		List<Double> numeros = new ArrayList<>();
		numeros.add(10.0);
		numeros.add(20.0);
		numeros.add(5.0);

		Double num = 5.00;

		Double aux = service.minimo(numeros);

		Assert.assertEquals(num, aux);

	}

	@Test
	void testMaximo(){
		RecebidoService service = new RecebidoService();

		List<Double> numeros = new ArrayList<>();
		numeros.add(10.0);
		numeros.add(20.0);
		numeros.add(5.0);

		Double num = 20.00;

		Double aux = service.maximo(numeros);

		Assert.assertEquals(num, aux);

	}

	@Test
	void somaTotal(){
		RecebidoService service = new RecebidoService();

		List<Double> numeros = new ArrayList<>();
		numeros.add(10.0);
		numeros.add(20.0);
		numeros.add(5.0);

		Double num = 35.00;

		Double aux = service.somaValores(numeros);

		Assert.assertEquals(num, aux);
	}



}
