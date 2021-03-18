package com.example.services;

import org.springframework.stereotype.Service;

import com.example.modelo.aula.Aula;
import com.example.modelo.centro.Centro;
import com.example.repositories.AulaRepo;
import com.example.repositories.CentroRepo;

@Service

public class CentroService extends BaseService<Centro, String, CentroRepo> {

}
