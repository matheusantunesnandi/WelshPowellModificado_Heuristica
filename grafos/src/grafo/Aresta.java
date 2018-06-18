package grafo;

public class Aresta {

	private Vertice verticeA = null;
	private Vertice verticeB = null;

	private Double valor = null;
	
	public Aresta() {
		super();
	}

	public Aresta(Vertice a, Vertice b, Double valor) {
		this.verticeA = a;
		this.verticeB = b;
		this.valor = valor;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[");
		s.append(verticeA.getNome());
		s.append(" -> ");
		s.append(verticeB.getNome());
		s.append(" (");
		s.append(valor);
		s.append(")");
		s.append("]");

		return s.toString();
	}

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
