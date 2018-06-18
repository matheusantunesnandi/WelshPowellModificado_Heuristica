package principal;

import algoritmo.AlgoritmoColoracaoHeuristica;
import grafo.Grafo;

public class PrincipalSeminario_Opcao1 {
	public static void main(String[] args) {
		executarSeminario();
	}

	public static void executarSeminario() {

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

		AlgoritmoColoracaoHeuristica ach = new AlgoritmoColoracaoHeuristica(g);
		// System.out.println("Exemplo do professor:");
		// ach.imprimirNumeroCromatico();

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

		ach = new AlgoritmoColoracaoHeuristica(g);
		System.out.println("Bipartido");
		ach.imprimirNumeroCromatico();

		// Exemplo do vídeo:
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

		ach = new AlgoritmoColoracaoHeuristica(g);
		System.out.println("Exemplo do vídeo:");
		ach.imprimirNumeroCromatico();
		
		System.out.println("PrincipalSeminario_Opcao1");
	}
}
