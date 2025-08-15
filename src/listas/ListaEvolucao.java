package listas;

import modelos.Colaborador;

public class ListaEvolucao {

    private class NO {
        Colaborador colaborador;
        NO prox;
    }

    NO lista = null;

    public boolean isEmpty() {
        return (lista == null);
    }

    public void add(Colaborador colaboradorASerAdicionado) {
        NO novo = new NO();
        novo.colaborador = colaboradorASerAdicionado;
        novo.prox = null;

        if (isEmpty()) {
            lista = novo;
        } else if (colaboradorASerAdicionado.getNota() == -1) {
            // Colaboradores que sao adicionados ficarao no final da lista, a fim de facilitar na listagem final e para organizacao.
            NO aux = lista;
            while (aux.prox != null) {
                aux = aux.prox;
            }
            aux.prox = novo;
        } else if (novo.colaborador.getNota() < lista.colaborador.getNota()) {
            novo.prox = lista;
            lista = novo;
        } else if (novo.colaborador.getNota() == lista.colaborador.getNota()) {
            if (novo.colaborador.getID() < lista.colaborador.getID()) {
                novo.prox = lista;
                lista = novo;
            } else {
                novo.prox = lista.prox;
                lista.prox = novo;
            }
        } else {
            NO aux = lista;
            boolean achou = false;
            while (aux.prox != null && !achou) {
                if (aux.prox.colaborador.getNota() < novo.colaborador.getNota())
                    aux = aux.prox;
                else
                    achou = true;
            }
            novo.prox = aux.prox;
            aux.prox = novo;
        }
    }

    public void show() {
        NO aux = lista;
        System.out.println("*********** Lista ************");
        while (aux != null) {
            System.out.print(aux.colaborador + "\t");
            aux = aux.prox;
        }
        System.out.println();
    }

    public boolean remove(int id) {
        boolean achou = false;
        if (!isEmpty()) {
            if (id == lista.colaborador.getID()) {
                achou = true;
                lista = lista.prox;
            } else {
                NO aux = lista;
                while (aux.prox != null && !achou) {
                    if (id == aux.prox.colaborador.getID())
                        achou = true;
                    else
                        aux = aux.prox;
                }
                if (achou)
                    aux.prox = aux.prox.prox;
            }
        }
        return achou;
    }

    public Colaborador[] getColaborador(int quantidadeDeVezes) {
        NO aux = lista;
        Colaborador[] colaboradores = new Colaborador[quantidadeDeVezes];
        for (int i = 0; i < quantidadeDeVezes; i++) {
            if (aux.colaborador.getNota() == -1) {
                i++;
            }
            colaboradores[i] = aux.colaborador;
            aux = aux.prox;
        }
        return colaboradores;
    }

    public int tamanho() {
        NO aux = lista;
        int tamanho = 0;
        while (aux.prox != null) {
            tamanho++;
            aux = aux.prox;
        }
        return tamanho;
    }

}
