/*
NOME: Erik Samuel Viana Hsu         RA: 10403109
NOME: Mateus Kenzo Iochimoto        RA: 10400995
NOME: Thiago Shihan Cardoso Toma    RA: 10400764
 */

package GrafoMatriz;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//definição de uma estrutura Matriz de Adjacência para armezanar um grafo
public class TGrafo {
	// Atributos Privados
	private	int n; // quantidade de vértices
	private	int m; // quantidade de arestas
	private	int adj[][]; //matriz de adjacência
	// Métodos Públicos
	public TGrafo( int n) {  // construtor
	    this.n = n;
	    // No início dos tempos não há arestas
	    this.m = 0; 
	    // alocação da matriz do TGrafo
	    this.adj = new int [n][n];

	    // Inicia a matriz com zeros
		for(int i = 0; i< n; i++)
			for(int j = 0; j< n; j++)
				this.adj[i][j]=0;	
	}

	// Insere uma aresta no Grafo tal que
	// v é adjacente a w
	public void insereA(int v, int w) {
	    // testa se nao temos a aresta
	    if(adj[v][w] == 0 ){
	        adj[v][w] = 1;
	        m++; // atualiza qtd arestas
	    }
	}
	
	// remove uma aresta v->w do Grafo	
	public void removeA(int v, int w) {
	    // testa se temos a aresta
	    if(adj[v][w] == 1 ){
	        adj[v][w] = 0;
	        m--; // atualiza qtd arestas
	    }
	}
	// Apresenta o Grafo contendo
	// número de vértices, arestas
	// e a matriz de adjacência obtida	
	public void show() {
	    System.out.println("n: " + n );
	    System.out.println("m: " + m );
	    for( int i=0; i < n; i++){
	    	System.out.print("\n");
	        for( int w=0; w < n; w++)
	            if(adj[i][w] == 1)
	            	System.out.print("Adj[" + i + "," + w + "]= 1" + " ");
	            else System.out.print("Adj[" + i + "," + w + "]= 0" + " ");
	    }
	    System.out.println("\n\nfim da impressao do grafo." );
	}

	//Exercício 1
	public int inDegree(int v) {
		int grau = 0;
		for( int i=0; i < n; i++) {
				if (adj[i][v] == 1){
					grau++;
			}
		}
		return grau;
	}
	//Exercício 2
	public int outDegree(int v) {
		int grau = 0;
		for( int i=0; i < n; i++) {
			if (adj[v][i] == 1){
				grau++;
			}
		}
		return grau;
	}
	//Exercício 3
	public int ehFonte(int v){
		if (outDegree(v) > 0 && inDegree(v) == 0){
			return 1;
		}
		else return 0;
	}
	//Exercício 4
	public int ehSorvedouro(int v){
		if (inDegree(v) > 0 && outDegree(v) == 0){
			return 1;
		}
		else return 0;
	}
	//Exercício 5
	public int ehSimetrico() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (adj[i][j] != adj[j][i]) {
					return 0; // Não é simétrico
				}
			}
		}
		return 1; // É simétrico
	}

	//Exercício 6
	public void construirGrafoDeArquivo(String nomeArquivo) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));

			// Ler o número de vértices
			int numVertices = Integer.parseInt(br.readLine());
			this.n = numVertices;
			this.m = 0; // Inicializar o número de arestas como 0
			this.adj = new int[numVertices][numVertices]; // Inicializar a matriz de adjacência

			// Inicializar a matriz com zeros
			for(int i = 0; i < numVertices; i++) {
				for(int j = 0; j < numVertices; j++) {
					adj[i][j] = 0;
				}
			}

			// Ler o número de arestas
			int numArestas = Integer.parseInt(br.readLine());

			// Ler as arestas do arquivo e preencher a matriz de adjacência
			String linha;
			while ((linha = br.readLine()) != null) {
				String[] partes = linha.split(" ");
				int v = Integer.parseInt(partes[0]);
				int w = Integer.parseInt(partes[1]);
				insereA(v, w); // Adiciona a aresta ao grafo
			}

			br.close();
		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo: " + e.getMessage());
		}
	}

	public void removeVertice(int v) {
		// Remover arestas associadas ao vértice v
		for (int i = 0; i < n; i++) {
			if (adj[v][i] == 1) {
				removeA(v, i);
			}
			if (adj[i][v] == 1) {
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
	
	//exercicio 10
	public boolean isCompletoNDirecional() {
        int n = adj.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (adj[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }
	
	//exercicio 11
	public boolean isCompletoDirecional() {
        int n = adj.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && adj[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }
	
	//exercicio 12
	public int[][] complementoGrafo() {
        int n = adj.length;
        int[][] complemento = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                complemento[i][j] = complemento[j][i] = 1 - adj[i][j];
            }
        }

        return complemento;
    }
	
	//exercicio 13
	public boolean isConexo() {
        int n = adj.length;
        boolean[] visitados = new boolean[n];
        
        Stack<Integer> pilha = new Stack<>();
        pilha.push(0);
        
        while (!pilha.isEmpty()) {
            int v = pilha.pop();
            visitados[v] = true;
            
            for (int i = 0; i < n; i++) {
                if (adj[v][i] == 1 && !visitados[i]) {
                    pilha.push(i);
                }
            }
        }
        
        for (boolean visitado : visitados) {
            if (!visitado) {
                return false;
            }
        }
        
        return true;
    }
	
	//exercicio 14
	public int categoriaConexidade() {
        int n = adj.length;
        boolean[] visitados = new boolean[n];

        // Função auxiliar para realizar uma busca em profundidade
        void dfs(int s) {
            visitados[s] = true;
            for (int i = 0; i < n; i++) {
                if (matrizAdjacencia[s][i] == 1 && !visitados[i]) {
                    dfs(i);
                }
            }
        }

        // 1ª DFS para verificar se o grafo é fortemente conexo
        dfs(0); // Começa a busca a partir de um vértice qualquer
        for (boolean visitado : visitados) {
            if (!visitado) {
                return 0; // Não é fortemente conexo
            }
        }

        // Transpor a matriz de adjacência para verificar se o grafo transposto é fortemente conexo
        int[][] transposta = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transposta[i][j] = matrizAdjacencia[j][i];
            }
        }

        // Reiniciar os visitados
        Arrays.fill(visitados, false);
        dfs(0); // Começa a busca a partir do mesmo vértice inicial no grafo transposto

        for (boolean visitado : visitados) {
            if (!visitado) {
                return 2; // É semi-fortemente conexo
            }
        }

        // Se chegou aqui, o grafo é fortemente conexo
        return 3;
    }
	
}
