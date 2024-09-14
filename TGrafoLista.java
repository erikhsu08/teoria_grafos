/*
NOME: Erik Samuel Viana Hsu         RA: 10403109
NOME: Mateus Kenzo Iochimoto        RA: 10400995
NOME: Thiago Shihan Cardoso Toma    RA: 10400764
 */

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//definicao da classe de nós da lista
class TNo{ // define uma struct (registro)
    public	int w;  // vértice que é adjacente ao elemento da lista
    public TNo prox;

    TNo(){

    }
    TNo(int w){
        this.w = w;
        this.prox = null;
    }
}

public class TGrafoLista {
    // Atributos Privados
    private	int n; // quantidade de vértices
    private	int m; // quantidade de arestas
    private	TNo lista_adj[]; // um vetor onde cada entrada guarda o inicio de uma lista

    public TGrafoLista(int n ) {
        // aloca a estrutura TGrafo
        this.n = n;
        this.m = 0;
        // aloca m vetor para guardar lista de adjacencias
        TNo adjac[] = new TNo[n];
        // Inicia o vetor com nullL
        for(int i = 0; i< n; i++)
            adjac[i]=null;
        this.lista_adj = adjac;
    };

    public void insereA( int v, int w) {

        TNo novoNo;
        // anda na lista para chegar ao final
        TNo no = lista_adj[v];
        TNo ant = null;
        // anda na lista enquanto no != NULL E w  > no->w
        while( no != null && w >= no.w ){
            if( w == no.w)
                return;
            ant = no;
            no = no.prox;
        };
        // cria o novo No para guardar w
        novoNo = new TNo();
        novoNo.w = w;
        novoNo.prox = no;
        // atualiza a lista
        if( ant == null){
            // insere no inicio
            lista_adj[v] = novoNo;
        } else
            // insere no final
            ant.prox = novoNo;
        m++;
    }

    public void removeA( int v, int w) {
        // Obtém o início da lista do vértice v
        TNo no = lista_adj[v];
        TNo ant = null;
        // Percorre a lista do vértice v
        // procurando w (se adjacente)
        while( no != null && no.w != w ){
            ant = no;
            no = no.prox;
        }
        // Se w é adjacente, remove da lista de v
        if (no != null){
            ant.prox = no.prox;
            no = null;
            m--;
        }
    }

    public void show() {
        System.out.print("n: " + n);
        System.out.print("\nm: " + m + "\n");
        for( int i=0; i < n; i++){
            System.out.print("\n" + i + ": ");
            // Percorre a lista na posição i do vetor
            TNo no = lista_adj[i];
            while( no != null ){
                System.out.print(no.w + " ");
                no = no.prox;
            }
        }
        System.out.print("\n\nfim da impressao do grafo.\n");
    }



    //------------EXERCÍCIOS----------------

    //Exercicio 19
    public void inverterAdjacencias(){
        for (int i = 0; i < n; i++){
            TNo ant = null;
            TNo atual = lista_adj[i];
            TNo prox = null;

            //Percorre a lista de adjacencia e inverte os vizinhos
            while (atual != null){
                prox = atual.prox;
                atual.prox = ant;
                ant = atual;
                atual = prox;
            }

            //Atualiza o head da lista
            lista_adj[i] = ant;
        }
    }

    //Exercício 20
    public int ehFonte(int v){
        //Verifica se o grau de entrada é = 0
        for (int i = 0; i < n; i++){
            TNo atual = lista_adj[i]; //Percorre a lista de adj. de cada vertice
            while(atual != null){
                if (atual.w == v){
                    return 0;   //O vértice v tem entrada, então não é fonte
                }
                atual = atual.prox;
            }
        }

        //Verifica se o grau de saída é maior que 0
        if (lista_adj[v] != null){
            return 1; //O vertice v tem saída e não tem entrada, então é fonte
        }
        return 0; //Caso contrário, não é fonte
    }

    //Exercício 21
    public int ehSorvedouro(int v){
        //Verifica se o grau de saída é 0
        if (lista_adj[v] != null){
            return 0; //O vertice v tem saída, nao eh sorvedouro
        }

        //Verifica se o grau de entrada é maior que 0
        for (int i = 0; i < n; i++){
            TNo adjacente = lista_adj[i]; //Percorre a lista de adj. de cada vertice
            while(adjacente != null){
                if (adjacente.w == v){
                    return 1;   //O vértice v tem entrada, então não é fonte
                }
                adjacente = adjacente.prox;
            }
        }
        return 0; //Caso contrário, não é sorvedouro
    }

    //Exercício 22
    public int ehSimetrico(){
        //Percorre cada vertice u
        for (int u = 0; u < n; u++){
            TNo adjacente = lista_adj[u];

            //Percorre todos os vertices adjacentes a u
            while (adjacente != null){
                int v = adjacente.w;

                //verifica se existe uma aresta de v para u
                boolean existe = false;
                TNo adjListaV = lista_adj[v];
                while (adjListaV != null){
                    if (adjListaV.w == u){
                        existe = true;
                        break;
                    }
                    adjListaV = adjListaV.prox;
                }
                //Se não existe aresta inversa, o grafo não é simétrico
                if(!existe){
                    return 0;
                }
                adjacente = adjacente.prox;
            }
        }
        return 1; //Se todas as arestas são simétricas, o grafo é simétrico.
    }

    //Exercício 23
    public void construirGrafoDeArquivo(String nomeArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            // Lê o número de vértices
            this.n = Integer.parseInt(br.readLine());
            // Lê o número de arestas
            this.m = Integer.parseInt(br.readLine());
            // Inicializa a lista de adjacência
            this.lista_adj = new TNo[n];

            // Lê as arestas e constrói o grafo
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] vertices = linha.split(" ");
                int u = Integer.parseInt(vertices[0]);
                int v = Integer.parseInt(vertices[1]);

                // Adiciona a aresta u -> v à lista de adjacências
                TNo novoNo = new TNo(v);
                novoNo.prox = lista_adj[u];
                lista_adj[u] = novoNo;
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    //Exercício 25
    public void removeVertice(int v) {
        // Verifica se o vértice está no intervalo válido
        if (v < 0 || v >= n) {
            System.out.println("Vértice inválido.");
            return;
        }

        // Remove todas as arestas que partem do vértice v
        lista_adj[v] = null;

        // Percorre todas as listas de adjacência para remover as arestas que chegam ao vértice v
        for (int i = 0; i < n; i++) {
            if (i != v) {
                TNo atual = lista_adj[i];
                TNo ant = null;

                while (atual != null) {
                    if (atual.w == v) {
                        if (ant == null) {
                            // Remover do início da lista
                            lista_adj[i] = atual.prox;
                        } else {
                            // Remover do meio ou fim da lista
                            ant.prox = atual.prox;
                        }
                        m--; // Decrementa a contagem de arestas
                        break;
                    }
                    ant = atual;
                    atual = atual.prox;
                }
            }
        }
        // Ajusta o número de vértices
        n--;

        System.out.println("Vértice " + v + " removido do grafo.");
    }

    //Exercício 26
    public boolean ehCompleto(boolean dirigido) {
        // Percorre todos os vértices
        for (int u = 0; u < n; u++) {
            // Cria um conjunto para armazenar os vértices que o vértice u está conectado
            Set<Integer> adjacentes = new HashSet<>();

            // Adiciona todos os vértices adjacentes a u
            TNo atual = lista_adj[u];
            while (atual != null) {
                adjacentes.add(atual.w);
                atual = atual.prox;
            }

            // Se for dirigido, o vértice u precisa ter uma aresta para todos os outros vértices
            // exceto ele mesmo.
            if (dirigido) {
                for (int v = 0; v < n; v++) {
                    if (v != u && !adjacentes.contains(v)) {
                        return false;  // Não há aresta u -> v, então o grafo não é completo
                    }
                }
            }
            // Se não for dirigido, verifica se o vértice u está conectado a todos os outros
            // vértices, ignorando arestas duplicadas.
            else {
                for (int v = u + 1; v < n; v++) {
                    if (!adjacentes.contains(v) && !temAresta(v, u)) {
                        return false;  // Não há aresta entre u e v, então o grafo não é completo
                    }
                }
            }
        }
        return true;  // Se todas as arestas necessárias existem, o grafo é completo
    }

    // Método auxiliar para verificar se existe uma aresta de v para u
    private boolean temAresta(int v, int u) {
        TNo atual = lista_adj[v];
        while (atual != null) {
            if (atual.w == u) {
                return true;
            }
            atual = atual.prox;
        }
        return false;
    }

}
