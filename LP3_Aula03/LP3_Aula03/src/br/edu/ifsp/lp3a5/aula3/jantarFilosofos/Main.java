package br.edu.ifsp.lp3a5.aula3.jantarFilosofos;

import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br.edu.ifsp.lp3a5.aula3.jantarFilosofos.solucao1.Mesa1;
import br.edu.ifsp.lp3a5.aula3.jantarFilosofos.solucao2.Mesa2;
import br.edu.ifsp.lp3a5.aula3.jantarFilosofos.solucao3.Mesa3;
import br.edu.ifsp.lp3a5.aula3.utils.ICicloDeVida;
import br.edu.ifsp.lp3a5.aula3.utils.JanelaStartStop;
import br.edu.ifsp.lp3a5.aula3.utils.LogPanelHandler;

public class Main {

	// usa logging.handler para poder printar no painel
	final static Logger log = Logger.getLogger("logging.handler");

	public static void createAndShowGui(JPanel panel) {
		final JFrame frame = new JFrame("Start Stop");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void initialize(AbstractMesa mesa) {
		final ICicloDeVida jantar = new Jantar(mesa);
		final JanelaStartStop panel = new JanelaStartStop(jantar);
		final LogPanelHandler handler = LogPanelHandler.getInstance(panel);
		log.addHandler(handler);
		SwingUtilities.invokeLater(() -> createAndShowGui(panel));
	}

	public static void testeDeadlock() {
		initialize(new Mesa1(5));
		log.info("TESTE DEADLOCK");
		log.info("Neste exemplo o fil�sofo fica com um garfo na m�o � "
				+ "espera que o segundo garfo libere e ele possa comer. "
				+ "Depois de um tempo gera uma situa��o de deadlock quando "
				+ "todos os fil�sofos ficam aguardando, sem comer ou " + "liberar o talher para os demais.");
	}

	public static void testeStarved() {
		initialize(new Mesa2(5));
		log.info("TESTE STARVED");
		log.info("Neste exemplo o fil�sofo volta a pensar quando n�o consegue "
				+ "obter os dois garfos. N�o h� garantias que na pr�xima "
				+ "rodada ele conseguir� os dois garfos. Com isso existe a "
				+ "probabilidade de que uns comam bastante e outros fiquem " + "famintos.");
	}

	public static void testeOK() {
		initialize(new Mesa3(5));
		log.info("TESTE NORMAL");
		log.info("Neste exemplo o fil�sofo agarra o primeiro garfo e n�o o solta "
				+ "at� conseguir pegar o segundo e comer, por�m, a sincroniza��o "
				+ "dos m�todos que pegam e devolvem os garfos evitam o problema"
				+ "de deadlock, pois quando um fil�sofo pega o primeiro garfo,"
				+ "os demais precisam esperar para conseguirem pegar um primeiro" + "garfo tamb�m.");
	}

	public static void main(String[] args) {

		testeDeadlock();
		// testeStarved();
		// testeOK();
	}
}
