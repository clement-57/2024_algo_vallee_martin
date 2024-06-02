import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class MainDijkstra {

    public static void main(String[] args) {
        GrapheListe graphe = new GrapheListe();

        try (BufferedReader br = new BufferedReader(new FileReader("Graphe1.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length == 3) {
                    String depart = parts[0];
                    String destination = parts[1];
                    double cout = Double.parseDouble(parts[2]);
                    graphe.ajouterArc(depart, destination, cout);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String depart = "1";
        Valeur valeurs = Dijkstra.resoudre(graphe, depart);

        for (int i = 2; i <= 30; i++) {
            afficherChemin(valeurs, String.valueOf(i));
        }
    }

    private static void afficherChemin(Valeur valeurs, String destination) {
        List<String> chemin = valeurs.calculerChemin(destination);
        if (chemin.isEmpty() || chemin.size() == 1 && chemin.get(0).equals(destination)) {
            System.out.println("Pas de chemin trouvé de 1 à " + destination);
        } else {
            System.out.print("Chemin de 1 à " + destination + " : ");
            for (String noeud : chemin) {
                System.out.print(noeud + " ");
            }
            System.out.println("\nValeur : " + valeurs.getValeur(destination));
        }
    }
}
