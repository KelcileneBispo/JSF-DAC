package br.edu.ifpb;


import br.edu.ifpb.domain.Dependente;
import br.edu.ifpb.domain.Funcionario;
import br.edu.ifpb.infra.memory.FuncionarioEmMemoria;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name="controBean")
@SessionScoped
public class Contro implements Serializable {


    private Funcionario funcionario = new Funcionario("", "");
    private Dependente dependente = new Dependente("");


    private AlterarNomeDasPessoas service = new AlterarNomeDasPessoas();
    private FuncionarioEmMemoria memory = new FuncionarioEmMemoria();


    public String redirecionar(){
      funcionario.alterarNome();
      //service.alterarNome();

        return "funcionario/list.xhtml?faces-redirect=true";
    }

    public String adicionar() {
        Funcionario retorno = this.memory.localizaFuncionarioComId(
                this.funcionario.getId()
        );
                if(Funcionario.fake().equals(retorno)){
                    this.memory.nova(this.funcionario);
                }else{
                    this.memory.atualizar(this.funcionario);
                }

        this.funcionario = new Funcionario("", "");
        return null;
    }

    public String adicionarDependente() {
        this.memory.novo(dependente);
        this.dependente = new Dependente("");
        return null;
    }

    public String excluir(Funcionario funcionario){
        this.memory.excluir(funcionario);
        return null;
    }

    public String editar(Funcionario funcionario){
        this.funcionario = funcionario;
        return "edit";
    }



    public List<Funcionario> todasAsPessoas(){
        return this.memory.todos();
    }

   public List<Dependente> todosOsDepentendes(){
        return this.memory.todosOsDepentendes();
   }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Dependente getDependente() {
        return dependente;
    }

    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }

}
