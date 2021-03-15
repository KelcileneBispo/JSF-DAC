package br.edu.ifpb.domain;

import java.io.Serializable;
import java.util.List;

public interface Funcionarios extends Serializable {

    public void nova (Funcionario funcionario);

    public List<Funcionario> todos();


    public void excluir(Funcionario funcionario);

    public void atualizar(Funcionario funcionario);

    public Dependente localizarDependenteComId(String uuid);

    public List<Dependente> todosOsDepentendes();

    public void novo(Dependente dependente);

    public Funcionario localizaFuncionarioComId(long id);
}
