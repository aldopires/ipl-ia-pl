package metodos;

import agente.Estado;
import agente.No;
import java.util.List;
import utils.NodePriorityQueue;

public class PesquisaUniforme extends MetodoPesquisaAGP<NodePriorityQueue> {

    public PesquisaUniforme() {
        nosPorExpandir = new NodePriorityQueue();
    }
    public static final String NOME = "Uniforme";

    @Override
    public void inserirSucessores(No noAExpandir, List<Estado> listaSucessores) {
        double custo;
        for (Estado est : listaSucessores) {
            custo = noAExpandir.getG() + est.getOperador().getCusto();
            if(!nosPorExpandir.contemEstado(est)){
                if(!nosExpandidos.contains(est)){
                    No no = new No(est, noAExpandir, custo, custo);
                    nosPorExpandir.add(no);
                }
            } else if (nosPorExpandir.getNo(est).getG() > custo){
                nosPorExpandir.removeNo(est);
                nosPorExpandir.add(new No(est, noAExpandir, custo, custo));
            }
        }
    }

    @Override
    public String toString() {
        return NOME;
    }
}
