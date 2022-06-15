package test;

import org.junit.jupiter.api.Test;

import main.GildedRose;
import main.Item;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

	@Test
	void foo() {
		Item[] items = new Item[] { new Item("foo", 0, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("fixme", app.items[0].name);
	}

}
