"""
NOME: Erik Samuel Viana Hsu
RA: 10403109
NOME: Mateus Kenzo Iochimoto
RA: 10400995
NOME: Thiago Shihan Cardoso Toma
RA: 10400764
"""

class Node:
    
    def __init__(self, nome) -> None:
        self.nome = nome
        self.arestas = []
    
    def insereAresta(self, aresta):
        self.arestas.append(aresta)
