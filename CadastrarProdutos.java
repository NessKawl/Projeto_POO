import java.util.Scanner;

public class CadastrarProdutos {
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		Scanner leiaStr = new Scanner(System.in);

		int opcao, qtd, tipo, qtdProduto = 0;
		double valor, volume, peso;
		String nome, desc, tipoProduto, tipoFiltroStr = "";

		Produto produtos[] = new Produto[10];
		Produto produto = new Produto();

		do {

			try {
				menu();
				opcao = leia.nextInt();

			} catch (Exception e) {
				System.out.println("\n\tValor inválido! Tente Novamente");
				leia.nextLine();
				opcao = -1;
				continue;
			}

			switch (opcao) {

				case 1:
					try {
						System.out.print("\nNome: ");
						nome = leiaStr.nextLine();

						System.out.print("\nDescricao: ");
						desc = leiaStr.nextLine();

						System.out.print("\nQuantidade: ");
						qtd = leia.nextInt();

						System.out.print("\nValor: ");
						valor = leia.nextDouble();

						System.out.print(
								"\nSelecione o tipo do produto [1- Suspensão | 2- Freio | 3- Motor | 4- Cambio | 5- Funilaria | 6- Acessório ]: ");
						tipo = leia.nextInt();

						System.out.print("\nProduto físico ou líquido [f/l]? ");
						tipoProduto = leiaStr.nextLine();

						if (tipoProduto.equalsIgnoreCase("f")) {

							System.out.print("\nQual o peso do produto em gramas?: ");
							peso = leia.nextDouble();

							produtos[qtdProduto++] = new Fisico(nome, desc, qtd, valor, tipo, peso);

						} else if (tipoProduto.equalsIgnoreCase("l")) {

							System.out.print("\nQual o volume do produto em ml?: ");
							volume = leia.nextDouble();

							produtos[qtdProduto++] = new Liquido(nome, desc, qtd, valor, tipo, volume);
						} else {
							throw new IllegalArgumentException("Opção Inválida. Tente Novamente");
						}

						if (produtos[qtdProduto - 1].gravaNoArquivo()) {
							System.out.println("\n\tARQUIVOS GRAVADOS COM SUCESSO!");
						} else {
							System.out.println("\n\tERRO AO GRAVAR ARQUIVOS!");
						}

					} catch (IllegalArgumentException iae) {
						System.out.println("\n\tErro!!! - " + iae.getMessage());
					} catch (Exception e) {
						System.out.println("\n\tErro!!! - " + e.getMessage());
					}

					break;

				case 2:
					/*
					 * for (int atual = 0; atual < qtdProduto; atual++) {
					 * System.out.println( produtos[atual].toString() );
					 * System.out.println("= = = = = = = = = = = = = = = =");
					 * }
					 */
					System.out.println("\nLista de Produtos:");
					produto.leDoArquivo();

					break;

				case 3:
					System.out.print(
							"\nDigite o tipo de produto que deseja exibir [1- Suspensão | 2- Freio | 3- Motor | 4- Cambio | 5- Funilaria | 6- Acessório ]: ");
					int tipoFiltro = leia.nextInt();

					switch (tipoFiltro) {
						case 1:
							tipoFiltroStr = "Suspensao";
							break;

						case 2:
							tipoFiltroStr = "Freio";
							break;

						case 3:
							tipoFiltroStr = "Motor";
							break;

						case 4:
							tipoFiltroStr = "Cambio";
							break;

						case 5:
							tipoFiltroStr = "Funilaria";
							break;

						case 6:
							tipoFiltroStr = "Acessorio";
							break;

						default:
							throw new IllegalArgumentException("O produto não pode ser desse tipo");
					}

					System.out.println("\nProdutos do tipo: " + tipoFiltro);
					produto.lePorTipo(tipoFiltroStr);

					break;

				case 4:
					System.out.println("\n\tFIM DO PROGRAMA!");
					break;

				default:
					System.out.println("\n\tOpção Inválida!!");
			}
		} while (opcao != 4);

		leia.close();
		leiaStr.close();
	}

	static void menu() {
		System.out.println("\n======= M E N U =======");
		System.out.println("1) Cadastrar produto");
		System.out.println("2) Mostrar todos os produtos");
		System.out.println("3) Mostrar os produtos por categoria");
		System.out.println("4) Sair");
		System.out.print("Opção >>> ");
	}
}