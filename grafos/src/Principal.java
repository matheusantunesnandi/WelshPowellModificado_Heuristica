public class Principal {

	public static void main(String[] args) {

		// imprimirLegenda();
		// executarTrabalho2();
		// executarTrabalho3();
		// executarAlgoritmoFordFulkerson();

		// executarSeminario();
		executarAlgoritmoWelshPowell();
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
		// ach.imprimirNumeroCromatico();

		// Bibartido
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
		ach.imprimirNumeroCromatico();

		// Exemplo do vídeo
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
		ach.imprimirNumeroCromatico();

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

		// g.setOrientado(true);

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
		awp.imprimirNumeroCromatico();

		// Bibartido
		g = new Grafo();

		g.adicionarVertice("s");
		g.adicionarVertice("a");
		g.adicionarVertice("b");
		g.adicionarVertice("c");

		g.adicionarAresta("s", "b", 10.0);
		g.adicionarAresta("s", "c", 10.0);
		g.adicionarAresta("a", "b", 10.0);
		g.adicionarAresta("a", "c", 10.0);

		awp = new AlgoritmoWelshPowell(g);
		awp.imprimirNumeroCromatico();
	}

	/**
	 * Mesmas entradas utilizadas no exemplo usado na aula do professor. Slide 8.
	 */
	public static void executarTrabalho3() {
		Grafo g = new Grafo();

		g.adicionarVertice("0");
		g.adicionarVertice("1");
		g.adicionarVertice("2");
		g.adicionarVertice("3");
		g.adicionarVertice("4");
		g.adicionarVertice("5");
		g.adicionarVertice("6");
		g.adicionarVertice("7");
		g.adicionarVertice("8");

		g.adicionarAresta("0", "1", 4.0);
		g.adicionarAresta("0", "7", 8.0);
		g.adicionarAresta("1", "2", 8.0);
		g.adicionarAresta("1", "7", 11.0);
		g.adicionarAresta("2", "3", 7.0);
		g.adicionarAresta("2", "5", 4.0);
		g.adicionarAresta("2", "8", 2.0);
		g.adicionarAresta("3", "4", 9.0);
		g.adicionarAresta("3", "5", 14.0);
		g.adicionarAresta("4", "5", 10.0);
		g.adicionarAresta("5", "6", 2.0);
		g.adicionarAresta("6", "7", 1.0);
		g.adicionarAresta("6", "8", 6.0);
		g.adicionarAresta("7", "8", 7.0);

		AlgoritmoKruskale ak = new AlgoritmoKruskale(g);
		ak.imprimirArvoreGeradoraMinima();

		AlgoritmoPrimJarnik apj = new AlgoritmoPrimJarnik(g, "0");
		apj.imprimirArvoreGeradoraMinima();

	}

	/**
	 * Mesmas entradas utilizadas no exemplo usado na aula do professor. Slide 6.
	 */
	public static void executarTrabalho2() {
		Grafo g = new Grafo();

		g.adicionarVertice("S");
		g.adicionarVertice("U");
		g.adicionarVertice("X");
		g.adicionarVertice("V");
		g.adicionarVertice("Y");

		g.adicionarAresta("S", "U", 10.0);
		g.adicionarAresta("S", "X", 5.0);
		g.adicionarAresta("U", "X", 2.0);
		g.adicionarAresta("U", "V", 1.0);
		g.adicionarAresta("X", "U", 3.0);
		g.adicionarAresta("X", "V", 9.0);
		g.adicionarAresta("X", "Y", 2.0);
		g.adicionarAresta("V", "Y", 4.0);
		g.adicionarAresta("Y", "V", 6.0);
		g.adicionarAresta("Y", "S", 7.0);

		g.setOrientado(true);

		AlgoritmoDijkstra ad = new AlgoritmoDijkstra(g, "S");
		ad.imprimirTabelaDistanciaCaminho();
	}

	/**
	 * Mesmas entradas utilizadas no exemplo usado na aula do professor. Slide 3.
	 */
	public static void executarTrabalho1() {
		// TODO Implementar
	}

	public static void imprimirLegenda() {
		StringBuilder l = new StringBuilder();

		l.append("As arestas são mostradas com o seguinte padrão:\n");
		l.append("(VerticeA_VerticeB Valor).");

		System.out.println(l.toString());
		System.out.println();
	}
}
