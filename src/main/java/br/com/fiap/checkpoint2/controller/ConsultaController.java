package br.com.fiap.checkpoint2.controller;

import br.com.fiap.checkpoint2.dto.ConsultaDTO;
import br.com.fiap.checkpoint2.service.ConsultaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ConsultaDTO> criar(@RequestBody ConsultaDTO dto) {
        ConsultaDTO criado = service.criarConsulta(dto);
        return ResponseEntity.status(201).body(criado);
    }

    @GetMapping
    public ResponseEntity<List<ConsultaDTO>> listar() {
        List<ConsultaDTO> list = service.listarTodos();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaDTO> buscarPorId(@PathVariable Long id) {
        ConsultaDTO dto = service.buscarPorId(id);
        return dto != null
                ? ResponseEntity.ok(dto)
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaDTO> atualizar(@PathVariable Long id, @RequestBody ConsultaDTO dto) {
        ConsultaDTO atualizado = service.atualizarConsulta(id, dto);
        return atualizado != null
                ? ResponseEntity.ok(atualizado)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        service.removerConsulta(id);
        return ResponseEntity.noContent().build();
    }
}
