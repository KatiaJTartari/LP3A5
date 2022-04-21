package br.edu.ifsp.lp3a5.jantarFilosofos.solucao2;

import br.edu.ifsp.lp3a5.jantarFilosofos.AbstractMesa;
import br.edu.ifsp.lp3a5.jantarFilosofos.Filosofo;
import br.edu.ifsp.lp3a5.jantarFilosofos.Garfo;
import br.edu.ifsp.lp3a5.jantarFilosofos.RoteiroComplacente;

public class Mesa2 extends AbstractMesa {

	public Mesa2(int qtdFilosofos) {
		super(qtdFilosofos, new RoteiroComplacente());
	}

	/**
	 * Tenta pegar os garfos, um de cada vez, sem ordem definida.
	 * 
	 * Desiste caso n�o consiga pegar o primeiro garfo.
	 * 
	 * Desiste e devolve o primeiro, caso n�o consiga pegar o segundo garfo.
	 * 
	 * Aguarda um pouco antes de prosseguir.
	 * 
	 * Ao variar esse tempo de espera o algoritmo pode se tornar mais ou menos
	 * eficiente, ainda assim, h� o risco de cair na situa��o de que alguns
	 * fil�sofos comam mais que os outros.
	 * 
	 */
	public boolean pegaGarfosComplacente(Filosofo filosofo) throws InterruptedException {

		// se n�o conseguir pegar o primeiro garfo para de tentar.
		if (!this.pegaUmGarfo(filosofo)) {
			return false;
		}

		// se n�o conseguir pegar o segundo garfo, devolve o primeiro e para de tentar
		if (!this.pegaUmGarfo(filosofo)) {
			this.devolveGarfos(filosofo);
			log.fine(filosofo.getIdFilosofo() + " falhou ao tentar comer.");
			// Varia��o 1 - com tempo fixo, superior ao tempo m�ximo aleat�rio.
			Thread.sleep(Filosofo.TEMPO_ESPERA_MAXIMO * 2);

			// Varia��o 2 - com tempo aleat�rio parecido com o das outras opera��es
			// filosofo.aguarda();

			// Variacao 3 - n�o aguarda

			return false;
		}

		log.fine(filosofo.getIdFilosofo() + " pegou os garfos com sucesso.");
		return true;
	}

	private boolean pegaUmGarfo(Filosofo filosofo) {
		final Garfo garfoEsq = this.escolheGarfoEsquerdo(filosofo);
		if (garfoEsq.isDisponivel()) {
			return garfoEsq.pegar(filosofo);
		}

		final Garfo garfoDir = this.escolheGarfoDireito(filosofo);
		if (garfoDir.isDisponivel()) {
			return garfoDir.pegar(filosofo);
		}

		return false;
	}

	public void devolveGarfos(Filosofo filosofo) {
		this.escolheGarfoEsquerdo(filosofo).devolver();
		this.escolheGarfoDireito(filosofo).devolver();
		log.fine(this.getMsgGarfos());
	}

	@Override
	public void pegaGarfosGuloso(Filosofo filosofo) throws InterruptedException {
		throw new UnsupportedOperationException();

	}
}
