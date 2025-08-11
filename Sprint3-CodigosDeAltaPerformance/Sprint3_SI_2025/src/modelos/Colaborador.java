package modelos;

public class Colaborador {
    private int ID;
    private String nome;
    private String setor;
    private String buddy;
    private int nota;

    public Colaborador(int ID, String nome, String setor, String buddy, int nota) {
        this.ID = ID;
        this.nome = nome;
        this.setor = setor;
        this.buddy = buddy;
        this.nota = nota;
    }

    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getSetor() {
        return setor;
    }

    public String getBuddy() {
        return buddy;
    }

    public int getNota() {
        return nota;
    }




    @Override
    public String toString() {
        return "Colaborador{" +
                "ID=" + ID +
                ", nome='" + nome + '\'' +
                ", setor='" + setor + '\'' +
                ", buddy='" + buddy + '\'' +
                ", nota=" + nota +
                '}';
    }
}
