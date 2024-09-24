"""
NOME: Erik Samuel Viana Hsu
RA: 10403109
NOME: Mateus Kenzo Iochimoto
RA: 10400995
NOME: Thiago Shihan Cardoso Toma
RA: 10400764
"""

import networkx as nx #usar comando "pip install networkx" no terminal
import matplotlib.pyplot as plt #usar comando "pip install matplotlib" no terminal
import scipy as sp #usar comando "pip install scipy" no terminal

"""
todo
O menu do projeto de grafos: 3) o desenvolvimento de uma aplicação contendo um menu de opções que permita
a) Ler dados do arquivo grafo.txt; (👍)
b) Gravar dados no arquivo grafo.txt; (👍)
c) Inserir vértice; (👍)
d) Inserir aresta; (👍)
e) Remove vértice; (👍)
f) Remove aresta; (👍)
g) Mostrar conteúdo do arquivo; (👍)
h) Mostrar grafo; (👍)
i) Apresentar a conexidade do grafo e o reduzido;
j) Encerrar a aplicação. (👍)
"""

def printMenu():
    print("\nSelecione uma opção para prosseguir: ")
    print(" a) Ler dados do arquivo grafo.txt")
    print(" b) Gravar dados no arquivo grafo.txt")
    print(" c) Inserir vértice")
    print(" d) Inserir aresta")
    print(" e) Remove vértice")
    print(" f) Remove aresta")
    print(" g) Mostrar conteúdo do arquivo")
    print(" h) Mostrar grafo")
    print(" i) Apresentar a conexidade do grafo e o reduzido")
    print(" j) Encerrar a aplicação.")

def lerArquivo(graph): #está funcionando
    try:
        with open("grafo.txt" , "r") as f:
            edge_list = []

            linhas = f.readlines()
            for i in range(len(linhas)):
                linhas[i] = linhas[i].strip().split() #tratamento da string
                edge_list.append((linhas[i][0], linhas[i][1]))
            
            graph.add_edges_from(edge_list)

    except FileNotFoundError:
        print("não foi possível achar arquivo")

    f.close()

def mostraArquivo():
    try:
        with open("grafo.txt", "r") as f:
            linhas = f.readlines()
            print("\ncomeço do arquivo")
            for i in range(len(linhas)):
                print(linhas[i].strip())
            print("fim do arquivo\n")
    except FileNotFoundError:
        print("Arquivo não encontrado")

    f.close()

def main():
    while True:
        printMenu()
        opcao = input("Digite a opção: ")
        if (opcao == "a"):
            G = nx.DiGraph()
            lerArquivo(G)
            continue

        elif (opcao == "b"):
            nx.write_edgelist(G, "grafo.txt", data=False)
            continue

        elif (opcao == "c"):
            v = input("Digite o vértice a ser criado: ")
            try:
                G.add_node(v)
            except UnboundLocalError:
                print("O grafo ainda não foi criado")
            continue
            
        elif (opcao == "d"):
            v1 = input("A aresta sai de qual vértice... ")
            v2 = input("a aresta termina em qual vértice? ")
            try:
                G.add_edge(v1, v2)
            except UnboundLocalError:
                print("O grafo ainda não foi criado")
            continue
        
        elif (opcao == "e"):
            v = input("Digite o vértice a ser removido: ")
            try:
                G.remove_node(v)
            except UnboundLocalError:
                print("O grafo ainda não foi criado")
            continue

        elif (opcao == "f"):
            v1 = input("A aresta sai de qual vértice... ")
            v2 = input("a aresta termina em qual vértice? ")
            try:
                G.remove_edge(v1, v2)
            except UnboundLocalError:
                print("O grafo ainda não foi criado")
            continue

        elif (opcao == "g"):
            mostraArquivo()
            continue

        elif (opcao == "h"):
            nx.draw_circular(G, with_labels=True)
            plt.show()
            continue

        elif (opcao == "j"):
            print("\nPrograma encerrado")
            break

main()