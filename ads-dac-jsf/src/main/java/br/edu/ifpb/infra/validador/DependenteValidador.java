package br.edu.ifpb.infra.validador;

import br.edu.ifpb.domain.Dependente;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "dependente.validator")
public class DependenteValidador implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {

        Dependente dep = (Dependente) value;

        if(dep.naoValido()){
            FacesMessage facesMessage = new FacesMessage("Valor invalido para dependente");
            throw new ValidatorException(facesMessage);
        }


    }
}
