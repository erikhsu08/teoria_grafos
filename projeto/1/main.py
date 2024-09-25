from TGrafo import TGrafo

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

def main():
    while True:
        printMenu()
        opcao = input("Digite a opção: ")
        if (opcao == "a"):
            grafo = TGrafo()
            grafo.lerArquivo("grafo.txt")
            grafo.show()
        
        elif (opcao == "b"): #todo
            continue

        elif (opcao == "c"):
            continue
"""def main():
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
"""
main()