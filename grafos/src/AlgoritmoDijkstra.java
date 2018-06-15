import java.util.ArrayList;
import java.util.HashMap;

public class AlgoritmoDijkstra {

	public static double VALOR_RAIZ = 0.0;
	public static int PRIMEIRO_DA_LISTA = 0;

	private Grafo grafo;
	private Vertice raiz;

	private HashMap<Vertice, Double> distanciasAtribuidas = new HashMap<>();
	private HashMap<Vertice, Vertice> verticesAnteriores = new HashMap<>();

	// Vertices que faltam se passar como raiz.
	private ArrayList<Vertice> q = new ArrayList<>();

	public AlgoritmoDijkstra(Grafo grafo, String raiz) {
		this(grafo, grafo.buscarVerticePorNome(raiz));
	}

	public AlgoritmoDijkstra(Grafo grafo, Vertice raiz) {
		this.grafo = grafo;
		this.setRaiz(raiz);
		q.addAll(grafo.getVertices());

		// Inicializa o hashmap com os vertices.
		for (Vertice v : grafo.getVertices()) {
			distanciasAtribuidas.put(v, Double.POSITIVE_INFINITY);
			verticesAnteriores.put(v, null);
		}

		atualizarDistancia(raiz, VALOR_RAIZ);
	}

	public void imprimirTabelaDistanciaCaminho() {
		calcularDistancias();

		StringBuilder tabela = new StringBuilder();
		tabela.append("Dijkstra\n");
		tabela.append("Tabela de caminho mínimo:\n");

		tabela.append("Nome - Perm - Dist - Path");

		for (Vertice v : grafo.getVertices()) {
			tabela.append("\n");
			tabela.append(v.getNome());
			tabela.append(" - ");
			tabela.append(!q.contains(v));
			tabela.append(" - ");
			tabela.append(distanciasAtribuidas.get(v));
			tabela.append(" - ");
			tabela.append(verticesAnteriores.get(v));
		}

		System.out.println(tabela);
		System.out.println();
	}

	public void calcularDistancias() {

		while (!q.isEmpty()) {
			Vertice origem = buscarVerticeComMenorDistancia(q);
			q.remove(origem);

			for (Vertice adjacente : origem.getAdjacentes()) {

				Double distanciaEntreOA = distanciaEntre(origem, adjacente);

				Double distancia = distanciasAtribuidas.get(origem) + distanciaEntreOA;

				if (distancia < distanciasAtribuidas.get(adjacente)) {

					atualizarDistancia(adjacente, distancia);
					atualizarAnterior(adjacente, origem);

				}
			}
		}
	}

	public Double distanciaEntre(Vertice verticeA, Vertice verticeB) {
		Aresta a = grafo.buscarArestaCorrespondente(verticeA, verticeB);
		return a != null ? a.getValor() : Double.POSITIVE_INFINITY;
	}

	public Vertice buscarVerticeComMenorDistancia(ArrayList<Vertice> vertices) {
		if (vertices.isEmpty()) {
			return null;
		}

		Vertice verticeComMenorDistancia = vertices.get(PRIMEIRO_DA_LISTA);

		Double menorValor = distanciasAtribuidas.get(verticeComMenorDistancia);

		for (Vertice v : vertices) {
			Double valorAtual = distanciasAtribuidas.get(v);

			if (valorAtual < menorValor) {
				menorValor = valorAtual;
				verticeComMenorDistancia = v;
			}
		}

		return verticeComMenorDistancia;
	}

	/**
	 * Informa ao vertice A que o anterior mais próximo dele é o B.
	 * 
	 * @param atual
	 *            = Vértice A
	 * @param anterior
	 *            = Vértice B
	 */
	public void atualizarAnterior(Vertice atual, Vertice anterior) {
		verticesAnteriores.replace(atual, anterior);
	}

	/**
	 * Atuliza o peso do vértice V que é a distancia de do vértice U até V.
	 * 
	 * @param v
	 * @param valor
	 */
	public void atualizarDistancia(Vertice v, Double valor) {
		distanciasAtribuidas.replace(v, valor);
	}

	public Vertice getRaiz() {
		return raiz;
	}

	public void setRaiz(Vertice raiz) {
		this.raiz = raiz;
	}

}
