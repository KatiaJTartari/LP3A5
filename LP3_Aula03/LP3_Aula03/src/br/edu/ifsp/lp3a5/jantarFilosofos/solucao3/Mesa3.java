package br.edu.ifsp.lp3a5.jantarFilosofos.solucao3;

import java.util.logging.Logger;

import br.edu.ifsp.lp3a5.jantarFilosofos.AbstractMesa;
import br.edu.ifsp.lp3a5.jantarFilosofos.Filosofo;
import br.edu.ifsp.lp3a5.jantarFilosofos.Garfo;
import br.edu.ifsp.lp3a5.jantarFilosofos.RoteiroGuloso;

/**
 * Solu��o para o problema de deadlock e starved.
 * 
 * Aqui a abordagem tamb�m � gulosa, isto �, o fil�sofo n�o larga o primeiro
 * garfo enquanto n�o conseguir comer, o que resolve o problema da inani��o.
 * 
 * Por�m, os m�todos que pegam e devolvem os garfos s�o sincronizados,
 * garantindo que apenas um fil�sofo chame o m�todo de cada vez, enquanto os
 * outros aguardam para que possam tamb�m tentar pegar os garfos da mesa.
 * 
 * Por conta disso, n�o haver� o deadlock de todos os fil�sofos aguardarem com
 * um garfo em m�os.
 * 
 * A sincroniza��o torna o processo um pouco mais lento
 * 
 * @author diego
 *
 */
public class Mesa3 extends AbstractMesa {

	final static Logger logger = Logger.getLogger("logging.handler");

	final StatusFilosofo[] estadoFilosofos;

	public Mesa3(int qtdFilosofos) {
		super(qtdFilosofos, new RoteiroGuloso());

		estadoFilosofos = new StatusFilosofo[this.qtdFilosofos];

		for (int i = 0; i < this.qtdFilosofos; i++) {
			estadoFilosofos[i] = StatusFilosofo.PENSANDO;
		}
	}

	/**
	 * O m�todo sincronizado garante que cada um entre no m�todo de cada vez.
	 * 
	 * 
	 */
	public synchronized boolean pegaGarfos(Filosofo filosofo) throws InterruptedException {
		final int numFilosofo = filosofo.getPosicaoMesa();
		estadoFilosofos[numFilosofo] = StatusFilosofo.FOME;
		// polling loop (n�o � busy wait)
		while (this.confereStatusFilosofosAoLado(filosofo, StatusFilosofo.COMENDO)) {
			tentativas[numFilosofo]++;
			wait(); // aguarda at� receber notifica��o para sair de espera
		}

		tentativas[numFilosofo] = 0;
		final Garfo garfoEsq = this.escolheGarfoEsquerdo(filosofo);
		garfoEsq.pegar(filosofo);

		final Garfo garfoDir = this.escolheGarfoDireito(filosofo);
		garfoDir.pegar(filosofo);

		estadoFilosofos[numFilosofo] = StatusFilosofo.COMENDO;

		return true;
	}

	/**
	 * O m�todo sincronizado limita a que apenas uma thread execute o m�todo de cada
	 * vez.
	 */
	public synchronized void devolveGarfos(Filosofo filosofo) {
		this.escolheGarfoEsquerdo(filosofo).devolver();
		this.escolheGarfoDireito(filosofo).devolver();

		this.estadoFilosofos[filosofo.getPosicaoMesa()] = StatusFilosofo.PENSANDO;

		if (this.confereStatusFilosofosAoLado(filosofo, StatusFilosofo.FOME)) {
			/*
			 * tira da espera todas as threads caso um dos fil�sofos ao lado esteja com
			 * FOME, isto �, tenha entrado em wait enquanto espera um garfo
			 */
			notifyAll();
		}

		log.fine(getEstadosFilosofos());
		log.fine(getMsgGarfos());
		log.fine(getMsgTentativas());
	}

	private boolean confereStatusFilosofosAoLado(Filosofo filosofo, StatusFilosofo status) {
		final int posicao = filosofo.getPosicaoMesa();
		return estadoFilosofos[filosofoDaEsquerda(posicao)] == status
				|| estadoFilosofos[filosofoDaDireita(posicao)] == status;
	}

	private int filosofoDaDireita(int filosofo) {
		return (filosofo + 1) % this.qtdFilosofos;
	}

	private int filosofoDaEsquerda(int filosofo) {
		return (this.qtdFilosofos + filosofo - 1) % this.qtdFilosofos;
	}

	public String getEstadosFilosofos() {
		final StringBuffer sb = new StringBuffer("Fil�sofos = [ ");

		for (int i = 0; i < this.qtdFilosofos; i++) {
			sb.append(estadoFilosofos[1].name() + ", ");
		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public void pegaGarfosGuloso(Filosofo filosofo) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean pegaGarfosComplacente(Filosofo filosofo) throws InterruptedException {
		throw new UnsupportedOperationException();
	}

}
