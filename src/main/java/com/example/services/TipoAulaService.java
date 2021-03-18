package com.example.services;

import org.springframework.stereotype.Service;

import com.example.modelo.aula.Aula;
import com.example.modelo.tipoaula.TipoAula;
import com.example.repositories.AulaRepo;
import com.example.repositories.TipoAulaRepo;

@Service
public class TipoAulaService extends BaseService<TipoAula, String, TipoAulaRepo> {

}
