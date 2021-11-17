package com.gildedrose;

class GildedRose {

    // these constants make it easy to change the logic, if necessary:
    final int MINIMUM_NORMAL_QUALITY = 0;
    final int MAXIMUM_NORMAL_QUALITY = 50;
    final int QUALITY_STEP = 1;
    final int QUALITY_SULFURAS = 80;
    final int SELL_IN_NEVER = -1;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            // Only "Sulfuras", being a legendary item, never has to be sold or decreases in Quality of 80:
            if (items[i].name.contains("Sulfuras")) {
                items[i].sellIn = SELL_IN_NEVER;
                items[i].quality = QUALITY_SULFURAS;
            }
            // The Quality of any other item is never more than 50:
            if (items[i].quality < MAXIMUM_NORMAL_QUALITY
                    && !items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                // The Quality of an item is never negative:
                if (items[i].quality > MINIMUM_NORMAL_QUALITY) {
                    items[i].sellIn = items[i].sellIn - 1;
                    if (items[i].name.contains("Conjured")) {
                        // "Conjured" items degrade in Quality twice as fast as normal items:
                        items[i].quality = items[i].quality - 2 * QUALITY_STEP;
                    } else {
                        // Once the sell by date has passed, Quality degrades twice as fast:
                        if (items[i].sellIn < 1) {
                            items[i].quality = items[i].quality - 2 * QUALITY_STEP;
                        } else {
                            items[i].quality = items[i].quality - QUALITY_STEP;
                        }
                    }
                }
            } else {
                // "Aged Brie" actually increases in Quality the older it gets:
                if (items[i].name.equals("Aged Brie") && items[i].quality < MAXIMUM_NORMAL_QUALITY) {
                    items[i].sellIn = items[i].sellIn - 1;
                    items[i].quality = items[i].quality + QUALITY_STEP;
                }
                // "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
                if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")
                    && items[i].quality < MAXIMUM_NORMAL_QUALITY) {
                    items[i].sellIn = items[i].sellIn - 1;
                    if (items[i].sellIn > 10) {
                        items[i].quality = items[i].quality + QUALITY_STEP;
                    }
                    // ... Quality increases by 2 when there are 10 days or less:
                    if (items[i].sellIn < 11 && items[i].sellIn > 5) {
                        items[i].quality = items[i].quality + 2 * QUALITY_STEP;
                    }
                    // ... Quality increases by 3 when there are 5 days or less:
                    if (items[i].sellIn < 6 && items[i].sellIn > -1) {
                        items[i].quality = items[i].quality + 3 * QUALITY_STEP;
                    }
                    // ... Quality drops to 0 after the concert:
                    if (items[i].sellIn < 0) {
                        items[i].quality = MINIMUM_NORMAL_QUALITY;
                    }
                }
            }
        }
    }
}
