package services;

import entities.ContaBancaria;
import java.time.LocalTime;
import java.util.Scanner;

public class MenuService {
	private BancoService banco = new BancoService();
	private Scanner sc = new Scanner(System.in);

	public void iniciar() {
		int op;
		do {
			System.out.println(
					"\n=== MENU ===\n1 Criar conta\n2 Depósito\n3 Saque\n4 Transferência\n5 Alterar limite\n6 Exportar CSV\n7 Listar contas\n0 Sair");
			op = sc.nextInt();
			switch (op) {
			case 1 -> criarConta();
			case 2 -> depositar();
			case 3 -> saque();
			case 4 -> transfer();
			case 5 -> alterarLim();
			case 6 -> banco.exportarTransacoes();
			case 7 -> listar();
			case 0 -> System.out.println("Saindo...");
			}
		} while (op != 0);
	}

	private void criarConta() {
		System.out.print("Conta: ");
		int c = sc.nextInt();
		System.out.print("Agência: ");
		int a = sc.nextInt();
		sc.nextLine();
		System.out.print("Nome: ");
		String n = sc.nextLine();
		System.out.print("CPF: ");
		String cpf = sc.nextLine();
		System.out.print("Email: ");
		String e = sc.nextLine();
		System.out.print("Limite: ");
		double l = sc.nextDouble();
		sc.nextLine();
		System.out.print("Tipo: ");
		String t = sc.nextLine();
		banco.criarConta(c, a, n, cpf, e, l, t);
		System.out.println("Criada!");
	}

	private void depositar() {
		System.out.print("Conta: ");
		int c = sc.nextInt();
		ContaBancaria cb = banco.buscarConta(c);
		if (cb == null) {
			System.out.println("Não encontrada");
			return;
		}
		System.out.print("Valor: ");
		double v = sc.nextDouble();
		banco.registrarDeposito(cb, v);
		System.out.println("Depósito ok");
	}

	private void saque() {
		System.out.print("Conta: ");
		int c = sc.nextInt();
		ContaBancaria cb = banco.buscarConta(c);
		if (cb == null) {
			System.out.println("Não encontrada");
			return;
		}
		System.out.print("Valor: ");
		double v = sc.nextDouble();
		if (banco.registrarSaque(cb, v))
			System.out.println("Saque ok");
		else
			System.out.println("Saldo insuficiente");
	}

	private void transfer() {
		if (LocalTime.now().getHour() >= 22) {
			System.out.println("Transferências até 22h.");
			return;
		}
		System.out.print("Origem: ");
		int o = sc.nextInt();
		System.out.print("Destino: ");
		int d = sc.nextInt();
		ContaBancaria co = banco.buscarConta(o), cd = banco.buscarConta(d);
		if (co == null || cd == null) {
			System.out.println("Conta(s) inválida(s)");
			return;
		}
		System.out.print("Valor: ");
		double v = sc.nextDouble();
		if (banco.registrarTransferencia(co, cd, v))
			System.out.println("Transfer ok");
		else
			System.out.println("Erro transferência");
	}

	private void alterarLim() {
		System.out.print("Conta: ");
		int c = sc.nextInt();
		ContaBancaria cb = banco.buscarConta(c);
		if (cb == null) {
			System.out.println("Não encontrada");
			return;
		}
		System.out.print("Novo limite: ");
		cb.alterarLimite(sc.nextDouble());
	}

	private void listar() {
		banco.listarContas().forEach(System.out::println);
	}
}