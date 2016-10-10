package com.marvel.developer.repositories;

import java.net.URI;
import java.util.List;

import com.marvel.developer.models.Character;

/**
 * @author diego.almeida
 *
 */
public interface MarvelCharacterRepository {

	List<Character> findAll();

	Character findOneById(int pId);

	Character findOneByURI(URI resourceURI);

	List<Character> findAll(URI resourceURI);

	boolean remove(int pId);
}
