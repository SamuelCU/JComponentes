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
                /*JFileChooser es una clase la que nos permite selecionar archivos*/
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null); /*Abre una ventana emergente con la clase de JFileChooser*/

                /*Aqui se crea la variable para abrir el arhivo y se pueda ver como la barra carga*/
                File file = chooser.getSelectedFile(); /*Este método devuelve el archivo selecionado*/
                /*ProgressBar*/
                cargando.setValue(0); /*Comienza desde 0*/
                cargando.setStringPainted(true); /*Método para que se pinte el porcentaje que va de proceso*/

                new Thread(new Runnable() {
                    public void run() { /*metodo "run" aqui se define el bucle para definir el proceso de la tarea*/
                        for (int i = 0; i <= 100; i++) {
                            final int currentValue = i; /*actualiza el valor de barra*/
                            try {
                                SwingUtilities.invokeLater(new Runnable() {
                                    public void run() {
                                        cargando.setValue(currentValue); /*la barra cambiara al valor de currentValue*/
                                    }
                                });
                                java.lang.Thread.sleep(100); /*Solo da un tiempo de demora para simular la carga de datos*/
                            } catch (InterruptedException e) {
                                JOptionPane.showMessageDialog(null, e);
                            }
                        }
                    }
                }).start();
                /*Hace que el archivo selecionado por JFileChooser se vea en JTable*/
                /*Solo sirve para archivos .csv ya que en este tipo de archivos la separación es por comas*/
                try {
                    BufferedReader cc = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
                    String line;
                    int numColumnas = 0;
                    while ((line = cc.readLine()) != null) {
                        String[] data = line.split(","); /*Esta definida las separaciones*/
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

            }

        });
    }
}


