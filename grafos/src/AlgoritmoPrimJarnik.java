import java.util.ArrayList;
import java.util.HashMap;

public class AlgoritmoPrimJarnik {
	public static double VALOR_RAIZ = 0.0;
	public static int PRIMEIRO_DA_LISTA = 0;

	private Grafo grafo;
	private Vertice raiz;

	private HashMap<Vertice, Double> distanciasAtribuidas = new HashMap<>();
	private HashMap<Vertice, Vertice> verticesAnteriores = new HashMap<>();

	// Vertices que faltam se passar como raiz.
	private ArrayList<Vertice> q = new ArrayList<>();

	private double custo = 0.0;

	public AlgoritmoPrimJarnik(Grafo grafo, String raiz) {
		this(grafo, grafo.buscarVerticePorNome(raiz));
	}

	public AlgoritmoPrimJarnik(Grafo grafo, Vertice raiz) {
		this.grafo = grafo;
		this.setRaiz(raiz);

		grafo.ordernarVertices();

		q.addAll(grafo.getVertices());

		// Inicializa o hashmap com os vertices.
		for (Vertice v : grafo.getVertices()) {
			distanciasAtribuidas.put(v, Double.POSITIVE_INFINITY);
			verticesAnteriores.put(v, null);
		}

		atualizarDistancia(raiz, VALOR_RAIZ);
	}

	public void imprimirArvoreGeradoraMinima() {
		calcularDistancias();

		StringBuilder txt = new StringBuilder();

		txt.append("Prim-Jarnik\n");
		txt.append("Árvore geradora mínima:\n");
		txt.append("Arestas: ");

		for (Aresta a : getArestasArvoreGeradoraMinima()) {
			txt.append("(");
			txt.append(a);
			txt.append(")");
		}

		txt.append("\nCusto: ");
		txt.append(custo);

		System.out.println(txt);
		System.out.println();
	}

	public void calcularDistancias() {

		while (!q.isEmpty()) {
			Vertice origem = q.get(PRIMEIRO_DA_LISTA);
			q.remove(origem);

			for (Vertice adjacente : origem.getAdjacentes()) {

				if (!q.contains(adjacente))
					continue;

				Double distanciaEntreOA = distanciaEntre(origem, adjacente);

				if (distanciaEntreOA < distanciasAtribuidas.get(adjacente)) {

					atualizarDistancia(adjacente, distanciaEntreOA);
					atualizarAnterior(adjacente, origem);

				}
			}
		}
	}

	public ArrayList<Aresta> getArestasArvoreGeradoraMinima() {
		ArrayList<Aresta> arestas = new ArrayList<>();

		for (Vertice v : grafo.getVertices()) {
			Vertice pai = verticesAnteriores.get(v);

			Aresta a = grafo.buscarArestaCorrespondente(pai, v);

			if (a == null)
				continue;

			arestas.add(a);

			custo += a.getValor();
		}
		return arestas;
	}

	/**
	 * Retorna o valor da aresta AB que é a distância de A até B. Se não existir
	 * caminho retornará POSITIVE_INFINITY.
	 * 
	 * @param verticeA
	 * @param verticeB
	 * @return
	 */
	public Double distanciaEntre(Vertice verticeA, Vertice verticeB) {
		Aresta a = grafo.buscarArestaCorrespondente(verticeA, verticeB);
		return a != null ? a.getValor() : Double.POSITIVE_INFINITY;
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
