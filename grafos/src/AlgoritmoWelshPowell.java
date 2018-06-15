import java.util.ArrayList;
import java.util.HashMap;

public class AlgoritmoWelshPowell {
	public static int PRIMEIRO_DA_LISTA = 0;

	private Grafo grafo;

	// Vertices ordenados pelo grau.
	private ArrayList<Vertice> q = new ArrayList<>();

	private ArrayList<Integer> cores = new ArrayList<>();

	private HashMap<Vertice, Integer> verticesColoridos = new HashMap<>();

	public AlgoritmoWelshPowell(Grafo grafo) {
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

		nCromatico.append("Welsh-Powell Modificado:\n");

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
		nCromatico.append("Número cromático = ");
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

			// Todos menos U menos os adjacentes é igual a todos que não são adjacentes a U:
			ArrayList<Vertice> naoAdjacentes = new ArrayList<>();
			naoAdjacentes.addAll(q);
			naoAdjacentes.remove(u);
			naoAdjacentes.removeAll(u.getAdjacentes());

			ArrayList<Vertice> pintados = new ArrayList<>();
			for (Vertice p : naoAdjacentes) {
				if (verticesColoridos.get(p) != null) {
					pintados.add(p);
				}
			}

			// Não pode pintar os não-adjacentes que já foram definidos
			naoAdjacentes.removeAll(pintados);

			// Pintar somente os adjacentes que ainda não foram definidos
			for (Vertice v : naoAdjacentes) {
				atualizarCorDoVertice(v, proximaCor);
			}

			qb.removeAll(naoAdjacentes);
		}
	}

	public int getProximaCorDisponivel(Vertice v) {

		ArrayList<Integer> coresUsadas = new ArrayList<>();

		// ArrayList<Vertice> adjacentesFiltrados = new ArrayList<>();
		//
		// // Adiciona todos
		// adjacentesFiltrados.addAll(q);
		//
		// // Todos menos o que não foi pintado = O que já foi pintado
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

}
