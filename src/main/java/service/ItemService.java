package service;

import DAO.ItemDAO;
import entity.Item;

import java.util.List;

public class ItemService {
    ItemDAO ITEM_DAO = new ItemDAO();

    public Item save(Item item) {
        return ITEM_DAO.save(item);
    }

    public Item update(Item item) {
        return ITEM_DAO.update(item);
    }

    public void delete(Item item) {
        ITEM_DAO.delete(item);
    }

    public List<Item> findById(long id) {
        return ITEM_DAO.findById(id);
    }
}
