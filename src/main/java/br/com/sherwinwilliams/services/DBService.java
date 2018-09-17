package br.com.sherwinwilliams.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sherwinwilliams.domain.Cliente;
import br.com.sherwinwilliams.enums.EnumStatus;
import br.com.sherwinwilliams.enums.EnumTipoCliente;
import br.com.sherwinwilliams.repositories.ClienteRepository;

@Service
public class DBService {

	@Autowired
	private ClienteRepository clienteRepository;

	public void instantiateTestDataBase() throws ParseException {

		Cliente cli1 = new Cliente(null, "Lucas Tartarini Banin", null, null, "38941569885", 
				EnumTipoCliente.PESSOA_FISICA, EnumStatus.ATIVO);
		cli1.getTelefones().addAll(Arrays.asList("23589546", "956321592"));

		Cliente cli2 = new Cliente(null, null, "Lucas T Banin Serviços", "CLOUD9 Serviços", "28340655000128",
				EnumTipoCliente.PESSOA_JURIDICA, EnumStatus.INATIVO);
		cli2.getTelefones().addAll(Arrays.asList("42294854", "982007841"));

		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
	}
}
