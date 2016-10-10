package com.marvel.developer.repositories;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Iterables;
import com.marvel.developer.models.Character;
import com.marvel.developer.models.CharacterDataWrapper;
import com.marvel.developer.services.MarvelAPIService;

import jersey.repackaged.com.google.common.collect.Lists;

/**
 * @author diego.almeida
 *
 */
@Component
public class MarvelCharacterRepositoryImpl implements MarvelCharacterRepository {

    @Autowired
    private MarvelAPIService marvelsAPIService;

    @Override
    @Cacheable("cacheCharacters")
    public Character findOneById(int pId) {
        URI targetURI = marvelsAPIService.buildFromMarvelPublicURI(String.format("/characters/%s", pId));
        return findOneByURI(targetURI);
    }

    @Override
    @Cacheable("cacheCharacters")
    public List<Character> findAll() {
        URI targetURI = marvelsAPIService.buildFromMarvelPublicURI("/characters");
        return findAll(targetURI);
    }

    @Override
    @Cacheable("cacheCharacters")
    public Character findOneByURI(URI resourceURI) {
        List<Character> listCharacters = findAll(resourceURI);
        return Iterables.getFirst(listCharacters, null);
    }

    @Override
    @Cacheable("cacheCharacters")
    public List<Character> findAll(URI resourceURI) {
        RestTemplate restTemplate = new RestTemplate();
        URI authTargetURI = marvelsAPIService.buildAuthenticatedURI(resourceURI);
        CharacterDataWrapper charactersDataWrapper = restTemplate.getForObject(authTargetURI, CharacterDataWrapper.class);
        List<Character> listCharacters = (List<Character>) (charactersDataWrapper.data.results.isEmpty() ? Lists.newArrayList() : charactersDataWrapper.data.results);

        return listCharacters;
    }

    @Override
    @CacheEvict("cacheCharacters")
    public boolean remove(int pId) {
        return true;
    }
}
