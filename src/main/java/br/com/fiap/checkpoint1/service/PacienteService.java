package br.com.fiap.checkpoint1.service;

import br.com.fiap.checkpoint1.dto.PacienteDTO;
import java.util.List;

public interface PacienteService {

    PacienteDTO criarPaciente(PacienteDTO pacienteDTO);
    PacienteDTO atualizarPaciente(Long id, PacienteDTO pacienteDTO);
    void removerPaciente(Long id);
    PacienteDTO buscarPorId(Long id);
    List<PacienteDTO> listarTodos();
}
