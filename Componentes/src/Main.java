import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Inicio Sesion");
        frame.setContentPane(new form1().inicioSesion);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720,240);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


    }
}