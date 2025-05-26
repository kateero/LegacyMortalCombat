package GUI;

public class winGameDialog extends javax.swing.JDialog {

    public winGameDialog() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        TitleLabel = new javax.swing.JLabel();
        nameValue = new javax.swing.JTextField();
        enterNameLabel = new javax.swing.JLabel();
        endGameButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel.setBackground(new java.awt.Color(255, 204, 255));

        TitleLabel.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        TitleLabel.setForeground(new java.awt.Color(234, 87, 19));
        TitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleLabel.setText("Победа на вашей стороне");

        nameValue.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        nameValue.setForeground(new java.awt.Color(0, 0, 0));
        nameValue.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nameValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameValueActionPerformed(evt);
            }
        });

        enterNameLabel.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        enterNameLabel.setForeground(new java.awt.Color(51, 51, 51));
        enterNameLabel.setText("Введите имя своего персонажа");

        endGameButton.setBackground(new java.awt.Color(234, 87, 19));
        endGameButton.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        endGameButton.setForeground(new java.awt.Color(255, 255, 255));
        endGameButton.setText("Закончить игру");
        endGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endGameButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(enterNameLabel)
                .addGap(87, 87, 87))
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameValue))
                .addGap(0, 58, Short.MAX_VALUE))
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(endGameButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(TitleLabel)
                .addGap(18, 18, 18)
                .addComponent(enterNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameValue, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(endGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameValueActionPerformed

    private void endGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endGameButtonActionPerformed

    }//GEN-LAST:event_endGameButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JButton endGameButton;
    private javax.swing.JLabel enterNameLabel;
    private javax.swing.JPanel jPanel;
    private javax.swing.JTextField nameValue;
    // End of variables declaration//GEN-END:variables
}
