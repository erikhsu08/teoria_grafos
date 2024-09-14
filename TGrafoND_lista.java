/*
NOME: Erik Samuel Viana Hsu         RA: 10403109
NOME: Mateus Kenzo Iochimoto        RA: 10400995
NOME: Thiago Shihan Cardoso Toma    RA: 10400764
 */

import java.util.LinkedList;

public class TGrafoND_lista {
    private int n; // quantidade de vértices
    private int m; // quantidade de arestas
    private LinkedList<Integer>[] lista_adj; // lista de adjacência para arestas

    // Construtor do grafo não-dirigido
    public TGrafoND_lista(int n) {
        this.n = n;
        this.m = 0;
        lista_adj = new LinkedList[n]; // Cria uma lista de adjacência para cada vértice

        // Inicializa cada lista de adjacência
        for (int i = 0; i < n; i++) {
            lista_adj[i] = new LinkedList<>();
        }
    }

    // Insere uma aresta no grafo não-dirigido
    public void insereA(int v, int w) {
        if (!lista_adj[v].contains(w)) {
            lista_adj[v].add(w);  // Aresta de v para w
            lista_adj[w].add(v);  // Aresta de w para v (bidirecional)
            m++; // Atualiza a quantidade de arestas
        }
    }

    // Remove uma aresta no grafo não-dirigido
    public void removeA(int v, int w) {
        if (lista_adj[v].contains(w)) {
            lista_adj[v].remove((Integer) w);  // Remove aresta de v para w
            lista_adj[w].remove((Integer) v);  // Remove aresta de w para v (bidirecional)
            m--; // Atualiza a quantidade de arestas
        }
    }

    // Apresenta o grafo com vértices e arestas
    public void show() {
        System.out.println("n: " + n);
        System.out.println("m: " + m);
        for (int i = 0; i < n; i++) {
            System.out.print("Vértice " + i + ": ");
            for (int w : lista_adj[i]) {
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }

    //Exercício 24
    public void removeVertice(int v) {
        // Remover todas as arestas conectadas ao vértice v
        for (int i = 0; i < n; i++) {
            if (i != v) {
                removeA(v, i);
            }
        }

        // Ajustar as listas de adjacência para "encolher" o grafo, removendo o vértice
        for (int i = v; i < n - 1; i++) {
            lista_adj[i] = lista_adj[i + 1]; // Copiar as listas de adjacência para uma posição anterior
        }

        // Ajustar as referências dos outros vértices nas listas de adjacência
        for (int i = 0; i < n - 1; i++) {
            lista_adj[i].removeIf(x -> x == v); // Remove referências ao vértice removido
            lista_adj[i].replaceAll(x -> (x > v) ? x - 1 : x); // Ajusta índices dos vértices maiores
        }

        // Reduzir o número de vértices
        n--;
    }
}
