package com.apple.shop.entity;

import com.apple.shop.dto.ItemDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String title;
    @Column
    private Integer price;

    public static Item toItemEntity(ItemDTO itemDTO) {
        Item item = new Item();
        item.setTitle(itemDTO.getTitle());
        item.setPrice(itemDTO.getPrice());
        return item;
    }
}
