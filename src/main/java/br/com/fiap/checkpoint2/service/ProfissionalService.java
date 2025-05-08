package br.com.fiap.checkpoint2.service;

import br.com.fiap.checkpoint2.dto.ProfissionalDTO;
import java.util.List;

public interface ProfissionalService {

    ProfissionalDTO criarProfissional(ProfissionalDTO profissionalDTO);
    ProfissionalDTO atualizarProfissional(Long id, ProfissionalDTO profissionalDTO);
    void removerProfissional(Long id);
    ProfissionalDTO buscarPorId(Long id);
    List<ProfissionalDTO> listarTodos();
}
