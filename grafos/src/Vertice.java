import java.util.ArrayList;

public class Vertice {

    private String nome = "";
    private ArrayList<Vertice> adjacentes = new ArrayList<>();

    public Vertice() {

    }

    public int getGrau() {
	return adjacentes.size();
    }

    public Vertice clone() {
	Vertice v = new Vertice();
	v.setNome(nome);
	v.getAdjacentes().addAll(adjacentes);

	return v;
    }

    public Vertice(String nome) {
	this.nome = nome;
    }

    public String toString() {
	return nome;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public ArrayList<Vertice> getAdjacentes() {
	return adjacentes;
    }

    public void setAdjacentes(ArrayList<Vertice> adjacentes) {
	this.adjacentes = adjacentes;
    }
}
