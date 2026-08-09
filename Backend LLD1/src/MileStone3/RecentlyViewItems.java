package MileStone3;

import MileStone1.Item;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RecentlyViewItems {

    LinkedList<Item> items;

    private Integer MAX_SIZE = 3;

    public  RecentlyViewItems(){
        items = new LinkedList<>();
    }

    public  void addRecentlyViewedItem(Item item)
    {
        items.remove(item);

        items.add(item);
        if( items.size() > MAX_SIZE)
        {
            items.removeLast();
        }


    }

    public List<Item> getRecentlyViewedItems(){
        return new ArrayList<>(items);
    }
}
