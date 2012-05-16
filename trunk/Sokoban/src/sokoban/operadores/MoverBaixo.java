/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban.operadores;

import agente.Operador;
import sokoban.EstadoSokoban;
import sokoban.Celula;

/**
 *
 * @author Leonardo Lino
 */
public class MoverBaixo extends Operador<EstadoSokoban> {

    public MoverBaixo(double custo) {
        super(custo);
    }

    @Override
    public void executar(EstadoSokoban estado) {
        Celula celula = estado.getCelulaAbaixo(estado.getPosicaoAgente());
       estado.setPosicaoAgente(celula);
        
        if (celula.temCaixote()) {
            Celula celulaAbaixoCaixote = estado.getCelulaAbaixo(celula);
            celulaAbaixoCaixote.setCaixote(true);
            celula.setCaixote(false);
        }
    }

    @Override
    public boolean podeSerAplicado(EstadoSokoban estado) {
        Celula celula = estado.getCelulaAbaixo(estado.getPosicaoAgente());
        
        if (celula == null) {
            return false;
        }
        if (celula.isParede()) {
            return false;
        }
        
        if (celula.temCaixote()) {
            Celula celulaAbaixoCaixote = estado.getCelulaAbaixo(celula);
            if (celulaAbaixoCaixote == null) {
                return false;
            }
            if (celulaAbaixoCaixote.isParede() || celulaAbaixoCaixote.temCaixote()) {
                return false;
            }
        }
        return true;
    }
    
    
}