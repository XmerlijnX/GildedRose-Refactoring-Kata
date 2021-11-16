package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].quality < 50
                    && !items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros") && items[i].name.contains("Conjured")) {
                        items[i].sellIn = items[i].sellIn - 1;
                        items[i].quality = items[i].quality - 1;
                    }
                    // "Conjured" items degrade in Quality twice as fast as normal items:
                    if (items[i].name.contains("Conjured")) {
                        items[i].quality = items[i].quality - 2;
                    }
                }
                if (items[i].sellIn < 1) {
                    items[i].quality = 0;
                }
            } else {
                if (items[i].name.equals("Aged Brie") && items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;
                }
                if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert") && items[i].quality < 50) {
                    if (items[i].sellIn < 11) {
                        if (items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1; // +2 according to requirements
                        }
                    }

                    if (items[i].sellIn < 6) {
                        if (items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1; // +3 according to requirements
                        }
                    }
                }
            }
        }
    }
}
