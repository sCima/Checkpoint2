package br.com.fiap.checkpoint2.dto;

import br.com.fiap.checkpoint2.model.Profissional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProfissionalDTO {

    private Long id;
    private String nome;
    private String especialidade;
    private BigDecimal valorHora;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProfissionalDTO() { }

    public ProfissionalDTO(Profissional entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.especialidade = entity.getEspecialidade();
        this.valorHora = entity.getValorHora();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
    }

    // getters e setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    public BigDecimal getValorHora() { return valorHora; }
    public void setValorHora(BigDecimal valorHora) { this.valorHora = valorHora; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
