package com.apple.shop.controller;

import com.apple.shop.dto.ItemDTO;
import com.apple.shop.entity.Item;
import com.apple.shop.repository.Itemrepository;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/shop")
public class ItemController {

    private final Itemrepository itemrepository;

    @GetMapping("/list")
    public String list(Model model){
        List<Item> itemList = itemrepository.findAll();
        List<ItemDTO> itemDTOList = new ArrayList<>();
        for(Item item : itemList){
            ItemDTO itemDTO = ItemDTO.toItemDTO(item);
            itemDTOList.add(itemDTO);
        }


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
        return "redirect:/shop/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable(name = "id") Long id, Model model){
        Optional<Item> result = itemrepository.findById(id);
        if(result.isPresent()){
            System.out.println(result.get());
            model.addAttribute("item", result.get());

        }else{
            return "redirect/list.html";
        }


        return "detail";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") Long id, Model model){
        Optional<Item> result = itemrepository.findById(id);
        if(result.isPresent()){
            System.out.println(result.get());
            model.addAttribute("item", result.get());

        }else{
            return "redirect/list.html";
        }
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Item item){

        itemrepository.save(item);

        return "redirect:/shop/list";
    }


    @PostMapping("/test1")
    public String test1(@RequestBody Map<String, Object> body){
        System.out.println(body.get("name"));
        return "redirect:/list";

    }

    @DeleteMapping("/item")
    public ResponseEntity<String> deleteItem(@RequestParam(name="id") Long id){
        System.out.println(id);
        itemrepository.deleteById(id);
        return ResponseEntity.status(200).body("삭제완료");

    }
}
