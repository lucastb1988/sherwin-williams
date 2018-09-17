package br.com.sherwinwilliams.enums;

public enum EnumStatus {

	ATIVO("A", "Ativo"), INATIVO("I", "Inativo");

	private String codigo;
	private String descricao;

	private EnumStatus(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EnumStatus toEnum(String codigo) {

		if (codigo == null) {
			return null;
		}

		for (EnumStatus status : EnumStatus.values()) {
			if (status.getCodigo().equalsIgnoreCase(codigo)) {
				return status;
			}
		}

		throw new IllegalArgumentException("Código inválido: " + codigo);
	}
}
