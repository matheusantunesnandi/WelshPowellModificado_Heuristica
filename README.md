# Projeto WelshPowellModificado_Heuristica
Heurística usada no algorimto de Welsh Powell.
Vídeo explicativo que inspirou este projeto: https://www.youtube.com/watch?v=WacW3WwBCko

Etapas para coloração Heurística:
1 - Deve-se verficar o grau de cada vértice e coloca-los em 
ordem decrescente.
2 - Selecionar o vértice de maior grau da lista.
3 - Verificar seus vizinhos para ver quais cores estão disponíveis.
	-Caso seja o primeiro vértice, adicionar a primeira cor.
	-Caso não for o primeiro vértice, verificar a cor dos vizinhos.
	-A próxima cor da lista de cores disponíveis é a nova cor do .


Entrada: Grafo G com lista de vértices v1, v2
Saída: Uma coloração de vértices f: V > {1,2,...}

Por Matheus Antunes Nandi e Gabriel Cavalcante dos Santos
