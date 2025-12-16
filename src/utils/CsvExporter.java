package utils;

import entities.Transacao;
import java.io.FileWriter;
import java.util.List;

public class CsvExporter {
	public static void exportar(List<Transacao> lista) {
		try (FileWriter w = new FileWriter("transacoes.csv")) {
			w.write("tipo,valor,data,origem,destino\n");
			for (Transacao t : lista)
				w.write(t.getTipo() + "," + t.getValor() + "," + t.getData() + "," + t.getOrigem() + ","
						+ t.getDestino() + "\n");
			System.out.println("Arquivo transacoes.csv exportado!");
		} catch (Exception e) {
			System.out.println("Erro CSV " + e.getMessage());
		}
	}
}