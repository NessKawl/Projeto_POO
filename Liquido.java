
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Liquido extends Produto {
    private double volume;
    private String arquivo = "dados.txt", separador = ";";

    public Liquido() {
        super();
        volume = 0.0;
    }

    public Liquido(String nome, String desc, int qtd, double valor, int tipo, double volume) {
        super(nome, desc, qtd, valor, tipo);
        setVolume(volume);
    }

    public void setVolume(double volume) {
        if (volume <= 0) {
            throw new IllegalArgumentException("O volume não pode ser negativo");
        }
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
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
			bw.write("L");
            bw.write(separador);
			bw.write(String.valueOf(getVolume()));
			bw.newLine();

			bw.close();
			fw.close();

			return true;
            
        } catch (IOException e) {
            return false;
        }
    }


}