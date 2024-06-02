import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Valeur {
    private final double INFINI = Double.MAX_VALUE;
    private final String INCONNU = "";
    private Map<String, Double> valeurs;
    private Map<String, String> parents;

    public Valeur() {
        valeurs = new HashMap<>();
        parents = new HashMap<>();
    }

    public void setValeur(String noeud, double valeur) {
        valeurs.put(noeud, valeur);
    }

    public double getValeur(String noeud) {
        return valeurs.getOrDefault(noeud, Double.POSITIVE_INFINITY);
    }

    public void setParent(String noeud, String parent) {
        parents.put(noeud, parent);
    }

    public String getParent(String noeud) {
        return parents.get(noeud);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Double> entry : valeurs.entrySet()) {
            sb.append(entry.getKey()).append(" -> ").append(entry.getValue()).append(" (");
            String parent = parents.get(entry.getKey());
            if (parent != null) {
                sb.append(parent);
            } else {
                sb.append("null");
            }
            sb.append(")\n");
        }
        return sb.toString();
    }

    public List<String> calculerChemin(String destination) {
        List<String> chemin = new ArrayList<>();
        String noeud = destination;
        while (noeud != null) {
            chemin.add(0, noeud);
            noeud = getParent(noeud);
        }
        return chemin;
    }
}
