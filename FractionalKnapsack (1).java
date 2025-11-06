import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value, weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}
public class FractionalKnapsack {

    static double getMaxValue(Item[] items, int capacity) {

        // Sort items by value-to-weight ratio in descending order
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                double r1 = (double) o1.value / o1.weight;
                double r2 = (double) o2.value / o2.weight;
                return Double.compare(r2, r1);
            }
        });
        double totalvalue = 0.0;
        for (Item item : items) {
            if (capacity >= item.weight) {
                // Take the whole item
                capacity -= item.weight;
                totalvalue += item.value;
            } else {
                // Take the fractional part of the item
                totalvalue += item.value * ((double) capacity / item.weight);
                break;
            }
        }
        return totalvalue;
    }    public static void main(String[] args) {

        Item[] items = {
                new Item(10, 2),
                new Item(5, 3),
                new Item(15, 5),
                new Item(7, 7),
                new Item(6, 1),
                new Item(18, 4),
                new Item(3, 1) };
        int capacity = 15;
        double maxValue = getMaxValue(items, capacity);
        System.out.println("Maximum value we can obtain = " + maxValue);
    }
}
