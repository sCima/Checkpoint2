package br.com.fiap.checkpoint2.dto;

import br.com.fiap.checkpoint2.model.Consulta;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ConsultaDTO {

    private Long id;
    private LocalDate data;
    private String descricao;
    private Long pacienteId;
    private Long profissionalId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ConsultaDTO() { }

    public ConsultaDTO(Consulta entity) {
        this.id = entity.getId();
        this.data = entity.getData();
        this.descricao = entity.getDescricao();
        this.pacienteId = entity.getPacienteId();
        this.profissionalId = entity.getProfissionalId();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
    }

    // getters e setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Long getPacienteId() { return pacienteId; }
    public void setPacienteId(Long pacienteId) { this.pacienteId = pacienteId; }

    public Long getProfissionalId() { return profissionalId; }
    public void setProfissionalId(Long profissionalId) { this.profissionalId = profissionalId; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
