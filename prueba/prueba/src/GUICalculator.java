import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class GUICalculator extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel fondo;
	private JPanel elementos;
	private JButton sumar;
	private JLabel Lhead;
	private JLabel Lresultado;
	private JTextField resultado;
	private JTextArea ingresar;
	private JButton limpiar;
	private JLabel enternumber;
	public Calculator calcular = new Calculator();

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GUICalculator inst = new GUICalculator();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	// constructor
	public GUICalculator() {
		super("Wellcome Gloria!");
		initGUI();
	}

	// pinta la intrfaz
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				fondo = new JPanel();
				getContentPane().add(fondo, BorderLayout.CENTER);
				{
					elementos = new JPanel();
					fondo.add(elementos);
					elementos.setLayout(null);
					elementos
							.setPreferredSize(new java.awt.Dimension(374, 291));
					{
						enternumber = new JLabel();
						elementos.add(enternumber);
						enternumber.setText("Ingrese el numero");
						enternumber.setBounds(12, 73, 106, 16);
					}
					{
						ingresar = new JTextArea();
						elementos.add(ingresar);
						ingresar.setBounds(130, 61, 232, 55);
					}
					{
						sumar = new JButton();
						elementos.add(sumar);
						sumar.setText("Sumar");
						sumar.setBounds(278, 139, 85, 23);
						sumar.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								// capturamos el valor del inputtext
								String cadena;
								cadena = ingresar.getText();
								 
								if(cadena.isEmpty()){
								 JOptionPane.showMessageDialog(null, "ingrese datos");								 
								}																	
								int suma = calcular.add(cadena);
								switch (suma) {
									case -1:
										JOptionPane.showMessageDialog(null, "patron no correcto");
										break;
									case -2:
										JOptionPane.showMessageDialog(null, "No puede ingresar numeros negativos");
										break;
									default:
										String resultadosuma=Integer.toString(suma);
										resultado.setText(resultadosuma);
										break;
								}																		
							}
						});
					}
					{
						limpiar = new JButton();
						elementos.add(limpiar);
						limpiar.setText("limpiar");
						limpiar.setBounds(182, 139, 85, 24);
						limpiar.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								ingresar.setText("");
								resultado.setText("");
							}
						});

					}
					{
						resultado = new JTextField();
						elementos.add(resultado);
						resultado.setText("");
						resultado.setEditable(false);
						resultado.setBounds(130, 189, 232, 17);
					}
					{
						Lresultado = new JLabel();
						elementos.add(Lresultado);
						Lresultado.setText("Resultado");
						Lresultado.setBounds(23, 189, 82, 16);
					}
					{
						Lhead = new JLabel();
						elementos.add(Lhead);
						Lhead.setText("STRING CALCULATOR");
						Lhead.setBounds(118, 18, 160, 16);
					}
				}
			}
			pack();
			this.setSize(400, 289);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}	
}
