package com.marvel.developer.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.marvel.developer.models.Comic;
import com.marvel.developer.services.MarvelComicService;

/**
 * @author diego.almeida
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MarvelComicsControllerTests {

    public static final int MARVEL_COMIC_ID_AVENGERS_IRON_MAN_II = 29795;

    @Autowired
    private MarvelComicService comicService;

    @Test
    public void testComicFindAll() {
        List<Comic> listComics = comicService.findAll();
        assertFalse(listComics.isEmpty());
    }

    @Test
    public void testComicFindOneById() {
        Comic comic = comicService.findOneById(MARVEL_COMIC_ID_AVENGERS_IRON_MAN_II);
        assertEquals(comic.id, MARVEL_COMIC_ID_AVENGERS_IRON_MAN_II);
    }

    @Test
    public void testComicRemoveById() {
        comicService.findOneById(MARVEL_COMIC_ID_AVENGERS_IRON_MAN_II);
        boolean isComicRemoved = comicService.remove(MARVEL_COMIC_ID_AVENGERS_IRON_MAN_II);
        assertTrue(isComicRemoved);
    }
}
