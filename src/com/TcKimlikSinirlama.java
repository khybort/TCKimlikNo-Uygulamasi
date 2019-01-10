package com;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;


    public class TcKimlikSinirlama extends JApplet{
        private JFrame mainFrame;
        private JLabel headerLabel;
        private JLabel statusLabel;
        private JPanel controlPanel;
         JTextField txtTCKimlikNo;
         JButton btnDogrula;
         JLabel label1;
        public TcKimlikSinirlama()
        {
            prepareGUI();
        }


        private void prepareGUI(){
            mainFrame = new JFrame("Java Swing Examples");
            mainFrame.setSize(400,200);
            mainFrame.setLayout(new GridLayout(3, 1));

            mainFrame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent windowEvent){
                    System.exit(0);
                }
            });
            headerLabel = new JLabel("", JLabel.CENTER);
            statusLabel = new JLabel("",JLabel.CENTER);
            statusLabel.setSize(350,100);

            controlPanel = new JPanel();
            controlPanel.setLayout(new FlowLayout());

            mainFrame.add(headerLabel);
            mainFrame.add(controlPanel);
            mainFrame.add(statusLabel);
            mainFrame.setVisible(true);
        }
        private static boolean isValidTckn(Long tckn)
        {
            try
            {
                String tmp = tckn.toString();
                if (tmp.length() == 11)
                {
                    int totalOdd = 0;
                    int totalEven = 0;
                    for (int i = 0; i < 9; i++)
                    {
                        int val = Integer.valueOf(tmp.substring(i, i + 1));
                        if (i % 2 == 0)
                        {
                            totalOdd += val;
                        }
                        else
                        {
                            totalEven += val;
                        }
                    }
                    int total = totalOdd + totalEven + Integer.valueOf(tmp.substring(9, 10));
                    int lastDigit = total % 10;
                    if (tmp.substring(10).equals(String.valueOf(lastDigit)))
                    {
                        int check = (totalOdd * 7 - totalEven) % 10;
                        if (tmp.substring(9, 10).equals(String.valueOf(check)))
                        { return true; }
                    }
                }
            }
            catch (Exception e)
            {
//LOGGER.catching(e);
            }
            return false;
        }

        /**
         * Validates a given TCK No
         *
         * @param tckn
         * TCK No
         * @return true if valid otherwise false
         */
        public static boolean isValidTckn(String tckn) {
            if (null!=tckn && tckn.matches("^([1-9]{1}[0-9]{10})$")) {
                return isValidTckn(Long.valueOf(tckn));
            }

            return false;
        }

        public static void main(String[] args) {
            new TcKimlikSinirlama().init();
        }

        public void init() {
            getContentPane().setLayout(new FlowLayout());

            label1 = new JLabel("max 11 karakter girebilirsiniz..");
            txtTCKimlikNo = new JTextField(15);
            btnDogrula = new JButton("Doğrula");
            btnDogrula.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    Boolean v = isValidTckn(txtTCKimlikNo.getText());
                    String s ="";
                    if (v) s="Gerçek"; else s="Hatalı…!!!!";
                    statusLabel.setText(s);
                }
            });
            controlPanel.add(label1);
            controlPanel.add(txtTCKimlikNo);
            controlPanel.add(btnDogrula);
            txtTCKimlikNo.setDocument
                    (new JTextFieldLimit(11));
            mainFrame.setVisible(true);


        }
    }

