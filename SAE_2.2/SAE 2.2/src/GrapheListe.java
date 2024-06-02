import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GrapheListe implements Graphe {
    private ArrayList<String> noeuds;
    private ArrayList<Arcs> adjacence;

    public GrapheListe() {
        noeuds = new ArrayList<>();
        adjacence = new ArrayList<>();
    }

    public GrapheListe(String filename) {
        this();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 3) {
                    String depart = parts[0];
                    String destination = parts[1];
                    double cout = Double.parseDouble(parts[2]);
                    ajouterArc(depart, destination, cout);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> listeNoeuds() {
        return noeuds;
    }

    @Override
    public List<Arc> suivants(String n) {
        int indice = getIndice(n);
        if (indice == -1) {
            return new ArrayList<>();
        }
        return adjacence.get(indice).getArcs();
    }

    public void ajouterArc(String depart, String destination, double cout) {
        int indiceDepart = getIndice(depart);
        int indiceDestination = getIndice(destination);

        if (indiceDepart == -1) {
            noeuds.add(depart);
            adjacence.add(new Arcs());
            indiceDepart = noeuds.size() - 1;
        }
        if (indiceDestination == -1) {
            noeuds.add(destination);
            adjacence.add(new Arcs());
            indiceDestination = noeuds.size() - 1;
        }

        adjacence.get(indiceDepart).ajouterArc(new Arc(destination, cout));
    }

    private int getIndice(String n) {
        return noeuds.indexOf(n);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        List<String> sortedNoeuds = new ArrayList<>(noeuds);
        Collections.sort(sortedNoeuds);

        for (String noeud : sortedNoeuds) {
            int index = noeuds.indexOf(noeud);
            result.append(noeud).append(" -> ");
            List<Arc> arcs = new ArrayList<>(adjacence.get(index).getArcs());
            arcs.sort(Comparator.comparing(Arc::getDest));
            for (Arc arc : arcs) {
                result.append(arc.getDest())
                        .append("(")
                        .append(arc.getCout() % 1.0 == 0 ? String.format("%.0f", arc.getCout()) : arc.getCout())
                        .append(") ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
