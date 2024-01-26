// Group 1 - Bagtas, Kristel Joy G., Isidro, Abby Gayle C., Laxa, Jayzelyn R.
// BSIT - NW2A
package group1_ctcc0513_cmo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainFrame extends javax.swing.JFrame {

    /**
     * Creates new form mainFrame
     */
    public mainFrame() {
        initComponents();
    }
// this method is used to convert binary to decimal
    public int BtD(Long number) { 
        int Decimal = 0; //initializes the variable to store its equivalent of the binary number
        Long mod; //stores the remainder obtained 
        int mul = 2; //stores the multiplier used in the conversion process
        for (int i = 0; i < 100; i++) { //used to iterate each of the binary digit from right to left
            mod = number % 10; // calculates remainder of the binary digit 
            number = number / 10; //divides the binary digit by 10
            if (mod == 1) { //checks if the digit is equal to 1
                if (i == 0) { //checks if the digit is equal to 0
                    Decimal += 1; //adds 1 to the decimal variable if the number is the first digit 
                } else if (i == 1) { //checks if the binary digit is the second digit
                    Decimal += mul; //adds the product of the multiplier and the current digit of the decimal variable
                } else {
                    //a loop that calculates each digit from the current digit to second digit by multiplying it by 2
                    for (int j = i; j > 1; j--) { 
                        mul *= 2; 
                    }
                    Decimal += mul; //adds the multiplier's product to the current digit of the decimal variable
                }
                mul = 2; // resets the multiplier to 2 for next iteration
            } else if (mod != 0) { //executes if and only if the current digit is not 0
                Decimal = -1; //indicates an error if the current number is not a 0
                break;
            }
        }
        return Decimal; //returns the new value or the decimal value of the binary number
    }
    
// this method is used to convert decimal to binary
    public String DtB(int number) {
        String Binary = ""; //initializes the variable to store its equivalent of the decimal number
        int top = 0; //keeps tracking of the top index of a character array stack
        char[] stack = new char[100]; //initializes the array's character with a size of 100 to store the decimal number's binary digits
        int mul = 2; //stores the multiplier used in the conversion process
        double mod; //stores the remainder obtained
        while (number != 0) { //a loop to stop when the decimal number becomes 0
            mod = number % mul; //calculates the remainder of the decimal number
            number = number / mul; //divides the decimal number to the multiplier 
            if (mod != 0) { //checks if the current digit is not 0
                stack[top] = '1'; //pushes a 1 to the top of the stack if the digit is not 0
                top++; //increments the top index of the stack
            } else {
                stack[top] = '0'; //pushes a 0 if the current digit is 0
                top++; //increments the top index of the stack
            }
        }
        
        for (int i = 1; top >= i; top--) { //a loop for when the top index of the stack becomes 0
            Binary = Binary.concat(stack[top - 1] + ""); //concatenates the binary digit at the top of the stack to the binary string
        }
        return Binary; //returns the new value or the binary value of the decimal number
    }
    
    // this method is used to take the user's input and return a new one in reversed 
    public String WordReverse(String word) {
        char[] stack = new char[word.length()]; //declares new character array that the length of the input string is equal to the length of the input string itself
        int top; //declares an int variable top 
        for (top = 0; top < word.length(); top++) { //initializes the variable top to 0 and start a loop for when each character in the input string is being iterated
            stack[top] = word.charAt(top); //assigns the character at the current index of the input string to the corresponding index in the stack
        }
        
        word = ""; //initializes the input string to an empty string
        for (int i = 1; top >= i; top--) { //a loop that iterates backwards over the stack
            word = word.concat(String.valueOf(stack[top - 1])); //concatenates the character at the current index of the stack to the end of the string
        }
        return word; //returns the new value or the reversed word
    }

    // this will check the given word if the word is a palindrome or not
    public void PalindromeChecker(String word, String Reversedword) {
        word = (String.valueOf(word.charAt(0)).toUpperCase()) + 
                (word.substring(1).toLowerCase());
        Reversedword = (String.valueOf(Reversedword.charAt(0)).toUpperCase()) + 
                ((Reversedword.substring(1)).toLowerCase());
        if (word.equalsIgnoreCase(Reversedword)) {
            jLabel7.setText(word + " is a Palindrome word");
        } else {
            jLabel7.setText(word + " is not a Palindrome word");
        }
        converted.setText(Reversedword);
    }

    void reset() {
        //this will clear all the textfield in the frame
        converter.setText("");
        converted.setText("");
        jLabel7.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Reset = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CB1 = new javax.swing.JComboBox<>();
        converter = new javax.swing.JTextField();
        Convertbtn = new javax.swing.JButton();
        converted = new javax.swing.JTextField();
        resetbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Reset.setBackground(new java.awt.Color(153, 153, 255));
        Reset.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(255, 255, 255)));
        Reset.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Abyssinica SIL", 1, 24)); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        CB1.setFont(new java.awt.Font("Abyssinica SIL", 1, 18)); // NOI18N
        CB1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Binary to Decimal", "Decimal to Binary", "Palindrome Checker" }));
        CB1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CB1ItemStateChanged(evt);
            }
        });
        CB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB1ActionPerformed(evt);
            }
        });

        converter.setFont(new java.awt.Font("Minecraft", 0, 18)); // NOI18N
        converter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                converterKeyReleased(evt);
            }
        });

        Convertbtn.setBackground(new java.awt.Color(153, 153, 255));
        Convertbtn.setFont(new java.awt.Font("Abyssinica SIL", 1, 18)); // NOI18N
        Convertbtn.setText("Convert");
        Convertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConvertbtnActionPerformed(evt);
            }
        });

        converted.setFont(new java.awt.Font("Minecraft", 0, 18)); // NOI18N
        converted.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        converted.setEnabled(false);

        resetbtn.setBackground(new java.awt.Color(153, 153, 255));
        resetbtn.setFont(new java.awt.Font("Abyssinica SIL", 1, 18)); // NOI18N
        resetbtn.setText("Reset");
        resetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Abyssinica SIL", 1, 18)); // NOI18N
        jLabel2.setText("Decimal");

        jLabel3.setFont(new java.awt.Font("Abyssinica SIL", 1, 18)); // NOI18N
        jLabel3.setText("Binary");

        jLabel4.setFont(new java.awt.Font("Abyssinica SIL", 1, 24)); // NOI18N
        jLabel4.setText("Binary Converter/ Palindrome Checker");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Abyssinica SIL", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 255));
        jLabel5.setText("10");

        jLabel6.setBackground(new java.awt.Color(153, 153, 255));
        jLabel6.setFont(new java.awt.Font("Abyssinica SIL", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 255));
        jLabel6.setText("2");

        jLabel7.setFont(new java.awt.Font("Abyssinica SIL", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout ResetLayout = new javax.swing.GroupLayout(Reset);
        Reset.setLayout(ResetLayout);
        ResetLayout.setHorizontalGroup(
            ResetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ResetLayout.createSequentialGroup()
                .addGroup(ResetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ResetLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(ResetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ResetLayout.createSequentialGroup()
                                .addGroup(ResetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ResetLayout.createSequentialGroup()
                                        .addComponent(converter, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6))
                                    .addGroup(ResetLayout.createSequentialGroup()
                                        .addGap(80, 80, 80)
                                        .addComponent(jLabel3)))
                                .addGroup(ResetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ResetLayout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(converted, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5))
                                    .addGroup(ResetLayout.createSequentialGroup()
                                        .addGap(125, 125, 125)
                                        .addComponent(jLabel2))))
                            .addGroup(ResetLayout.createSequentialGroup()
                                .addComponent(resetbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(254, 254, 254)
                                .addComponent(Convertbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(CB1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ResetLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(62, 62, 62)))
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(ResetLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ResetLayout.setVerticalGroup(
            ResetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ResetLayout.createSequentialGroup()
                .addGroup(ResetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ResetLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ResetLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(CB1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(ResetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ResetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(converter, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(converted, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(ResetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Convertbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Reset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CB1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CB1ItemStateChanged
        //this method will change the components in the frame dependeing on the selected item
        if (CB1.getSelectedItem() == "Decimal to Binary") {
            reset();
            jLabel3.setText("Decimal");
            jLabel2.setText("Binary");
            jLabel6.setText("10");
            jLabel5.setText("2");
            Convertbtn.setText("Convert");
        } else if (CB1.getSelectedItem() == "Binary to Decimal") {
            reset();
            jLabel3.setText("Binary");
            jLabel2.setText("Decimal");
            jLabel6.setText("2");
            jLabel5.setText("10");
            Convertbtn.setText("Convert");
        } else if (CB1.getSelectedItem() == "Palindrome Checker") {
            reset();
            jLabel3.setText("Word");
            jLabel2.setText("Reversed Word");
            jLabel6.setText("");
            jLabel5.setText("");
            Convertbtn.setText("Check");
        }
    }//GEN-LAST:event_CB1ItemStateChanged

    private void CB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB1ActionPerformed

    private void converterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_converterKeyReleased
        if(jLabel6.getText() == "10" && converter.getText().length() >= 10){
            JOptionPane.showMessageDialog(null, "You have reached maximum input!");
            reset();
            // if the user's decimal number input has reached the maximum number of ten, the system will show a message dialog that the user has reached the limit input
        }
    }//GEN-LAST:event_converterKeyReleased

    private void ConvertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConvertbtnActionPerformed
        if (!converter.getText().equals("")) {
            String lbltype = jLabel6.getText();//this will get the text in the label jLabel6
            int number;//this will be the container of the element that will be returned when the method BtD is called

            if (lbltype == "2") {
                Long num = Long.parseLong(converter.getText());
                number = BtD(num);
                if (number == -1) {
                    JOptionPane.showMessageDialog(null, "Invalid Input!");
                    reset();
                    // if the user input a non-binary number then the system will show a message dialog that says that the user's input is invalid
                } else {
                    converted.setText(String.valueOf(number));
                }
            } else if (lbltype == "10") {
                //if the text in the label is equal to 10 then the method that will be used is the DtB method
                number = Integer.parseInt(converter.getText());//get the value in the textfield converter
                converted.setText(DtB(number));//this will call the method DtB to convert the decimal to binary
            } else if (lbltype == ""){
                //if the text in the label is equal to "" then the method that will be used is the WordReverse method
                String word = String.valueOf(converter.getText());//get the value in the textfield converter
                String ReversedWord;//this will serve as container for the ReversedWord
                ReversedWord = WordReverse(word);//this will call the method WordReverse to reverse the word
                PalindromeChecker(word, ReversedWord);//this will call the method PalindromeChecker to check if the is panlindrome or not
            }
        }
    }//GEN-LAST:event_ConvertbtnActionPerformed

    private void resetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbtnActionPerformed
        reset();//this will call the method WordReverse to clear all the textfield in the frame
    }//GEN-LAST:event_resetbtnActionPerformed

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
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB1;
    private javax.swing.JButton Convertbtn;
    private javax.swing.JPanel Reset;
    private javax.swing.JTextField converted;
    private javax.swing.JTextField converter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton resetbtn;
    // End of variables declaration//GEN-END:variables
}
