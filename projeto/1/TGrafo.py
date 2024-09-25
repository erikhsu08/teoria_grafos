from node import Node
import networkx as nx #usar comando "pip install networkx" no terminal
import matplotlib.pyplot as plt #usar comando "pip install matplotlib" no terminal

class TGrafo:
    
    def __init__(self, n=0, vertices=[],nodes=[]) -> None:
        self.n = n
        self.vertices = vertices
        self.nodes = nodes

    def add_node(self, node):
        v = Node(node)
        self.nodes.append(v)
        self.n =+ 1

    def get_n(self):
        return self.n
    
    def get_node(self, nome) -> Node:
        v = None
        for i in range(len(self.nodes)):
            v = self.nodes[i]
            if v.nome == nome:
                return v

    def lerArquivo(self, file):
        try:
            with open(file, "r") as f:
                
                linhas = f.readlines()
                for i in range(len(linhas)):
                    linhas[i] = linhas[i].strip().split() #tratamento da string

                    self.add_node(linhas[i][0])
                    self.get_node(linhas[i][0]).insereAresta(linhas[i][1])

        except FileNotFoundError:
            print("Arquivo não encontrado")
        
        f.close()

    def get_edgelist(self):
        edge_list = []

        for node in self.nodes:
            for edge in node.arestas:
                edge_list.append((node.nome, edge))

        return edge_list

    def show(self):
        G = nx.DiGraph()
        G.add_edges_from(self.get_edgelist())
        nx.draw_circular(G, with_labels=True)
        plt.show()