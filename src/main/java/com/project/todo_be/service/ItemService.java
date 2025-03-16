package com.project.todo_be.service;

import com.project.todo_be.entity.Item;
import com.project.todo_be.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public Item postItem (Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return  itemRepository.findAll();
    }

}
