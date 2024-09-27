package com.jose.gerenciarveiculos.repository;

import com.jose.gerenciarveiculos.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
