package gui;

import algorithms.CompleteGraphFinder;
import algorithms.TimeseriesToGraph;
import datastructures.graphs.AdjacencyList;
import datastructures.graphs.CompleteSubgraph;
import datastructures.vo.Threshold;
import datastructures.vo.ThresholdAbsoluteValue;
import datastructures.vo.ThresholdPercentage;
import datastructures.vo.ThresholdType;
import inout.MyReader;
import inout.MyWriter;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import utils.SimilarityDefinitions;
import vo.Summary;

public class MainFrame extends javax.swing.JFrame {
    
    private Double prosent;
    private Integer absoluteValue;
    private Integer cliqueSize;
    private File valgtFil;
    private TimeseriesToGraph algoritme;
    private List<Integer> tidsserie;
    private Threshold threshold;

    /**
     * Creates new form MainFrame2
     */
    public MainFrame() {
        initComponents();
        lagResultatfilButton.setEnabled(false);
        nettverkStatistikkButton.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jLabel3 = new javax.swing.JLabel();
        visibilityGraphtabbedPane = new javax.swing.JTabbedPane();
        noderPanel = new javax.swing.JPanel();
        valgtFilTextField = new javax.swing.JTextField();
        lagResultatfilButton = new javax.swing.JButton();
        velgInputfilButton = new javax.swing.JButton();
        beregnButton = new javax.swing.JButton();
        prosentLabel = new javax.swing.JLabel();
        prosentTextField = new javax.swing.JTextField();
        resultaterPanel = new javax.swing.JPanel();
        antallNoderLabel = new javax.swing.JLabel();
        antallNoderTextField = new javax.swing.JTextField();
        gjennomsnittLabel = new javax.swing.JLabel();
        gjennomsnitttextField = new javax.swing.JTextField();
        statusLabel = new javax.swing.JLabel();
        numConnectedComponentsLabel = new javax.swing.JLabel();
        numConnectedComponentsTextField = new javax.swing.JTextField();
        numBridgesLabel = new javax.swing.JLabel();
        numBridgesTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        numMissingDirectRelationshipsTextField = new javax.swing.JTextField();
        numCliquesLabel = new javax.swing.JLabel();
        numCliquesTextField = new javax.swing.JTextField();
        antNaboerEnVeiLabel = new javax.swing.JLabel();
        antNaboerEnVeiTextField = new javax.swing.JTextField();
        nettverkStatistikkButton = new javax.swing.JButton();
        statusNettverkLabel = new javax.swing.JLabel();
        cliqueSizeLabel = new javax.swing.JLabel();
        cliqueSizeTextField = new javax.swing.JTextField();
        nettverkNullstillButton = new javax.swing.JButton();
        absoluttverdiLabel = new javax.swing.JLabel();
        absoluttverdiTextField = new javax.swing.JTextField();

        jLabel1.setText("jLabel1");

        jButton1.setText("jButton1");

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        valgtFilTextField.setEditable(false);

        lagResultatfilButton.setText("Create result file");
        lagResultatfilButton.setToolTipText("");
        lagResultatfilButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lagResultatfilButtonActionPerformed(evt);
            }
        });

        velgInputfilButton.setText("Choose file");
        velgInputfilButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                velgInputfilButtonActionPerformed(evt);
            }
        });

        beregnButton.setText("Calculate");
        beregnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beregnButtonActionPerformed(evt);
            }
        });

        prosentLabel.setText("Percentage");

        prosentTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prosentTextFieldActionPerformed(evt);
            }
        });

        resultaterPanel.setBorder(BorderFactory.createTitledBorder("Resultater"));

        antallNoderLabel.setText("Number of nodes");

        antallNoderTextField.setEditable(false);

        gjennomsnittLabel.setText("Average number of equal neigbhors");

        gjennomsnitttextField.setEditable(false);
        gjennomsnitttextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gjennomsnitttextFieldActionPerformed(evt);
            }
        });

        numConnectedComponentsLabel.setText("Number of connected components");

        numConnectedComponentsTextField.setEditable(false);

        numBridgesLabel.setText("Number of bridges");

        numBridgesTextField.setEditable(false);

        jLabel2.setText("Number of missing edges between direct neighbors");

        numMissingDirectRelationshipsTextField.setEditable(false);

        numCliquesLabel.setText("Number of cliques");

        numCliquesTextField.setEditable(false);

        javax.swing.GroupLayout resultaterPanelLayout = new javax.swing.GroupLayout(resultaterPanel);
        resultaterPanel.setLayout(resultaterPanelLayout);
        resultaterPanelLayout.setHorizontalGroup(
            resultaterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultaterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(resultaterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gjennomsnittLabel)
                    .addComponent(antallNoderLabel)
                    .addComponent(statusLabel)
                    .addComponent(numConnectedComponentsLabel)
                    .addComponent(numBridgesLabel)
                    .addComponent(jLabel2)
                    .addComponent(numCliquesLabel))
                .addGap(12, 12, 12)
                .addGroup(resultaterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(antallNoderTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(gjennomsnitttextField, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(numConnectedComponentsTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(numBridgesTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(numMissingDirectRelationshipsTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(numCliquesTextField))
                .addContainerGap())
        );

        resultaterPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {antallNoderLabel, antallNoderTextField, gjennomsnittLabel, gjennomsnitttextField, jLabel2, numBridgesLabel, numBridgesTextField, numConnectedComponentsLabel, numConnectedComponentsTextField, numMissingDirectRelationshipsTextField});

        resultaterPanelLayout.setVerticalGroup(
            resultaterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultaterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(resultaterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(antallNoderLabel)
                    .addComponent(antallNoderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(resultaterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gjennomsnitttextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gjennomsnittLabel))
                .addGroup(resultaterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(resultaterPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(statusLabel))
                    .addGroup(resultaterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(numConnectedComponentsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(numConnectedComponentsLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(resultaterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numBridgesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numBridgesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(resultaterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numMissingDirectRelationshipsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(resultaterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numCliquesLabel)
                    .addComponent(numCliquesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        antNaboerEnVeiLabel.setText("Num neighbors one way");

        nettverkStatistikkButton.setText("Statistics");
        nettverkStatistikkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nettverkStatistikkButtonActionPerformed(evt);
            }
        });

        statusNettverkLabel.setText("Status:");

        cliqueSizeLabel.setText("Clique size");

        nettverkNullstillButton.setText("Reset");
        nettverkNullstillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nettverkNullstillButtonActionPerformed(evt);
            }
        });

        absoluttverdiLabel.setText("Absolute value");

        javax.swing.GroupLayout noderPanelLayout = new javax.swing.GroupLayout(noderPanel);
        noderPanel.setLayout(noderPanelLayout);
        noderPanelLayout.setHorizontalGroup(
            noderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(noderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(noderPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(statusNettverkLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(noderPanelLayout.createSequentialGroup()
                        .addGroup(noderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(resultaterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, noderPanelLayout.createSequentialGroup()
                                .addGroup(noderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, noderPanelLayout.createSequentialGroup()
                                        .addGroup(noderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(antNaboerEnVeiLabel)
                                            .addComponent(prosentLabel)
                                            .addComponent(velgInputfilButton))
                                        .addGap(18, 18, 18)
                                        .addGroup(noderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(valgtFilTextField)
                                            .addGroup(noderPanelLayout.createSequentialGroup()
                                                .addGroup(noderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(cliqueSizeTextField)
                                                    .addComponent(prosentTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                                    .addComponent(antNaboerEnVeiTextField, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(absoluttverdiLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(absoluttverdiTextField))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, noderPanelLayout.createSequentialGroup()
                                        .addComponent(beregnButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(nettverkNullstillButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nettverkStatistikkButton)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lagResultatfilButton)
                                .addGap(6, 6, 6)))
                        .addContainerGap())
                    .addGroup(noderPanelLayout.createSequentialGroup()
                        .addComponent(cliqueSizeLabel)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        noderPanelLayout.setVerticalGroup(
            noderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(noderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valgtFilTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(velgInputfilButton))
                .addGap(1, 1, 1)
                .addGroup(noderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prosentLabel)
                    .addComponent(prosentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(absoluttverdiLabel)
                    .addComponent(absoluttverdiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(antNaboerEnVeiLabel)
                    .addComponent(antNaboerEnVeiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cliqueSizeLabel)
                    .addComponent(cliqueSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(noderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(beregnButton)
                    .addComponent(lagResultatfilButton)
                    .addComponent(nettverkStatistikkButton)
                    .addComponent(nettverkNullstillButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statusNettverkLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resultaterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        visibilityGraphtabbedPane.addTab("Network", noderPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(visibilityGraphtabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(visibilityGraphtabbedPane)
                .addContainerGap())
        );

        visibilityGraphtabbedPane.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nettverkStatistikkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nettverkStatistikkButtonActionPerformed
        if (inputIsOK()) {
            final Map<Integer,Summary> antNaboerTilSummary = algoritme.getNumNeighborsToSummary();
            final List<BigDecimal> localClusteringCoefficients = algoritme.getLocalClusteringCoefficients();

            final int antNaboerEnVei = Integer.parseInt(antNaboerEnVeiTextField.getText());
            final String fileName = getNettverkStatistikkUtdataFilnavn(valgtFil, antNaboerEnVei, threshold); // threshold
            final boolean ok = MyWriter.writeShortSummary(fileName, antNaboerTilSummary, localClusteringCoefficients);

            if (ok) {
                statusNettverkLabel.setText("<html><font color='green'>Fil " + fileName + " opprettet.</font></html>");
            } else {
                statusNettverkLabel.setText("<html><font color='red'>Fil IKKE opprettet.</font></html>");
            }
        }
    }//GEN-LAST:event_nettverkStatistikkButtonActionPerformed

    private void gjennomsnitttextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gjennomsnitttextFieldActionPerformed

    }//GEN-LAST:event_gjennomsnitttextFieldActionPerformed

    private void beregnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beregnButtonActionPerformed
        if (inputIsOK()) {
            
            if (NumberUtils.isNumber(prosentTextField.getText())) {
                prosent = Double.parseDouble(prosentTextField.getText());
                threshold = new ThresholdPercentage(prosent);
            } else if (NumberUtils.isNumber(absoluttverdiTextField.getText())) {
                absoluteValue = Integer.parseInt(absoluttverdiTextField.getText());
                threshold = new ThresholdAbsoluteValue(absoluteValue);
            } else {
                throw new IllegalStateException("Percentage is invalid and milliseconds is invalid");
            }
            
            cliqueSize = Integer.parseInt(cliqueSizeTextField.getText());
            int antNaboerEnvei = Integer.parseInt(antNaboerEnVeiTextField.getText());
            algoritme = new TimeseriesToGraph(tidsserie, threshold, antNaboerEnvei, SimilarityDefinitions.SYMMETRIC);
            final AdjacencyList adjacencyList = algoritme.getAdjacencyList(cliqueSize);
            final Set<CompleteSubgraph> completeSubgraphs = new CompleteGraphFinder().find(adjacencyList, cliqueSize);
            numCliquesTextField.setText(String.valueOf(completeSubgraphs.size()));
            antallNoderTextField.setText(algoritme.getNumNodes().toString());
            gjennomsnitttextField.setText(algoritme.getAverage().toString());
            numConnectedComponentsTextField.setText(algoritme.getNumConnectedComponents().toString());
            numBridgesTextField.setText(algoritme.getNumBridges().toString());
            numMissingDirectRelationshipsTextField.setText(algoritme.getNumMissingDirectNeighborRelationships().toString());
            statusNettverkLabel.setText("Status: algoritmen er utført.");
            nettverkStatistikkButton.setEnabled(true);
            lagResultatfilButton.setEnabled(true);
        }
    }//GEN-LAST:event_beregnButtonActionPerformed

    private void velgInputfilButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_velgInputfilButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(this);
        File nyValgtFil = chooser.getSelectedFile();
        if (!nyValgtFil.equals(valgtFil)) { // brukeren har valgt en annen fil enn forrige gang
            valgtFil = nyValgtFil;
            valgtFilTextField.setText(valgtFil.getAbsolutePath());
            try {
                tidsserie = MyReader.getTidsserie(valgtFil);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Kunne ikke lage tidsserie.");
            }
        }
    }//GEN-LAST:event_velgInputfilButtonActionPerformed

    private void lagResultatfilButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lagResultatfilButtonActionPerformed
        if (inputIsOK()) {
            List<List<Integer>> tidsserier = new ArrayList<>();
            tidsserier.add(0, new ArrayList<>());
            for (int prs = 1; prs <= 100; ++prs) {
                int antNaboerEnvei = Integer.parseInt(antNaboerEnVeiTextField.getText());
                final TimeseriesToGraph alg = new TimeseriesToGraph(tidsserie, new ThresholdPercentage(Double.valueOf(prs)), antNaboerEnvei, SimilarityDefinitions.SYMMETRIC);
                tidsserier.add(prs, alg.getNumSimilarNeighbors());
            }

            statusNettverkLabel.setText("Oppretter fil ...");

            int antNaboerEnVei = Integer.parseInt(antNaboerEnVeiTextField.getText());

            String filnavn = getUtdataFilnavn(valgtFil, "resultater", antNaboerEnVei);
            boolean ok = MyWriter.write(filnavn, tidsserier);

            if (ok) {
                statusNettverkLabel.setText("<html><font color='green'>Fil " + filnavn + " opprettet.</font></html>");
            } else {
                statusNettverkLabel.setText("<html><font color='red'>Fil IKKE opprettet.</font></html>");
            }
        }
    }//GEN-LAST:event_lagResultatfilButtonActionPerformed

    private void nettverkNullstillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nettverkNullstillButtonActionPerformed
        valgtFilTextField.setText("");
        valgtFil = null;
        prosentTextField.setText("");
        absoluttverdiTextField.setText("");
        antNaboerEnVeiTextField.setText("");
        cliqueSizeTextField.setText("");
        antallNoderTextField.setText("");
        gjennomsnitttextField.setText("");
        numConnectedComponentsTextField.setText("");
        numBridgesTextField.setText("");
        numMissingDirectRelationshipsTextField.setText("");
        numCliquesTextField.setText("");
        threshold = null;
    }//GEN-LAST:event_nettverkNullstillButtonActionPerformed

    private void prosentTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prosentTextFieldActionPerformed
        
    }//GEN-LAST:event_prosentTextFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
    
    private String getNettverkStatistikkUtdataFilnavn(File file, Integer antNaboerTilHoyre, Threshold threshold) {
        String absolutePath = file.getAbsolutePath();
        String navn = file.getName();
        navn = navn.substring(0, navn.lastIndexOf("."));
        String resultatPath = absolutePath.substring(0, absolutePath.lastIndexOf(File.separator));
        String resultatFilNavn = resultatPath + File.separator + navn + "_nettverk_statistikk_antNaboer_" + antNaboerTilHoyre.toString();
        if (threshold.getThresholdType() == ThresholdType.ABSOLUTE_VALUE) {
            resultatFilNavn += "_absolute_" + threshold.getRawInput() +  ".txt";
        } else {
            resultatFilNavn += "_prosent_" + threshold.getRawInput() +  ".txt";
        }
        return resultatFilNavn;
    }
    
    private String getUtdataFilnavn(File file, String extension, Integer antNaboerEnVei) {
        String absolutePath = file.getAbsolutePath();
        String navn = file.getName();
        navn = navn.substring(0, navn.lastIndexOf("."));
        String resultatPath = absolutePath.substring(0, absolutePath.lastIndexOf(File.separator));
        if (antNaboerEnVei != null) { // nettverk
            String resultatFilNavn = resultatPath + File.separator + navn + "_antNaboerEnVei" + antNaboerEnVei + "_" +  extension + ".txt";
            return resultatFilNavn;
        } else { // symboldynamikk
            String resultatFilNavn = resultatPath + File.separator + navn + "_" +  extension + ".txt";
            return resultatFilNavn;
        }
    }

    private boolean inputIsOK() {

        if (tidsserie == null) {
            return false;
        }
        
        if (!NumberUtils.isNumber(prosentTextField.getText()) && !NumberUtils.isNumber(absoluttverdiTextField.getText())) {
            return false;
        }
        
        String antNaboerEnvei = antNaboerEnVeiTextField.getText();
        
        if (antNaboerEnvei == null)
            return false;
        
        if (StringUtils.isBlank(antNaboerEnvei)) {
            return false;
        }
        
        try {
            Integer.parseInt(antNaboerEnvei);
        } catch (NumberFormatException e) {
            return false;
        }
        
        final String cliqueSizeStr = cliqueSizeTextField.getText();
        
        if (cliqueSizeStr == null || StringUtils.isBlank(cliqueSizeStr)) {
            return false;
        }
        
        try {
            Integer.parseInt(cliqueSizeStr);
        } catch (NumberFormatException e) {
            return false;
        }

        if (valgtFil == null) {
            return false;
        }

        if (!valgtFil.exists()) {
            return false;
        }

        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel absoluttverdiLabel;
    private javax.swing.JTextField absoluttverdiTextField;
    private javax.swing.JLabel antNaboerEnVeiLabel;
    private javax.swing.JTextField antNaboerEnVeiTextField;
    private javax.swing.JLabel antallNoderLabel;
    private javax.swing.JTextField antallNoderTextField;
    private javax.swing.JButton beregnButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JLabel cliqueSizeLabel;
    private javax.swing.JTextField cliqueSizeTextField;
    private javax.swing.JLabel gjennomsnittLabel;
    private javax.swing.JTextField gjennomsnitttextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton lagResultatfilButton;
    private javax.swing.JButton nettverkNullstillButton;
    private javax.swing.JButton nettverkStatistikkButton;
    private javax.swing.JPanel noderPanel;
    private javax.swing.JLabel numBridgesLabel;
    private javax.swing.JTextField numBridgesTextField;
    private javax.swing.JLabel numCliquesLabel;
    private javax.swing.JTextField numCliquesTextField;
    private javax.swing.JLabel numConnectedComponentsLabel;
    private javax.swing.JTextField numConnectedComponentsTextField;
    private javax.swing.JTextField numMissingDirectRelationshipsTextField;
    private javax.swing.JLabel prosentLabel;
    private javax.swing.JTextField prosentTextField;
    private javax.swing.JPanel resultaterPanel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel statusNettverkLabel;
    private javax.swing.JTextField valgtFilTextField;
    private javax.swing.JButton velgInputfilButton;
    private javax.swing.JTabbedPane visibilityGraphtabbedPane;
    // End of variables declaration//GEN-END:variables
}
