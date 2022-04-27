import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {
    JLabel aboutLabel;
    JLabel exerciseLabel;
    JLabel taskLabel;
    JLabel sideLabel;
    JTextField sideField;
    JLabel angleLabel;
    JTextField angleField;
    JButton calcButton;
    JPanel mainPanel;
    JPanel buttonPanel;
    JButton deleteButton;
    JButton exitButton;

    public MainFrame() {
        this.setComponent();
        this.setButtonPanel();
        this.setMainPanel();        
        this.setFrame();
    }
    private void setComponent() {
        aboutLabel = new JLabel("Nagy János, 2022-04-27, Szoft I N");
        exerciseLabel = new JLabel("Feladat 0312");
        taskLabel = new JLabel("Rombuszba írható kör sugara");
        sideLabel = new JLabel("Oldal");
        sideField = new JTextField();
        angleLabel = new JLabel("Alfa szög");
        angleField = new JTextField();
        calcButton = new JButton("Számít");
        Font font = new Font("sans serif", Font.BOLD, 20);
        aboutLabel.setFont(font);
        exerciseLabel.setFont(font);
        calcButton.addActionListener(event -> onClickCalcButon());

        deleteButton = new JButton("Törlés");
        exitButton = new JButton("Kilépés");
        deleteButton.addActionListener(event -> onClickDeleteButon());
        exitButton.addActionListener(event -> onClickExitButon());
    }
    private void setMainPanel() {
        mainPanel = new JPanel();
        mainPanel.add(this.aboutLabel);
        mainPanel.add(this.exerciseLabel);
        mainPanel.add(this.taskLabel);
        mainPanel.add(this.sideLabel);
        mainPanel.add(this.sideField);
        mainPanel.add(this.angleLabel);
        mainPanel.add(this.angleField);
        mainPanel.add(this.buttonPanel);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        EmptyBorder border = new EmptyBorder(10, 10, 10, 10);
        mainPanel.setBorder(border);
    }
    private void setButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.add(calcButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(exitButton);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
    }
    private void setFrame() {

        this.add(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setSize(400, 300);
        this.pack();
        this.setVisible(true);
    }
    private void onClickCalcButon() {
        String sideStr = this.sideField.getText();
        String angleStr = this.angleField.getText();
        if(sideStr.isEmpty() || angleStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hiba! Nincs érték beállítva!");
            return;
        }
        if(!sideStr.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Hiba! Nem szám az oldal!");
            return;
        }
        if(!angleStr.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Hiba! Nem szám a szög!");
            return;
        }
        double side = Double.parseDouble(sideStr);        
        double angle = Double.parseDouble(angleStr);
        double rad = angle * Math.PI / 180;
        Double radius = (1.0 / 2.0) * side * Math.sin(rad);
        this.sideField.setText(radius.toString());
        this.sideLabel.setText("Sugár");
        this.angleField.setText("");
    }
    private void onClickDeleteButon() {
        this.sideField.setText("");
        this.sideLabel.setText("Oldal");
        this.angleField.setText("");
    }
    private void onClickExitButon() {
        System.exit(0);
    }
}
