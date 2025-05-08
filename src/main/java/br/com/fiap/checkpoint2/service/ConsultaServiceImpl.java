package br.com.fiap.checkpoint2.service;

import br.com.fiap.checkpoint2.dto.ConsultaDTO;
import br.com.fiap.checkpoint2.model.Consulta;
import br.com.fiap.checkpoint2.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultaServiceImpl implements ConsultaService {

    @Autowired
    private ConsultaRepository repository;

    @Override
    public ConsultaDTO criarConsulta(ConsultaDTO dto) {
        Consulta consulta = new Consulta();
        consulta.setData(dto.getData());
        consulta.setDescricao(dto.getDescricao());
        consulta.setPacienteId(dto.getPacienteId());
        consulta.setProfissionalId(dto.getProfissionalId());
        consulta.setCreatedAt(LocalDateTime.now());
        consulta.setUpdatedAt(LocalDateTime.now());

        Consulta salvo = repository.save(consulta);
        return new ConsultaDTO(salvo);
    }


    @Override
    public ConsultaDTO atualizarConsulta(Long id, ConsultaDTO dto) {
        return repository.findById(id)
                .map(existente -> {
                    existente.setData(dto.getData());
                    existente.setDescricao(dto.getDescricao());
                    existente.setUpdatedAt(LocalDateTime.now());
                    Consulta atualizado = repository.save(existente);
                    return new ConsultaDTO(atualizado);
                })
                .orElse(null);
    }


    @Override
    public void removerConsulta(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ConsultaDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(ConsultaDTO::new)
                .orElse(null);
    }

    @Override
    public List<ConsultaDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(ConsultaDTO::new)
                .collect(Collectors.toList());
    }
}
