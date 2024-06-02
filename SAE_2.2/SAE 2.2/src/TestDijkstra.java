import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestDijkstra {

    @Test
    public void TestResoudre() {
        GrapheListe graphe = new GrapheListe();

        graphe.ajouterArc("A", "B", 12.0);
        graphe.ajouterArc("A", "D", 87.0);
        graphe.ajouterArc("B", "E", 11.0);
        graphe.ajouterArc("D", "B", 23.0);
        graphe.ajouterArc("D", "C", 10.0);
        graphe.ajouterArc("E", "D", 43.0);

        Valeur result = Dijkstra.resoudre(graphe, "A");

        assertEquals(0.0, result.getValeur("A"));
        assertEquals(12.0, result.getValeur("B"));
        assertEquals(76.0, result.getValeur("C")); // A -> B -> E -> D -> C
        assertEquals(66.0, result.getValeur("D")); // A -> B -> E -> D
        assertEquals(23.0, result.getValeur("E")); // A -> B -> E

        assertNull(result.getParent("A"));
        assertEquals("A", result.getParent("B"));
        assertEquals("D", result.getParent("C"));
        assertEquals("E", result.getParent("D"));
        assertEquals("B", result.getParent("E"));
    }
}
