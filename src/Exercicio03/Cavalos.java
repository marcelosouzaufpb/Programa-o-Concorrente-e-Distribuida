package Exercicio03;

import java.util.Random;

import javax.swing.JLabel;

public class Cavalos extends JLabel implements Runnable {
	private static final long serialVersionUID = 1L;
	private Thread cavalo = null;
	private int posicaoX;
	private int posicaoY;

	// CONSTRUTOR SOBRECARREGADO
	public Cavalos(String nome, int posicaoX, int posicaoY) {
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
		cavalo = new Thread(this, nome);
		cavalo.start();

	}

	// MÉTODO RUN() DA INTERFACE RUNNABLE
	@Override
	public void run() {
		posicaoX += new Random().nextInt(3) * 10;
		this.setLocation(posicaoX, posicaoY);

		if (posicaoX >= 1280)
			return;

		try {
			Thread.sleep(new Random().nextInt(5) * 100);
			run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
