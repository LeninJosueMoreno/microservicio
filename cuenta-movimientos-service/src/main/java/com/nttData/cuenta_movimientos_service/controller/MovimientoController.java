package com.nttData.cuenta_movimientos_service.controller;

import com.nttData.cuenta_movimientos_service.entity.Movimiento;
import com.nttData.cuenta_movimientos_service.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {
    @Autowired
    private MovimientoRepository movimientoRepository;

    @GetMapping
    public List<Movimiento> getAllMovimientos() {
        return movimientoRepository.findAll();
    }
    @PostMapping
    public Movimiento createMovimiento(@RequestBody Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movimiento> updateMovimiento(@PathVariable Long id, @RequestBody Movimiento movimientoDetails) {
        Optional<Movimiento> optionalMovimiento = movimientoRepository.findById(id);

        if (!optionalMovimiento.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Movimiento movimiento = optionalMovimiento.get();
        movimiento.setFecha(movimientoDetails.getFecha());
        movimiento.setTipoMovimiento(movimientoDetails.getTipoMovimiento());
        movimiento.setValor(movimientoDetails.getValor());
        movimiento.setSaldo(movimientoDetails.getSaldo());

        final Movimiento updatedMovimiento = movimientoRepository.save(movimiento);
        return ResponseEntity.ok(updatedMovimiento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovimiento(@PathVariable Long id) {
        Optional<Movimiento> optionalMovimiento = movimientoRepository.findById(id);

        if (!optionalMovimiento.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        movimientoRepository.delete(optionalMovimiento.get());
        return ResponseEntity.noContent().build();
    }


}
