package com.nttData.cuenta_movimientos_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Movimiento {
    @Id
    private Long id;
    private String fecha;
    private String tipoMovimiento;
    private double valor;
    private double saldo;
}
