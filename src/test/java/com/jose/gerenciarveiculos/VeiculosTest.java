package com.jose.gerenciarveiculos;

import com.jose.gerenciarveiculos.model.Veiculo;
import com.jose.gerenciarveiculos.repository.VeiculoRepository;
import com.jose.gerenciarveiculos.service.VeiculoService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VeiculosTest {

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private VeiculoRepository veiculoRepository;
    @Test
    @DisplayName("Criar novos veículos")
    public void testCreateVeiculo() {
        List<Veiculo> all = veiculoService.findAll();
        int initialSize = all.size();

        Veiculo veiculo = new Veiculo();
        veiculo.setModelo("Uno");
        veiculo.setAno("2021");
        veiculo.setPlaca("ABC1334");
        veiculo.setMarca("Fiat");

        veiculoService.save(veiculo);

        List<Veiculo> updatedList = veiculoService.findAll();
        int finalSize = updatedList.size();

        assertEquals(initialSize + 1, finalSize);
        Optional<Veiculo> savedVeiculo = veiculoService.findById(veiculo.getId());
        assertTrue(savedVeiculo.isPresent());
        assertEquals("Uno", savedVeiculo.get().getModelo());
    }

    @Test
    @DisplayName("Atualizar um veículo existente")
    public void testUpdateVeiculo() {
        Veiculo veiculo = new Veiculo();
        veiculo.setModelo("Mustang GT");
        veiculo.setAno("2024");
        veiculo.setPlaca("XYZ-5678");
        veiculo.setMarca("Shelby");

        veiculoService.save(veiculo);

        veiculo.setMarca("Ford");
        Veiculo updatedVeiculo = veiculoService.update(veiculo.getId(), veiculo);

        assertEquals("Ford", updatedVeiculo.getMarca());
    }

    @Test
    @DisplayName("Deletar um veículo existente")
    public void testDeleteVeiculo() {
        Veiculo veiculo = new Veiculo();
        veiculo.setModelo("Defender");
        veiculo.setAno("2020");
        veiculo.setPlaca("JKL-9012");
        veiculo.setMarca("Land Rover");

        veiculoService.save(veiculo);

        List<Veiculo> all = veiculoService.findAll();
        int initialSize = all.size();

        veiculoService.deleteById(veiculo.getId());

        List<Veiculo> updatedList = veiculoService.findAll();
        int finalSize = updatedList.size();

        assertEquals(initialSize - 1, finalSize);

        Optional<Veiculo> deletedVeiculo = veiculoService.findById(veiculo.getId());
        assertFalse(deletedVeiculo.isPresent());
    }

    @Test
    @DisplayName("Buscar um veículo existente")
    public void testFindById() {
        Veiculo veiculo = new Veiculo();
        veiculo.setModelo("Fusca");
        veiculo.setAno("1970");
        veiculo.setPlaca("LMN-3456");
        veiculo.setMarca("Volkswagen");

        veiculoService.save(veiculo);

        Optional<Veiculo> foundVeiculo = veiculoService.findById(veiculo.getId());

        assertTrue(foundVeiculo.isPresent());
        assertEquals("Fusca", foundVeiculo.get().getModelo());
    }
}
