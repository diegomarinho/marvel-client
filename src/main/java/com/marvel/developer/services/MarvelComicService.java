package com.marvel.developer.services;

import java.util.List;

import com.marvel.developer.models.Comic;

/**
 * @author diego.almeida
 *
 */
public interface MarvelComicService {
	
	List<Comic> findAll();

	Comic findOneById(int pId);

	boolean remove(int pId);
}
