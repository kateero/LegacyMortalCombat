package GUI;

import Characters.Player;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mortalkombatbversion.Game;
import Characters.Human;
import mortalkombatbversion.Items;

public class JFrames extends javax.swing.JFrame {
    
    Game game = new Game();
    Human human = null;
    Player enemy = null;
    Items[] items = new Items[3];
    String nameButton = "";

    public JFrames() {
        initComponents();
        try {
            game.ReadFromExcel();
        } catch (IOException ex) {
            Logger.getLogger(JFrames.class.getName()).log(Level.SEVERE, null, ex);
        }
        game.WriteToTable(jTable1);
        
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton3);
        
        items[0]=new Items("Малое зелье лечение",0);
        items[1]=new Items("Большое зелье лечение",0);
        items[2]=new Items("Крест возрождения",0);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        startPanel = new javax.swing.JPanel();
        mortalCombatLabel = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        checkResultsButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jPanel3.setBackground(new java.awt.Color(179, 226, 217));

        jLabel18.setBackground(new java.awt.Color(204, 204, 204));
        jLabel18.setFont(new java.awt.Font("Comic Sans MS", 1, 42)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 0, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("jLabel18");
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        nextButton.setBackground(new java.awt.Color(114, 218, 142));
        nextButton.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        nextButton.setForeground(new java.awt.Color(0, 0, 0));
        nextButton.setText("Дальше");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        startPanel.setBackground(new java.awt.Color(255, 255, 255));

        mortalCombatLabel.setFont(new java.awt.Font("Comic Sans MS", 2, 24)); // NOI18N
        mortalCombatLabel.setForeground(new java.awt.Color(204, 204, 0));
        mortalCombatLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mortalCombatLabel.setText("Mortal Kombat");

        startButton.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        startButton.setText("Начать новую игру");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        checkResultsButton.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        checkResultsButton.setText("Посмотреть таблицу \nрезультатов");
        checkResultsButton.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        checkResultsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkResultsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout startPanelLayout = new javax.swing.GroupLayout(startPanel);
        startPanel.setLayout(startPanelLayout);
        startPanelLayout.setHorizontalGroup(
            startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(startPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(checkResultsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(startPanelLayout.createSequentialGroup()
                .addGroup(startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(startPanelLayout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(mortalCombatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(startPanelLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        startPanelLayout.setVerticalGroup(
            startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(startPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(mortalCombatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkResultsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(startPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(startPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        gameFrame.setVisible(rootPaneCheckingEnabled);
        gameFrame.setSize(1000,700);
        
        human = game.NewHuman(jProgressBar1);
        
        enemy = game.NewEnemy(jLabel4, jLabel5, jLabel10, jLabel13, jProgressBar2);
        
        game.change.NewRoundTexts(human, enemy, jProgressBar1, jProgressBar2, 
                jLabel17, jLabel16, jLabel6, jLabel19, jLabel12, jLabel13, jLabel9,
                jLabel26, jLabel27, game.fight.i, items, jRadioButton1, jRadioButton2, jRadioButton3);
        
        /*game.action.setEnemyes();
        enemy = game.action.ChooseEnemy(jLabel4, jLabel5, jLabel10, jLabel13);
                //a.ChooseEmemy(human, jLabel4, jProgressBar2, jLabel5, jLabel10, jLabel13);
        
        //Fight f = new Fight();
        
        game.action.HP(human, jProgressBar1);
        game.action.HP(enemy, jProgressBar2);
        jProgressBar2.setMaximum(enemy.getMaxHealth());*/
        
    }//GEN-LAST:event_startButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed

        enemy=game.fight.NewRound(human, jLabel4, jProgressBar1, jProgressBar2, 
                jLabel5, jLabel10, jLabel13, game.action);

        
        game.change.NewRoundTexts(human, enemy, jProgressBar1, jProgressBar2, 
                jLabel17, jLabel16, jLabel6, jLabel19, jLabel12, jLabel13, jLabel9,
                jLabel26, jLabel27, game.fight.i, items, jRadioButton1, jRadioButton2, jRadioButton3);

        jDialog1.dispose();
    }//GEN-LAST:event_nextButtonActionPerformed

    private void checkResultsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkResultsButtonActionPerformed
        jDialog3.setVisible(true);
        jDialog3.setBounds(100, 100, 580, 450);
    }//GEN-LAST:event_checkResultsButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkResultsButton;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel mortalCombatLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton startButton;
    private javax.swing.JPanel startPanel;
    // End of variables declaration//GEN-END:variables
}
