package MileStone2;

import MileStone1.Electronics;
import MileStone1.Item;
import MileStone1.cloth;

public class client {

    static void main(String[] args) {

        Inventory<Item> list = new Inventory<>();
        list.addItem(new Item("1", "saket", 9000, 2));
        list.addItem(new cloth("2", "T-Shirt", 10000, 7, "M"));
        list.addItem(new Electronics("3", "Television", 15000, 10, 10));

        Item item = list.getItem("1");
        System.out.println(item.getId() + " "+ item.getName() + " " + item.getPrice());

    }
}
