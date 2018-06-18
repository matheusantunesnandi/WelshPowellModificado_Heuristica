package principal;

import algoritmo.AlgoritmoWelshPowell;
import grafo.Grafo;
//classe principal
public class PrincipalImplementacoesExtra {

	public static void main(String[] args) {

		// executarAlgoritmoFordFulkerson();
		executarAlgoritmoWelshPowell();

	}
	//não é mais relevantes para o trabalho
//	public static void executarAlgoritmoFordFulkerson() {
//		Grafo g = new Grafo();
//
//		g.setOrientado(true);
//
//		g.adicionarVertice("Pólvora");
//		g.adicionarVertice("a");
//		g.adicionarVertice("Nitrato de Amônio");
//		g.adicionarVertice("C4");
//		g.adicionarVertice("d");
//		g.adicionarVertice("Trinitrotolueno");
//
//		g.adicionarAresta("Pólvora", "a", 10.0);
//		g.adicionarAresta("Pólvora", "b", 10.0);
//		g.adicionarAresta("a", "c", 4.0);
//		g.adicionarAresta("a", "d", 8.0);
//		g.adicionarAresta("a", "b", 2.0);
//		g.adicionarAresta("b", "d", 9.0);
//		g.adicionarAresta("d", "c", 6.0);
//		g.adicionarAresta("d", "Trinitrotolueno", 10.0);
//		g.adicionarAresta("c", "Trinitrotolueno", 10.0);
//
//		AlgoritmoFordFulkerson aff = new AlgoritmoFordFulkerson(g, "Pólvora", "Trinitrotolueno");
//		aff.imprimirValorFluxoMaximo();
//	}

	public static void executarAlgoritmoWelshPowell() {
		// Exemplo do professor:
		Grafo g = new Grafo();

		g.adicionarVertice("Pólvora");
		g.adicionarVertice("Nitroglicerina");
		g.adicionarVertice("Nitrato de Amônio");
		g.adicionarVertice("C4");
		g.adicionarVertice("C3");
		g.adicionarVertice("Trinitrotolueno");

		g.adicionarAresta("Pólvora", "Nitroglicerina", 10.0);
		g.adicionarAresta("Pólvora", "Nitrato de Amônio", 10.0);
		g.adicionarAresta("Nitroglicerina", "C4", 4.0);
		g.adicionarAresta("Nitroglicerina", "C3", 8.0);
		g.adicionarAresta("Nitroglicerina", "Nitrato de Amônio", 2.0);
		g.adicionarAresta("Nitrato de Amônio", "C3", 9.0);
		g.adicionarAresta("C3", "C4", 6.0);
		g.adicionarAresta("C3", "Trinitrotolueno", 10.0);
		g.adicionarAresta("C4", "Trinitrotolueno", 10.0);

		AlgoritmoWelshPowell awp = new AlgoritmoWelshPowell(g);
		// System.out.println("Exemplo do professor:");
		// awp.imprimirNumeroCromatico();

		// Bipartido
		g = new Grafo();

		g.adicionarVertice("Pólvora");
		g.adicionarVertice("Nitroglicerina");
		g.adicionarVertice("Nitrato de Amônio");
		g.adicionarVertice("C4");
		g.adicionarVertice("C3");
		g.adicionarVertice("Trinitrotolueno");

		g.adicionarAresta("Pólvora", "Nitrato de Amônio", 10.0);
		g.adicionarAresta("Pólvora", "C4", 10.0);
		g.adicionarAresta("Nitroglicerina", "Nitrato de Amônio", 10.0);
		g.adicionarAresta("Nitroglicerina", "C4", 10.0);

		g.adicionarAresta("Nitrato de Amônio", "Pólvora", 10.0);
		g.adicionarAresta("Nitrato de Amônio", "Nitroglicerina", 10.0);
		g.adicionarAresta("C4", "Pólvora", 10.0);
		g.adicionarAresta("C4", "Nitroglicerina", 10.0);

		awp = new AlgoritmoWelshPowell(g);
		System.out.println("Bipartido");
		awp.imprimirNumeroCromatico();

		// Exemplo do v�deo:
		g = new Grafo();
		g.adicionarVertice("Nitroglicerina");
		g.adicionarVertice("Nitrato de Amônio");
		g.adicionarVertice("C4");
		g.adicionarVertice("C3");
		g.adicionarVertice("e");
		g.adicionarVertice("f");
		g.adicionarVertice("g");
		g.adicionarVertice("h");
		g.adicionarVertice("i");
		g.adicionarVertice("j");
		g.adicionarVertice("k");
		g.adicionarVertice("l");

		g.adicionarAresta("Nitroglicerina", "Nitrato de Amônio", 0.0);
		g.adicionarAresta("Nitroglicerina", "f", 0.0);
		g.adicionarAresta("Nitroglicerina", "g", 0.0);
		g.adicionarAresta("Nitrato de Amônio", "C4", 0.0);
		g.adicionarAresta("Nitrato de Amônio", "g", 0.0);
		g.adicionarAresta("Nitrato de Amônio", "h", 0.0);
		g.adicionarAresta("C4", "C3", 0.0);
		g.adicionarAresta("C4", "g", 0.0);
		g.adicionarAresta("C4", "j", 0.0);
		g.adicionarAresta("C3", "e", 0.0);
		g.adicionarAresta("C3", "g", 0.0);
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
