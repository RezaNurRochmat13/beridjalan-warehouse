package com.beridjalan.warehouse.presenter;

import com.beridjalan.warehouse.entity.Item;
import com.beridjalan.warehouse.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ItemPresenter {

    @Autowired
    private ItemServiceImpl itemService;

    @GetMapping
    public String getAllItems(Model model) {
        model.addAttribute("items", itemService.findAllItems());
        return "index";
    }

    @GetMapping("items/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Item getItemById(@PathVariable Long id) {
        return itemService.findItemById(id);
    }

    @GetMapping("/add")
    public String addItemForm(Model model) {
        model.addAttribute("item", new Item());
        return "add-item";
    }

    @PostMapping("/save")
    public String createOneItem(@ModelAttribute Item payload) {
        itemService.createOneItem(payload);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editItemForm(@PathVariable Long id, Model model) {
        model.addAttribute("item", itemService.findItemById(id));
        return "update-item"; // Renders update-user.html
    }

    @PostMapping("/update/{id}")
    public String updateOneItem(@PathVariable Long id, @ModelAttribute Item payload) {
        itemService.updateOneItem(id, payload);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteOneItem(@PathVariable Long id) {
        itemService.deleteOneItem(id);
        return "redirect:/";
    }
}
