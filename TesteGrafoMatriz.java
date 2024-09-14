/*
NOME: Erik Samuel Viana Hsu         RA: 10403109
NOME: Mateus Kenzo Iochimoto        RA: 10400995
NOME: Thiago Shihan Cardoso Toma    RA: 10400764
 */

package GrafoMatriz;

public class TesteGrafoMatriz {
	public static void main(String args[]) {
		// Testando a classe TGrafo (Grafo Dirigido)
		System.out.println("Testando TGrafo (Grafo Dirigido):");
		TGrafo g = new TGrafo(4);

		// Insere arestas no grafo dirigido
		g.insereA(0, 1);
		g.insereA(0, 2);
		g.insereA(2, 1);
		g.insereA(2, 3);
		g.insereA(1, 3);

		// Mostra o grafo preenchido
		g.show();

		// Testa métodos de grau de entrada e saída
		System.out.println("\nGrau de entrada de 1: " + g.inDegree(1));
		System.out.println("\nGrau de saída de 2: " + g.outDegree(2));


		//Teste fonte
		System.out.println("\nO vértice 1 é uma fonte? " + (g.ehFonte(1) == 1 ? "Sim" : "Não"));

		//Teste sorvedouro
		System.out.println("\nO vértice 1 é um sorvedouro? " + (g.ehSorvedouro(1) == 1 ? "Sim" : "Não"));

		// Testa simetria
		System.out.println("\nO grafo é simétrico? " + (g.ehSimetrico() == 1 ? "Sim" : "Não"));

		// Testando o método construirGrafoDeArquivo
		TGrafo t = new TGrafo(0); // Inicializa com 0 vértices, será atualizado no método
		System.out.println("\nTestando grafo de arquivo");
		t.construirGrafoDeArquivo("grafo.txt");
		t.show();

		// Testando a classe TGrafoND (Grafo Não-Dirigido Rotulado)
		System.out.println("\nTestando TGrafoND (Grafo Não-Dirigido Rotulado):");
		TGrafoND gnd = new TGrafoND(4);

		// Insere arestas rotuladas no grafo não-dirigido
		gnd.insereA(0, 1, 2.5f);
		gnd.insereA(0, 2, 3.5f);
		gnd.insereA(2, 3, 1.5f);
		gnd.insereA(1, 3, 4.5f);

		// Mostra o grafo preenchido
		gnd.show();

		//Teste removeA
		System.out.println("\nTestando remoção de aresta");
		gnd.removeA(1,3);
		gnd.show();

		// Testa remoção de vértice no grafo não-dirigido
		System.out.println("\nTestando remoção de vértice");
		gnd.removeVertice(1);
		gnd.show();
	}
}
