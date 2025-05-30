package GUI;

import Characters.Action;
import Characters.Enemy;
import Characters.Human;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import mortalkombatbversion.Fight;

public class galaFrame extends javax.swing.JFrame {

    private boolean isPlayerMove = true;
    private Fight fight;
    private Human human;
    private Enemy enemy;

    public galaFrame() {
        initComponents();
    }

    public JButton getAttackButton() {
        return attackButton;
    }

    public JButton getDefendButton() {
        return defendButton;
    }

    public JButton getWeakButton() {
        return weakButton;
    }

    public JLabel getLabelMoves() {
        return labelMoves;
    }

    public void setFight(Fight fight) {
        this.fight = fight;
        this.human = fight.getPlayer();
        this.enemy = fight.getEnemy();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanel = new javax.swing.JPanel();
        humanImage = new javax.swing.JLabel();
        attackButton = new javax.swing.JButton();
        defendButton = new javax.swing.JButton();
        humanProgressBar = new javax.swing.JProgressBar();
        enemyImage = new javax.swing.JLabel();
        enemyProgressBar = new javax.swing.JProgressBar();
        enemyTypeValye = new javax.swing.JLabel();
        enemyDamageLabel = new javax.swing.JLabel();
        humanDamageLabel = new javax.swing.JLabel();
        humanDamageValue = new javax.swing.JLabel();
        enemyDamageValue = new javax.swing.JLabel();
        humanLevelLabel = new javax.swing.JLabel();
        LocationLabel = new javax.swing.JLabel();
        enemyHealthValue = new javax.swing.JLabel();
        experinceLabel = new javax.swing.JLabel();
        pointsLabel = new javax.swing.JLabel();
        experienceValue = new javax.swing.JLabel();
        pointsValue = new javax.swing.JLabel();
        enemyLevelLabel = new javax.swing.JLabel();
        labelMoves = new javax.swing.JLabel();
        humanNameValue = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        objectsButton = new javax.swing.JButton();
        weakButton = new javax.swing.JButton();
        humanHealthValue = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpanel.setBackground(new java.awt.Color(255, 255, 255));

        attackButton.setBackground(new java.awt.Color(255, 0, 0));
        attackButton.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        attackButton.setForeground(new java.awt.Color(0, 0, 0));
        attackButton.setText("Атаковать");
        attackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attackButtonActionPerformed(evt);
            }
        });

        defendButton.setBackground(new java.awt.Color(255, 204, 0));
        defendButton.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        defendButton.setForeground(new java.awt.Color(0, 0, 0));
        defendButton.setText("Защититься");
        defendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defendButtonActionPerformed(evt);
            }
        });

        humanProgressBar.setBackground(new java.awt.Color(204, 204, 204));
        humanProgressBar.setForeground(new java.awt.Color(51, 255, 51));

        enemyProgressBar.setBackground(new java.awt.Color(204, 204, 204));
        enemyProgressBar.setForeground(new java.awt.Color(0, 255, 0));

        enemyTypeValye.setBackground(new java.awt.Color(0, 0, 0));
        enemyTypeValye.setFont(new java.awt.Font("Comic Sans MS", 2, 14)); // NOI18N

        enemyDamageLabel.setBackground(new java.awt.Color(255, 255, 255));
        enemyDamageLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        enemyDamageLabel.setForeground(new java.awt.Color(0, 0, 0));
        enemyDamageLabel.setText("Damage");

        humanDamageLabel.setBackground(new java.awt.Color(255, 255, 255));
        humanDamageLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        humanDamageLabel.setForeground(new java.awt.Color(0, 0, 0));
        humanDamageLabel.setText("Damage");

        humanDamageValue.setBackground(new java.awt.Color(255, 255, 255));
        humanDamageValue.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        humanDamageValue.setForeground(new java.awt.Color(255, 0, 0));
        humanDamageValue.setText("3");

        enemyDamageValue.setBackground(new java.awt.Color(255, 255, 255));
        enemyDamageValue.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        enemyDamageValue.setForeground(new java.awt.Color(255, 0, 0));
        enemyDamageValue.setText("16");

        humanLevelLabel.setBackground(new java.awt.Color(255, 255, 255));
        humanLevelLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        humanLevelLabel.setForeground(new java.awt.Color(0, 0, 0));
        humanLevelLabel.setText("8 уровень");

        LocationLabel.setBackground(new java.awt.Color(255, 255, 255));
        LocationLabel.setFont(new java.awt.Font("Comic Sans MS", 3, 36)); // NOI18N
        LocationLabel.setForeground(new java.awt.Color(0, 0, 153));
        LocationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LocationLabel.setText("FIGHT");
        LocationLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        enemyHealthValue.setBackground(new java.awt.Color(255, 255, 255));
        enemyHealthValue.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        enemyHealthValue.setForeground(new java.awt.Color(102, 102, 102));
        enemyHealthValue.setText("80/80");

        experinceLabel.setBackground(new java.awt.Color(255, 255, 255));
        experinceLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        experinceLabel.setForeground(new java.awt.Color(128, 92, 31));
        experinceLabel.setText("experience");

        pointsLabel.setBackground(new java.awt.Color(255, 255, 255));
        pointsLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        pointsLabel.setForeground(new java.awt.Color(128, 92, 31));
        pointsLabel.setText("points");

        experienceValue.setBackground(new java.awt.Color(255, 255, 255));
        experienceValue.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        experienceValue.setForeground(new java.awt.Color(113, 90, 16));
        experienceValue.setText("0/40");

        pointsValue.setBackground(new java.awt.Color(255, 255, 255));
        pointsValue.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        pointsValue.setForeground(new java.awt.Color(113, 90, 16));
        pointsValue.setText("0");

        enemyLevelLabel.setBackground(new java.awt.Color(255, 255, 255));
        enemyLevelLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        enemyLevelLabel.setForeground(new java.awt.Color(0, 0, 0));
        enemyLevelLabel.setText("1 уровень");

        labelMoves.setBackground(new java.awt.Color(255, 255, 204));
        labelMoves.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        labelMoves.setForeground(new java.awt.Color(0, 0, 0));
        labelMoves.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        humanNameValue.setFont(new java.awt.Font("Comic Sans MS", 2, 14)); // NOI18N
        humanNameValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        humanNameValue.setText("Kitana ");

        jLabel29.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        objectsButton.setBackground(new java.awt.Color(174, 183, 106));
        objectsButton.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        objectsButton.setForeground(new java.awt.Color(0, 0, 0));
        objectsButton.setText("Предметы");
        objectsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objectsButtonActionPerformed(evt);
            }
        });

        weakButton.setBackground(new java.awt.Color(102, 204, 255));
        weakButton.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        weakButton.setText("Ослабить");
        weakButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weakButtonActionPerformed(evt);
            }
        });

        humanHealthValue.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        humanHealthValue.setText("10/10");

        javax.swing.GroupLayout jpanelLayout = new javax.swing.GroupLayout(jpanel);
        jpanel.setLayout(jpanelLayout);
        jpanelLayout.setHorizontalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelLayout.createSequentialGroup()
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpanelLayout.createSequentialGroup()
                        .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpanelLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(humanImage, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(humanNameValue, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)))
                        .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpanelLayout.createSequentialGroup()
                                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpanelLayout.createSequentialGroup()
                                        .addGap(232, 232, 232)
                                        .addComponent(experienceValue))
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(72, 72, 72))
                            .addComponent(labelMoves, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(enemyImage, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jpanelLayout.createSequentialGroup()
                                    .addGap(57, 57, 57)
                                    .addComponent(enemyTypeValye, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jpanelLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                                    .addComponent(enemyLevelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jpanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpanelLayout.createSequentialGroup()
                                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(humanHealthValue, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(humanLevelLabel))
                                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(LocationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(73, 73, 73))
                                    .addGroup(jpanelLayout.createSequentialGroup()
                                        .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(humanProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jpanelLayout.createSequentialGroup()
                                                .addComponent(enemyDamageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(humanDamageValue, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jpanelLayout.createSequentialGroup()
                                                .addGap(66, 66, 66)
                                                .addComponent(pointsLabel)
                                                .addGap(4, 4, 4))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(pointsValue)
                                                .addGap(28, 28, 28)))
                                        .addGap(53, 53, 53)
                                        .addComponent(experinceLabel)
                                        .addGap(18, 18, 18)))
                                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpanelLayout.createSequentialGroup()
                                        .addComponent(enemyProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(enemyHealthValue))
                                    .addGroup(jpanelLayout.createSequentialGroup()
                                        .addComponent(humanDamageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(enemyDamageValue, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jpanelLayout.createSequentialGroup()
                                .addComponent(attackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(defendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(weakButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(objectsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jpanelLayout.setVerticalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelLayout.createSequentialGroup()
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(enemyHealthValue, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(enemyProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(enemyDamageValue)
                            .addComponent(humanDamageLabel)
                            .addComponent(enemyLevelLabel)))
                    .addGroup(jpanelLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(LocationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pointsLabel)
                            .addComponent(experinceLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pointsValue)
                            .addComponent(experienceValue)))
                    .addGroup(jpanelLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(humanProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(humanHealthValue, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(humanDamageValue)
                            .addComponent(enemyDamageLabel)
                            .addComponent(humanLevelLabel))))
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpanelLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jpanelLayout.createSequentialGroup()
                                .addComponent(humanImage, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(humanNameValue, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addGroup(jpanelLayout.createSequentialGroup()
                                .addComponent(enemyImage, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(enemyTypeValye, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33)
                        .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(attackButton)
                            .addComponent(defendButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(objectsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(weakButton))
                        .addGap(28, 28, 28))
                    .addGroup(jpanelLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(labelMoves, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 590, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void attackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attackButtonActionPerformed
        if (isPlayerMove) {
            fight.playerMove(Action.ATTACK);
            isPlayerMove = false;
        } else {
            fight.computerMove(Action.ATTACK);
            isPlayerMove = true;
        }
        refreshAfterHit();
    }//GEN-LAST:event_attackButtonActionPerformed

    private void defendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defendButtonActionPerformed
        if (isPlayerMove) {
            fight.playerMove(Action.DEFEND);
            isPlayerMove = false;
        } else {
            fight.computerMove(Action.DEFEND);
            isPlayerMove = true;
        }
        refreshAfterHit();
    }//GEN-LAST:event_defendButtonActionPerformed

    private void objectsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objectsButtonActionPerformed
       //ObjectsDialog
    }//GEN-LAST:event_objectsButtonActionPerformed

    private void weakButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weakButtonActionPerformed
        if (isPlayerMove) {
            fight.playerMove(Action.WEAKEN);
            isPlayerMove = false;
        } else {
            fight.computerMove(Action.WEAKEN);
            isPlayerMove = true;
        }
        refreshAfterHit();
    }//GEN-LAST:event_weakButtonActionPerformed

    public void initilaize(){
        pointsValue.setText(String.valueOf(human.getPoints()));
        experienceValue.setText(human.getExperience() + "/" 
                + human.getNextExperience());
        humanDamageValue.setText(String.valueOf(human.getDamage()));
        humanLevelLabel.setText(human.getLevel() + " уровень");
        humanProgressBar.setMaximum(human.getMaxHealth());
        humanProgressBar.setValue(human.getHealth());
        humanHealthValue.setText(human.getHealth() + "/" + human.getMaxHealth());
        
        ImageIcon icon = new ImageIcon("C:\\Users\\Катя\\Downloads\\Kitana.jpg");
        Image scaledKitana = icon.getImage().getScaledInstance(210, 255, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledKitana);
        humanImage.setIcon(icon);
        
        enemyTypeValye.setText(enemy.getName());
        enemyLevelLabel.setText(enemy.getLevel() + " уровень");
        enemyDamageValue.setText(String.valueOf(enemy.getDamage()));
        enemyHealthValue.setText(enemy.getHealth() + "/" + enemy.getMaxHealth());
        enemyProgressBar.setMaximum(enemy.getMaxHealth());
        enemyProgressBar.setValue(enemy.getHealth());
    }
    
    public void refreshAfterHit(){
        humanProgressBar.setValue(human.getHealth());
        humanHealthValue.setText(human.getHealth() + "/" + human.getMaxHealth());
        humanDamageValue.setText(String.valueOf(human.getDamage()));
        
        enemyProgressBar.setValue(enemy.getHealth());
        enemyHealthValue.setText(enemy.getHealth() + "/" + enemy.getMaxHealth());
        enemyDamageValue.setText(String.valueOf(enemy.getDamage()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LocationLabel;
    private javax.swing.JButton attackButton;
    private javax.swing.JButton defendButton;
    private javax.swing.JLabel enemyDamageLabel;
    private javax.swing.JLabel enemyDamageValue;
    private javax.swing.JLabel enemyHealthValue;
    private javax.swing.JLabel enemyImage;
    private javax.swing.JLabel enemyLevelLabel;
    private javax.swing.JProgressBar enemyProgressBar;
    private javax.swing.JLabel enemyTypeValye;
    private javax.swing.JLabel experienceValue;
    private javax.swing.JLabel experinceLabel;
    private javax.swing.JLabel humanDamageLabel;
    private javax.swing.JLabel humanDamageValue;
    private javax.swing.JLabel humanHealthValue;
    private javax.swing.JLabel humanImage;
    private javax.swing.JLabel humanLevelLabel;
    private javax.swing.JLabel humanNameValue;
    private javax.swing.JProgressBar humanProgressBar;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jpanel;
    private javax.swing.JLabel labelMoves;
    private javax.swing.JButton objectsButton;
    private javax.swing.JLabel pointsLabel;
    private javax.swing.JLabel pointsValue;
    private javax.swing.JButton weakButton;
    // End of variables declaration//GEN-END:variables
}
