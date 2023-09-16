package com.example.springjspdemo.controller;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, String> {

}
