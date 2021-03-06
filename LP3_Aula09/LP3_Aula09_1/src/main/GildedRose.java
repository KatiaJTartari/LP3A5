package main;

// Classe GildedRose modificada / refactoring

public class GildedRose {

	public Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			updateQuality(items[i]);
			updateSellIn(items[i]);
		}
	}

	private void updateQuality(Item item) {
		if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
			if (item.quality > 0) {
				if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
					item.quality = item.quality - 1;
				}
			}
		} else {
			if (item.quality < 50) {
				item.quality = item.quality + 1;

				if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
					if (item.sellIn < 11) {
						if (item.quality < 50) {
							item.quality = item.quality + 1;
						}
					}

					if (item.sellIn < 6) {
						if (item.quality < 50) {
							item.quality = item.quality + 1;
						}
					}
				}
			}
		}
	}

	private void updateSellIn(Item item) {
		if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
			item.sellIn = item.sellIn - 1;
		}

		handleIfExpired(item);
	}

	private void handleIfExpired(Item item) {
		if (item.sellIn < 0) {
			handleExpired(item);
		}
	}

	private void handleExpired(Item item) {
		if (!item.name.equals("Aged Brie")) {
			if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
				if (item.quality > 0) {
					if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
						item.quality = item.quality - 1;
					}
				}
			} else {
				item.quality = item.quality - item.quality;
			}
		} else {
			if (item.quality < 50) {
				item.quality = item.quality + 1;
			}
		}
	}

}
