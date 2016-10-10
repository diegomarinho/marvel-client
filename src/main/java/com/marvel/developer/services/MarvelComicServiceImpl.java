package com.marvel.developer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marvel.developer.models.Comic;
import com.marvel.developer.repositories.MarvelComicRepository;

/**
 * @author diego.almeida
 *
 */
@Service
public class MarvelComicServiceImpl implements MarvelComicService {

    @Autowired
    private MarvelComicRepository comicRepository;

    @Override
    public List<Comic> findAll() {
        return comicRepository.findAll();
    }

    @Override
    public Comic findOneById(int pId) {
        return comicRepository.findOneById(pId);
    }

    public boolean remove(int pId) {
        return comicRepository.remove(pId);
    }
}
