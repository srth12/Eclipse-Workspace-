package com.hackerrank.test.partsavatar;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryAllocation {

    public static void main(String[] args) {
        InventoryAllocation allocation = new InventoryAllocation();
        Map<String, Integer> pdtInChart = new ConcurrentHashMap<>();
        pdtInChart.put("car", 2);
        pdtInChart.put("jeep", 2);
        allocation.getInventoryAllocation(pdtInChart, new Address());
    }
    public Map<Warehouse, Map<String, Integer>> getInventoryAllocation(Map<String, Integer> shoppingCart, Address addressOfCustomer) {

        List<Warehouse> nearestWarehouses = getNearestWarehouses(addressOfCustomer);
        Map<Warehouse, Map<String, Integer>> allocatedWarehouseInventoryMap = new ConcurrentHashMap<>(); //used concurrentHashmap bcoz in future we can make the stream parallel in future

        /** Considered shoppingCart first even though we need map with key of 'warehouse',
         bcoz this is more efficient, as shopping cart size will be < warehouse list */
        shoppingCart.entrySet().stream().forEach(requiredInventoryEntry -> {
            String productId = requiredInventoryEntry.getKey();
            int requiredQuantity = requiredInventoryEntry.getValue();
            Map<Warehouse, Integer> availableInventory = getInventory(productId);

            for (int i = 0; i < nearestWarehouses.size(); i++) {
                if (!availableInventory.containsKey(nearestWarehouses.get(i)))
                    continue;
                int availableQuantity = availableInventory.get(nearestWarehouses.get(i));
                if (availableQuantity <= 0)
                    continue;

                if (requiredQuantity <= availableQuantity) {
                    addNewProductToWarehouseForOrdering(nearestWarehouses.get(i), allocatedWarehouseInventoryMap, productId, requiredQuantity);
                    break;
                } else {
                    addNewProductToWarehouseForOrdering(nearestWarehouses.get(i), allocatedWarehouseInventoryMap, productId, availableQuantity);
                    requiredQuantity -= availableQuantity;
                }
            }
        });
        return allocatedWarehouseInventoryMap;
    }

    private void addNewProductToWarehouseForOrdering(Warehouse warehouse, Map<Warehouse, Map<String, Integer>> warehouseMapMap, String productId, int orderQuantity) {
        if (warehouseMapMap.containsKey(warehouse)) {// if this warehouse has already existing order for other pdt
            Map<String, Integer> productsQuantityMap = warehouseMapMap.get(warehouse);
            productsQuantityMap.put(productId, orderQuantity);
        } else {
            Map<String, Integer> productsQuantityMap = new ConcurrentHashMap<>();
            productsQuantityMap.put(productId, orderQuantity);
            warehouseMapMap.put(warehouse, productsQuantityMap);
        }
    }
    int count = 0;
    public Map<Warehouse, Integer> getInventory(String product) {
        Map<Warehouse, Integer> temp = new ConcurrentHashMap<>();
        if (product.equalsIgnoreCase("car"))
            temp.put(Warehouse.EDMONTON, 2);
        else if (product.equalsIgnoreCase("bike"))
            temp.put(Warehouse.TORONTO, 2);
        return temp;
    }

    public List<Warehouse> getNearestWarehouses(Address addressOfCustomer) {
        return Arrays.asList(Warehouse.values());
    }

}

class Address {

}
