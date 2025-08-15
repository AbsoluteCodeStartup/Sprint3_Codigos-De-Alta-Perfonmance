package aplicacao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import listas.ListaCrescenteInt;
import listas.ListaEvolucao;
import modelos.Colaborador;

public class Onboarding {
    public static Scanner le = new Scanner(System.in);

    public static void main(String[] args) {
        ListaEvolucao lista = new ListaEvolucao();
        Scanner le = new Scanner(System.in);
        geraLista(lista);

        int opcao;
        do {
            System.out.println("0 - Encerrar atendimento");
            System.out.println("1 - Obter colaboradores com piores notas presentes na lista");
            System.out.println("2 - Atualizar nota de um colaborador");
            System.out.println("3 - Inserir novo colaborador");
            System.out.print("Opcao: ");
            opcao = le.nextInt();
            switch (opcao) {
                case 0:
                    listarColaboradores(lista);
                    break;
                case 1:
                    obterPioresNotasNaLista(lista);
                    break;
                case 2:
                    atualizarNotaColaborador(lista);
                    break;
                case 3:
                    inserirNovoColaborador(lista);
                    break;
                default:
                    System.out.println("Opcao Invalida");
            }

        } while (opcao != 0);

        le.close();

    }
    private static void listarColaboradores(ListaEvolucao lista) {
        lista.show();
    }

    private static void obterPioresNotasNaLista(ListaEvolucao lista) {
        System.out.print("Quantas notas deseja pegar da lista?: ");
        int quantidadeDeNotas = le.nextInt();
        while (quantidadeDeNotas > lista.tamanho()) {
            System.out.print("Quantidade desejada maior que a lista, por favor insira um número menor: ");
            quantidadeDeNotas = le.nextInt();
        }
        Colaborador[] colaboradores = lista.getColaboradores(quantidadeDeNotas);

        System.out.println("----------Colaboradores com piores notas----------");
        for (int i = 0; i < quantidadeDeNotas; i++) {
            System.out.println("ID: " + colaboradores[i].getID() + " | Nome: " + colaboradores[i].getNome() + " | Nota: " + colaboradores[i].getNota());
        }
        System.out.println("--------------------------------------------------\n\n");

    }

    private static void atualizarNotaColaborador(ListaEvolucao lista) {
        System.out.print("Digite o ID do colaborador que deseja atualizar a nota: ");
        int id = le.nextInt();
        Colaborador colaborador = lista.getColaborador(id);
        lista.remove(id);
        if (colaborador != null) {
            System.out.println("Escreva a nota que deseja inserir: ");
            int nota = le.nextInt();
            while (nota < 0 || nota > 100) {
                System.out.println("******Nota inválida. Por favor, tente novamente!******\n");
                System.out.print("Escreva a nota que deseja inserir: ");
                nota = le.nextInt();
            }

            colaborador.setNota(nota);
            lista.add(colaborador);
            System.out.println("Nota atualizada com sucesso!\n");
        }


    }

    private static void inserirNovoColaborador(ListaEvolucao lista) {
        System.out.print("ID: ");
        int id = le.nextInt();
        System.out.print("Nome: ");
        String nome = le.next();
        System.out.print("Setor: ");
        String setor = le.next();
        System.out.print("Buddy: ");
        String buddy = le.next();
        lista.add(new Colaborador(id, nome, setor, buddy, -1));
        System.out.println("Colaborador adicionado com sucesso!");
    }

    public static void geraLista(ListaEvolucao lista) {
        /*Altere esse metodo para inserir um objeto da classe Colaborador na lista*/
        String caminhoDoArquivo = "src/arquivos/Colaboradores.txt";

        try {
            // Criar um objeto File com o caminho do arquivo
            File arquivo = new File(caminhoDoArquivo);

            // Criar um Scanner para ler o arquivo
            Scanner leArq = new Scanner(arquivo);

            // Loop para ler linha por linha at� o final do arquivo
            while (leArq.hasNextLine()) {
                // Ler a pr�xima linha
                String linha = leArq.nextLine();
                String[] partes = linha.split(";");
                int id = Integer.parseInt(partes[0]);
                String nome = partes[1];
                String setor = partes[2];
                String buddy = partes[3];
                int nota = Integer.parseInt(partes[4]);
                Colaborador colaborador = new Colaborador(id, nome, setor, buddy, nota);
                lista.add(colaborador);
            }
            // Fechar o objeto da classe Scanner le
            leArq.close();
        } catch (FileNotFoundException e) {
            // Caso o arquivo n�o seja encontrado
            System.out.println("Arquivo n�o encontrado: " + e.getMessage());
        }
    }


}
