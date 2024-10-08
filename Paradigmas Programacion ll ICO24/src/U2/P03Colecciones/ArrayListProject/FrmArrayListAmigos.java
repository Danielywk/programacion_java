package U2.P03Colecciones.ArrayListProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Iterator;

public class FrmArrayListAmigos extends JFrame {
    // Se declaran las variables que ocupará el formulario
    DefaultListModel modelo = new DefaultListModel();
    ArrayList <String> listaAmigos = new ArrayList<>();

    // Se declara el constructor del formulario
    public FrmArrayListAmigos() {
        initComponents();
        listaAmigos.add("Alberto");
        listaAmigos.add("María");
        listaAmigos.add("Antonio");
        listaAmigos.add("Juan");
        listaAmigos.add("Rosario");
        llenarJListAmigos();
    }

    // Se declaran los métodos que ocupará el formulario por parte del usuario
    public void llenarJListAmigos() {
        modelo.removeAllElements();
        for (int i = 0; i < listaAmigos.size(); i++) {
            modelo.addElement(listaAmigos.get(i));
        }
    }

    // Se declara un método para inicializar los componentes del formulario
    private void initComponents() {
        lblTitulo = new JLabel();
        // Características de la ventana
        getContentPane().setBackground(Color.black);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        // Establecer un layout de 2 renglones y una columna
        setLayout(new GridLayout(2, 1, 20, 20));
        // Características del titulo
        lblTitulo.setFont(new Font("Dialog", 0, 48));
        lblTitulo.setText("AMIGOS");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setPreferredSize(new Dimension(300, 60));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblTitulo);

        JListAmigos = new JList<>();
        JListAmigos.setPreferredSize(new Dimension(60, 30));
        JListAmigos.setVisibleRowCount(5); // muestra cinco filas a la vez
        JListAmigos.setModel(modelo);

        panelParteInferior = new JPanel();
        panelParteInferior.setBackground(Color.black);
        panelParteInferior.setLayout(new GridLayout(1, 2, 20, 20));
        add(panelParteInferior);
        panelParteInferior.add(add(new JScrollPane(JListAmigos)));

        // Panel donde se colocaran los botones
        panelBotones = new JPanel();
        panelBotones.setBackground(Color.black);
        panelBotones.setLayout(new GridLayout(4, 1, 10, 10));
        panelParteInferior.add(panelBotones);

        // Se establecen los botones y se agregan al panel
        btnAgregar = new JButton("Agregar");
        btnBuscar = new JButton("Buscar");
        btnBorrar = new JButton("Borrar");
        btnSalir = new JButton("Salir");

        //eventos
        btnAgregar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        btnAgregarActionPerformed(event);
                    }
                }
        ); // fin btnAgregar.addActionListener
        btnBuscar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        btnBuscarActionPerformed(event);
                    }
                }
        ); // fin btnBuscar.addActionListener
        btnBorrar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        btnBorrarActionPerformed(event);
                    }
                }
        ); // fin btnBorrar.addActionListener
        btnSalir.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        btnSalirActionPerformed(event);
                    }
                }
        ); // fin btnSalir.addActionListener

        panelBotones.add(btnAgregar);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnBorrar);
        panelBotones.add(btnSalir);
    }

    // Listado de eventos
    public void btnAgregarActionPerformed(ActionEvent event) {
        String nombreAmigo = JOptionPane.showInputDialog("Escribe un nombre: ");
        if (nombreAmigo.equals("") || nombreAmigo == null){
            return;
        }
        listaAmigos.add(nombreAmigo);
        llenarJListAmigos();
    }

    public void btnBuscarActionPerformed(ActionEvent event) {
        String nombreAmigo = JOptionPane.showInputDialog("Escribe un nombre a buscar: ");
        if (nombreAmigo.equals("") || nombreAmigo == null){
            return;
        }
        if (listaAmigos.contains(nombreAmigo)){
            JOptionPane.showMessageDialog(this, "El amigo si se encuentra.");
        }else {
            JOptionPane.showMessageDialog(this, "El amigo no se encuentra.");
        }

    }

    public void btnBorrarActionPerformed(ActionEvent event) {
        String nombreAmigo = JOptionPane.showInputDialog("Escribe un nombre: ");
        if (nombreAmigo.equals("") || nombreAmigo == null){
            return;
        }
        Iterator<String> iterador = listaAmigos.iterator();
        while (iterador.hasNext()){
          if(nombreAmigo.equals(iterador.next())){
              iterador.remove();
              JOptionPane.showMessageDialog(this, "El amigo se ha eliminado.");
          }
        }
llenarJListAmigos();
    }

    public void btnSalirActionPerformed(ActionEvent event) {
        System.exit(0);

    }

    // Se declara el método main para ejecutar el formulario
    public static void main(String[] args) {
        new FrmArrayListAmigos().setVisible(true);
    }

    // Se declaran los controles que llevará el formulario
    private JList<String> JListAmigos;
    private JLabel lblTitulo;
    private JButton btnAgregar;
    private JButton btnBuscar;
    private JButton btnBorrar;
    private JButton btnSalir;
    JPanel panelBotones;
    JPanel panelParteInferior;
}