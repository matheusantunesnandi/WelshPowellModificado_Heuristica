package principal;

import algoritmo.AlgoritmoFordFulkerson;
import algoritmo.AlgoritmoWelshPowell;
import grafo.Grafo;

public class PrincipalImplementacoesExtra {

	public static void main(String[] args) {

		// executarAlgoritmoFordFulkerson();
		executarAlgoritmoWelshPowell();

	}

	public static void executarAlgoritmoFordFulkerson() {
		Grafo g = new Grafo();

		g.setOrientado(true);

		g.adicionarVertice("s");
		g.adicionarVertice("a");
		g.adicionarVertice("b");
		g.adicionarVertice("c");
		g.adicionarVertice("d");
		g.adicionarVertice("t");

		g.adicionarAresta("s", "a", 10.0);
		g.adicionarAresta("s", "b", 10.0);
		g.adicionarAresta("a", "c", 4.0);
		g.adicionarAresta("a", "d", 8.0);
		g.adicionarAresta("a", "b", 2.0);
		g.adicionarAresta("b", "d", 9.0);
		g.adicionarAresta("d", "c", 6.0);
		g.adicionarAresta("d", "t", 10.0);
		g.adicionarAresta("c", "t", 10.0);

		AlgoritmoFordFulkerson aff = new AlgoritmoFordFulkerson(g, "s", "t");
		aff.imprimirValorFluxoMaximo();
	}

	public static void executarAlgoritmoWelshPowell() {
		// Exemplo do professor:
		Grafo g = new Grafo();

		g.adicionarVertice("s");
		g.adicionarVertice("a");
		g.adicionarVertice("b");
		g.adicionarVertice("c");
		g.adicionarVertice("d");
		g.adicionarVertice("t");

		g.adicionarAresta("s", "a", 10.0);
		g.adicionarAresta("s", "b", 10.0);
		g.adicionarAresta("a", "c", 4.0);
		g.adicionarAresta("a", "d", 8.0);
		g.adicionarAresta("a", "b", 2.0);
		g.adicionarAresta("b", "d", 9.0);
		g.adicionarAresta("d", "c", 6.0);
		g.adicionarAresta("d", "t", 10.0);
		g.adicionarAresta("c", "t", 10.0);

		AlgoritmoWelshPowell awp = new AlgoritmoWelshPowell(g);
		// System.out.println("Exemplo do professor:");
		// awp.imprimirNumeroCromatico();

		// Bipartido
		g = new Grafo();

		g.adicionarVertice("s");
		g.adicionarVertice("a");
		g.adicionarVertice("b");
		g.adicionarVertice("c");
		g.adicionarVertice("d");
		g.adicionarVertice("t");

		g.adicionarAresta("s", "b", 10.0);
		g.adicionarAresta("s", "c", 10.0);
		g.adicionarAresta("a", "b", 10.0);
		g.adicionarAresta("a", "c", 10.0);

		g.adicionarAresta("b", "s", 10.0);
		g.adicionarAresta("b", "a", 10.0);
		g.adicionarAresta("c", "s", 10.0);
		g.adicionarAresta("c", "a", 10.0);

		awp = new AlgoritmoWelshPowell(g);
		System.out.println("Bipartido");
		awp.imprimirNumeroCromatico();

		// Exemplo do v�deo:
		g = new Grafo();
		g.adicionarVertice("a");
		g.adicionarVertice("b");
		g.adicionarVertice("c");
		g.adicionarVertice("d");
		g.adicionarVertice("e");
		g.adicionarVertice("f");
		g.adicionarVertice("g");
		g.adicionarVertice("h");
		g.adicionarVertice("i");
		g.adicionarVertice("j");
		g.adicionarVertice("k");
		g.adicionarVertice("l");

		g.adicionarAresta("a", "b", 0.0);
		g.adicionarAresta("a", "f", 0.0);
		g.adicionarAresta("a", "g", 0.0);
		g.adicionarAresta("b", "c", 0.0);
		g.adicionarAresta("b", "g", 0.0);
		g.adicionarAresta("b", "h", 0.0);
		g.adicionarAresta("c", "d", 0.0);
		g.adicionarAresta("c", "g", 0.0);
		g.adicionarAresta("c", "j", 0.0);
		g.adicionarAresta("d", "e", 0.0);
		g.adicionarAresta("d", "g", 0.0);
		g.adicionarAresta("e", "f", 0.0);
		g.adicionarAresta("e", "g", 0.0);
		g.adicionarAresta("f", "g", 0.0);
		g.adicionarAresta("h", "i", 0.0);
		g.adicionarAresta("h", "k", 0.0);
		g.adicionarAresta("h", "l", 0.0);
		g.adicionarAresta("i", "j", 0.0);
		g.adicionarAresta("i", "k", 0.0);
		g.adicionarAresta("i", "l", 0.0);
		g.adicionarAresta("j", "k", 0.0);
		g.adicionarAresta("j", "l", 0.0);

		awp = new AlgoritmoWelshPowell(g);
		System.out.println("Exemplo do v�deo:");
		awp.imprimirNumeroCromatico();
	}
}
