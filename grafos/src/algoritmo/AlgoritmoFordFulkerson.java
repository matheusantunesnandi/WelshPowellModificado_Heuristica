package algoritmo;
import java.util.ArrayList;
import java.util.HashMap;

import grafo.Aresta;
import grafo.Grafo;
import grafo.Vertice;

/**
 * 
 */

/**
 * @author Matheus Antunes Nandi
 * @since 2018-06-04 15:54
 *
 */
public class AlgoritmoFordFulkerson {
	public static int PRIMEIRO_DA_LISTA = 0;

	Grafo grafo;
	private Vertice raiz;
	private Vertice destino;

	private HashMap<Aresta, Double> capacidade = new HashMap<>();
	private HashMap<Aresta, Double> fluxo = new HashMap<>();

	public AlgoritmoFordFulkerson(Grafo grafo, String raiz, String destino) {
		this(grafo, grafo.buscarVerticePorNome(raiz), grafo.buscarVerticePorNome(destino));
	}

	public AlgoritmoFordFulkerson(Grafo grafo, Vertice raiz, Vertice destino) {
		this.grafo = grafo;
		this.raiz = raiz;
		this.destino = destino;

		for (Aresta a : grafo.getArestas()) {
			capacidade.put(a, a.getValor());
			fluxo.put(a, 0.0);
		}
	}

	public boolean isExistenteCaminhoAumentante() {
		return !buscarProximoCaminho().isEmpty();
	}

	public ArrayList<Vertice> buscarProximoCaminho() {
		return buscarProximoCaminho(raiz, new ArrayList<>());
	}

	public ArrayList<Vertice> buscarProximoCaminho(Vertice u, ArrayList<Vertice> proximoCaminho) {

		if (proximoCaminho.contains(destino)) {
			return proximoCaminho;
		}

		proximoCaminho.add(u);

		for (Vertice v : getAdjacentesCapacitados(u)) {
			buscarProximoCaminho(v, proximoCaminho);
		}

		return proximoCaminho;
	}

	public ArrayList<Vertice> getAdjacentesCapacitados(Vertice u) {

		ArrayList<Vertice> capacitados = new ArrayList<>();

		for (Vertice v : u.getAdjacentes()) {
			Aresta a = grafo.buscarArestaCorrespondente(u, v);

			if (fluxo.get(a) >= 0.0 && fluxo.get(a) < capacidade.get(a)) {
				capacitados.add(v);
			}
		}

		return capacitados;
	}

	public double getCapacidadeResidual(Aresta a) {
		return capacidade.get(a) - fluxo.get(a);
	}

	public double getValorFluxoMaximo() {
		// Fluxo máximo
		double fm = 0.0;

		while (isExistenteCaminhoAumentante()) {
			double min = 0.0;

			ArrayList<Vertice> caminho = buscarProximoCaminho();

			for (int i = 0; i < caminho.size(); i++) {

				if ((i + 1) >= caminho.size()) {
					break;
				}

				Vertice u = caminho.get(i);
				Vertice v = caminho.get(i + 1);

				Aresta a = grafo.buscarArestaCorrespondente(u, v);

				Double capacidadeResidual = getCapacidadeResidual(a);

				min = capacidadeResidual < min ? capacidadeResidual : min;

			}

			fm = fm + min;
		}

		return fm;

	}

	public void imprimirValorFluxoMaximo() {
		StringBuilder impr = new StringBuilder();

		impr.append("Ford-Fulkerson\n");
		impr.append("Fluxo máximo:\n");

		impr.append(getValorFluxoMaximo());

		System.out.println(impr);
		System.out.println();
	}

}
