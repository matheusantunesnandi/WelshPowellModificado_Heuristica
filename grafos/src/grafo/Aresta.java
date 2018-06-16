package grafo;
//classe responsável por lidar com arestas
public class Aresta {
	//esses dois vértices são ligados
	private Vertice verticeA = null;
	private Vertice verticeB = null;
	//valor da aresta
	private Double valor = null;
	//método com StringBuilder para concatenação de Strings
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(verticeA.getNome());
		s.append("_");
		s.append(verticeB.getNome());
		s.append(" ");
		s.append(valor);

		return s.toString();
	}
	//abaixo só getter e setters
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Vertice getVerticeA() {
		return verticeA;
	}

	public void setVerticeA(Vertice verticeA) {
		this.verticeA = verticeA;
	}

	public Vertice getVerticeB() {
		return verticeB;
	}

	public void setVerticeB(Vertice verticeB) {
		this.verticeB = verticeB;
	}
}
