package com.beridjalan.warehouse.service;

import com.beridjalan.warehouse.entity.Item;
import com.beridjalan.warehouse.exception.ResourceNotFound;
import com.beridjalan.warehouse.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> findAllActiveItems() {
        return itemRepository.findActiveItems();
    }

    @Override
    public Item findItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Item not found with id :" + id));
    }

    @Override
    public Item createOneItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item updateOneItem(Long id, Item payload) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Item not found with id :" + id));

        item.setName(payload.getName());
        item.setDescription(payload.getDescription());
        item.setQuantity(payload.getQuantity());

        itemRepository.save(item);

        return item;
    }

    @Override
    public void deleteOneItem(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Item not found with id :" + id));

        item.setDeletedAt(LocalDateTime.now());
        itemRepository.save(item);
    }
}
