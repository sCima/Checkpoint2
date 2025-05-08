package br.com.fiap.checkpoint2.model;

import br.com.fiap.checkpoint2.dto.PacienteDTO;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String endereco;
    private String bairro;
    private String email;
    private String telefoneCompleto;
    private LocalDate dataNascimento;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Paciente() { }

    /** Construtor de conveniência para criar a entidade a partir de um DTO */
    public Paciente(PacienteDTO dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.endereco = dto.getEndereco();
        this.bairro = dto.getBairro();
        this.email = dto.getEmail();
        this.telefoneCompleto = dto.getTelefoneCompleto();
        this.dataNascimento = dto.getDataNascimento();
        this.createdAt = dto.getCreatedAt();
        this.updatedAt = dto.getUpdatedAt();
    }

    // Getters & Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefoneCompleto() { return telefoneCompleto; }
    public void setTelefoneCompleto(String telefoneCompleto) { this.telefoneCompleto = telefoneCompleto; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
