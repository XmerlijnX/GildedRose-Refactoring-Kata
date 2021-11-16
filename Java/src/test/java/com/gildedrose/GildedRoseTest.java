package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void qualityIsMinimumZero() { // SUCCESFUL
        Item[] items = new Item[] { new Item("bar", 1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void normalItemDecreasesInQualityBy1EveryDay() { // SUCCESFUL
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10 - 1, app.items[0].sellIn);
        assertEquals(20 - 1, app.items[0].quality);
    }


    @Test
    void qualityAfterSellByDateDegradesDouble() { // SUCCESFUL
        Item[] items = new Item[] { new Item("abc", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10 - 2, app.items[0].quality);
    }

    @Test
    void agedBrieIncreasesInQuality() { // SUCCESFUL
        Item[] items = new Item[] { new Item("Aged Brie", 2, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10 + 1, app.items[0].quality);
    }

    @Test
    void qualityIsMaximum50() { // SUCCESFUL
        Item[] items = new Item[] { new Item("50 Quality Item", 2, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void SulfurasNeverSellsNorDecreasesInQuality() { // SUCCESFUL
        // Note: also corrects wrong input values for Sulfuras
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 4321, 1234) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void backstagePassQualityIncreasesBy2WhenSellByDateIsBetween6and10() { // SUCCESFUL
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 8, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10 + 2, app.items[0].quality);
    }

    @Test
    void backstagePassQualityIncreasesBy3WhenSellByDateIsBetween0and5() { // SUCCESFUL
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10 + 3, app.items[0].quality);
    }

    @Test
    void backstagePassQualityDropsToZeroAfterTheConcert() { // SUCCESFUL
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void conjuredItemQualityDecreasesTwiceAsFast() { // SUCCESFUL
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10 - 2, app.items[0].quality);
    }
}
