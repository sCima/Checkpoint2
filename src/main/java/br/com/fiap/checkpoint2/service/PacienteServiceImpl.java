package br.com.fiap.checkpoint2.service;

import br.com.fiap.checkpoint2.dto.PacienteDTO;
import br.com.fiap.checkpoint2.model.Paciente;
import br.com.fiap.checkpoint2.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository repository;

    public PacienteServiceImpl(PacienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public PacienteDTO criarPaciente(PacienteDTO dto) {
        Paciente paciente = new Paciente();
        paciente.setNome(dto.getNome());
        paciente.setEndereco(dto.getEndereco());
        paciente.setBairro(dto.getBairro());
        paciente.setEmail(dto.getEmail());
        paciente.setTelefoneCompleto(dto.getTelefoneCompleto());
        paciente.setDataNascimento(dto.getDataNascimento());
        paciente.setCreatedAt(LocalDateTime.now());
        paciente.setUpdatedAt(LocalDateTime.now());

        Paciente salvo = repository.save(paciente);
        return new PacienteDTO(salvo);
    }

    @Override
    public List<PacienteDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(PacienteDTO::new)
                .toList();
    }

    @Override
    public PacienteDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(PacienteDTO::new)
                .orElse(null);
    }

    @Override
    public PacienteDTO atualizarPaciente(Long id, PacienteDTO dto) {
        return repository.findById(id)
                .map(existente -> {
                    existente.setNome(dto.getNome());
                    existente.setEndereco(dto.getEndereco());
                    existente.setBairro(dto.getBairro());
                    existente.setEmail(dto.getEmail());
                    existente.setTelefoneCompleto(dto.getTelefoneCompleto());
                    existente.setDataNascimento(dto.getDataNascimento());
                    existente.setUpdatedAt(LocalDateTime.now());
                    return new PacienteDTO(repository.save(existente));
                })
                .orElse(null);
    }

    @Override
    public void removerPaciente(Long id) {
        repository.deleteById(id);
    }
}
