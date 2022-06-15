package mainJava;

// Classe GildedRose sem modificação:

public class GildedRoseOriginal {
	public Item[] items;

	public GildedRoseOriginal(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {

		for (int i = 0; i < items.length; i++) {
			// Item não é brie e 'backspace passes' (assim a qualidade não aumenta com o
			// envelhecimento)
			// Itens 'backspace passes' aumentam a qualidade de forma diferente enquanto se
			// aproximam da data de vencimento, mas têm qualidade 0 após data de venda
			// Brie aumenta a qualidade em 1 a cada dia
			if (!items[i].name.equals("Aged Brie")
					&& !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
				// qualidade não pode ser negativa
				if (items[i].quality > 0) {
					// se não for sulfuras (para que o item possa ser vendido)
					if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
						// qualidade diminui dia a dia
						items[i].quality = items[i].quality - 1;
					}
				}
				// o item é brie e backspace passes (a qualidade aumenta a cada dia em ambos
				// os casos)
			} else {
				// a qualidade não pode ser superior a 50
				if (items[i].quality < 50) {
					items[i].quality = items[i].quality + 1;
					// item é 'backspace passes' (qualidade aumenta a cada dia)
					if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
						// aumenta em 2 quando faltam menos de 11 dias
						if (items[i].sellIn < 11) {
							// item 'backspace passes' pode ter qualidade 49 max
							if (items[i].quality < 50) {
								// não deveria ser + 2?
								items[i].quality = items[i].quality + 1;
							}
						}
						// item 'Backspace passes' aumentado em 3 quando faltam menos de 5
						// dias
						if (items[i].sellIn < 6) {
							// como acima
							if (items[i].quality < 50) {
								// não deveria ser + 3?
								items[i].quality = items[i].quality + 1;
							}
						}
					}
				}
			}
            
			// se não for sulfuras 
			if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
				// número de dias para vender diminui a cada dia
				items[i].sellIn = items[i].sellIn - 1;
			}
			if (items[i].sellIn < 0) {
				if (!items[i].name.equals("Aged Brie")) {
					if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
						if (items[i].quality > 0) {
							if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
								items[i].quality = items[i].quality - 1;
							}
						}
					} else {
						items[i].quality = items[i].quality - items[i].quality;
					}
				} else {
					if (items[i].quality < 50) {
						items[i].quality = items[i].quality + 1;
					}
				}
			}
		}
	}
}
