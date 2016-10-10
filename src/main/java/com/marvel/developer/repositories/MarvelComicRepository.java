package com.marvel.developer.repositories;

import java.net.URI;
import java.util.List;

import com.marvel.developer.models.Comic;

/**
 * @author diego.almeida
 *
 */
public interface MarvelComicRepository {
	
	List<Comic> findAll();

	Comic findOneById(int pId);

	Comic findOneByURI(URI resourceURI);

	List<Comic> findAll(URI resourceURI);

	boolean remove(int pId);
}
