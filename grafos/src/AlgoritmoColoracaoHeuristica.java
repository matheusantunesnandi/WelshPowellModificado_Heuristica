import java.util.ArrayList;
import java.util.HashMap;

public class AlgoritmoColoracaoHeuristica {
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

		nCromatico.append("Welsh-Powell Modificado para heur�stica:\n");

		ArrayList<Vertice> vertices = new ArrayList<>();
		vertices.addAll(q);

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
		nCromatico.append("N�mero crom�tico = ");
		nCromatico.append(cores.size());

		System.out.println(nCromatico);
		System.out.println();
	}

	public void colorir() {

		ArrayList<Vertice> qb = new ArrayList<>();
		qb.addAll(q);

		while (!qb.isEmpty()) {
			Vertice u = qb.get(PRIMEIRO_DA_LISTA);
			qb.remove(u);

			Integer proximaCor = getProximaCorDisponivel(u);

			atualizarCorDoVertice(u, proximaCor);

			// Todos menos o que fala � igual o que j� foi:
			ArrayList<Vertice> verticesDefinidos = new ArrayList<>();
			verticesDefinidos.addAll(q);
			verticesDefinidos.removeAll(qb);

			ArrayList<Vertice> adjacentesFiltrados = new ArrayList<>();
			adjacentesFiltrados.addAll(u.getAdjacentes());
			adjacentesFiltrados.removeAll(verticesDefinidos);

			// Pintar somente os adjacentes que ainda n�o foram definidos
			for (Vertice v : adjacentesFiltrados) {
				// TODO Parte desnecess�ria?
				atualizarCorDoVertice(v, proximaCor);
			}
		}
	}

	public int getProximaCorDisponivel(Vertice v) {

		ArrayList<Integer> coresUsadas = new ArrayList<>();

		// ArrayList<Vertice> adjacentesFiltrados = new ArrayList<>();
		//
		// // Adiciona todos
		// adjacentesFiltrados.addAll(q);
		//
		// // Todos menos o que n�o foi pintado = O que j� foi pintado
		// adjacentesFiltrados.removeAll(verticesNaoDefinidos);

		for (Vertice u : v.getAdjacentes()) {

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

	public Grafo getGrafo() {
		return grafo;
	}

	public void setGrafo(Grafo grafo) {
		this.grafo = grafo;
	}
}
