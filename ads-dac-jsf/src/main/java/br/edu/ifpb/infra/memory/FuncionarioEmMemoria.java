package br.edu.ifpb.infra.memory;

import br.edu.ifpb.domain.Dependente;
import br.edu.ifpb.domain.Funcionario;
import br.edu.ifpb.domain.Funcionarios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FuncionarioEmMemoria implements Funcionarios {
    private final List<Funcionario> funcionarios = new ArrayList<>();
    private final List<Dependente> dependentes = new ArrayList<>();

    public FuncionarioEmMemoria() {
        this.funcionarios.addAll(
                Arrays.asList(
                        new Funcionario("Jubileu", "12312312332"),
                        new Funcionario("Cleus", "12312312339"),
                        new Funcionario("Magnus", "12312312330"),
                        new Funcionario("Carlsen", "12312312388"),
                        new Funcionario("Bob Fisher", "12312312337")
                )
        );
        this.dependentes.addAll(
                Arrays.asList(
                        new Dependente("5366b487-bf9e-46c9-aac1-99e96dcea70b", "Job", LocalDate.now().plusDays(1)), //amanhã
                        new Dependente("db9aee2d-811b-42e8-945a-5d10a4560f33", "Antonio", null), //nulo
                        new Dependente("21ce7508-5a9e-4f8b-9a41-b497f91c79bb", "Mariana", LocalDate.now().minusDays(1)), //ontem
                        new Dependente("e41f0a5e-095e-4f4a-9d60-f6fd5465965d", "Ana", LocalDate.now())

                )
        );

    }


    public void nova(Funcionario funcionario){
        this.funcionarios.add(funcionario);
    }

    @Override
    public List<Funcionario> todos() {

        return Collections.unmodifiableList(funcionarios);

    }

    @Override
    public void excluir(Funcionario funcionario) {
        this.funcionarios.remove(funcionario);
    }

    @Override
    public void atualizar(Funcionario funcionario) {
        this.funcionarios
                .removeIf(f -> f.getId() == funcionario.getId());
        this.funcionarios.add(funcionario);
    }

    @Override
    public List<Dependente> todosOsDepentendes() {
        return Collections.unmodifiableList(dependentes);
    }

    @Override
    public Dependente localizarDependenteComId(String uuid) {
        return todosOsDepentendes()
                .stream()
                .filter(d -> d.getUuid().equals(uuid))
                .findFirst()
                .orElse(Dependente.fake());
    }



    @Override
    public void novo(Dependente dependente) {
        this.dependentes.add(dependente);
    }

    @Override
    public Funcionario localizaFuncionarioComId(long id) {
        return todos()
                .stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(Funcionario.fake());

    }


}
