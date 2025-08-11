package listas;

import modelos.Colaborador;

public class ListaEvolucao {

    private class NO {
        Colaborador colaborador;
        ListaEvolucao.NO prox;
    }

    ListaEvolucao.NO lista = null;

    public boolean isEmpty() {
        return (lista == null);
    }

    public void add(Colaborador colaboradorASerAdicionado) {
        ListaEvolucao.NO novo = new ListaEvolucao.NO();
        novo.colaborador = colaboradorASerAdicionado;
        if (isEmpty()) {
            lista = novo;
            novo.prox = null;
        } else if (novo.colaborador.getNota() < lista.colaborador.getNota()) {
            novo.prox = lista;
            lista = novo;
        } else if (novo.colaborador.getNota() == lista.colaborador.getNota()) {
            if (novo.colaborador.getID() < lista.colaborador.getID()) {
                novo.prox = lista;
                lista = novo;
            } else {
                lista.prox = novo;
                novo = lista;
            }
        } else {
            ListaEvolucao.NO aux = lista;
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
        ListaEvolucao.NO aux = lista;
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
                ListaEvolucao.NO aux = lista;
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


}
