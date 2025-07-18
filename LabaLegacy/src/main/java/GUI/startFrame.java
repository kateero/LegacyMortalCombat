package GUI;

import mortalkombatbversion.Game;
import javax.swing.JOptionPane;

public class startFrame extends javax.swing.JFrame {

    public startFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startPanel = new javax.swing.JPanel();
        mortalCombatLabel = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        checkResultsButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        startPanel.setBackground(new java.awt.Color(234, 234, 234));
        startPanel.setForeground(new java.awt.Color(102, 102, 102));

        mortalCombatLabel.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        mortalCombatLabel.setForeground(new java.awt.Color(186, 24, 27));
        mortalCombatLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mortalCombatLabel.setText("Mortal Kombat");

        startButton.setBackground(new java.awt.Color(204, 204, 204));
        startButton.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        startButton.setForeground(new java.awt.Color(102, 7, 8));
        startButton.setText("Начать игру");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        checkResultsButton.setBackground(new java.awt.Color(204, 204, 204));
        checkResultsButton.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        checkResultsButton.setForeground(new java.awt.Color(102, 7, 8));
        checkResultsButton.setText("Таблица  результатов");
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
                .addGroup(startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(startPanelLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(mortalCombatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(startPanelLayout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(startPanelLayout.createSequentialGroup()
                                .addGap(241, 241, 241)
                                .addComponent(jLabel3))
                            .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkResultsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        startPanelLayout.setVerticalGroup(
            startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(startPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(mortalCombatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(startPanelLayout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabel3))
                    .addGroup(startPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(checkResultsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(startPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(startPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        String input = JOptionPane.showInputDialog(this, 
            "Введите количество локаций (от 1 до 10):", 
            "Количество локаций", 
            JOptionPane.QUESTION_MESSAGE);
            
        if (input != null && !input.trim().isEmpty()) {
            try {
                int locationCount = Integer.parseInt(input.trim());
                if (locationCount >= 1 && locationCount <= 10) {
                    galaFrame gf = new galaFrame();
                    Game mainIdea = new Game(locationCount, gf);
                    mainIdea.startGame();
                    this.dispose();
                    gf.setLocationRelativeTo(null);
                    gf.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this,
                        "Пожалуйста, введите число от 1 до 10",
                        "Ошибка",
                        JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                    "Пожалуйста, введите корректное число",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_startButtonActionPerformed

    private void checkResultsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkResultsButtonActionPerformed
        recordsDialog dialog = new recordsDialog(this);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }//GEN-LAST:event_checkResultsButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkResultsButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel mortalCombatLabel;
    private javax.swing.JButton startButton;
    private javax.swing.JPanel startPanel;
    // End of variables declaration//GEN-END:variables
}
