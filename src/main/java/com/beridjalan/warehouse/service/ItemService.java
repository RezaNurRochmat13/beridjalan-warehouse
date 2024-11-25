package com.beridjalan.warehouse.service;

import com.beridjalan.warehouse.entity.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<Item> findAllItems();
    Item findItemById(Long id);
    Item createOneItem(Item item);
    Item updateOneItem(Long id, Item item);
    void deleteOneItem(Long id);
}
