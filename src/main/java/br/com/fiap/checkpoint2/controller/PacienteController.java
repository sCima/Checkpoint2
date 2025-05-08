package br.com.fiap.checkpoint2.controller;

import br.com.fiap.checkpoint2.dto.PacienteDTO;
import br.com.fiap.checkpoint2.service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PacienteDTO> criar(@RequestBody PacienteDTO dto) {
        PacienteDTO criado = service.criarPaciente(dto);
        return ResponseEntity.status(201).body(criado);
    }

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> listar() {
        List<PacienteDTO> list = service.listarTodos();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> buscarPorId(@PathVariable Long id) {
        PacienteDTO dto = service.buscarPorId(id);
        return dto != null
                ? ResponseEntity.ok(dto)
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteDTO> atualizar(@PathVariable Long id, @RequestBody PacienteDTO dto) {
        PacienteDTO atualizado = service.atualizarPaciente(id, dto);
        return atualizado != null
                ? ResponseEntity.ok(atualizado)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        // verifica existência
        if (service.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        service.removerPaciente(id);
        return ResponseEntity.noContent().build();
    }
}
