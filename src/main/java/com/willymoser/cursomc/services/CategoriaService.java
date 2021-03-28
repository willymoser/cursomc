package com.willymoser.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.willymoser.cursomc.domain.Categoria;
import com.willymoser.cursomc.repositories.CategoriaRepository;
import com.willymoser.cursomc.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> categoria = repo.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo:" + Categoria.class.getName()));
	}

}