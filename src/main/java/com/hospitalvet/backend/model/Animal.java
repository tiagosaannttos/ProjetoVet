package com.hospitalvet.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "animais")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String especie;
    private String raca;
    private Integer idade;

    @Column(name = "historico_saude", columnDefinition = "TEXT")
    private String historicoSaude;

    @Column(name = "historico_visitas", columnDefinition = "TEXT")
    private String historicoVisitas;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    public Animal() {
    }

    public Animal(Integer id, String nome, String especie, String raca, Integer idade,
                  String historicoSaude, String historicoVisitas, Integer idUsuario) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.historicoSaude = historicoSaude;
        this.historicoVisitas = historicoVisitas;
        this.idUsuario = idUsuario;
    }

    // Getters e Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getHistoricoSaude() {
        return historicoSaude;
    }

    public void setHistoricoSaude(String historicoSaude) {
        this.historicoSaude = historicoSaude;
    }

    public String getHistoricoVisitas() {
        return historicoVisitas;
    }

    public void setHistoricoVisitas(String historicoVisitas) {
        this.historicoVisitas = historicoVisitas;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}
