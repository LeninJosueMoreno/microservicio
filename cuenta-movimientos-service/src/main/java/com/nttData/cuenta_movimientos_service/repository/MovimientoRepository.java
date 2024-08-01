package com.nttData.cuenta_movimientos_service.repository;

import com.nttData.cuenta_movimientos_service.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository <Movimiento, Long> {
}
