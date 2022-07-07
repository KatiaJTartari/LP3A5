package test;

// Classe GildedRoseTestOriginal original sem modifica��o.

import org.junit.jupiter.api.Test;

import main.GildedRoseOriginal;
import main.Item;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTestOriginal {

	@Test
	void foo() {
		Item[] items = new Item[] { new Item("foo", 0, 0) };
		GildedRoseOriginal app = new GildedRoseOriginal(items);
		app.updateQuality();
		assertEquals("fixme", app.items[0].name);
	}

}
