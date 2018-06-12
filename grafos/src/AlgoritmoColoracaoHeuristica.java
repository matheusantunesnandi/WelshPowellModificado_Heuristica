import java.util.ArrayList;
import java.util.HashMap;

public class AlgoritmoColoracaoHeuristica {

    // public static double VALOR_RAIZ = 0.0;
    public static int PRIMEIRO_DA_LISTA = 0;

    private Grafo grafo;

    // Vertices ordenados pelo grau.
    private ArrayList<Vertice> q = new ArrayList<>();

    private ArrayList<Integer> cores = new ArrayList<>();

    private HashMap<Vertice, Integer> verticesColoridos = new HashMap<>();

    public AlgoritmoColoracaoHeuristica(Grafo grafo) {
	this.grafo = grafo;

	q.addAll(grafo.getVertices());

	grafo.ordernarVerticesPorGrau(q);

	for (Vertice v : q) {
	    verticesColoridos.put(v, null);
	}
    }

    public void imprimirNumeroCromatico() {

	colorir();

	StringBuilder nCromatico = new StringBuilder();

	nCromatico.append("Welsh-Powell Modificado para heurística:\n");

	ArrayList<Vertice> vertices = new ArrayList<>();
	vertices.addAll(grafo.getVertices());

	Vertice z = vertices.get(PRIMEIRO_DA_LISTA);
	vertices.remove(z);
	nCromatico.append(z.getNome());
	nCromatico.append("-");
	nCromatico.append(verticesColoridos.get(z));

	for (Vertice u : vertices) {
	    nCromatico.append(", ");
	    nCromatico.append(u.getNome());
	    nCromatico.append("-");
	    nCromatico.append(verticesColoridos.get(u));
	}

	nCromatico.append("\n");
	nCromatico.append("Número cromático = ");
	nCromatico.append(cores.size());

	System.out.println(nCromatico);
	System.out.println();
    }

    public void colorir() {

	while (!q.isEmpty()) {
	    Vertice u = q.get(PRIMEIRO_DA_LISTA);
	    q.remove(u);

	    Integer proximaCor = getProximaCorDisponivel(u);

	    atualizarCorDoVertice(u, proximaCor);

	    ArrayList<Vertice> adjacentesFiltrados = new ArrayList<>();
	    adjacentesFiltrados.addAll(u.getAdjacentes());

	    ArrayList<Vertice> verticesFiltrados = new ArrayList<>();
	    verticesFiltrados.addAll(grafo.getVertices());
	    verticesFiltrados.removeAll(q);

	    adjacentesFiltrados.removeAll(verticesFiltrados);

	    for (Vertice v : adjacentesFiltrados) {
		atualizarCorDoVertice(v, proximaCor);
	    }
	}
    }

    public int getProximaCorDisponivel(Vertice v) {

	ArrayList<Integer> coresUsadas = new ArrayList<>();

	ArrayList<Vertice> adjacentesFiltrados = new ArrayList<>();
	adjacentesFiltrados.addAll(v.getAdjacentes());
	adjacentesFiltrados.removeAll(q);

	for (Vertice u : adjacentesFiltrados) {

	    Integer cor = verticesColoridos.get(u);

	    if (cor != null) {
		coresUsadas.add(cor);
	    }

	}

	ArrayList<Integer> coresFiltradas = new ArrayList<>();
	coresFiltradas.addAll(cores);
	coresFiltradas.removeAll(coresUsadas);

	if (coresFiltradas.isEmpty()) {

	    Integer proximaCor = cores.size() + 1;

	    cores.add(proximaCor);
	    return proximaCor;
	}

	return coresFiltradas.get(PRIMEIRO_DA_LISTA);
    }

    public void atualizarCorDoVertice(Vertice v, Integer cor) {
	verticesColoridos.replace(v, cor);
    }

}
