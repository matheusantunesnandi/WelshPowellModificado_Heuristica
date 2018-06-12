import java.util.ArrayList;
import java.util.HashMap;

public class AlgoritmoWelshPowellModificado {

    // public static double VALOR_RAIZ = 0.0;
    public static int PRIMEIRO_DA_LISTA = 0;

    private Grafo grafo;

    // Vertices ordenados pelo grau.
    private ArrayList<Vertice> q = new ArrayList<>();

    private ArrayList<Integer> cores = new ArrayList<>();

    private HashMap<Vertice, Integer> verticesColoridos = new HashMap<>();

    public AlgoritmoWelshPowellModificado(Grafo grafo) {
	this.grafo = grafo;

	grafo.ordernarVerticesPorGrau(q);

	for (Vertice v : q) {
	    verticesColoridos.put(v, null);
	}
    }

    public void colorir() {

	Vertice u = q.get(PRIMEIRO_DA_LISTA);
	q.remove(u);

	Integer proximaCor = getProximaCorDisponivel(u);

	atualizarCorDoVertice(u, proximaCor);

	for (Vertice v : u.getAdjacentes()) {
	    atualizarCorDoVertice(v, proximaCor);
	}

    }

    public int getProximaCorDisponivel(Vertice v) {

	if (cores.isEmpty()) {
	    cores.add(0);
	    return 0;
	}

	for (Vertice u : v.getAdjacentes()) {

	}
    }

    public void atualizarCorDoVertice(Vertice v, Integer cor) {
	verticesColoridos.replace(v, cor);
    }

}
