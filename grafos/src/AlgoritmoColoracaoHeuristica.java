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

		// TODO Corrigir a ordenação de algum modo. Observando no desenho, a ordem
		// deveria ser: a || d, b || c, s || t
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

//			for (Vertice vertice : u.getAdjacentes()) {
//				atualizarCorDoVertice(u, proximaCor);
//			}
		}
	}

	public int getProximaCorDisponivel(Vertice v) {

		ArrayList<Integer> coresUsadas = new ArrayList<>();

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
