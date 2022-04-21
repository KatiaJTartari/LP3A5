package br.edu.ifsp.lp3a5.aula3.jantarFilosofos.solucao1;

import br.edu.ifsp.lp3a5.aula3.jantarFilosofos.AbstractMesa;
import br.edu.ifsp.lp3a5.aula3.jantarFilosofos.Filosofo;
import br.edu.ifsp.lp3a5.aula3.jantarFilosofos.Garfo;
import br.edu.ifsp.lp3a5.aula3.jantarFilosofos.RoteiroGuloso;

public class Mesa1 extends AbstractMesa {

	public Mesa1(int qtdFilosofos) {
		super(qtdFilosofos, new RoteiroGuloso());
	}

	/**
	 * M�todo guloso de pegar os garfos. Fica segurando um garto enquanto n�o obt�m
	 * os dois garfos.
	 */
	public void pegaGarfosGuloso(Filosofo filosofo) throws InterruptedException {
		int qtdGarfos = 0;

		/*
		 * POLLING LOOP (la�o de sondagem - apesar de ser um la�o, n�o � o mesmo que
		 * busy wait pois o sleep na Thread libera o SO para fazer outras coisas
		 */

		while (qtdGarfos < 2) {
			while (!pegaUmGarfo(filosofo)) {

				System.out.println(filosofo.getIdFilosofo() + " est� aguardando por um garfo..");
				log.fine(this.getMsgGarfos());
				filosofo.aguarda();
			}
			qtdGarfos++;
			log.fine(filosofo.getIdFilosofo() + " est� com " + qtdGarfos + " garfos.");
		}
	}

	private boolean pegaUmGarfo(Filosofo filosofo) {
		final Garfo garfoEsquerdo = escolheGarfoEsquerdo(filosofo);
		if (garfoEsquerdo.isDisponivel()) {
			return garfoEsquerdo.pegar(filosofo);
		}

		final Garfo garfoDireito = escolheGarfoDireito(filosofo);
		if (garfoDireito.isDisponivel()) {
			return garfoDireito.pegar(filosofo);
		}

		return false;
	}

	public void devolveGarfos(Filosofo filosofo) {
		escolheGarfoEsquerdo(filosofo).devolver();
		escolheGarfoDireito(filosofo).devolver();
		log.fine(this.getMsgGarfos());
	}

	@Override
	public boolean pegaGarfosComplacente(Filosofo filosofo) throws InterruptedException {
		throw new UnsupportedOperationException();
	}
}
