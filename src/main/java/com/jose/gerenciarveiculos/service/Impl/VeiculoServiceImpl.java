package com.jose.gerenciarveiculos.service.Impl;

import com.jose.gerenciarveiculos.model.Veiculo;
import com.jose.gerenciarveiculos.repository.VeiculoRepository;
import com.jose.gerenciarveiculos.service.VeiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VeiculoServiceImpl implements VeiculoService {

    private final VeiculoRepository veiculoRepository;

    @Override
    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }
    @Override
    public Optional<Veiculo> findById(Integer id) {
        return veiculoRepository.findById(Long.valueOf(id));
    }
    public void deleteById(Integer id){
        veiculoRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public void save(Veiculo veiculo) {
        veiculoRepository.save(veiculo);
    };
    public Veiculo update(Integer id, Veiculo veiculo){
        veiculo.setId(id);
        return veiculoRepository.save(veiculo);

    };

}
