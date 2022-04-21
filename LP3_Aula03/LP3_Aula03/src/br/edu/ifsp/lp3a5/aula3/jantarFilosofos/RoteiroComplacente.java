package br.edu.ifsp.lp3a5.aula3.jantarFilosofos;

public class RoteiroComplacente implements IRoteiroJantar {

	public void jantarPensante(Filosofo filosofo) throws InterruptedException {
		filosofo.pensa();

		if (!filosofo.getMesa().pegaGarfosComplacente(filosofo)) {
			return;
		}

		filosofo.come();
		filosofo.devolveGarfos();

	}
}
