package br.com.fiap.checkpoint2.controller;

import br.com.fiap.checkpoint2.dto.ProfissionalDTO;
import br.com.fiap.checkpoint2.service.ProfissionalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

    private final ProfissionalService service;

    public ProfissionalController(ProfissionalService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProfissionalDTO> criar(@RequestBody ProfissionalDTO dto) {
        ProfissionalDTO criado = service.criarProfissional(dto);
        return ResponseEntity.status(201).body(criado);
    }

    @GetMapping
    public ResponseEntity<List<ProfissionalDTO>> listar() {
        List<ProfissionalDTO> list = service.listarTodos();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalDTO> buscarPorId(@PathVariable Long id) {
        ProfissionalDTO dto = service.buscarPorId(id);
        return dto != null
                ? ResponseEntity.ok(dto)
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfissionalDTO> atualizar(@PathVariable Long id, @RequestBody ProfissionalDTO dto) {
        ProfissionalDTO atualizado = service.atualizarProfissional(id, dto);
        return atualizado != null
                ? ResponseEntity.ok(atualizado)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        service.removerProfissional(id);
        return ResponseEntity.noContent().build();
    }
}
