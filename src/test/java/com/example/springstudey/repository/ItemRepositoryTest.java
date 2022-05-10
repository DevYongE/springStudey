package com.example.springstudey.repository;

import com.example.springstudey.SpringStudeyApplicationTests;
import com.example.springstudey.model.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Assertions;

import javax.persistence.Id;
import java.util.Optional;

public class ItemRepositoryTest extends SpringStudeyApplicationTests {
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){
        Item item= new Item();
        item.setName("노트북");
        item.setPrice(100000);
        item.setContents("삼성 놋북");

        Item newItem  = itemRepository.save(item);
        Assertions.assertNotNull(newItem);
    }
    @Test
    public void read(){
        Long id = 1L;
        Optional<Item> item = itemRepository.findById(id);

        Assertions.assertTrue(item.isPresent());
    }
}
