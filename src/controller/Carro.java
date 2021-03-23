package controller;

import java.util.concurrent.Semaphore;

public class Carro extends Thread{
	String sentido;
	Semaphore semaforo;
	
	public Carro(Semaphore semaforo, int id){
		switch(id) {
		case 0:
			sentido = "a direita ";
			break;
		case 1:
			sentido = "a esquerda ";
			break;
		case 2:
			sentido = "cima ";
			break;
		case 3:
			sentido = "baixo ";
			break;
		}
		this.semaforo = semaforo;
	}
	
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cruzar();
		semaforo.release();
	}


	public void cruzar() {
		try {
			sleep(3000);
			System.out.println("O carro indo para " + sentido + "acabou de atravessar o cruzamento.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
