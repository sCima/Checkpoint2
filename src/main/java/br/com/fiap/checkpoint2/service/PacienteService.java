package br.com.fiap.checkpoint2.service;

import br.com.fiap.checkpoint2.dto.PacienteDTO;

import java.util.List;

public interface PacienteService {
    PacienteDTO criarPaciente(PacienteDTO dto);
    List<PacienteDTO> listarTodos();
    PacienteDTO buscarPorId(Long id);
    PacienteDTO atualizarPaciente(Long id, PacienteDTO dto);
    void removerPaciente(Long id);
}
