package br.com.fiap.checkpoint1.service;

import br.com.fiap.checkpoint1.dto.PacienteDTO;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PacienteServiceImpl implements PacienteService {

    // banco de dados simulado
    private final Map<Long, PacienteDTO> pacienteDB = new HashMap<>();
    private final AtomicLong sequence = new AtomicLong();

    @Override
    public PacienteDTO criarPaciente(PacienteDTO pacienteDTO) {
        Long idGerado = sequence.incrementAndGet();
        pacienteDTO.setId(idGerado);
        pacienteDB.put(idGerado, pacienteDTO);
        return pacienteDTO;
    }

    @Override
    public PacienteDTO atualizarPaciente(Long id, PacienteDTO pacienteDTO) {
        if (!pacienteDB.containsKey(id)) {
            return null;
        }
        pacienteDTO.setId(id);
        pacienteDB.put(id, pacienteDTO);
        return pacienteDTO;
    }

    @Override
    public void removerPaciente(Long id) {
        pacienteDB.remove(id);
    }

    @Override
    public PacienteDTO buscarPorId(Long id) {
        return pacienteDB.get(id);
    }

    @Override
    public List<PacienteDTO> listarTodos() {
        return new ArrayList<>(pacienteDB.values());
    }
}
