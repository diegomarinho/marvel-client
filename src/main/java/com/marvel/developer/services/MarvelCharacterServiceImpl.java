package com.marvel.developer.services;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marvel.developer.models.Character;
import com.marvel.developer.models.CharacterSummary;
import com.marvel.developer.models.Comic;
import com.marvel.developer.repositories.MarvelCharacterRepository;

/**
 * @author diego.almeida
 *
 */
@Service
public class MarvelCharacterServiceImpl implements MarvelCharacterService {

    private static final String LOGGER_MSG_CANT_RECOVER_CHARACTER_FROM_URI = "Can't recover character from URI";

	private static final Logger logger = LoggerFactory.getLogger(MarvelCharacterServiceImpl.class);

    @Autowired
    private MarvelComicService comicService;

    @Autowired
    private MarvelCharacterRepository characterRepository;

    @Override
    public List<Character> findAll() {
        return characterRepository.findAll();
    }

    @Override
    public List<Character> findAllByComic(int pId) {
        List<Character> listCharacters = new ArrayList<>();
        Comic comic = comicService.findOneById(pId);

        for (CharacterSummary characterSummary : comic.characters.items) {
            URI resourceURI;
            try {
                resourceURI = new URI(characterSummary.resourceURI);
                List<Character> characters = characterRepository.findAll(resourceURI);
                listCharacters.addAll(characters);
            } catch (URISyntaxException e) {
                logger.error(LOGGER_MSG_CANT_RECOVER_CHARACTER_FROM_URI, e);
            }
        }

        return listCharacters;
    }

    @Override
    public Character findOneById(int pId) {
        return characterRepository.findOneById(pId);
    }

    @Override
    public boolean remove(int pId) {
        return characterRepository.remove(pId);
    }
}
