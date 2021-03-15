package br.edu.ifpb.infra.converter;

import br.edu.ifpb.domain.CPF;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "cpf.converter", forClass = CPF.class)
public class CPFConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if(value == null){
            return null;
        }
        CPF cpf = new CPF(value);
        return cpf;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if(value == null){
            return null;
        }
        CPF cpf = (CPF) value;
        return cpf.valor();
    }
}
