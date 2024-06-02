public class BellmanFord {

    public static Valeur resoudre(Graphe g, String depart) {
        Valeur valeurs = new Valeur();

        for (String noeud : g.listeNoeuds()) {
            valeurs.setValeur(noeud, Double.MAX_VALUE);
            valeurs.setParent(noeud, null);
        }

        valeurs.setValeur(depart, 0.0);

        boolean modifie;
        do {
            modifie = false;
            for (String noeud : g.listeNoeuds()) {
                for (Arc arc : g.suivants(noeud)) {
                    String destination = arc.getDest();
                    double nouveauCout = valeurs.getValeur(noeud) + arc.getCout();
                    if (nouveauCout < valeurs.getValeur(destination)) {
                        valeurs.setValeur(destination, nouveauCout);
                        valeurs.setParent(destination, noeud);
                        modifie = true;
                    }
                }
            }
        } while (modifie);

        return valeurs;
    }
}