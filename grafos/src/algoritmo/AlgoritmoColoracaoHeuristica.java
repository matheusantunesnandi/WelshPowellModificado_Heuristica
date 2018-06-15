package algoritmo;
import java.util.ArrayList;
import java.util.HashMap;

import grafo.Grafo;
import grafo.Vertice;

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

		StringBuilder txt = new StringBuilder();

		txt.append("Welsh-Powell Modificado para heurística:\n");

		ArrayList<Vertice> vertices = new ArrayList<>();
		vertices.addAll(q);

		Vertice z = vertices.get(PRIMEIRO_DA_LISTA);
		vertices.remove(z);
		txt.append(z.getNome());
		txt.append("-");
		txt.append(verticesColoridos.get(z));

		for (Vertice u : vertices) {
			txt.append(", ");
			txt.append(u.getNome());
			txt.append("-");
			txt.append(verticesColoridos.get(u));
		}

		txt.append("\n");
		txt.append("Número cromático = ");
		txt.append(cores.size());

		System.out.println(txt);
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

			// Todos menos o que fala é igual o que já foi:
			ArrayList<Vertice> verticesDefinidos = new ArrayList<>();
			verticesDefinidos.addAll(q);
			verticesDefinidos.removeAll(qb);

			ArrayList<Vertice> adjacentesFiltrados = new ArrayList<>();
			adjacentesFiltrados.addAll(u.getAdjacentes());
			adjacentesFiltrados.removeAll(verticesDefinidos);

			// Pintar somente os adjacentes que ainda não foram definidos
			for (Vertice v : adjacentesFiltrados) {
				// TODO Parte desnecessária?
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

	public Grafo getGrafo() {
		return grafo;
	}

	public void setGrafo(Grafo grafo) {
		this.grafo = grafo;
	}
}
