package br.com.fiap.checkpoint1.controller;

import br.com.fiap.checkpoint1.dto.PacienteDTO;
import br.com.fiap.checkpoint1.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<PacienteDTO> criarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        PacienteDTO criado = pacienteService.criarPaciente(pacienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteDTO> atualizarPaciente(
            @PathVariable Long id,
            @RequestBody PacienteDTO pacienteDTO
    ) {
        PacienteDTO atualizado = pacienteService.atualizarPaciente(id, pacienteDTO);
        if (atualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atualizado);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPaciente(@PathVariable Long id) {

        PacienteDTO paciente = pacienteService.buscarPorId(id);
        if (paciente == null) {
            return ResponseEntity.notFound().build();
        }

        pacienteService.removerPaciente(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> buscarPorId(@PathVariable Long id) {
        PacienteDTO paciente = pacienteService.buscarPorId(id);
        if (paciente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(paciente);
    }

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> listarTodos() {
        List<PacienteDTO> pacientes = pacienteService.listarTodos();
        return ResponseEntity.ok(pacientes);
    }
}
