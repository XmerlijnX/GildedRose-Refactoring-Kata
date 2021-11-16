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
    void agedBrie() { // SUCCESFUL
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void conjuredItem() { // FAILS
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
    }


}
