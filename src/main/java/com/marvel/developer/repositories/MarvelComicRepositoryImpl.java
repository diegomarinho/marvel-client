package com.marvel.developer.repositories;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Iterables;
import com.marvel.developer.models.Comic;
import com.marvel.developer.models.ComicDataWrapper;
import com.marvel.developer.services.MarvelAPIService;

import jersey.repackaged.com.google.common.collect.Lists;

/**
 * @author diego.almeida
 *
 */
@Component
public class MarvelComicRepositoryImpl implements MarvelComicRepository {

    @Autowired
    private MarvelAPIService marvelsAPIService;

    @Override
    @Cacheable("cacheComics")
    public Comic findOneById(int pId) {
        URI targetURI = marvelsAPIService.buildFromMarvelPublicURI(String.format("/comics/%s", pId));
        return findOneByURI(targetURI);
    }

    @Override
    @Cacheable("cacheComics")
    public List<Comic> findAll() {
        URI targetURI = marvelsAPIService.buildFromMarvelPublicURI("/comics");
        return findAll(targetURI);
    }

    @Override
    @Cacheable("cacheComics")
    public Comic findOneByURI(URI resourceURI) {
        List<Comic> listComics = findAll(resourceURI);
        return Iterables.getFirst(listComics, null);
    }

    @Override
    @Cacheable("cacheComics")
    public List<Comic> findAll(URI resourceURI) {
        RestTemplate restTemplate = new RestTemplate();
        URI authTargetURI = marvelsAPIService.buildAuthenticatedURI(resourceURI);
        ComicDataWrapper ComicsDataWrapper = restTemplate.getForObject(authTargetURI, ComicDataWrapper.class);
        List<Comic> listComics = (List<Comic>) (ComicsDataWrapper.data.results.isEmpty() ? Lists.newArrayList()
                        : ComicsDataWrapper.data.results);

        return listComics;
    }

    @Override
    @CacheEvict("cacheComics")
    public boolean remove(int pId) {
        return true;
    }
}
