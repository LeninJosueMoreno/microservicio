package com.nttData.cuenta_movimientos_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cuenta {
    @Id
    private Long numeroCuenta;
    private String tipoCuenta;
    private double saldoInicial;
    private Boolean estado;
}

