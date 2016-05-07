
package quiz;

import java.awt.Image;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author evan
 */
public class Quiz extends javax.swing.JFrame{
    private int index;
    private Thread editor;
    private Image background;
    private boolean running = true;
    private double score = 0;
    private boolean done = false;
    private final double QUIZ_LENGTH = 10;
    private Object lock = new Object();
    private volatile boolean paused = true;
    private String answer = "";
    private List<Question> questionPool = new ArrayList<>();
    public void populateQuestionPool(){
        BufferedReader br = null;
	String line = "";
  	try {
            br = new BufferedReader(new FileReader("questions.txt"));
            while ((line = br.readLine()) != null) {
                List<String> temp = new ArrayList<>();
                String[] memes = line.split(";");
                for(String s : memes){
                    temp.add(s);
                }
                questionPool.add(new Question(temp));
            }
            Collections.shuffle(questionPool);
        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
    }
    public Quiz() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jProgressBar1.setMaximum(9);

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        jButton2.getAccessibleContext().setAccessibleName("answer2");
        jButton1.getAccessibleContext().setAccessibleName("answer1");
        jButton3.getAccessibleContext().setAccessibleName("answer3");
        jButton4.getAccessibleContext().setAccessibleName("answer4");
        jLabel2.getAccessibleContext().setAccessibleName("image");
        jLabel1.getAccessibleContext().setAccessibleName("question");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(done){
            jButton2.setVisible(true);
            jButton4.setVisible(true);
            jProgressBar1.setVisible(true);
            jProgressBar1.setValue(0);
            index = 0;
            jLabel2.setText("");
            score = 0;
            done = false;

        }else{
            answer = jButton1.getText();
            
        }
        paused = false;
            synchronized(lock) {
                lock.notifyAll();
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(done){
            running = false;
        }else{
            answer = jButton3.getText();
            
        }
        paused = false;
            synchronized(lock) {
                lock.notifyAll();
            }

    }//GEN-LAST:event_jButton3ActionPerformed
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        answer = jButton4.getText();
paused = !paused;
                synchronized(lock) {
                    lock.notifyAll();
                }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        answer = jButton2.getText();
paused = !paused;
                synchronized(lock) {
                    lock.notifyAll();
                }
    }//GEN-LAST:event_jButton2ActionPerformed

  
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Quiz quiz = new Quiz();
                quiz.setVisible(true);
                quiz.go();
            }
        });
    }
    public void go(){
        
        editor = new Thread(new Runnable(){
          public void run(){
              while(true){
                if(running)
                takeQuiz();
                else
                System.exit(0);
              }
            }
        });
        editor.start();
                
            
        
        
    }
    public void takeQuiz(){
        
        Random rand = new Random();
        populateQuestionPool();

            while(index < QUIZ_LENGTH){

                int selector = rand.nextInt(4);
                List<String> wrong = questionPool.get(index).getIncorrectAnswers();
                switch(selector){
                    case 0:jButton1.setText(questionPool.get(index).getCorrectAnswer());jButton2.setText(wrong.get(0));jButton3.setText(wrong.get(1));jButton4.setText(wrong.get(2));break;
                    case 2:jButton1.setText(wrong.get(0));jButton2.setText(questionPool.get(index).getCorrectAnswer());jButton3.setText(wrong.get(1));jButton4.setText(wrong.get(2));;break;
                    case 1:jButton1.setText(wrong.get(1));jButton2.setText(wrong.get(0));jButton3.setText(questionPool.get(index).getCorrectAnswer());jButton4.setText(wrong.get(2));;break;
                    case 3:jButton1.setText(wrong.get(2));jButton2.setText(wrong.get(0));jButton3.setText(wrong.get(1));jButton4.setText(questionPool.get(index).getCorrectAnswer());;break;
                    default:jButton1.setText(questionPool.get(index).getCorrectAnswer());jButton2.setText(wrong.get(0));jButton3.setText(wrong.get(1));jButton4.setText(wrong.get(2));break;
                }
                changeImage(questionPool.get(index).getImageName());
                jLabel1.setText(questionPool.get(index).getQuestion());
                paused = true;
                pause();
                if(answer.equals(questionPool.get(index).getCorrectAnswer())){
                    score++;
                }
                jProgressBar1.setValue(index);
                index++;
                
            }
            done = true;
            jLabel2.setIcon(null);
            jLabel2.revalidate();
            jButton2.setVisible(false);
            jButton4.setVisible(false);
            jProgressBar1.setVisible(false);
            jLabel1.setText("Do you want to take another quiz?");
            jButton1.setText("Yes");
            jButton3.setText("No");
            jLabel2.setText("Your score: " + (score/QUIZ_LENGTH)*100+"%");
            paused = true;
            pause();
    }
    public void pause(){
        synchronized(lock){
            while(paused){
                try{
                    lock.wait();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    public void changeImage(String file_name){
        ImageIcon icon = new ImageIcon(file_name);
                icon.getImage().flush();
                jLabel2.setIcon(icon);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
