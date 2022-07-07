package teacher.main;
 
/* Classe Item original sem modifica��o, como requisito 
 * � pedido para N�O ALTERAR o c�digo da classe Item. */

public class Item {

	public String name;

	public int sellIn;

	public int quality;

	public Item(String name, int sellIn, int quality) {
		this.name = name;
		this.sellIn = sellIn;
		this.quality = quality;
	}

	@Override
	public String toString() {
		return this.name + ", " + this.sellIn + ", " + this.quality;
	}
}
