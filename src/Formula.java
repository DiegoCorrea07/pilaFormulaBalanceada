import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;

public class Formula {
    private JPanel Ventana;
    private JTextField textField1;
    private JButton comprobarButton;
    private JLabel elementosAperturaLabel;
    private JLabel elementosCierreLabel;
    private JButton limpiarButton;

    private PilaCaracteres formula = new PilaCaracteres();

    public Formula() {
        comprobarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = textField1.getText();
                int elementosApertura = 0;
                int elementosCierre = 0;
                boolean esFormulaEquilibrada = true; // Variable para rastrear si la fórmula está equilibrada

                for (int i = 0; i < texto.length(); i++) {
                    char caracter = texto.charAt(i);

                    if (esSimboloApertura(caracter)) {
                        formula.apilarElemento(caracter);
                        elementosApertura++;
                    } else if (esSimboloCierre(caracter)) {
                        try {
                            char ultimoCaracterApertura = formula.quitarElemento();
                            if (!esParValido(ultimoCaracterApertura, caracter)) {
                                esFormulaEquilibrada = false;
                                break; // Sale del bucle si se encuentra un carácter no equilibrado
                            }
                            elementosCierre++;
                        } catch (Exception ex) {
                            esFormulaEquilibrada = false;
                            break; // Sale del bucle si se produce una excepción
                        }
                    }
                }

                if (esFormulaEquilibrada) {
                    JOptionPane.showMessageDialog(null, "La fórmula está equilibrada.");
                } else {
                    JOptionPane.showMessageDialog(null, "La fórmula no está equilibrada.");
                }

                elementosAperturaLabel.setText("Elementos de apertura: " + elementosApertura);
                elementosCierreLabel.setText("Elementos de cierre: " + elementosCierre);
            }
        });



        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    while (!formula.estaVacia()) {
                        formula.quitarElemento();
                    }
                    textField1.setText(""); // Limpia el cuadro de texto
                    elementosAperturaLabel.setText("Elementos de apertura: 0"); // Actualiza el label de elementos de apertura
                    elementosCierreLabel.setText("Elementos de cierre: 0"); // Actualiza el label de elementos de cierre
                    JOptionPane.showMessageDialog(null, "Cuadro de texto limpiado.");
                } catch (EmptyStackException ex) {
                    // Maneja la excepción si la pila ya está vacía
                    JOptionPane.showMessageDialog(null, "La pila ya está vacía.");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });



    }

    private boolean esSimboloApertura(char simbolo) {
        return simbolo == '(' || simbolo == '[' || simbolo == '{';
    }

    private boolean esSimboloCierre(char simbolo) {
        return simbolo == ')' || simbolo == ']' || simbolo == '}';
    }

    private boolean esParValido(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
                (apertura == '[' && cierre == ']') ||
                (apertura == '{' && cierre == '}');
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Formula Balanceada");
        frame.setContentPane(new Formula().Ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
