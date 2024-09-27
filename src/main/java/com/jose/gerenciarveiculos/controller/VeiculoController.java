package com.jose.gerenciarveiculos.controller;

import com.jose.gerenciarveiculos.model.Veiculo;
import com.jose.gerenciarveiculos.service.VeiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class VeiculoController {
    private final VeiculoService veiculoService;

    @GetMapping("/status")
    public String index() {
        return "Servidor Ativo";
    }
    @GetMapping
    public ResponseEntity<List<Veiculo>> getAll() {
            return ResponseEntity.ok(veiculoService.findAll());
    }
    @PostMapping
    public ResponseEntity<Veiculo> save(@RequestBody Veiculo veiculo) {
        try {
            veiculoService.save(veiculo);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Veiculo> delete(@PathVariable Integer id) {
        try {
            veiculoService.deleteById(Math.toIntExact(id));
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> update(@PathVariable Integer id, @RequestBody Veiculo veiculo) {
        try {
            veiculoService.update(id, veiculo);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(veiculo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
