package com.nttData.cuenta_movimientos_service.controller;

import com.nttData.cuenta_movimientos_service.entity.Cuenta;
import com.nttData.cuenta_movimientos_service.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    @Autowired
    private CuentaRepository cuentaRepository;

    @GetMapping
    public List<Cuenta> getAllCuentas() {
        return cuentaRepository.findAll();
    }
    @PostMapping
    public Cuenta createCuenta(@RequestBody Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cuenta> updateCuenta(@PathVariable Long id, @RequestBody Cuenta cuentaDetails) {
        Optional<Cuenta> optionalCuenta = cuentaRepository.findById(id);

        if (!optionalCuenta.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Cuenta cuenta = optionalCuenta.get();
        cuenta.setTipoCuenta(cuentaDetails.getTipoCuenta());
        cuenta.setSaldoInicial(cuentaDetails.getSaldoInicial());
        cuenta.setEstado(cuentaDetails.getEstado());

        final Cuenta updatedCuenta = cuentaRepository.save(cuenta);
        return ResponseEntity.ok(updatedCuenta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCuenta(@PathVariable Long id) {
        Optional<Cuenta> optionalCuenta = cuentaRepository.findById(id);

        if (!optionalCuenta.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        cuentaRepository.delete(optionalCuenta.get());
        return ResponseEntity.noContent().build();
    }
}
