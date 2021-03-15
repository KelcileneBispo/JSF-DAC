package br.edu.ifpb.infra.validador;


import br.edu.ifpb.domain.CPF;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("cpf.validator")
public class CPFValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {

        CPF cpf = (CPF) value;
        if(cpf.valido()) return;

        throw new ValidatorException(
                new FacesMessage("CPF Inválido")
        );
    }
}
