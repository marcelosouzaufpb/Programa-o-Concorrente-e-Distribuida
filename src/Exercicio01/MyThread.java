package Exercicio01;

public class MyThread extends Thread {

	// Costrutor
	public MyThread(int i) {
		super("Thread: " + i);
	}

	// Funcao run para da starte nas threads
	@Override
	public void run() {
		try {
			while (true) {
				// Printe dos nomes das threads
				System.out.println(getName());
				// Funcao para dormir as threds por um valor randomico
				sleep((long) (Math.random()));
			}
		} catch (InterruptedException e) {
			// Execao esperada
		}
	}
}
