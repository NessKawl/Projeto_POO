import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Fisico extends Produto {

	private double peso;
	private static String arquivo = "dados.txt", separador = ";";

	public Fisico() {
		super();
		peso = 0.0;
	}

	public Fisico(String nome, String desc, int qtd, double valor, int tipo, double peso) {
		super(nome, desc, qtd, valor, tipo);
		setPeso(peso);
	}

	public void setPeso(double peso) {
		if (peso <= 0) {
			throw new IllegalArgumentException("O peso não pode ser negativo");
		}
		this.peso = peso;
	}

	public double getPeso() {
		return peso;
	}

	@Override
    public boolean gravaNoArquivo() {
        try {
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(getNome());
			bw.write(separador);
			bw.write(getDesc());
			bw.write(separador);
			bw.write(String.valueOf(getQtd()));
			bw.write(separador);
			bw.write(String.valueOf(getValor()));
			bw.write(separador);
			bw.write(getTipo());
			bw.write(separador);
			bw.write("F");
            bw.write(separador);
			bw.write(String.valueOf(getPeso()));
			bw.newLine();

			bw.close();
			fw.close();

			return true;
			
        } catch (IOException e) {
            return false;
        }
    }
}