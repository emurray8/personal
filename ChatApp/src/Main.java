
import GUI.ClientGUI;
import GUI.ServerGUI;
import java.awt.Color;
import java.net.Inet4Address;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emurr_000
 */
public class Main extends javax.swing.JPanel {

    private javax.swing.JFrame frame = new javax.swing.JFrame();

    public Main() {
        frame.setVisible(true);
        frame.setSize(550,500);
        this.setFocusable(true);
        frame.add(this);
        setLayout(null);
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setLocation(250, 200);
        jLabel1.setSize(50,20);
        jLabel1.setForeground(Color.white);
        add(jLabel1);
        launchButton = new javax.swing.JButton();
        launchButton.setLocation(150, 400);
        launchButton.setSize(100,20);
        add(launchButton);
        launchClientCheck = new javax.swing.JCheckBox();
        launchClientCheck.setLocation(260, 400);
        launchClientCheck.setSize(60,20);
        add(launchClientCheck);
        launchServerCheck = new javax.swing.JCheckBox();
        launchServerCheck.setLocation(330, 400);
        launchServerCheck.setSize(70,20);
        add(launchServerCheck);
        jTextArea1 = new javax.swing.JTextArea();
        jTextArea1.setLocation(150,295);
        jTextArea1.setSize(250,100);
        jTextArea1.setEditable(false);
        jTextArea1.setText("Welcome to my chat application. \nCheck server, client, or both to launch the \ndesired programs.");
        add(jTextArea1);
        this.setBackground(Color.black);

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EChat");

        launchButton.setText("launch");
        launchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                launchButtonActionPerformed(evt);
            }
        });

        launchClientCheck.setSelected(true);
        launchClientCheck.setText("client");
        launchClientCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                launchClientCheckActionPerformed(evt);
            }
        });

        launchServerCheck.setText("server");
        launchServerCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                launchServerCheckActionPerformed(evt);
            }
        });
    }

 




       
 

    private void launchClientCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_launchClientCheckActionPerformed

    }//GEN-LAST:event_launchClientCheckActionPerformed

    private void launchServerCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_launchServerCheckActionPerformed
    }//GEN-LAST:event_launchServerCheckActionPerformed

    private void launchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_launchButtonActionPerformed
        if(launchServerCheck.isSelected()) {
            new ServerGUI(1500);
            frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
        }
        if(launchClientCheck.isSelected())
        {
            new ClientGUI("localhost", 1500);
            frame.setDefaultCloseOperation(HIDE_ON_CLOSE);

        }
       }//GEN-LAST:event_launchButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton launchButton;
    private javax.swing.JCheckBox launchClientCheck;
    private javax.swing.JCheckBox launchServerCheck;
    // End of variables declaration//GEN-END:variables

}
