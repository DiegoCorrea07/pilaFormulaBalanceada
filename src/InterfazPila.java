import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazPila {
    private JPanel Ventana;
    private JTextField textField1;
    private JButton apilarButton;
    private JButton mostrarButton;
    private JButton retirarButton;
    private JButton buscarButton;
    private JButton imprimirButton;
    private JButton salirButton;
    private JTextField textField3;

    private PilaCaracteres pila = new PilaCaracteres();

    public InterfazPila(){
        apilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pila.apilarElemento(textField1.getText().charAt(0));
                JOptionPane.showMessageDialog(null, "Tamaño" + pila.tamanio());
            }
        });

        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    JOptionPane.showMessageDialog(null, pila.mirarElemento());
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        retirarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    JOptionPane.showMessageDialog(null, pila.quitarElemento() + "\n tamaño" + pila.tamanio());
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(null, pila.buscarElemento(textField1.getText().charAt(0)));
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });


        imprimirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField3.setText(pila.toString());
            }
        });


    }

    public  static void main(String[] args){
        JFrame frame = new JFrame("InterfazPila");
        frame.setContentPane(new InterfazPila().Ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
