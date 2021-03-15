package br.edu.ifpb.infra.converter;

import br.edu.ifpb.domain.Dependente;
import br.edu.ifpb.domain.Funcionarios;
import br.edu.ifpb.infra.memory.FuncionarioEmMemoria;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value = "dependente.converter")
public class ConveterDependente  implements Converter {
    private Funcionarios service = new FuncionarioEmMemoria();


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if(value == null){
            return  null;
        };
        Dependente dep = this.service.localizarDependenteComId(value);
        return  dep;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if(value == null){
            return  null;
        };
        Dependente dep = (Dependente) value;
        return dep.getUuid();
    }
}

