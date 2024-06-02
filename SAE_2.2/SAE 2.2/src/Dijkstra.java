import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Dijkstra {

    public static Valeur resoudre(Graphe g, String depart) {
        Valeur valeurs = new Valeur();
        PriorityQueue<String> Q = new PriorityQueue<>(Comparator.comparing(valeurs::getValeur));

        for (String noeud : g.listeNoeuds()) {
            valeurs.setValeur(noeud, Double.MAX_VALUE);
            valeurs.setParent(noeud, null);
            Q.add(noeud);
        }

        valeurs.setValeur(depart, 0.0);

        while (!Q.isEmpty()) {
            String u = Q.poll();

            for (Arc arc : g.suivants(u)) {
                String v = arc.getDest();
                double poidsUV = arc.getCout();
                double nouvelleValeur = valeurs.getValeur(u) + poidsUV;

                if (nouvelleValeur < valeurs.getValeur(v)) {
                    Q.remove(v);
                    valeurs.setValeur(v, nouvelleValeur);
                    valeurs.setParent(v, u);
                    Q.add(v);
                }
            }
        }

        return valeurs;
    }
}
