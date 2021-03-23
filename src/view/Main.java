package view;

import java.util.concurrent.Semaphore;

import controller.Carro;

public class Main {
	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(2);
		for(int i = 0; i < 4; i++) {
			Carro c = new Carro(semaforo, i);
			c.start();
		}
	}
}
