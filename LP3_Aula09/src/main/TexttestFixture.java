package main;

/* Classe TexttestFixture original com pequenas alterações:
   (deixei como comentário linha 13 e inclui linha 14) 
   (deixei como comentário linha 27 e inclui linha 28)
   (deixei como comentário linha 33 e inclui linha 34) 
   */

public class TexttestFixture {

	public static void main(String[] args) {

		// System.out.println("OMGHAI!");
		System.out.println("Bem Vindo ao Sistema de Atualização de Preços do Estoque!\n");

		Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20), new Item("Aged Brie", 2, 0),
				new Item("Elixir of the Mongoose", 5, 7), new Item("Sulfuras, Hand of Ragnaros", 0, 80),
				new Item("Sulfuras, Hand of Ragnaros", -1, 80),
				new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				// this conjured item does not work properly yet
				new Item("Conjured Mana Cake", 3, 6) };

		GildedRose app = new GildedRose(items);

		// int days = 2;
		int days = 30;
		if (args.length > 0) {
			days = Integer.parseInt(args[0]) + 1;
		}

		// for (int i = 0; i < days; i++) {
		for (int i = 1; i <= days; i++) {
			System.out.println("-------- day " + i + " --------");
			System.out.println("name, sellIn, quality");
			for (Item item : items) {
				System.out.println(item);
			}
			System.out.println();
			app.updateQuality();
		}
	}
}
