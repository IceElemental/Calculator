
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import static java.math.BigDecimal.ROUND_HALF_UP;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VMS
 */
public class MainWindow extends JFrame {
    
    private static JButton n1, n2, n3, n4, n5, n6, n7, n8, n9, n0, plus, minus, multiple, del, point, clear, equal;
    private static JTextField inputField1;
    private static Font serifFont = new Font("SansSerif", Font.PLAIN, 20);
    private static double doubleBuf = 0;
    private static String stringBuf = "";
    private static String operBuf = "";
    private static ButtonListener listen = new ButtonListener();
    private static boolean newInput = true;
    private static BigDecimal megabuff;
    
    public MainWindow(String s)
    {
        super(s);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(260, 340);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        
        inputField1 = new JTextField();
           
        n1 = new JButton("1");
        n2 = new JButton("2");
        n3 = new JButton("3");
        n4 = new JButton("4");
        n5 = new JButton("5");
        n6 = new JButton("6");
        n7 = new JButton("7");
        n8 = new JButton("8");
        n9 = new JButton("9");
        n0 = new JButton("0");
        plus = new JButton("+");
        minus = new JButton("-");
        multiple = new JButton("*");
        del = new JButton("/");
        point = new JButton(".");
        //clear = new JButton("clr");
        equal = new JButton("=");
        
        inputField1.setSize(231, 50);
        inputField1.setLocation(10, 10);
        inputField1.setBorder(BorderFactory.createCompoundBorder(inputField1.getBorder(), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        inputField1.setHorizontalAlignment(JTextField.RIGHT);
        inputField1.setFont(serifFont);
         
        n1.setSize(50, 50);
        n1.setLocation(10, 70);
        n1.setMargin(new Insets(2,2,2,2));
        n1.addActionListener(listen);
        n1.setFont(serifFont);
        
        n2.setSize(50, 50);
        n2.setLocation(70, 70);
        n2.setMargin(new Insets(2,2,2,2));
        n2.addActionListener(listen);
        n2.setFont(serifFont);
        
        n3.setSize(50, 50);
        n3.setLocation(130, 70);
        n3.setMargin(new Insets(2,2,2,2));
        n3.addActionListener(listen);
        n3.setFont(serifFont);
        
        n4.setSize(50, 50);
        n4.setLocation(10, 130);
        n4.setMargin(new Insets(2,2,2,2));
        n4.addActionListener(listen);
        n4.setFont(serifFont);
        
        n5.setSize(50, 50);
        n5.setLocation(70, 130);
        n5.setMargin(new Insets(2,2,2,2));
        n5.addActionListener(listen);
        n5.setFont(serifFont);
        
        n6.setSize(50, 50);
        n6.setLocation(130, 130);
        n6.setMargin(new Insets(2,2,2,2));
        n6.addActionListener(listen);
        n6.setFont(serifFont);
        
        n7.setSize(50, 50);
        n7.setLocation(10, 190);
        n7.setMargin(new Insets(2,2,2,2));
        n7.addActionListener(listen);
        n7.setFont(serifFont);
        
        n8.setSize(50, 50);
        n8.setLocation(70, 190);
        n8.setMargin(new Insets(2,2,2,2));
        n8.addActionListener(listen);
        n8.setFont(serifFont);
        
        n9.setSize(50, 50);
        n9.setLocation(130, 190);
        n9.setMargin(new Insets(2,2,2,2));
        n9.addActionListener(listen);
        n9.setFont(serifFont);
        
        n0.setSize(50, 50);
        n0.setLocation(10, 250);
        n0.setMargin(new Insets(2,2,2,2));
        n0.addActionListener(listen);
        n0.setFont(serifFont);
        
        plus.setSize(50, 50);
        plus.setLocation(190, 70);
        plus.setMargin(new Insets(2,2,2,2));
        plus.addActionListener(listen);
        plus.setFont(serifFont);
        
        minus.setSize(50, 50);
        minus.setLocation(190, 130);
        minus.setMargin(new Insets(2,2,2,2));
        minus.addActionListener(listen);
        minus.setFont(serifFont);
        
        multiple.setSize(50, 50);
        multiple.setLocation(190, 190);
        multiple.setMargin(new Insets(2,2,2,2));
        multiple.addActionListener(listen);
        multiple.setFont(serifFont);
        
        del.setSize(50, 50);
        del.setLocation(190, 250);
        del.setMargin(new Insets(2,2,2,2));
        del.addActionListener(listen);
        del.setFont(serifFont);
        
        point.setSize(50, 50);
        point.setLocation(70, 250);
        point.setMargin(new Insets(2,2,2,2));
        point.addActionListener(listen);
        point.setFont(serifFont);
        
        equal.setSize(50, 50);
        equal.setLocation(130, 250);
        equal.setMargin(new Insets(2,2,2,2));
        equal.addActionListener(listen);
        equal.setFont(serifFont);
        
        panel.add(inputField1);
        panel.add(n1);
        panel.add(n2);
        panel.add(n3);
        panel.add(n4);
        panel.add(n5);
        panel.add(n6);
        panel.add(n7);
        panel.add(n8);
        panel.add(n9);
        panel.add(n0);
        panel.add(plus);
        panel.add(minus);
        panel.add(multiple);
        panel.add(del);
        panel.add(point);
        panel.add(equal);
        
        setContentPane(panel);
    }
    public static class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clear)
            {
                inputField1.setText("");
            }
            if ( (e.getSource() ==  n0) || (e.getSource() ==  n1) || (e.getSource() ==  n2) || (e.getSource() ==  n3) || (e.getSource() ==  n4) || (e.getSource() ==  n5) || (e.getSource() ==  n6) || (e.getSource() ==  n7) || (e.getSource() ==  n8) || (e.getSource() ==  n9) )
            {
                if (newInput)
                {
                    newInput = false;
                    inputField1.setText("");
                }
                inputField1.setText(inputField1.getText() + e.getActionCommand());
            }
            if ( e.getSource() ==  point )
            {
                if ( inputField1.getText().contains("."))
                {
                }
                else if (inputField1.getText().equals("") )
                {
                    inputField1.setText( "0" + e.getActionCommand());
                }
                else 
                {
                    inputField1.setText(inputField1.getText() + e.getActionCommand()); 
                }
            }
            if ( (e.getSource() == plus) || (e.getSource() == minus) || (e.getSource() == multiple) || (e.getSource() == del) )
            {
                if ( !( inputField1.getText().equals("") ) )
                {
                    stringBuf = inputField1.getText();
                }
                operBuf = e.getActionCommand();
                newInput = true;
            }
            if (e.getSource() == equal)
            {
                if ( inputField1.getText().endsWith(".") )
                {
                    inputField1.setText(inputField1.getText().concat("0"));
                }
                if ( stringBuf.equals("") )
                {
                    stringBuf = inputField1.getText();
                }
                else 
                {
                    if ( operBuf.equals("+") )
                    {
                        doubleBuf = Double.parseDouble(stringBuf) + Double.parseDouble(inputField1.getText());
                        //megabuff = BigDecimal.valueOf(Double.parseDouble(stringBuf)).add(BigDecimal.valueOf(Double.parseDouble(inputField1.getText())));
                    }
                    else if ( operBuf.equals("-") )
                    {
                        doubleBuf = Double.parseDouble(stringBuf) - Double.parseDouble(inputField1.getText());
                        //megabuff = BigDecimal.valueOf(Double.parseDouble(stringBuf)).subtract(BigDecimal.valueOf(Double.parseDouble(inputField1.getText())));
                    } 
                    else if ( operBuf.equals("*") )
                    {
                        doubleBuf = Double.parseDouble(stringBuf) * Double.parseDouble(inputField1.getText());
                        //megabuff = BigDecimal.valueOf(doubleBuf);
                        //megabuff = BigDecimal.valueOf(Double.parseDouble(stringBuf)).multiply(BigDecimal.valueOf(Double.parseDouble(inputField1.getText())));
                    }
                    else if ( operBuf.equals("/") )
                    {
                        doubleBuf = Double.parseDouble(stringBuf) / Double.parseDouble(inputField1.getText());
                        //megabuff = BigDecimal.valueOf(doubleBuf);
                        //megabuff = BigDecimal.valueOf(Double.parseDouble(stringBuf)).divide( BigDecimal.valueOf(Double.parseDouble(inputField1.getText())));
                    }
                    if ( (doubleBuf%1) ==0 )
                    {
                        stringBuf = String.valueOf( (int)doubleBuf );
                    } 
                    else 
                    { 
                        stringBuf = String.valueOf(doubleBuf); 
                    }
                    //stringBuf = String.valueOf(doubleBuf);
                }
                
                inputField1.setText( stringBuf );
                newInput = true;
                operBuf = "";
                stringBuf = "";
            }
        }
    }
}
