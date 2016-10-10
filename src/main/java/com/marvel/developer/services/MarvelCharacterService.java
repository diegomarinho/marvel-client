package com.marvel.developer.services;

import java.util.List;

import com.marvel.developer.models.Character;

/**
 * @author diego.almeida
 *
 */
public interface MarvelCharacterService {
	
	List<Character> findAll();

	Character findOneById(int pId);

	List<Character> findAllByComic(int pId);

	boolean remove(int pId);
}
