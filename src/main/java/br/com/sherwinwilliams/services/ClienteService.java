package br.com.sherwinwilliams.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sherwinwilliams.domain.Cliente;
import br.com.sherwinwilliams.dto.ClienteDTO;
import br.com.sherwinwilliams.enums.EnumStatus;
import br.com.sherwinwilliams.enums.EnumTipoCliente;
import br.com.sherwinwilliams.exceptions.ObjectNotFoundException;
import br.com.sherwinwilliams.repositories.ClienteRepository;

@Service
public class ClienteService {
	
    @Autowired
    private ClienteRepository repo;
    
    public Cliente find(Integer codigo) {
    	
        Optional<Cliente> cliente = repo.findById(codigo);
        return cliente.orElseThrow(() -> new ObjectNotFoundException(
        		"Objeto não encontrado! Código: " + codigo + ", Tipo: " + Cliente.class.getName()));
    }
    
    @Transactional
    public Cliente insert(Cliente obj) {
    	obj.setCodigo(null);
    	obj.setStatus(EnumStatus.ATIVO.getCodigo());
    	obj = repo.save(obj);
    	return obj;
    }
    
    public List<Cliente> findAll() {
    	return repo.findAll();
    }
    
    public Cliente fromDto(ClienteDTO objDto) {
    	Cliente cli = new Cliente(
    			null,
    			objDto.getNomeCliente(),
    			objDto.getRazaoSocial(),
    			objDto.getNomeFantasia(),
    			objDto.getCpfOuCnpj(),
    			EnumTipoCliente.toEnum(objDto.getTipo()),
    			null);
    	
    	cli.getTelefones().add(objDto.getTelefone1());
    	if (objDto.getTelefone2() != null) {
    		cli.getTelefones().add(objDto.getTelefone2());
    	}
    	if (objDto.getTelefone3() != null) {
    		cli.getTelefones().add(objDto.getTelefone3());
    	}
    	
    	return cli;
    }
}
