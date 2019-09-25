package br.edu.ifba.ads.inf008.model.session;

import br.edu.ifba.ads.inf008.exceptions.ContabilException;

public interface RegistroContabilApp {
	public void registrarFato(String nomeCredito, String nomeDebito,
							  String descricao, double valor) throws ContabilException;
}
