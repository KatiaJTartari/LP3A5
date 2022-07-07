package main;

/* Classe Item original sem modificação, como requisito 
 * é pedido para NÃO ALTERAR o código da classe Item. */

public class Item {

	public String name;

	public int sellIn; // sellIn (vender em): informa o número de dias que tem para vender.

	public int quality; // quality: informa o quão valioso é o item.

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
