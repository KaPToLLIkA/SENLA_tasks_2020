package com.tasks.task_6;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Backpack {
    private double maxWeight;
    private double cost;
    private Cargo loadedItems;

    public Backpack(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Cargo getLoadedItems() {
        return loadedItems;
    }

    public double getCost() {
        return cost;
    }

    public void loadingItems(Cargo downloadableItems) {
        Map<Double, Cargo> allVariantsOfLoadedItems = new HashMap<>();

        recursiveLoadingItems(
                allVariantsOfLoadedItems,
                new Cargo(),
                downloadableItems,
                0,
                0,
                0
        );

        allVariantsOfLoadedItems = new TreeMap<>(allVariantsOfLoadedItems);

        loadedItems = ((TreeMap<Double, Cargo>)allVariantsOfLoadedItems).lastEntry().getValue();
        cost = ((TreeMap<Double, Cargo>)allVariantsOfLoadedItems).lastKey();
    }

    private void recursiveLoadingItems(
            Map<Double, Cargo> allVariantsOfLoadedItems,
            Cargo curVariantOfLoadedItems,
            Cargo downloadableItems,
            double curWeight,
            double curCost,
            int curIndex
    ) {
        for(int i = curIndex + 1; i < downloadableItems.getSize(); i++) {
            double newWeight = curWeight + downloadableItems.getItem(i).getWeight();
            double newCost = curCost + downloadableItems.getItem(i).getCost();

            if(newWeight <= maxWeight) {
                Cargo newCollection = new Cargo(curVariantOfLoadedItems);
                newCollection.addItem(downloadableItems.getItem(i));

                allVariantsOfLoadedItems.put(newCost, newCollection);

                if(i + 1 != downloadableItems.getSize()) {
                    recursiveLoadingItems(
                            allVariantsOfLoadedItems,
                            newCollection,
                            downloadableItems,
                            newWeight,
                            newCost,
                            i
                    );
                }
            }
        }
    }
}
