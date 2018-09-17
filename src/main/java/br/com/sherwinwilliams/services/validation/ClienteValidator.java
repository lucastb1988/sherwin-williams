package br.com.sherwinwilliams.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.sherwinwilliams.dto.ClienteDTO;
import br.com.sherwinwilliams.enums.EnumTipoCliente;
import br.com.sherwinwilliams.resources.exception.FieldMessage;
import br.com.sherwinwilliams.services.validation.utils.BR;

//Validação personalizada de cpf ou cnpj para Cliente
public class ClienteValidator implements ConstraintValidator<ClienteAnnotation, ClienteDTO> {
	
	@Override
	public void initialize(ClienteAnnotation ann) {
	}

	//esta validação será conjunta a anotação @Valid inserida no rest quando salvar um cliente
	@Override
	public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> errors = new ArrayList<>();
		
		if (EnumTipoCliente.PESSOA_FISICA.getCodigo().equals(objDto.getTipo())) {
			
			if (!BR.isValidCpf(objDto.getCpfOuCnpj())) {
				errors.add(new FieldMessage("cpfOuCnpj", "CPF inválido."));
			}
			
			if (objDto.getNomeCliente() == null 
				|| objDto.getNomeCliente().length() > 50
				|| objDto.getNomeCliente().length() < 5) {
				errors.add(new FieldMessage("nomeCliente", "Nome obrigatório ou inválido."));
			}
		}

		if (EnumTipoCliente.PESSOA_JURIDICA.getCodigo().equals(objDto.getTipo())) {

			if (!BR.isValidCnpj(objDto.getCpfOuCnpj())) {
				errors.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido."));
			}

			if (objDto.getRazaoSocial() == null 
					|| objDto.getRazaoSocial().length() > 50
					|| objDto.getRazaoSocial().length() < 5) {
				errors.add(new FieldMessage("razaoSocial", "Razão Social obrigatório ou inválido."));
			}
		}
		
		//inserindo cada erro encontrado das validações
		for (FieldMessage e : errors) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return errors.isEmpty();
	}
}
