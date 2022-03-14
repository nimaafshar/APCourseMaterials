import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Calculation implements ActionListener {
    JFrame frame;
    JTextField text;
    JButton[] btns = new JButton[15];
    String[] numbers = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    String[] operators = new String[]{"+", "-", "*", "/", "=", ".", "+/-", "Clear", "Delete"};
    int btnW = 45, btnH = 45;
    String operator;
    double lastNumber;
    double firstNumber = Double.NaN;
    double backUp;


    public Calculation() {
        frame = new JFrame("Calculator");
        frame.setSize(250, 380);
        frame.getContentPane().setBackground(Color.black);


        text = new JTextField("0");
        text.setBounds(10, 10, 215, 45);
        frame.add(text);

        InitialNumberBtns();
        InitialOperatorBtns();

        frame.setLayout(null);

        frame.setVisible(true);
    }

    public void InitialNumberBtns() {

        int x = 10, y = 65;
        int col = 0;
        for (int i = 0; i < numbers.length; i++) {
            JButton btn = new JButton(numbers[i]);
            btn.setBounds(x, y, btnW, btnH);

            btn.addActionListener(this);
            frame.add(btn);

            btns[i] = btn;
            btn.setBackground(Color.lightGray);

            col++;
            if (col == 3) {
                y += btnH + 10;
                x = 10;
                col = 0;
            } else {
                x += 10 + btnW;
            }
        }
    }

    public void InitialOperatorBtns() {
        //  int totalSize = 440;
        int defaultX = (3 * this.btnW) + 40;
        int x = defaultX, y = 65;
        int btnW = 50, btnH = 45;

        for (int i = 0; i < operators.length; i++) {
            JButton btn = new JButton(operators[i]);
            btn.setBounds(x, y, btnW, btnH);
            btn.setBackground(Color.orange);

            if (operators[i].equals("=")) {
                btn.setBounds(120, 230, 45, 45);
                btn.setBackground(Color.orange);
            }
            if (operators[i].equals(".")) {
                btn.setBounds(65, 230, 45, 45);
                btn.setBackground(Color.orange);
            }
            if (operators[i].equals("Clear")) {
                btn.setBounds(10, 285, 70, 45);
                btn.setBackground(Color.green);
            }
            if (operators[i].equals("Delete")) {
                btn.setBounds(95, 285, 70, 45);
                btn.setBackground(Color.red);
            }
            if (operators[i].equals("+/-")) {
                btn.setBounds(175, 285, 50, 45);
                btn.setBackground(Color.orange);
            }


            btn.addActionListener(this);
            frame.add(btn);

            btns[i] = btn;

            y += btnH + 10;

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btnLable = ((JButton) e.getSource()).getText();
        //  int i=0;


        if (Arrays.asList(numbers).contains(btnLable)) {
            text.setText(text.getText() + btnLable);
        }
        if (btnLable == "+" || btnLable == "-" || btnLable == "*" || btnLable == "/") {
            if (Double.isNaN(firstNumber)) {
                firstNumber = Double.valueOf(text.getText());
                text.setText("");
                operator = btnLable;
            } else {
                backUp=firstNumber;
                lastNumber = Double.valueOf(text.getText());
                firstNumber = calculation(firstNumber,lastNumber,operator);
                lastNumber = Double.NaN;
                operator = btnLable;
                text.setText("");
            }
            if(firstNumber==Double.POSITIVE_INFINITY){
                firstNumber=backUp;
                operator = "/";
                text.setText("0");
            }
        }

        if (btnLable == "=") {
            double res = 0;
            switch (operator) {
                case "+":
                    res = firstNumber + Double.valueOf(text.getText());
                    firstNumber = Double.NaN;
                    break;
                case "-":
                    res = firstNumber - Double.valueOf(text.getText());
                    firstNumber = Double.NaN;
                    break;
                case "*":
                    res = firstNumber * Double.valueOf(text.getText());
                    firstNumber = Double.NaN;
                    break;
                case "/":
                    res = firstNumber / Double.valueOf(text.getText());
                    break;
            }
            if (res==Double.POSITIVE_INFINITY) {
                text.setText("0");
              }else {
                firstNumber=Double.NaN;
                text.setText(String.valueOf(res));
           }

        }
        if (btnLable=="Clear"){
            text.setText("");
        }
        if(btnLable=="Delete"){
            firstNumber=Double.NaN;
            text.setText("");
        }
        if (btnLable == "+/-"){
            text.setText(String.valueOf(Double.valueOf(text.getText())*-1));
        }
        if (btnLable == "."){
            text.setText(text.getText() + ".");

        }


    }

    public double calculation(double firstNumber, double lastNumber, String op) {
        switch (op){
            case"+":
                firstNumber =firstNumber + lastNumber;
                break;
            case"-":
                firstNumber =firstNumber - lastNumber;
                break;
            case"*":
                firstNumber =firstNumber * lastNumber;
                break;
            case"/":
                firstNumber = firstNumber / lastNumber;
                break;
        }
        return firstNumber;

      }





}

