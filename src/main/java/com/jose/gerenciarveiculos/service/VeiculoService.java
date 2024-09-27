package com.jose.gerenciarveiculos.service;

import com.jose.gerenciarveiculos.model.Veiculo;
import com.jose.gerenciarveiculos.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface VeiculoService {

    List<Veiculo> findAll();
    Optional<Veiculo> findById(Integer id);
    void deleteById(Integer id);
    void save(Veiculo veiculo);
    Veiculo update(Integer id, Veiculo veiculo);
}
