/*
NOME: Erik Samuel Viana Hsu         RA: 10403109
NOME: Mateus Kenzo Iochimoto        RA: 10400995
NOME: Thiago Shihan Cardoso Toma    RA: 10400764
 */

package GrafoMatriz;

public class TGrafoND {
    private int n; // quantidade de vértices
    private int m; // quantidade de arestas
    private float adj[][]; // matriz de adjacência para arestas rotuladas

    public TGrafoND(int n) {
        this.n = n;
        this.m = 0;
        this.adj = new float[n][n];
        // Inicializa a matriz com 0.0f, indicando que não há arestas
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.adj[i][j] = 0.0f;
            }
        }
    }

    // Insere uma aresta rotulada no grafo não-dirigido
    public void insereA(int v, int w, float rotulo) {
        if (adj[v][w] == 0.0f && adj[w][v] == 0.0f) {
            adj[v][w] = rotulo;  // Aresta de v para w com rótulo
            adj[w][v] = rotulo;  // Aresta de w para v com rótulo (bidirecional)
            m++; // Atualiza a quantidade de arestas
        }
    }

    // Remove uma aresta no grafo não-dirigido
    public void removeA(int v, int w) {
        if (adj[v][w] != 0.0f && adj[w][v] != 0.0f) {
            adj[v][w] = 0.0f;  // Remove aresta de v para w
            adj[w][v] = 0.0f;  // Remove aresta de w para v (bidirecional)
            m--; // Atualiza a quantidade de arestas
        }
    }

    // Apresenta o grafo com vértices, arestas e a matriz de adjacência rotulada
    public void show() {
        System.out.println("n: " + n);
        System.out.println("m: " + m);
        for (int i = 0; i < n; i++) {
            System.out.print("\n");
            for (int w = 0; w < n; w++) {
                if (adj[i][w] != 0.0f)
                    System.out.print("Adj[" + i + "," + w + "]= " + adj[i][w] + " ");
                else
                    System.out.print("Adj[" + i + "," + w + "]= 0.0" + " ");
            }
        }
        System.out.println("\n\nfim da impressao do grafo.");
    }

    public void removeVertice(int v) {
        // Remover arestas associadas ao vértice v
        for (int i = 0; i < n; i++) {
            if (adj[v][i] != 0.0f) {
                removeA(v, i);
            }
            if (adj[i][v] != 0.0f) {
                removeA(i, v);
            }
        }

        // Remover o vértice da matriz de adjacência
        for (int i = v; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j] = adj[i + 1][j];
                adj[j][i] = adj[j][i + 1];
            }
        }

        // Reduzir o tamanho da matriz
        n--;
    }
}
