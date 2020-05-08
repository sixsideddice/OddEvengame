
package oddevengame;

import java.util.Random;
import javax.swing.JOptionPane;


public class ODDEven extends javax.swing.JFrame {
        static int score = 0; // score each corrent question add 1 
        static int count = 0; // number of  question out of 10
        
        //generate random number for each question(number)
        Random r = new Random();
        int randomNum;
        

    public ODDEven() {
        initComponents();
        //first time generate random 
        randomNum = r.nextInt(100);
        lblNumber.setText(String.valueOf(randomNum));
    }

    //GUI Section
    private void initComponents() {

        lblNumber = new javax.swing.JLabel();
        btnOdd = new javax.swing.JButton();
        btnEven = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(30, 39, 46));

        lblNumber.setFont(new java.awt.Font("Lato Black", 0, 48));
        lblNumber.setForeground(new java.awt.Color(109, 184, 166));
        lblNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnOdd.setBackground(new java.awt.Color(71, 71, 71));
        btnOdd.setFont(new java.awt.Font("Quicksand", 1, 24));
        btnOdd.setForeground(new java.awt.Color(202, 232, 230));
        btnOdd.setText("ODD");
        btnOdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOddActionPerformed(evt);
            }
        });

        btnEven.setBackground(new java.awt.Color(71, 71, 71));
        btnEven.setFont(new java.awt.Font("Quicksand", 1, 24));
        btnEven.setForeground(new java.awt.Color(202, 232, 230));
        btnEven.setText("EVEN");
        btnEven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEvenActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Quicksand", 1, 24));
        jLabel1.setForeground(new java.awt.Color(107, 107, 107));
        jLabel1.setText("SCORE");

        lblScore.setBackground(new java.awt.Color(202, 232, 230));
        lblScore.setFont(new java.awt.Font("Quicksand", 1, 24));
        lblScore.setForeground(new java.awt.Color(0, 155, 133));
        lblScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScore.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(126, 189, 173)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btnOdd, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnEven, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(lblNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(lblScore, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnOdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEven, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblScore, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void btnOddActionPerformed(java.awt.event.ActionEvent evt) {

        //odd operation
        count = count+1; //each button click count question add 1 out of 10
        int num = Integer.parseInt(lblNumber.getText());  //lblnumber is random num and convert to int for odd even operation
        if(count==10){
            //when counter reach last question(number)
            //than it calculate for last number 
            if(num%2!=0){
                // number corret add score 
                score = score+1;
                lblScore.setText(String.valueOf(score)); //set value of score when answer correct
                randomNum = r.nextInt(100); // random number generate for next question number
                
            }else{
                //if not odd number
                randomNum = r.nextInt(100);
                lblNumber.setText(String.valueOf(randomNum)); //set randomnumber
                               
            }
            
            //result display on 10th question
            JOptionPane.showMessageDialog(this, "Your score is: "+score+"/10");
            //reset values after score
            count=0;
            score =0;
            lblScore.setText("");
            randomNum = r.nextInt(100);
            lblNumber.setText(String.valueOf(randomNum));
            
        }else{
            // if number not reach 10th qestion ( for 1 to 9 )
            if(num%2!=0){
                score = score+1;
                lblScore.setText(String.valueOf(score)); //set score value
                //generate random number for next question
                randomNum = r.nextInt(100);
                lblNumber.setText(String.valueOf(randomNum));
            }else{
                //if not odd than generate random for next
                randomNum = r.nextInt(100);
                lblNumber.setText(String.valueOf(randomNum));
            }
        }
        
        
        
    }

    private void btnEvenActionPerformed(java.awt.event.ActionEvent evt) {

        count = count+1; //each button click count question add 1 out of 10
        int num = Integer.parseInt(lblNumber.getText());  //lblnumber is random num and convert to int for odd even operation
        if(count==10){
            //when counter reach last question(number)
            //than it calculate for last number 
            if(num%2==0){
                // number corret add score 
                score = score+1;
                lblScore.setText(String.valueOf(score)); //set value of score when answer correct
                randomNum = r.nextInt(100); // random number generate for next question number
                
            }else{
                //if not odd number
                randomNum = r.nextInt(100);
                lblNumber.setText(String.valueOf(randomNum)); //set randomnumber
                               
            }
            
            //result display on 10th question
            JOptionPane.showMessageDialog(this, "Your score is: "+score+"/10");
            //reset values after score
            count=0;
            score =0;
            lblScore.setText("");
            randomNum = r.nextInt(100);
            lblNumber.setText(String.valueOf(randomNum));
            
        }else{
            // if number not reach 10th qestion ( for 1 to 9 )
            if(num%2==0){
                score = score+1;
                lblScore.setText(String.valueOf(score)); //set score value
                //generate random number for next question
                randomNum = r.nextInt(100);
                lblNumber.setText(String.valueOf(randomNum));
            }else{
                //if not odd than generate random for next
                randomNum = r.nextInt(100);
                lblNumber.setText(String.valueOf(randomNum));
            }
        }
        
        
    }

    public static void main(String args[]) {
 
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ODDEven.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ODDEven.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ODDEven.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ODDEven.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ODDEven().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton btnEven;
    private javax.swing.JButton btnOdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblNumber;
    private javax.swing.JLabel lblScore;
    
}
