package com.apple.shop.dto;

import com.apple.shop.entity.Item;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemDTO {

    private Long id;
    private Integer price;
    private String title;

    public static ItemDTO toItemDTO(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId());
        itemDTO.setPrice(item.getPrice());
        itemDTO.setTitle(item.getTitle());
        return itemDTO;
    }
}
