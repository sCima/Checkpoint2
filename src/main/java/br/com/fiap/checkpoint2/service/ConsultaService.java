package br.com.fiap.checkpoint2.service;

import br.com.fiap.checkpoint2.dto.ConsultaDTO;
import java.util.List;

public interface ConsultaService {

    ConsultaDTO criarConsulta(ConsultaDTO consultaDTO);
    ConsultaDTO atualizarConsulta(Long id, ConsultaDTO consultaDTO);
    void removerConsulta(Long id);
    ConsultaDTO buscarPorId(Long id);
    List<ConsultaDTO> listarTodos();
}
