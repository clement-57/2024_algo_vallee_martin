public class Main {
    public static void main(String[] args) {
        GrapheListe graphe = new GrapheListe();

        graphe.ajouterArc("A", "B", 12);
        graphe.ajouterArc("A", "C", 87);
        graphe.ajouterArc("A", "D", 19);
        graphe.ajouterArc("B", "E", 10);
        graphe.ajouterArc("C", "D", 23);
        graphe.ajouterArc("C", "E", 43);
        graphe.ajouterArc("D", "E", 11);

        System.out.println(graphe.toString());

        BellmanFord bellmanFord = new BellmanFord();
        Valeur resultat = bellmanFord.resoudre(graphe, "A");

        System.out.println(resultat.toString());
    }
}

