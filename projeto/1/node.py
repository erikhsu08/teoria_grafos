
class Node:
    
    def __init__(self, nome) -> None:
        self.nome = nome
        self.arestas = []
        print(f"Node {nome} criado com sucesso")
    
    def insereAresta(self, aresta):
        self.arestas.append(aresta)
        print(f"Aresta {aresta} inserida com sucesso em {id(self.arestas)}")