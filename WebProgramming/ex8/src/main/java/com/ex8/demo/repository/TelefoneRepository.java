package com.ex8.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex8.demo.model.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> { }
