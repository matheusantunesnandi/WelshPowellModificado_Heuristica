package algoritmo;

import java.util.ArrayList;
import java.util.HashMap;

import grafo.Aresta;
import grafo.Grafo;
import grafo.Vertice;

public class AlgoritmoWelshPowell {
	public static int PRIMEIRO_DA_LISTA = 0;

	private Grafo grafo;

	// Vertices ordenados pelo grau.
	private ArrayList<Vertice> q = new ArrayList<>();

	private ArrayList<Integer> cores = new ArrayList<>();

	private HashMap<Vertice, Integer> verticesColoridos = new HashMap<>();

	public AlgoritmoWelshPowell(Grafo grafo) {
		this.setGrafo(grafo);

		q.addAll(grafo.getVertices());

		grafo.ordernarVerticesPorGrauDecrescente(q);

		for (Vertice v : q) {
			verticesColoridos.put(v, null);
		}
	}

	public void imprimirNumeroCromatico() {

		colorir();

		StringBuilder txt = new StringBuilder();

		txt.append("Algoritmo de Welsh-Powell:\n");

		appendVertices(txt);

		appendArestas(txt);

		txt.append("N�mero crom�tico = ");
		txt.append(cores.size());

		System.out.println(txt);
		System.out.println();
	}

	private void appendVertices(StringBuilder txt) {
		ArrayList<Vertice> vertices = new ArrayList<>();
		vertices.addAll(q);

		Vertice z = vertices.get(PRIMEIRO_DA_LISTA);
		vertices.remove(z);
		txt.append("Vertices: \n");
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
	}

	private void appendArestas(StringBuilder txt) {
		ArrayList<Aresta> arestas = grafo.getArestas();

		Aresta a = arestas.get(PRIMEIRO_DA_LISTA);
		arestas.remove(a);
		txt.append("Arestas:\n");
		txt.append(a);

		for (Aresta e : arestas) {
			txt.append(", ");
			txt.append(e);
		}

		txt.append("\n");
	}

	public void colorir() {

		ArrayList<Vertice> qb = new ArrayList<>();
		qb.addAll(q);

		while (!qb.isEmpty()) {
			Vertice u = qb.get(PRIMEIRO_DA_LISTA);
			qb.remove(u);

			Integer proximaCor = getProximaCorDisponivel(u);

			atualizarCorDoVertice(u, proximaCor);

			// Todos menos U menos os adjacentes � igual a todos que n�o s�o adjacentes a U:
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

			// N�o pode pintar os n�o-adjacentes que j� foram definidos
			naoAdjacentes.removeAll(pintados);

			// Pintar somente os adjacentes que ainda n�o foram definidos
			for (Vertice v : naoAdjacentes) {
				atualizarCorDoVertice(v, proximaCor);
			}

			qb.removeAll(naoAdjacentes);
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

	public Grafo getGrafo() {
		return grafo;
	}

	public void setGrafo(Grafo grafo) {
		this.grafo = grafo;
	}

}
