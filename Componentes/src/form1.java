
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form1 {
    private JTextField Email;
    private JPasswordField contrasenia;
    private JLabel tituloInicio;
    protected JPanel inicioSesion;
    private JMenuItem opcion1;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JMenuBar menu;
    private JMenu opciones;
    private JMenuItem opcion2;

    public form1() {
        opcion1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String correo = "A";
                String contraseña = "1";
                String user = Email.getText();
                String password = new String(contrasenia.getPassword());

                if (user.equals(correo) && password.equals(contraseña) ){
                    JFrame frame2 = new JFrame("Principal");
                    frame2.setContentPane(new form2().Principal);
                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame2.pack();
                    frame2.setSize(640,480);
                    frame2.setVisible(true);
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(opcion1);
                    frame.dispose();
                }
            }
        });
        opcion2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame3 = new JFrame("REGISTRO");
                frame3.setContentPane(new form3().registro);
                frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame3.pack();
                frame3.setSize(640,480);
                frame3.setVisible(true);
            }
        });
    }
}
