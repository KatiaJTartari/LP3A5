package test;

// Classe GildedRoseTest modificada 

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.GildedRose;
import main.Item;

public class GildedRoseTest {
	private Item[] arrayWith(Item item) {
		return new Item[] { item };
	}

	@Test // Teste que o valor do número de dias para vender é diminuído.
	public void testThatSellInValueIsDecreased() {
		Item whateverItem = new Item("whatever", 10, 0); // whatever(qualquer que seja).

		GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
		gildedRose.updateQuality();

		assertEquals(whateverItem.sellIn, 9);
	}

	@Test // Teste que o valor da qualidade é diminuído.
	public void testThatQualityValueIsDecreased() {
		Item whateverItem = new Item("whatever", 1, 10);

		GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
		gildedRose.updateQuality();

		assertEquals(whateverItem.quality, 9);
	}

	@Test // Teste que quando a data de venda tiver passado a qualidade do item diminui
			// duas vezes mais.
	public void testThatQualityDecreasesTwiceAsMuchWhenSellByIsPassed() {
		Item whateverItem = new Item("whatever", 0, 10);

		GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
		gildedRose.updateQuality();

		assertEquals(whateverItem.quality, 8);
	}

	@Test // Teste que a qualidade do item não pode ser negativa.
	public void testThatQualityIsNeverNegative() {
		Item whateverItem = new Item("whatever", 0, 0);

		GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
		gildedRose.updateQuality();

		assertEquals(whateverItem.quality, 0);
	}

	@Test // Teste que o Aged Brie aumenta a qualidade a medida que envelhece.
	public void testAgedBrieIncreasesQualityWithAge() {
		Item agedBrie = new Item("Aged Brie", 5, 1);

		GildedRose gildedRose = new GildedRose(arrayWith(agedBrie));
		gildedRose.updateQuality();

		assertEquals(agedBrie.quality, 2);
	}

	@Test // Teste que a qualidade do item não pode ser maior que 50.
	public void testQualityNeverIncreasesPastFifty() {
		Item agedBrie = new Item("Aged Brie", 5, 50);

		GildedRose gildedRose = new GildedRose(arrayWith(agedBrie));
		gildedRose.updateQuality();

		assertEquals(agedBrie.quality, 50);
	}

	@Test // Teste Sulfuras Nunca Muda (não precisa ter data de venda e sua qualidade não
			// diminuí).
	public void testSulfurasNeverChanges() {
		Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 25);

		GildedRose gildedRose = new GildedRose(arrayWith(sulfuras));
		gildedRose.updateQuality();

		assertEquals(sulfuras.quality, 25);
		assertEquals(sulfuras.sellIn, 0);
	}

	@Test // Teste Backstage passes aumenta a qualidade em 1 quando a data de venda for
			// maior que 10.
	public void testBackstagePassIncreasesQualityByOneIfSellByGreaterThenTen() {
		Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20);

		GildedRose gildedRose = new GildedRose(arrayWith(backstagePasses));
		gildedRose.updateQuality();

		assertEquals(backstagePasses.quality, 21);
	}

	@Test // Teste Backstage Pass aumenta a qualidade em 2 quando a data de venda for
			// menor ou igual que 10.
	public void testBackstagePassIncreasesQualityByTwoIfSellBySmallerThanTen() {
		Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20);

		GildedRose gildedRose = new GildedRose(arrayWith(backstagePasses));
		gildedRose.updateQuality();

		assertEquals(backstagePasses.quality, 22);
	}

	@Test // Teste Backstage Pass aumenta a qualidade em 3 quando a data de venda for
			// igual ou menor que 5.
	public void testBackstagePassIncreasesQualityByThreeIfSellBySmallerThanFive() {
		Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);

		GildedRose gildedRose = new GildedRose(arrayWith(backstagePasses));
		gildedRose.updateQuality();

		assertEquals(backstagePasses.quality, 23);
	}

	@Test // Teste Backstage Pass qualidade vai à 0 quando a data de venda tiver passado.
	public void testBackstagePassLosesValueAfterSellByPasses() {
		Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);

		GildedRose gildedRose = new GildedRose(arrayWith(backstagePasses));
		gildedRose.updateQuality();

		assertEquals(backstagePasses.quality, 0);
	}
}
