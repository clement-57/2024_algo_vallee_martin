SAE VALLEE MARTIN, S2-A, 2024


1. Présentation de la SAE
Le projet consiste à faire deux algorithme qui permettent de trouver le chemin minimal pour un graphe en utilisant l'algorithme de Bellman-Ford ou alors de Dijkstra.

2. Représentation d’un graphe
2.1 TAD Graphe
Pour représenter un graphe, nous utilisons une structure de données abstraite (TAD) qui comprend :

Nœuds : Les points du graphe.
Arcs : Les connexions entre les nœuds, chaque arc ayant un coût associé.
Les opérations principales sont :

listeNoeuds : Renvoie la liste des nœuds du graphe.
suivants : Donne la liste des arcs partant d'un nœud donné.
2.2 Interface Graphe
Les nœuds sont représentés par des chaînes de caractères (String en Java).

Classe Arc
Cette classe représente un arc avec :

Un nœud de destination.
Un coût associé.
Gestion d’un ensemble d’arcs
Pour gérer les arcs partant d'un nœud, une classe Arcs est utilisée, comprenant :

Une liste d'arcs.
Des méthodes pour ajouter et récupérer des arcs.
Interface Graphe
Cette interface comprend les méthodes pour obtenir la liste des nœuds et les arcs partant d'un nœud donné.

2.3 Implémentation GrapheListe
Cette classe implémente l'interface Graphe et représente les données d'un graphe avec :

Une liste de nœuds.
Une liste d'arcs pour chaque nœud.
Méthode ajouterArc

Cette méthode ajoute des arc pour relier les nœuds du graphe

Affichage d’un graphe

Une méthode toString permet d'afficher le graphe sous une forme structurée.

3. Calcul du plus court chemin par point fixe
3.1 Algorithme du point fixe
L'algorithme de Bellman-Ford trouve le plus court chemin en :
la méthode de point fixe permet de calculer le chemin minimal en calculent chaque valeur jusqu'à un point fixe ou chaque nœuds a une valeur fixe
