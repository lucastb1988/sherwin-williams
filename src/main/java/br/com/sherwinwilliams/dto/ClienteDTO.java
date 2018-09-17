package br.com.sherwinwilliams.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.sherwinwilliams.domain.Cliente;
import br.com.sherwinwilliams.services.validation.ClienteAnnotation;

//Anotação Customizada para atender a validação de cpf ou cnpj da entidade Cliente
@ClienteAnnotation
@JsonInclude(Include.NON_NULL)
public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer codigo;
	
	// Validação dentro da anotação
	private String nomeCliente;
	
	// Validação dentro da anotação
	private String razaoSocial;
	
	private String nomeFantasia;

	@NotEmpty(message = "Preenchimento Obrigatório")
	private String cpfOuCnpj;
	
	@NotEmpty(message = "Preenchimento Obrigatório")
	private String tipo;
	
	private String status;

	@NotEmpty(message = "Preenchimento Obrigatório")
	private String telefone1;

	private String telefone2;
	
	private String telefone3;

	public ClienteDTO() {
		super();
	}
	
	public ClienteDTO(Cliente obj) {
		codigo = obj.getCodigo();
		nomeCliente = obj.getNomeCliente();
		razaoSocial = obj.getRazaoSocial();
		nomeFantasia = obj.getNomeFantasia();
		cpfOuCnpj = obj.getCpfOuCnpj();
		tipo = obj.getTipo();
		status = obj.getStatus();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}
}
