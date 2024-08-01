package com.nttData.cuenta_movimientos_service.repository;

import com.nttData.cuenta_movimientos_service.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository <Cuenta, Long> {
}
