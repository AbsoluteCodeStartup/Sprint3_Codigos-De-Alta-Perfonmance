package aplicacao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import listas.ListaCrescenteInt;

public class Onboarding {
	public static Scanner le = new Scanner(System.in);

	public static void main(String[] args) {

		Scanner le =new Scanner(System.in);
		geraLista();

		

		int opcao;
		do {
			System.out.println("0 - Encerrar atendimento");
			System.out.println("1 - Obter colaboradores com piores notas presentes na lista");
			System.out.println("2 - Atualizar nota de um colaborador");
			System.out.println("3 - Inserir novo colaborador");
			System.out.println("Opcao: ");
			opcao = le.nextInt();
			switch (opcao) {
			case 0:
				break;
			case 1:
				break;
			case 2:
				break;
			default:
				System.out.println("Opcao Invalida");
			}

		} while (opcao != 0);

		le.close();

	}

	public static void geraLista(/*ListaEvolucao lista*/) {
/*Altere esse metodo para inserir um objeto da classe Colaborador na lista*/
		String caminhoDoArquivo = "src/arquivos/Colaboradores.txt";
		
		try {
			// Criar um objeto File com o caminho do arquivo
			File arquivo = new File(caminhoDoArquivo);

			// Criar um Scanner para ler o arquivo
			Scanner leArq = new Scanner(arquivo);

			// Loop para ler linha por linha até o final do arquivo
			while (leArq.hasNextLine()) {
				// Ler a próxima linha
				String linha = leArq.nextLine();
				System.out.println(linha);
				String[] partes = linha.split(";");
				int id = Integer.parseInt(partes[0]);
				String nome = partes[1];
				String setor = partes[2];
				String buddy = partes[3];
				int nota = Integer.parseInt(partes[4]);
			}
			// Fechar o objeto da classe Scanner le
			leArq.close();
		} catch (FileNotFoundException e) {
			// Caso o arquivo não seja encontrado
			System.out.println("Arquivo não encontrado: " + e.getMessage());
		}
	}

	
}
