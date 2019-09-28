package Exercicio01;

import java.util.ArrayList;

public class MainMyThread {

	// Variavel de ambiente para tamanho das threads
	private static final int NUM_THREADS = 10;

	public static void main(String[] args) {
		// Lista para guarda os estados das threads
		ArrayList<Thread> listaDeThreads = new ArrayList<Thread>();
		// For com para gerar threads
		for (int i = 0; i < NUM_THREADS; i++) {
			// Thread criada a partir de cada novo laco do for
			MyThread t1 = new MyThread(i);
			// Funcao inicio da thread
			t1.start();
			// Adicionando thread a listaDeThreds
			listaDeThreads.add(t1);
		}

		// interrupt

		try {
			// Adicionando o tempo a funcao sleep
			MyThread.sleep(1000);
			// Interropendo o funcionamento das threads com base na interacao do for
			for (int i = 0; i < NUM_THREADS; i++) {
				listaDeThreads.get(i).interrupt();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// join

		try {
			// Utilizando funcao join para fazer com que as threads esperem
			for (int i = 0; i < NUM_THREADS; i++) {
				listaDeThreads.get(i).join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("ALL DONE!");
	}
}
