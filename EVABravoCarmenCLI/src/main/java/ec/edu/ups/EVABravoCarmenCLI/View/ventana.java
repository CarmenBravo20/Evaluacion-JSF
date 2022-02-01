package ec.edu.ups.EVABravoCarmenCLI.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ec.edu.ups.EVABravoCarmenSRV.Business.LibroRemote;
import ec.edu.ups.EVABravoCarmenSRV.Model.Libro;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.awt.event.ActionEvent;

public class ventana extends JFrame {
	private LibroRemote lo;
	Libro libro=new Libro();

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtxtitulo;
	private JTextField txtedicion;
	private JTextField txtautor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana frame = new ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ventana() throws Exception {
		try {  
            final Hashtable<String, Comparable> jndiProperties =  
                    new Hashtable<String, Comparable>();  
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");  
            jndiProperties.put("jboss.naming.client.ejb.context", true);  
              
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");  
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "practica");  
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "practica");   
              
            final Context context = new InitialContext(jndiProperties);  
               
            
            final String lookupName1 = "ejb:/EVABravoCarmenSRV/LibroON!ec.edu.ups.EVABravoCarmenSRV.Business.LibroRemote";  
              
            this.lo = (LibroRemote) context.lookup(lookupName1); 
		   } catch (Exception ex) {  
			   ex.printStackTrace();  
	            throw ex;

		   }
	

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(21, 31, 46, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo");
		lblNewLabel_1.setBounds(21, 71, 46, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Edici\u00F3n");
		lblNewLabel_2.setBounds(21, 107, 46, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Autor");
		lblNewLabel_3.setBounds(21, 155, 46, 13);
		contentPane.add(lblNewLabel_3);
		
		txtid = new JTextField();
		txtid.setBounds(77, 28, 96, 19);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		txtxtitulo = new JTextField();
		txtxtitulo.setBounds(77, 68, 96, 19);
		contentPane.add(txtxtitulo);
		txtxtitulo.setColumns(10);
		
		txtedicion = new JTextField();
		txtedicion.setBounds(77, 104, 96, 19);
		contentPane.add(txtedicion);
		txtedicion.setColumns(10);
		
		txtautor = new JTextField();
		txtautor.setBounds(77, 152, 96, 19);
		contentPane.add(txtautor);
		txtautor.setColumns(10);
		
		JButton btncrear = new JButton("Crear");
		btncrear.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				int cod=Integer.parseInt(txtid.getText());
				libro.setAutor(txtautor.getText());
				libro.setCodigo(cod);
				libro.setEdicion(txtedicion.getText());
				libro.setTitulo(txtxtitulo.getText());
				
				try {
					lo.insertar(libro);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btncrear.setBounds(77, 202, 85, 19);
		contentPane.add(btncrear);
	}
}
