package br.com.sherwinwilliams.enums;

public enum EnumTipoCliente {

	PESSOA_FISICA("PF", "Pessoa Física"), PESSOA_JURIDICA("PJ", "Pessoa Jurídica");

	private String codigo;
	private String descricao;

	private EnumTipoCliente(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EnumTipoCliente toEnum(String codigo) {

		if (codigo == null) {
			return null;
		}

		for (EnumTipoCliente tipo : EnumTipoCliente.values()) {
			if (tipo.getCodigo().equalsIgnoreCase(codigo)) {
				return tipo;
			}
		}

		throw new IllegalArgumentException("Código inválido: " + codigo);
	}
}
