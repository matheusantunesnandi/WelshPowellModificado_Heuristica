package principal;

import algoritmo.AlgoritmoKruskale;
import grafo.Grafo;

public class PrincipalSeminario_Opcao2 {
	public static void main(String[] args) {
		executarSeminario();

		System.out.println("PrincipalSeminario_Opcao2.java");

	}

	public static void executarSeminario() {
		Grafo g = new Grafo();

		g.adicionarVertice("a");
		g.adicionarVertice("b");
		g.adicionarVertice("c");
		g.adicionarVertice("d");
		g.adicionarVertice("e");
		g.adicionarVertice("f");
		g.adicionarVertice("g");
		g.adicionarVertice("h");
		g.adicionarVertice("i");

		g.adicionarAresta("a", "b", 3.8);
		g.adicionarAresta("a", "c", 6.1);
		g.adicionarAresta("a", "d", 1.4);
		g.adicionarAresta("a", "e", 0.795);
		g.adicionarAresta("a", "f", 3.0);
		g.adicionarAresta("a", "g", 5.2);
		g.adicionarAresta("a", "h", 1.3);
		g.adicionarAresta("a", "i", 1.7);
		g.adicionarAresta("b", "c", 9.3);
		g.adicionarAresta("b", "d", 5.9);
		g.adicionarAresta("b", "e", 4.9);
		g.adicionarAresta("b", "f", 7.0);
		g.adicionarAresta("b", "g", 1.7);
		g.adicionarAresta("b", "h", 5.4);
		g.adicionarAresta("b", "i", 5.6);
		g.adicionarAresta("c", "d", 8.1);
		g.adicionarAresta("c", "e", 7.1);
		g.adicionarAresta("c", "f", 9.2);
		g.adicionarAresta("c", "g", 11.0);
		g.adicionarAresta("c", "h", 6.1);
		g.adicionarAresta("c", "i", 7.8);
		g.adicionarAresta("d", "e", 0.494);
		g.adicionarAresta("d", "f", 1.7);
		g.adicionarAresta("d", "g", 6.7);
		g.adicionarAresta("d", "h", 2.1);
		g.adicionarAresta("d", "i", 0.343);
		g.adicionarAresta("e", "f", 1.8);
		g.adicionarAresta("e", "g", 6.8);
		g.adicionarAresta("e", "h", 2.3);
		g.adicionarAresta("e", "i", 0.412);
		g.adicionarAresta("f", "g", 8.6);
		g.adicionarAresta("f", "h", 3.8);
		g.adicionarAresta("f", "i", 1.4);
		g.adicionarAresta("g", "h", 6.8);
		g.adicionarAresta("g", "i", 7.1);
		g.adicionarAresta("h", "i", 2.4);

		AlgoritmoKruskale ak = new AlgoritmoKruskale(g);
		ak.imprimirArvoreGeradoraMinima();
		//
		// AlgoritmoPrimJarnik apj = new AlgoritmoPrimJarnik(g, "a");
		// apj.imprimirArvoreGeradoraMinima();

		// AlgoritmoDijkstra ad;
		//
		// for (Vertice u : g.getVertices()) {
		// ad = new AlgoritmoDijkstra(g, u.getNome());
		// ad.imprimirTabelaDistanciaCaminho();
		// }
	}
}
