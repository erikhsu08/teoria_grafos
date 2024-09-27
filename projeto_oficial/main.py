"""
NOME: Erik Samuel Viana Hsu
RA: 10403109
NOME: Mateus Kenzo Iochimoto
RA: 10400995
NOME: Thiago Shihan Cardoso Toma
RA: 10400764
"""

from grafoLista import Grafo

def carregar_grafo(arquivo):
    with open(arquivo, 'r', encoding='utf-8') as f:
        tipo_grafo = int(f.readline().strip())
        n = int(f.readline().strip())
        grafo = Grafo(n)

        # Lendo vértices e associando as músicas
        for i in range(n):
            linha = f.readline().strip()
            if linha.startswith(str(i)):  # Verifica se a linha começa com o índice
                partes = linha.split(' ', 1)  # Divide em número e nome da música
                musica = partes[1].strip('"')  # Remove aspas
                grafo.set_musica(i, musica)  # Associa a música ao vértice

        # Lendo arestas
        m = int(f.readline().strip())
        for _ in range(m):
            linha = f.readline().strip().split()
            v = int(linha[0])
            w = int(linha[1])
            grafo.insereA(v, w)
        
        print(grafo.musicas)
        print(len(grafo.musicas))
    
    f.close()
    
    return grafo


def gravar_grafo(grafo, arquivo):
    with open(arquivo, 'w') as f:
        f.write(f"0\n")  # Tipo do grafo (0 para não orientado)
        f.write(f"{grafo.V}\n")  # Número de vértices
        # Se precisar salvar pesos ou rótulos dos vértices, adicione aqui

        # Grava arestas
        arestas = sum(len(adj) for adj in grafo.adj)
        f.write(f"{arestas}\n")  # Número de arestas
        for v in range(grafo.V):
            for w in grafo.adj[v]:
                f.write(f"{v} {w}\n")
    
    f.close()

def menu():
    grafo = None
    while True:
        print("\nMenu de opções: ")
        print("a. Ler dados do arquivo")
        print("b. Gravar dados no arquivo")
        print("c. Inserir vértice")
        print("d. Inserir aresta")
        print("e. Remover vértice")
        print("f. Remover aresta")
        print("g. Mostrar conteúdo do arquivo")
        print("h. Mostrar grafo")
        print("i. Apresentar a conexidade do grafo")
        print("j. Sair")

        opcao = input("\nEscolha uma opção: ")
        if opcao == "a":
            arquivo = input("Digite o nome do arquivo: ")
            grafo = carregar_grafo(arquivo)
            print("Grafo criado!")
        elif opcao == "b":
            if grafo:
                arquivo = input("\nDigite o nome do arquivo para gravar: ")
                gravar_grafo(grafo, arquivo)
                print(f"Grafo gravado em {arquivo}.")
            else:
                print("Grafo não carregado.")
        elif opcao == "c":
            if grafo is not None: 
                v = input("\nDigite o nome da música a ser inserida: ")
                grafo.adj.append([])  # Adiciona nova lista de adjacência
                grafo.musicas[grafo.V] = v
                print(f"Vértice {grafo.V} inserido.")
                grafo.V += 1
            else:
                print("Grafo não carregado.")
        elif opcao == "d":
            if grafo:
                v = int(input("\nDigite o vértice de origem: "))
                w = int(input("Digite o vértice de destino: "))
                if v < grafo.V and w < grafo.V:
                    grafo.insereA(v, w)
                    print(f"Aresta {v} -> {w} inserida.")
                else:
                    print("Vértice(s) inválido(s).")
            else:
                print("Grafo não carregado.")
        elif opcao == "e":
            if grafo:
                v = int(input("Digite o vértice a ser removido: "))
                if 0 <= v < grafo.V:
                    grafo.V -= 1
                    grafo.adj.pop(v)  # Remove o vértice
                    print(f"Vértice {v} removido.")
                else:
                    print("Vértice inválido.")
            else:
                print("Grafo não carregado.")
        elif opcao == "f":
            if grafo:
                v = int(input("Digite o vértice de origem: "))
                w = int(input("Digite o vértice de destino: "))
                grafo.removeA(v, w)
                print(f"Aresta {v} -> {w} removida.")
            else:
                print("Grafo não carregado.")
        
        elif opcao == "g":
            pass

        elif opcao == "h":
            if grafo:
                grafo.show()
            else:
                print("Grafo não carregado.")
        elif opcao == "i":
            if grafo:
                # Para simplicidade, apresentamos apenas que o grafo é conectado ou não
                # Aqui, você pode implementar um algoritmo para verificar a conectividade
                print("Conexidade do grafo não implementada ainda.")
            else:
                print("Grafo não carregado.")
        elif opcao == "j":
            break
        else:
            print("Opção inválida.")

menu()
