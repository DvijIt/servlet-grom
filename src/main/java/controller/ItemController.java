package controller;

import entity.Item;
import service.ItemService;

import java.util.List;

public class ItemController {
    ItemService ITEM_SERVICE = new ItemService();

    public Item save(Item item) {
        return ITEM_SERVICE.save(item);
    }

    public Item update(Item item) {
        return ITEM_SERVICE.update(item);
    }

    public void delete(Item item) {
        ITEM_SERVICE.delete(item);
    }

    public List<Item> findById(long id) {
        return ITEM_SERVICE.findById(id);
    }
}
