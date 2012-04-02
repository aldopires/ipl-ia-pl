/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AreaDesenho.java
 *
 * Created on 2/Abr/2012, 14:49:11
 */
package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Leonardo Lino
 */
public class AreaDesenho extends javax.swing.JPanel {

    /** Creates new form AreaDesenho */
    public AreaDesenho() {
        initComponents();
    }
    
    public void carregaPuzzle(String puzzleFile) {
        String puzzle = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader("./src/puzzles/" + puzzleFile));
            String str;
            while ((str = in.readLine()) != null) {
                if (puzzle == null) {
                     puzzle = str;
                } else {
                    puzzle = puzzle + str;
                }
            }
            in.close();
        } catch (IOException e) {
        }

        System.out.println(puzzle);

    }

    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
