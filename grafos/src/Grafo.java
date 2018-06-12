import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Não funciona com multi-grafo. Ou seja, não pode conter laços ou dois vertices
 * com mais de uma aresta entre eles
 **/
public class Grafo {
    public static int PRIMEIRO_DA_LISTA = 0;

    private boolean valorado = false;
    private boolean orientado = false;

    private ArrayList<Vertice> vertices = new ArrayList<>();
    private ArrayList<Aresta> arestas = new ArrayList<>();

    public void adicionarVertice(String nome) {
	Vertice v = new Vertice();
	v.setNome(nome);

	adicionarVertice(v);
    }

    public void adicionarVertice(Vertice v) {
	vertices.add(v);
    }

    public void removerVertice(String nome) {
	vertices.remove(buscarVerticePorNome(nome));
    }

    public void removerVertice(Vertice v) {
	vertices.remove(v);
    }

    public void adicionarAresta(String nomeVerticeA, String nomeVerticeB, Double valor) {
	Vertice verticeA = buscarVerticePorNome(nomeVerticeA);
	Vertice verticeB = buscarVerticePorNome(nomeVerticeB);

	adicionarAresta(verticeA, verticeB, valor);
    }

    public void adicionarAresta(Vertice verticeA, Vertice verticeB, Double valor) {
	if (!isOrientado()) {
	    verticeA.getAdjacentes().add(verticeB);
	    verticeB.getAdjacentes().add(verticeA);
	} else {
	    verticeA.getAdjacentes().add(verticeB);
	}

	Aresta a = new Aresta();

	a.setVerticeA(verticeA);
	a.setVerticeB(verticeB);
	a.setValor(valor);

	arestas.add(a);
    }

    public void adicionarAresta(Aresta a) {

	Vertice verticeA = a.getVerticeA();
	Vertice verticeB = a.getVerticeB();

	if (!isOrientado()) {
	    verticeA.getAdjacentes().add(verticeB);
	    verticeB.getAdjacentes().add(verticeA);
	} else {
	    verticeA.getAdjacentes().add(verticeB);
	}

	arestas.add(a);
    }

    public void removerAresta(String nomeVerticeA, String nomeVerticeB) {
	Vertice verticeA = buscarVerticePorNome(nomeVerticeA);
	Vertice verticeB = buscarVerticePorNome(nomeVerticeB);

	removerAresta(verticeA, verticeB);
    }

    public void removerAresta(Aresta a) {
	removerAresta(a.getVerticeA(), a.getVerticeB());
    }

    public void removerAresta(Vertice verticeA, Vertice verticeB) {
	arestas.remove(buscarArestaCorrespondente(verticeA, verticeB));

	if (!isOrientado()) {
	    verticeA.getAdjacentes().remove(verticeB);
	    verticeB.getAdjacentes().remove(verticeA);
	} else {
	    verticeA.getAdjacentes().remove(verticeB);
	}

    }

    public Vertice buscarVerticePorNome(String nome) {
	for (Vertice v : vertices) {
	    if (v.getNome().equalsIgnoreCase(nome)) {
		return v;
	    }
	}

	return null;
    }

    public Aresta buscarArestaCorrespondente(String verticeA, String verticeB) {
	Vertice a = buscarVerticePorNome(verticeA);
	Vertice b = buscarVerticePorNome(verticeB);

	return buscarArestaCorrespondente(a, b);
    }

    public Aresta buscarArestaCorrespondente(Vertice verticeA, Vertice verticeB) {
	for (Aresta aresta : arestas) {

	    boolean aabb = aresta.getVerticeA().equals(verticeA) && aresta.getVerticeB().equals(verticeB);
	    boolean abba = aresta.getVerticeA().equals(verticeB) && aresta.getVerticeB().equals(verticeA);

	    boolean isArestaCorreta = (!orientado && (aabb || abba)) || (orientado && aabb);

	    if (isArestaCorreta)
		return aresta;
	}
	return null;
    }

    public void ordernarArestas() {
	ordernarArestas(arestas);
    }

    public void ordernarArestas(ArrayList<Aresta> arestas) {
	Collections.sort(arestas, new Comparator<Aresta>() {
	    public int compare(Aresta a1, Aresta a2) {
		return a1.getValor() < a2.getValor() ? -1 : (a1.getValor() > a2.getValor() ? +1 : 0);
	    }
	});
    }

    public void ordernarVertices() {
	ordernarVertices(vertices);
    }

    public void ordernarVertices(ArrayList<Vertice> vertices) {
	Collections.sort(vertices, new Comparator<Vertice>() {
	    public int compare(Vertice v1, Vertice v2) {
		return v1.getNome().compareTo(v2.getNome());
	    }
	});
    }

    public void ordernarVerticesPorGrau() {
	ordernarVertices(vertices);
    }

    public void ordernarVerticesPorGrau(ArrayList<Vertice> vertices) {
	Collections.sort(vertices, new Comparator<Vertice>() {
	    public int compare(Vertice v1, Vertice v2) {
		return v1.getGrau() < v2.getGrau() ? -1 : v1.getGrau() == v2.getGrau() ? 0 : 1;
	    }
	});
    }

    public boolean isValorado() {
	return valorado;
    }

    public void setValorado(boolean valorado) {
	this.valorado = valorado;
    }

    public boolean isOrientado() {
	return orientado;
    }

    public void setOrientado(boolean orientado) {
	this.orientado = orientado;
    }

    public ArrayList<Vertice> getVertices() {
	return vertices;
    }

    public void setVertices(ArrayList<Vertice> vertices) {
	this.vertices = vertices;
    }

    public ArrayList<Aresta> getArestas() {
	return arestas;
    }

    public void setArestas(ArrayList<Aresta> arestas) {
	this.arestas = arestas;
    }

}