package MileStone2;

import MileStone1.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Inventory <T extends Item> {

    private HashMap<String, T> myhamp;

    public Inventory(){
        myhamp = new HashMap<>();
    }

    public void addItem(T item){

      //  if( myhamp.containsKey(item.getId()))
        myhamp.put(item.getId(), item);
    }

    public void removeItem(T item)
    {
        myhamp.remove(item.getId());
    }

    public T getItem(String id)
    {
        return myhamp.get(id);
    }

    public List<T> getAllItems(){
        return new ArrayList<>(myhamp.values());
    }



}
