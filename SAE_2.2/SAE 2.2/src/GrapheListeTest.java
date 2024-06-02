import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class GrapheListeTest {

    @Test
    public void testAjoutNoeudsEtArcs() {
        GrapheListe graphe = new GrapheListe();

        graphe.ajouterArc("A", "B", 12);
        graphe.ajouterArc("A", "D", 87);
        graphe.ajouterArc("B", "E", 11);
        graphe.ajouterArc("C", "A", 19);
        graphe.ajouterArc("D", "B", 23);
        graphe.ajouterArc("D", "C", 10);
        graphe.ajouterArc("E", "D", 43);

        List<String> noeuds = graphe.listeNoeuds();
        assertEquals(5, noeuds.size());
        assertTrue(noeuds.contains("A"));
        assertTrue(noeuds.contains("B"));
        assertTrue(noeuds.contains("C"));
        assertTrue(noeuds.contains("D"));
        assertTrue(noeuds.contains("E"));

        List<Arc> arcsA = graphe.suivants("A");
        assertEquals(2, arcsA.size());
        assertEquals("B", arcsA.get(0).getDest());
        assertEquals(12, arcsA.get(0).getCout());
        assertEquals("D", arcsA.get(1).getDest());
        assertEquals(87, arcsA.get(1).getCout());

        List<Arc> arcsB = graphe.suivants("B");
        assertEquals(1, arcsB.size());
        assertEquals("E", arcsB.get(0).getDest());
        assertEquals(11, arcsB.get(0).getCout());

        List<Arc> arcsC = graphe.suivants("C");
        assertEquals(1, arcsC.size());
        assertEquals("A", arcsC.get(0).getDest());
        assertEquals(19, arcsC.get(0).getCout());

        List<Arc> arcsD = graphe.suivants("D");
        assertEquals(2, arcsD.size());
        assertEquals("B", arcsD.get(0).getDest());
        assertEquals(23, arcsD.get(0).getCout());
        assertEquals("C", arcsD.get(1).getDest());
        assertEquals(10, arcsD.get(1).getCout());

        List<Arc> arcsE = graphe.suivants("E");
        assertEquals(1, arcsE.size());
        assertEquals("D", arcsE.get(0).getDest());
        assertEquals(43, arcsE.get(0).getCout());
    }

    @Test
    public void testToString() {
        GrapheListe graphe = new GrapheListe();

        graphe.ajouterArc("A", "B", 12);
        graphe.ajouterArc("A", "D", 87);
        graphe.ajouterArc("B", "E", 11);
        graphe.ajouterArc("C", "A", 19);
        graphe.ajouterArc("D", "B", 23);
        graphe.ajouterArc("D", "C", 10);
        graphe.ajouterArc("E", "D", 43);

        String expected = "A -> B(12) D(87) \n" +
                "B -> E(11) \n" +
                "C -> A(19) \n" +
                "D -> B(23) C(10) \n" +
                "E -> D(43) \n";

        assertEquals(expected, graphe.toString());
    }
}
