package br.edu.ifpb.domain;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Dependente {
    private String uuid;
    private String nome;
    private LocalDate dataDeNascimento;

    public Dependente() {
        this("");
    }

    public Dependente(String nome) {
        this(
                UUID.randomUUID().toString(),
                nome,
                LocalDate.now()
        );
    }

    public Dependente(String uuid, String nome) {
        this(
                uuid, nome, LocalDate.now()
        );
    }

    public Dependente(String uuid, String nome, LocalDate dataDeNascimento){
        this.uuid = uuid;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }

    public static Dependente fake(){
        return new Dependente("-1", "-1");
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public boolean naoValido() {
        return nomeVazio() || nascimentoAnterior();
    }

    public boolean nomeVazio() {
        return this.nome == null || this.nome.trim().equals("");
    }

    public boolean nascimentoAnterior() {
        return this.dataDeNascimento == null
                || this.dataDeNascimento.isEqual(LocalDate.now())
                || this.dataDeNascimento.isAfter(LocalDate.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dependente that = (Dependente) o;
        return Objects.equals(uuid, that.uuid) && Objects.equals(nome, that.nome) && Objects.equals(dataDeNascimento, that.dataDeNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, nome, dataDeNascimento);
    }
}
