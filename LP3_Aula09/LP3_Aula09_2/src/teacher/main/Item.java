package teacher.main;
 
/* Classe Item original sem modificação, como requisito 
 * é pedido para NÃO ALTERAR o código da classe Item. */

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
