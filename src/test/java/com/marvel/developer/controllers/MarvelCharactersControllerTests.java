package com.marvel.developer.controllers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.marvel.developer.models.Character;
import com.marvel.developer.services.MarvelCharacterService;

/**
 * @author diego.almeida
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MarvelCharactersControllerTests {

    public static final int MARVEL_CHARACTER_ID_IRON_PATRIOT = 1009538;
    public static final int MARVEL_COMIC_ID_AVENGERS_IRON_MAN_II = 29795;

    @Autowired
    private MarvelCharacterService characterService;

    @Test
    public void testCharacterFindAll() {
        List<Character> listCharacters = characterService.findAll();
        assertFalse(listCharacters.isEmpty());
    }

    @Test
    public void testCharacterFindOneById() {
        Character character = characterService.findOneById(MARVEL_CHARACTER_ID_IRON_PATRIOT);
        assertEquals(character.id, MARVEL_CHARACTER_ID_IRON_PATRIOT);
    }

    @Test
    public void testCharacterFindAllByComic() {
        List<Character> listCharacters = characterService.findAllByComic(MARVEL_COMIC_ID_AVENGERS_IRON_MAN_II);
        assertFalse(listCharacters.isEmpty());
    }

    @Test
    public void testCharacterRemoveById() {
        characterService.findOneById(MARVEL_CHARACTER_ID_IRON_PATRIOT);
        boolean isCharacterRemoved = characterService.remove(MARVEL_CHARACTER_ID_IRON_PATRIOT);
        assertTrue(isCharacterRemoved);
    }
}
