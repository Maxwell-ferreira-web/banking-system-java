package entities;

import java.time.LocalDateTime;

public class Transacao {
	private String tipo;
	private double valor;
	private LocalDateTime data;
	private String origem, destino;

	public Transacao(String t, double v, String o, String d) {
		tipo = t;
		valor = v;
		origem = o;
		destino = d;
		data = LocalDateTime.now();
	}

	public String getTipo() {
		return tipo;
	}

	public double getValor() {
		return valor;
	}

	public LocalDateTime getData() {
		return data;
	}

	public String getOrigem() {
		return origem;
	}

	public String getDestino() {
		return destino;
	}
}