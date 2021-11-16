package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() { // SUCCESFUL
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void qualityIsMinimumZero() { // SUCCESFUL
        Item[] items = new Item[] { new Item("bar", 1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void qualityAfterSellByDateDegradesDouble() { // SUCCESFUL
        Item[] items = new Item[] { new Item("abc", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10 - 2, app.items[0].quality);
    }
    @Test
    void agedBrie() { // SUCCESFUL
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void conjuredItem() { // SUCCESFUL
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
    }


}
