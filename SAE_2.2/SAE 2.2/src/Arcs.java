import java.util.ArrayList;
import java.util.List;

public class Arcs {
    private List<Arc> arcs;

    public Arcs() {
        this.arcs = new ArrayList<>();
    }

    public void ajouterArc(Arc a) {
        arcs.add(a);
    }

    public List<Arc> getArcs() {
        return arcs;
    }
}
