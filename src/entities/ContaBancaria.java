package entities;

public class ContaBancaria {
	private int numeroConta, numeroAgencia;
	private Cliente cliente;
	private double saldo, limite;
	private String tipoConta;

	public ContaBancaria(int nc, int na, Cliente c, double l, String t) {
		numeroConta = nc;
		numeroAgencia = na;
		cliente = c;
		limite = l;
		tipoConta = t;
		saldo = 0;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public int getNumeroAgencia() {
		return numeroAgencia;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public double getLimite() {
		return limite;
	}

	public void alterarLimite(double nl) {
		limite = nl;
	}

	public void depositar(double v) {
		saldo += v;
	}

	public boolean sacar(double v) {
		if (v <= saldo + limite) {
			saldo -= v;
			return true;
		}
		return false;
	}

	public boolean transferir(ContaBancaria d, double v) {
		if (sacar(v)) {
			d.depositar(v);
			return true;
		}
		return false;
	}

	public String toString() {
		return "Conta " + numeroConta + " | Agência " + numeroAgencia + " | Cliente: " + cliente.getNome()
				+ " | Saldo: R$ " + saldo + " | Tipo: " + tipoConta;
	}
}