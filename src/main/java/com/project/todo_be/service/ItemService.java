package com.project.todo_be.service;

import com.project.todo_be.entity.Item;
import com.project.todo_be.repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void deleteitem(Long id) {
        if(itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Employee with ID " + id + " does not exist");
        }
    }

    public Item setToDone(Long id) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if(optionalItem.isPresent()) {
//            Item existingItem = optionalItem.get();
//            existingItem.setIsCompleted(true);
//            return  itemRepository.save(existingItem);
             optionalItem.get().setIsCompleted(true);
             return itemRepository.save(optionalItem.get());
        }
        return null;
    }
}
