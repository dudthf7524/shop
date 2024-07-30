package com.apple.shop.controller;

import com.apple.shop.dto.ItemDTO;
import com.apple.shop.entity.Item;
import com.apple.shop.repository.Itemrepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/shop")
public class ShopController {

    private final Itemrepository itemrepository;

    @GetMapping("/list")
    public String list(Model model){
        List<Item> itemList = itemrepository.findAll();
        List<ItemDTO> itemDTOList = new ArrayList<>();
        for(Item item : itemList){
            ItemDTO itemDTO = ItemDTO.toItemDTO(item);
            itemDTOList.add(itemDTO);
        }

        System.out.println(itemDTOList.size());
        model.addAttribute("list", itemDTOList);
        model.addAttribute("name", "최영솔");
        return "list.html";
    }

    @GetMapping("/write")
    public String write(){

        return "write";
    }
    @GetMapping("/nav")
    public String nav(){

        return "nav";
    }

    @PostMapping("/write")
    public String writeForm(@ModelAttribute Item item){

        itemrepository.save(item);
        System.out.println("itemDTO : " + item );
        return "redirect:/shop/list";
    }

}
