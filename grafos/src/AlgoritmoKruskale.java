import java.util.ArrayList;

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
	StringBuilder tabela = new StringBuilder();

	tabela.append("Kruskale\n");
	tabela.append("Árvore geradora mínima:\n");
	tabela.append("Arestas: ");

	for (Aresta a : getArestasArvoreGeradoraMinima()) {
	    tabela.append("(");
	    tabela.append(a);
	    tabela.append(")");
	}

	tabela.append("\nCusto: ");
	tabela.append(custo);

	System.out.println(tabela);
	System.out.println();
    }

    public ArrayList<Aresta> getArestasArvoreGeradoraMinima() {

	Grafo componente = new Grafo();

	// Uma árvore geradora sempre terá todos os vértices.
	// Porém seus vérties não têm adjacência de inicio (Arestas).
	componente.setVertices(clonarVerticesSemAdjacencia(grafo));

	int iMax = grafo.getVertices().size() - 1;
	int i = 0;
	for (Aresta a : arestasOrdenadas) {
	    if (i == iMax) {
		break;
	    }

	    // Clonar aresta:
	    // va e vb devem vir do componente, e não do grafo original.
	    Vertice va = componente.buscarVerticePorNome(a.getVerticeA().getNome());
	    Vertice vb = componente.buscarVerticePorNome(a.getVerticeB().getNome());

	    // Instânciar uma nova aresta para não alterar a original em memória
	    Aresta a2 = new Aresta();
	    a2.setVerticeA(va);
	    a2.setVerticeB(vb);
	    a2.setValor(a.getValor());

	    // Até aqui a aresta é uma cópia identica, porém objeto em memória do componente

	    // isArestaCriadoraDeCiclo funcionará, pois as adjacências vem dos vertices
	    // contidos no componente no qual uma aresta nunca será inserida se criar
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

	// Limpar adjacência
	for (Vertice v : vertices) {
	    v.setAdjacentes(new ArrayList<>());
	}

	return vertices;
    }
}
