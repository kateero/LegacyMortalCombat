package GUI;

public class ObjectsDialog extends javax.swing.JDialog {

    public ObjectsDialog() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        smallPoisonRB = new javax.swing.JRadioButton();
        bigPoisonRB = new javax.swing.JRadioButton();
        rebirthRB = new javax.swing.JRadioButton();
        useButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel.setBackground(new java.awt.Color(240, 232, 182));

        titleLabel.setFont(new java.awt.Font("Georgia", 0, 22)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(51, 51, 51));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Мешок предметов");

        smallPoisonRB.setBackground(new java.awt.Color(240, 232, 182));
        smallPoisonRB.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        smallPoisonRB.setForeground(new java.awt.Color(0, 0, 0));
        smallPoisonRB.setText("Малое зелье лечение, 0 шт");
        smallPoisonRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smallPoisonRBActionPerformed(evt);
            }
        });

        bigPoisonRB.setBackground(new java.awt.Color(240, 232, 182));
        bigPoisonRB.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        bigPoisonRB.setForeground(new java.awt.Color(0, 0, 0));
        bigPoisonRB.setText("Большое зелье лечение, 0 шт");
        bigPoisonRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bigPoisonRBActionPerformed(evt);
            }
        });

        rebirthRB.setBackground(new java.awt.Color(240, 232, 182));
        rebirthRB.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        rebirthRB.setForeground(new java.awt.Color(0, 0, 0));
        rebirthRB.setText("Крест возрождения, 0 шт");

        useButton.setBackground(new java.awt.Color(210, 240, 183));
        useButton.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        useButton.setForeground(new java.awt.Color(0, 0, 0));
        useButton.setText("Использовать");
        useButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(smallPoisonRB)
                    .addComponent(rebirthRB)
                    .addComponent(bigPoisonRB)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(titleLabel)))
                .addGap(87, 87, 87))
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(useButton)
                .addContainerGap())
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(smallPoisonRB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bigPoisonRB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rebirthRB)
                .addGap(31, 31, 31)
                .addComponent(useButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void smallPoisonRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smallPoisonRBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_smallPoisonRBActionPerformed

    private void bigPoisonRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bigPoisonRBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bigPoisonRBActionPerformed

    private void useButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useButtonActionPerformed
        if(smallPoisonRB.isSelected()){
            nameButton="jRadioButton1";
        }
        if(bigPoisonRB.isSelected()){
            nameButton="jRadioButton2";
        }
        if(rebirthRB.isSelected()){
            nameButton="jRadioButton3";
        }
        game.action.UseItem(human, items, nameButton, jDialog6, jDialog5);
        game.action.HP(human, jProgressBar1);
        jLabel12.setText(human.getHealth() + "/" + human.getMaxHealth());
        game.change.BagText(items, smallPoisonRB, bigPoisonRB, rebirthRB);
    }//GEN-LAST:event_useButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton bigPoisonRB;
    private javax.swing.JPanel jPanel;
    private javax.swing.JRadioButton rebirthRB;
    private javax.swing.JRadioButton smallPoisonRB;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton useButton;
    // End of variables declaration//GEN-END:variables
}
