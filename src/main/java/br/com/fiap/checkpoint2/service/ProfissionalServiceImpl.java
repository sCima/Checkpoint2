package br.com.fiap.checkpoint2.service;

import br.com.fiap.checkpoint2.dto.ProfissionalDTO;
import br.com.fiap.checkpoint2.model.Profissional;
import br.com.fiap.checkpoint2.repository.ProfissionalRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProfissionalServiceImpl implements ProfissionalService {

    private final ProfissionalRepository repository;

    public ProfissionalServiceImpl(ProfissionalRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProfissionalDTO criarProfissional(ProfissionalDTO dto) {
        Profissional profissional = new Profissional();
        profissional.setNome(dto.getNome());
        profissional.setEspecialidade(dto.getEspecialidade());
        profissional.setValorHora(dto.getValorHora());
        profissional.setCreatedAt(LocalDateTime.now());
        profissional.setUpdatedAt(LocalDateTime.now());

        Profissional salvo = repository.save(profissional);

        return new ProfissionalDTO(salvo);
    }

    @Override
    public List<ProfissionalDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(ProfissionalDTO::new)
                .toList();
    }

    @Override
    public ProfissionalDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(ProfissionalDTO::new)
                .orElse(null);
    }

    @Override
    public ProfissionalDTO atualizarProfissional(Long id, ProfissionalDTO dto) {
        return repository.findById(id)
                .map(existente -> {
                    existente.setNome(dto.getNome());
                    existente.setEspecialidade(dto.getEspecialidade());
                    existente.setValorHora(dto.getValorHora());
                    existente.setUpdatedAt(LocalDateTime.now());
                    Profissional atualizado = repository.save(existente);
                    return new ProfissionalDTO(atualizado);
                })
                .orElse(null);
    }

    @Override
    public void removerProfissional(Long id) {
        repository.deleteById(id);
    }
}
