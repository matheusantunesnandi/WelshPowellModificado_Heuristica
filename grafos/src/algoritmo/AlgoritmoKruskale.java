package algoritmo;

import java.util.ArrayList;

import grafo.Aresta;
import grafo.Grafo;
import grafo.Vertice;

public class AlgoritmoKruskale {
	public static int PRIMEIRO_DA_LISTA = 0;

	Grafo grafo;

	ArrayList<Aresta> arestasOrdenadas = new ArrayList<>();

	private double custo = 0.0;

	public AlgoritmoKruskale(Grafo grafo) {
		this.grafo = grafo;
		arestasOrdenadas.addAll(grafo.getArestas());

		grafo.ordernarArestas(arestasOrdenadas);
	}

	public void imprimirArvoreGeradoraMinima() {
		StringBuilder txt = new StringBuilder();

		txt.append("Kruskale\n");
		txt.append("�rvore geradora m�nima:\n");
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

	public ArrayList<Aresta> getArestasArvoreGeradoraMinima() {

		Grafo componente = new Grafo();

		// Uma �rvore geradora sempre ter� todos os v�rtices.
		// Por�m seus v�rties n�o t�m adjac�ncia de inicio (Arestas).
		componente.setVertices(clonarVerticesSemAdjacencia(grafo));

		int iMax = grafo.getVertices().size() - 1;
		int i = 0;
		for (Aresta a : arestasOrdenadas) {
			if (i == iMax) {
				break;
			}

			// Clonar aresta:
			// va e vb devem vir do componente, e n�o do grafo original.
			Vertice va = componente.buscarVerticePorNome(a.getVerticeA().getNome());
			Vertice vb = componente.buscarVerticePorNome(a.getVerticeB().getNome());

			// Inst�nciar uma nova aresta para n�o alterar a original em mem�ria
			Aresta a2 = new Aresta();
			a2.setVerticeA(va);
			a2.setVerticeB(vb);
			a2.setValor(a.getValor());

			// At� aqui a aresta � uma c�pia identica, por�m objeto em mem�ria do componente

			// isArestaCriadoraDeCiclo funcionar�, pois as adjac�ncias vem dos vertices
			// contidos no componente no qual uma aresta nunca ser� inserida se criar
			// ciclos.
			if (!isArestaCriadoraDeCiclo(a2)) {
				componente.adicionarAresta(a2);
				custo += a.getValor();
				i++;
			}

		}

		return componente.getArestas();
	}

	public boolean isArestaCriadoraDeCiclo(Aresta aresta) {

		Vertice u = aresta.getVerticeA();
		Vertice v = aresta.getVerticeB();

		ArrayList<Vertice> verticesDoComponente = verticesDoComponente(u, new ArrayList<>());

		verticesDoComponente.remove(u);
		verticesDoComponente.removeAll(u.getAdjacentes());

		if (verticesDoComponente.contains(v)) {
			return true;
		}

		return false;
	}

	// TODO Poderia ser realizado utilizando l�gica de conjuntos:
	public ArrayList<Vertice> verticesDoComponente(Vertice raiz, ArrayList<Vertice> vertices) {

		if (!vertices.contains(raiz)) {
			vertices.add(raiz);
		}

		ArrayList<Vertice> adjacentesFiltrados = new ArrayList<>();
		adjacentesFiltrados.addAll(raiz.getAdjacentes());
		adjacentesFiltrados.removeAll(vertices);

		for (Vertice v : adjacentesFiltrados) {
			for (Vertice v2 : verticesDoComponente(v, vertices)) {
				if (!vertices.contains(v2)) {
					vertices.add(v2);
				}
			}

		}

		return vertices;
	}

	private ArrayList<Vertice> clonarVerticesSemAdjacencia(Grafo original) {
		ArrayList<Vertice> vertices = new ArrayList<>();

		for (Vertice u : original.getVertices()) {
			vertices.add(u.clone());
		}

		// Limpar adjac�ncia
		for (Vertice v : vertices) {
			v.setAdjacentes(new ArrayList<>());
		}

		return vertices;
	}
}
