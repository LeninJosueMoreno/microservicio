package com.nttData.cliente_persona_service.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Cliente extends Persona{
    private Long clienteId;
    private String contrasena;
    private Boolean estado;
}
