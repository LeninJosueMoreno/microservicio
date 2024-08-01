package com.nttData.cliente_persona_service.repository;

import com.nttData.cliente_persona_service.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
