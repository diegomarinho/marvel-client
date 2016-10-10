package com.marvel.developer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marvel.developer.models.Comic;
import com.marvel.developer.services.MarvelComicServiceImpl;

/**
 * @author diego.almeida
 *
 */
@RestController
@RequestMapping("/comics")
public class MarvelComicsController {

    @Autowired
    private MarvelComicServiceImpl comicService;

    @RequestMapping("")
    public List<Comic> findAll() {
        return comicService.findAll();
    }

    @RequestMapping("/{pId}")
    public Comic findOneById(@PathVariable int pId) {
        return comicService.findOneById(pId);
    }

    @RequestMapping(value = "/remove/{pId}", method = RequestMethod.DELETE)
    public boolean removeById(@PathVariable int pId) {
        return comicService.remove(pId);
    }
}
