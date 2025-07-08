import java.io.*;

public class Produto {

	private String nome, desc;
	private int qtd;
	private double valor;

	private String tipo, arquivo = "dados.txt", separador = ";";

	public Produto() {
		nome = "";
		desc = "";
		qtd = 0;
		valor = 0.0;
		tipo = "";
	}

	public Produto(String nome, String desc, int qtd, double valor, int tipo) {
		setNome(nome);
		setDesc(desc);
		setQtd(qtd);
		setValor(valor);
		setTipo(tipo);
	}

	public void setNome(String nome) {
		if (nome.isEmpty() || nome == null) {
			throw new IllegalArgumentException("Nome do Produto não pode ser vazio, nem nulo");
		}
		this.nome = nome;
	}

	public void setDesc(String desc) {
		if (desc.isEmpty() || desc == null) {
			throw new IllegalArgumentException("Descrição do Produto não pode ser vazio, nem nulo");
		}
		this.desc = desc;
	}

	public void setQtd(int qtd) {
		if (qtd <= 0) {
			throw new IllegalArgumentException("A quantidade não pode ser negativa e nem igual a 0");
		}
		this.qtd = qtd;
	}

	public void setValor(double valor) {
		if (valor <= 0) {
			throw new IllegalArgumentException("O valor do produto não pode ser negativo");
		}
		this.valor = valor;
	}

	public void setTipo(int tipo) {

		switch (tipo) {
			case 1:
				this.tipo = "Suspensao";
				break;

			case 2:
				this.tipo = "Freio";
				break;

			case 3:
				this.tipo = "Motor";
				break;

			case 4:
				this.tipo = "Cambio";
				break;

			case 5:
				this.tipo = "Funilaria";
				break;

			case 6:
				this.tipo = "Acessorio";
				break;

			default:
				throw new IllegalArgumentException("O produto não pode ser desse tipo");
		}
		// if (tipo == 1) {
		// this.tipo = "Suspensão";
		// } else if (tipo == 2) {
		// this.tipo = "Freio";
		// } else if (tipo == 3) {
		// this.tipo = "Motor";
		// }
		// else {
		// throw new IllegalArgumentException("O produto não pode ser desse tipo");
		// }
	}

	public String getNome() {
		return nome;
	}

	public String getDesc() {
		return desc;
	}

	public int getQtd() {
		return qtd;
	}

	public double getValor() {
		return valor;
	}

	public String getTipo() {
		return tipo;
	}

	public boolean gravaNoArquivo() {
		try {
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);

			String qtdStr = qtd + "";

			bw.write(nome);
			bw.write(separador);
			bw.write(desc);
			bw.write(separador);
			bw.write(qtdStr);
			bw.write(separador);
			bw.write(Double.toString(valor));
			bw.write(separador);
			bw.write(tipo);
			bw.newLine();

			bw.close();
			fw.close();

			return true;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void leDoArquivo() {
		try {
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);

			while (br.ready()) {
				String linha = br.readLine();
				// System.out.println(linha);
				String[] dados = linha.split(separador);

				if (dados.length == 7) {
					String tipoProduto = dados[5];
					if (tipoProduto.equalsIgnoreCase("f")) {
						System.out.println("\n[Nome: " + dados[0] + " | Descrição: " + dados[1] + " | Quantidade: "
								+ dados[2] + " | Valor: " + dados[3] + " | Tipo: " + dados[4] + " | Peso: " + dados[6]
								+ "]");
					} else if (tipoProduto.equalsIgnoreCase("l")) {
						System.out.println("\n[Nome: " + dados[0] + " | Descrição: " + dados[1] + " | Quantidade: "
								+ dados[2] + " | Valor: " + dados[3] + " | Tipo: " + dados[4] + " | Volume: " + dados[6]
								+ "]");
					}
				}
			}

			br.close();
			fr.close();

		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo.");
		}

	}

	public void lePorTipo(String tipoFiltro) {
		try {
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);

			while (br.ready()) {
				String linha = br.readLine();
				String[] dados = linha.split(separador);

				if (dados.length == 7 && dados[4].equalsIgnoreCase(tipoFiltro)) {
					String tipoProduto = dados[5];

					if (tipoProduto.equalsIgnoreCase("f")) {
						System.out.println("\n[Nome: " + dados[0] + " | Descrição: " + dados[1] + " | Quantidade: "
								+ dados[2] + " | Valor: " + dados[3] + " | Tipo: " + dados[4] + " | Peso: " + dados[6]
								+ " g]");
					} else if (tipoProduto.equalsIgnoreCase("l")) {
						System.out.println("\n[Nome: " + dados[0] + " | Descrição: " + dados[1] + " | Quantidade: "
								+ dados[2] + " | Valor: " + dados[3] + " | Tipo: " + dados[4] + " | Volume: " + dados[6]
								+ " ml]");
					}
				}
			}

			br.close();
			fr.close();

		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo.");
		}
	}

}