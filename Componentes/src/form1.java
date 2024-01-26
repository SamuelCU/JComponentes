
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

    public form1(JFrame as) {
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
                    as.dispose();
                }
            }
        });
    }
}
