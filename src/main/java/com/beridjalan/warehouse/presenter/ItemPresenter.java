package com.beridjalan.warehouse.presenter;

import com.beridjalan.warehouse.entity.Item;
import com.beridjalan.warehouse.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class ItemPresenter {

    @Autowired
    private ItemServiceImpl itemService;

    @GetMapping("items")
    @ResponseStatus(HttpStatus.OK)
    public List<Item> getAllItems() {
        return itemService.findAllItems();
    }

    @GetMapping("items/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Item> getItemById(@PathVariable Long id) {
        return itemService.findItemById(id);
    }

    @PostMapping("items")
    @ResponseStatus(HttpStatus.CREATED)
    public Item createOneItem(@RequestBody Item payload) {
        return itemService.createOneItem(payload);
    }

    @PutMapping("items/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Item updateOneItem(@PathVariable Long id, @RequestBody Item payload) {
        return itemService.updateOneItem(id, payload);
    }

    @DeleteMapping("items/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOneItem(@PathVariable Long id) {
        itemService.deleteOneItem(id);
    }
}
