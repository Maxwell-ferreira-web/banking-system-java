package services;

import entities.*;
import utils.CsvExporter;
import java.util.*;

public class BancoService {
	private List<ContaBancaria> contas = new ArrayList<>();
	private List<Transacao> trans = new ArrayList<>();

	public ContaBancaria criarConta(int nc, int na, String nome, String cpf, String email, double limite, String tipo) {
		Cliente c = new Cliente(nome, cpf, email);
		ContaBancaria cb = new ContaBancaria(nc, na, c, limite, tipo);
		contas.add(cb);
		return cb;
	}

	public ContaBancaria buscarConta(int n) {
		return contas.stream().filter(c -> c.getNumeroConta() == n).findFirst().orElse(null);
	}

	public boolean registrarDeposito(ContaBancaria c, double v) {
		c.depositar(v);
		trans.add(new Transacao("DEPÓSITO", v, c.toString(), "-"));
		return true;
	}

	public boolean registrarSaque(ContaBancaria c, double v) {
		if (c.sacar(v)) {
			trans.add(new Transacao("SAQUE", v, c.toString(), "-"));
			return true;
		}
		return false;
	}

	public boolean registrarTransferencia(ContaBancaria o, ContaBancaria d, double v) {
		if (o.transferir(d, v)) {
			trans.add(new Transacao("TRANSFERÊNCIA", v, o.toString(), d.toString()));
			return true;
		}
		return false;
	}

	public void exportarTransacoes() {
		CsvExporter.exportar(trans);
	}

	public List<ContaBancaria> listarContas() {
		return contas;
	}
}