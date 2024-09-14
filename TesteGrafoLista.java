/*
NOME: Erik Samuel Viana Hsu         RA: 10403109
NOME: Mateus Kenzo Iochimoto        RA: 10400995
NOME: Thiago Shihan Cardoso Toma    RA: 10400764
 */


public class TesteGrafoLista {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // Cria um objeto para um Grafo com 4 vértices
        // Armazendo em uma lista de adjacência
        TGrafoLista g = new TGrafoLista(4);
        //insere as arestas do grafo
        //A={(0,1),(0,2),(0,3),(2,1),(2,3),(1,3)}
        g.insereA(0,1);
        g.insereA(0,2);
        g.insereA(0,3);
        g.insereA(2,1);
        g.insereA(2,3);
        g.insereA(1,3);
        // mostra o grafo preenchido
        System.out.println("Testando TGrafo em Lista de Adjacências");
        g.show();

        /*
        //Remoção
        g.removeA_lista(0,3);  // remove a aresta (0,3)
        // mostra o grafo preenchido
        System.out.print("\nDepois da remoção da aresta (0,3)\n");
        g.show_lista();
        */

        //Inverter lista de adjacencias
        g.inverterAdjacencias();
        System.out.println("\nTestando - Inversão da lista de adjacências\n");
        g.show();

        //Verificar se é fonte
        System.out.println("\nTestando - Vértice é fonte?");
        System.out.println("\nO vértice 0 é uma fonte? " + (g.ehFonte(0) == 1 ? "Sim" : "Não"));
        System.out.println("\nO vértice 3 é uma fonte? " + (g.ehFonte(3) == 1 ? "Sim" : "Não"));

        //Verificar se é sorvedouro
        System.out.println("\nTestando - Vértice é sorvedouro?");
        System.out.println("\nO vértice 0 é um sorvedouro? " + (g.ehSorvedouro(0) == 1 ? "Sim" : "Não"));
        System.out.println("\nO vértice 3 é um sorvedouro? " + (g.ehSorvedouro(3) == 1 ? "Sim" : "Não"));

        //Verificar se o grafo é simétrico
        System.out.println("\nTestando - Grafo é simétrico?");
        System.out.println("\nO grafo é simétrico? " + (g.ehSimetrico() == 1 ? "Sim" : "Não"));

        // Testando o método construirGrafoDeArquivo
        TGrafoLista z = new TGrafoLista(0); // Inicializa com 0 vértices, será atualizado no método
        System.out.println("\nTestando construção de grafo em lista de adjacência lido do arquivo");
        z.construirGrafoDeArquivo("grafos_lista.txt");
        z.show();


        //Remover vertices do grafo direcionado
        System.out.println("\n Testando - Remover Vertices Grafo DIRECIONADO\n");
        System.out.println("\nRemovendo vértice 1:");
        g.removeVertice(1);
        g.show();

        //Verificar se o grafo é completo
        System.out.println("\n Testando - Verificar se o grafo inicial é completo\n");
        System.out.println("\nO grafo é completo? " + (g.ehCompleto(true) ? "Sim" : "Não"));

        //EXERCÍCIOS COM GRAFOS NÃO DIRECIONADOS
        TGrafoND_lista grafoND_lista = new TGrafoND_lista(5);
        grafoND_lista.insereA(0, 1);
        grafoND_lista.insereA(0, 2);
        grafoND_lista.insereA(1, 3);
        grafoND_lista.insereA(2, 3);
        grafoND_lista.insereA(3, 4);
        System.out.println("\nTestes com grafo não direcionado\n");
        System.out.println("\nGrafo original:\n");
        grafoND_lista.show();


        //Remover vertices do grafo nao direcionado
        System.out.println("\n Testando - Remover Vertices Grafo NÃO DIRECIONADO\n");
        System.out.println("\nRemovendo vértice 2:");
        grafoND_lista.removeVertice(2);
        grafoND_lista.show();

    }




}
