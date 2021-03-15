package br.edu.ifpb.domain;

import java.util.Arrays;
import java.util.List;


public class Funcionario {

    private String nome;
    private long id;
    private CPF cpf;
    private Dependente dependente;

    public Funcionario(String nome){
        this(nome, "11111111111");
    }

    public static Funcionario fake(){
        return new Funcionario("Fake");
    }

    public Funcionario(String nome, String cpf) {
        this.nome = nome;
        this.id = System.currentTimeMillis();
        this.cpf = new CPF(cpf);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }

    public Dependente getDependente() {
        return dependente;
    }

    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }


    public void alterarNome() {
        this.nome = this.nome.toUpperCase();
    }

    public void alterarNomeMinusculo() {
        this.nome = this.nome.toLowerCase();
    }


}
