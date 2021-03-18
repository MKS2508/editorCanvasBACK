package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.modelo.tipoaula.TipoAula;

public interface TipoAulaRepo extends JpaRepository<TipoAula, String> {

}
