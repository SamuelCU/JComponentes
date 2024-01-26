import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class form2 {
    JPanel Principal;
    private JTable table1;
    private JButton importarButton;
    private JProgressBar cargando;

    public form2() {
        importarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null);
                /**/

                File file = chooser.getSelectedFile();

                cargando.setValue(0);
                cargando.setStringPainted(true);

                new Thread(new Runnable() {
                    public void run() {
                        for (int i = 0; i <= 100; i++) {
                            final int currentValue = i;
                            try {
                                SwingUtilities.invokeLater(new Runnable() {
                                    public void run() {
                                        cargando.setValue(currentValue);
                                    }
                                });
                                java.lang.Thread.sleep(100);
                            } catch (InterruptedException e) {
                                JOptionPane.showMessageDialog(null, e);
                            }
                        }
                    }
                }).start();
                try {
                    BufferedReader cc = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
                    String line;
                    int numColumnas = 0;
                    while ((line = cc.readLine()) != null) {
                        String[] data = line.split(",");
                        numColumnas = data.length;
                    }
                    String[] columnNames = new String[numColumnas];
                    for(int i = 0; i < numColumnas; i++){
                        columnNames[i] = "Columna " + i;
                    }
                    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));

                    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                    while ((line = br.readLine()) != null) {
                        String[] data = line.split(",");
                        model.addRow(data);
                    }
                    table1.setModel(model);
                } catch (Exception ex) {
                    System.out.println(ex);
                }


                /**/

            }

        });
    }
}


