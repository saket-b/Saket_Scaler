package MileStone3;

import MileStone1.Item;

public class Test {


    static void main(String[] args) {
        RecentlyViewItems list1 = new RecentlyViewItems();

        list1.addRecentlyViewedItem( new Item("1", "saket", 100, 3));
        list1.addRecentlyViewedItem( new Item("2", "Bharti", 1000, 4));

        list1.addRecentlyViewedItem( new Item("3", "Aman", 40000, 5));

        list1.addRecentlyViewedItem( new Item("1", "Ram", 5000, 6));

        for( Item item : list1.getRecentlyViewedItems())
        {
            System.out.println(item.getId()+ " " + item.getName());
        }

    }

}
