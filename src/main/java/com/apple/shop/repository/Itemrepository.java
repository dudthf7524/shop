package com.apple.shop.repository;

import com.apple.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Itemrepository extends JpaRepository<Item, Long> {

}
