/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionmissions.IHM;
import gestionmissions.Metier.Mission;
import gestionmissions.Metier.Priorite;
import gestionmissions.Metier.Statut;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 *
 * @author guillaume.crampe
 */
public class ModifierMissionDialog1 extends JDialog {
    private Mission uneMission;
    private JTextField jTextField1;
    private JTextField jTextFieldDescription;
    private JTextField jTextFieldDateD;
    private JTextField jTextFieldDateF;
    private JTextField jTextFieldBudget;

    private JComboBox<Statut> jComboBox1Statut;
    private JComboBox<Priorite> jComboBox2Priorite;

    private JButton jButtonModifier;
    private JButton jButtonSupprimer;

    public ModifierMissionDialog1(Frame parent, Mission mission) {
        super(parent, "Gestion du projet", true);
        uneMission=mission;
        initialiserComposants();
        configurerFenetre();
        ajouterEvenements();
        initCombo();
    }
    private void initCombo(){
        for(Statut statut:Statut.values()){
         jComboBox1Statut.addItem(statut);
     }
        for(Priorite priorite:Priorite.values()){
         jComboBox2Priorite.addItem(priorite);
     }
    }
    private void initialiserComposants() {

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new LineBorder(new Color(220, 220, 255), 4));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(1, 1, 1, 1);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;

        // Champs de saisie
        jTextField1 = new JTextField();
        jTextFieldDescription = new JTextField();
        jTextFieldDateD = new JTextField();
        jTextFieldDateF = new JTextField();
        jTextFieldBudget = new JTextField();

        // Initialisation des listes déoulantes
        jComboBox1Statut = new JComboBox<>(Statut.values());
        jComboBox2Priorite = new JComboBox<>(Priorite.values());
                

        // Libellés
        String[] labels = {
            "Titre",
            "Description",
            "Date de début",
            "Date de fin",
            "Statut",
            "Priorité",
            "Budget"
        };

        JComponent[] composants = {
            jTextField1,
            jTextFieldDescription,
            jTextFieldDateD,
            jTextFieldDateF,
            jComboBox1Statut,
            jComboBox2Priorite,
            jTextFieldBudget
        };

        // Création des lignes du formulaire
        for (int i = 0; i < labels.length; i++) {

            gbc.gridy = i;
            gbc.gridx = 0;
            gbc.weightx = 1.0;

            JLabel label = new JLabel(labels[i]);
            label.setHorizontalAlignment(SwingConstants.LEFT);

            panel.add(label, gbc);

            gbc.gridx = 1;
            gbc.weightx = 1.0;

            composants[i].setPreferredSize(new Dimension(210, 49));

            panel.add(composants[i], gbc);
        }

        // Boutons du bas
        jButtonModifier = new JButton("Modifier");
        jButtonSupprimer = new JButton("Supprimer");

        gbc.gridy = labels.length;
        gbc.gridx = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        panel.add(jButtonModifier, gbc);

        gbc.gridx = 1;
        panel.add(jButtonSupprimer, gbc);

        // Taille des boutons
        jButtonModifier.setPreferredSize(new Dimension(210, 49));
        jButtonSupprimer.setPreferredSize(new Dimension(210, 49));

        setContentPane(panel);
    }

    private void configurerFenetre() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(getOwner());
    }

    private void ajouterEvenements() {

        jButtonModifier.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                this,
                "Modification du projet : " + jTextField1.getText()
            );

            // Ajouter ici le code de modification du projet.
        });

        jButtonSupprimer.addActionListener(e -> {

            int choix = JOptionPane.showConfirmDialog(
                this,
                "Voulez-vous vraiment supprimer ce projet ?",
                "Confirmation de suppression",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
            );

            if (choix == JOptionPane.YES_OPTION) {
                // Ajouter ici le code de suppression du projet.
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ModifierMissionDialog1 dialog = new ModifierMissionDialog1(null,null);
            dialog.setVisible(true);
        });
    }
}


