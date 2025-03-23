package com.project.todo_be.controller;

import com.project.todo_be.entity.Item;
import com.project.todo_be.service.ItemService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ItemController {
    private static final Logger log = LoggerFactory.getLogger(ItemController.class);
    private final ItemService itemService;

    @PostMapping("/item")
    public Item postItem(@RequestBody Item item) {
        log.info("item ===> " + item);
        return itemService.postItem(item);
    }

    @GetMapping("/items")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {
        try {
            itemService.deleteitem(id);
            return new ResponseEntity<>("Item with id + " + id + " deleted", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/item/{id}")
    public ResponseEntity<?> setToDone(@PathVariable Long id) {
        Item updateditem = itemService.setToDone(id);
        log.info("Updated item after service call " + updateditem);
        if(updateditem == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(updateditem);
    }

}
