package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import clases.candidatos;
import clases.votantes;
import conexion.conexion;
import consultas.consultas_candidatos;
import consultas.consultas_votantes;

public class ventana_votacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JLabel lblFoto1;
	private JLabel lblFoto2;
	private JLabel lblFoto3;
	private JLabel lblFoto4;
	private JLabel lblFoto5;
	private JLabel lblFoto6;
	private JLabel lblFoto7;
	private JButton btnVotar;

	public JLabel lblNombre;
	public JLabel lblDni;
	public JLabel lblGrado;
	public JLabel lblModalidad;
	private JLabel lblPorFavorPresione;
	private JLabel lblDni_1;
	private JLabel lblDni_2;
	public ButtonGroup rdbGrupo;
	public JRadioButton rdb1;
	public JRadioButton rdb2;
	public JRadioButton rdb3;
	public JRadioButton rdb4;
	public JRadioButton rdb5;
	public JRadioButton rdb6;
	public JRadioButton rdb7;
	public JLabel lblNombre_1;
	private JLabel lblNombre_1_1;
	public JLabel lblNombre_2;
	public JLabel lblNombre_3;
	public JLabel lblNombre_4;
	public JLabel lblNombre_5;
	public JLabel lblNombre_6;
	public JLabel lblNombre_7;

	public String nombre1;
	public String nombre2;
	public String nombre3;
	public String nombre4;
	public String nombre5;
	public String nombre6;
	public String nombre7;
	public String fotoc1;
	public String fotoc2;
	public String fotoc3;
	public String fotoc4;
	public String fotoc5;
	public String fotoc6;
	public String fotoc7;

	public int candidatoSeleccionado;
	public int votosConsultados;
	public int votoAgregado;

	public JLabel lblMarca1;
	public JLabel lblMarca2;
	public JLabel lblMarca3;
	public JLabel lblMarca4;
	public JLabel lblMarca5;
	public JLabel lblMarca6;
	public JLabel lblMarca7;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;

	public ventana_votacion() {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(ventana_votacion.class.getResource("/recursos/logo_ipm.png")));
		final ImageIcon foto1 = new ImageIcon(getClass().getResource("/recursos/foto1.png"));
		final ImageIcon foto2 = new ImageIcon(getClass().getResource("/recursos/foto2.png"));
		final ImageIcon foto3 = new ImageIcon(getClass().getResource("/recursos/foto3.png"));
		final ImageIcon foto4 = new ImageIcon(getClass().getResource("/recursos/foto4.png"));
		final ImageIcon foto5 = new ImageIcon(getClass().getResource("/recursos/foto5.png"));
		final ImageIcon foto6 = new ImageIcon(getClass().getResource("/recursos/foto6.png"));
		final ImageIcon foto7 = new ImageIcon(getClass().getResource("/recursos/foto7.png"));
		final ImageIcon fotoMarca = new ImageIcon(getClass().getResource("/recursos/marca.png"));
		final ImageIcon logoIPM = new ImageIcon(getClass().getResource("/recursos/logo_ipm.png"));

		setTitle("Sistema de votación - IPM 2024.");
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 1186, 601);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(34, 139, 34));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent evt) {
				close();
			}
		});

		JPanel panel = new JPanel();
		panel.setBackground(new Color(34, 139, 34));
		panel.setBorder(new LineBorder(Color.WHITE, 2));
		panel.setBounds(10, 11, 1150, 540);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(143, 86, 764, 139);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new LineBorder(Color.WHITE, 2));
		panel.add(panel_1);
		panel_1.setLayout(null);

		lblPorFavorPresione = new JLabel(
				"Por favor seleccione dando click en su candidato favorito y presione el botón VOTAR.");
		lblPorFavorPresione.setBounds(135, 110, 630, 16);
		panel_1.add(lblPorFavorPresione);
		lblPorFavorPresione.setForeground(Color.RED);
		lblPorFavorPresione.setFont(new Font("Arial", Font.BOLD, 15));

		lblDni_1 = new JLabel("DNI");
		lblDni_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblDni_1.setBounds(20, 80, 74, 18);
		panel_1.add(lblDni_1);
		lblDni_1.setForeground(Color.BLACK);
		lblDni_1.setFont(new Font("Arial Black", Font.PLAIN, 15));

		lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre_1.setBounds(20, 56, 74, 17);
		panel_1.add(lblNombre_1);
		lblNombre_1.setForeground(Color.BLACK);
		lblNombre_1.setFont(new Font("Arial Black", Font.PLAIN, 15));

		lblNombre = new JLabel("");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setBounds(135, 56, 287, 18);
		panel_1.add(lblNombre);
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 15));

		lblDni = new JLabel("");
		lblDni.setHorizontalAlignment(SwingConstants.LEFT);
		lblDni.setBounds(135, 81, 287, 18);
		panel_1.add(lblDni);
		lblDni.setForeground(Color.BLACK);
		lblDni.setFont(new Font("Arial", Font.PLAIN, 15));

		JLabel lblDni_2_1 = new JLabel("Instrucciones:");
		lblDni_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblDni_2_1.setForeground(Color.BLACK);
		lblDni_2_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblDni_2_1.setBounds(20, 108, 132, 18);
		panel_1.add(lblDni_2_1);

		JLabel lblNombre_1_2 = new JLabel("Grado");
		lblNombre_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre_1_2.setForeground(Color.BLACK);
		lblNombre_1_2.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNombre_1_2.setBounds(438, 55, 74, 18);
		panel_1.add(lblNombre_1_2);

		JLabel lblDni_1_1 = new JLabel("Modalidad");
		lblDni_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblDni_1_1.setForeground(Color.BLACK);
		lblDni_1_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblDni_1_1.setBounds(438, 81, 90, 18);
		panel_1.add(lblDni_1_1);

		lblGrado = new JLabel("");
		lblGrado.setHorizontalAlignment(SwingConstants.LEFT);
		lblGrado.setForeground(Color.BLACK);
		lblGrado.setFont(new Font("Arial", Font.PLAIN, 15));
		lblGrado.setBounds(564, 54, 190, 18);
		panel_1.add(lblGrado);

		lblModalidad = new JLabel("");
		lblModalidad.setHorizontalAlignment(SwingConstants.LEFT);
		lblModalidad.setForeground(Color.BLACK);
		lblModalidad.setFont(new Font("Arial", Font.PLAIN, 15));
		lblModalidad.setBounds(564, 81, 190, 18);
		panel_1.add(lblModalidad);

		lblDni_2 = new JLabel("Información del votante:");
		lblDni_2.setBounds(20, 12, 396, 33);
		panel_1.add(lblDni_2);
		lblDni_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblDni_2.setForeground(Color.BLACK);
		lblDni_2.setFont(new Font("Arial Black", Font.BOLD, 20));

		rdbGrupo = new ButtonGroup();

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(34, 139, 34));
		panel_2.setBorder(new LineBorder(Color.WHITE, 2));
		panel_2.setBounds(917, 86, 223, 139);
		panel.add(panel_2);
		panel_2.setLayout(null);

		btnVotar = new JButton("VOTAR");
		btnVotar.setBounds(10, 11, 203, 117);
		panel_2.add(btnVotar);
		btnVotar.setForeground(Color.WHITE);
		btnVotar.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnVotar.setBackground(Color.RED);

		panel_3 = new JPanel();
		panel_3.setBackground(new Color(34, 139, 34));
		panel_3.setBorder(new LineBorder(Color.WHITE, 2));
		panel_3.setBounds(10, 236, 1130, 293);
		panel.add(panel_3);
		panel_3.setLayout(null);

		lblFoto1 = new JLabel("");
		lblFoto1.setBounds(10, 32, 150, 170);
		panel_3.add(lblFoto1);
		lblFoto1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdb1.setSelected(true);
				lblMarca1.setEnabled(true);
				lblMarca2.setEnabled(false);
				lblMarca3.setEnabled(false);
				lblMarca4.setEnabled(false);
				lblMarca5.setEnabled(false);
				lblMarca6.setEnabled(false);
				lblMarca7.setEnabled(false);
			}
		});
		final ImageIcon icono1 = new ImageIcon(
				foto1.getImage().getScaledInstance(lblFoto1.getWidth(), lblFoto1.getHeight(), Image.SCALE_DEFAULT));
		lblFoto1.setIcon(icono1);

		lblMarca1 = new JLabel("");
		lblMarca1.setBounds(10, 179, 150, 125);
		panel_3.add(lblMarca1);
		lblMarca1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdb1.setSelected(true);
				lblMarca1.setEnabled(true);
				lblMarca2.setEnabled(false);
				lblMarca3.setEnabled(false);
				lblMarca4.setEnabled(false);
				lblMarca5.setEnabled(false);
				lblMarca6.setEnabled(false);
				lblMarca7.setEnabled(false);
			}
		});
		lblMarca1.setEnabled(false);
		final ImageIcon icono8 = new ImageIcon(fotoMarca.getImage().getScaledInstance(lblMarca1.getWidth(),
				lblMarca1.getHeight(), Image.SCALE_DEFAULT));
		lblMarca1.setIcon(icono8);

		rdb1 = new JRadioButton("Seleccionar");
		rdb1.setBounds(10, 182, 144, 23);
		panel_3.add(rdb1);
		rdb1.setFont(new Font("Arial", Font.BOLD, 15));
		rdb1.setHorizontalAlignment(SwingConstants.CENTER);
		rdb1.setVisible(false);
		rdbGrupo.add(rdb1);

		lblNombre_2 = new JLabel("Nombre 2");
		lblNombre_2.setForeground(Color.WHITE);
		lblNombre_2.setBounds(170, 11, 150, 23);
		panel_3.add(lblNombre_2);
		lblNombre_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre_2.setFont(new Font("Arial", Font.BOLD, 15));

		lblFoto2 = new JLabel("");
		lblFoto2.setBounds(170, 32, 150, 170);
		panel_3.add(lblFoto2);
		lblFoto2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdb2.setSelected(true);
				lblMarca1.setEnabled(false);
				lblMarca2.setEnabled(true);
				lblMarca3.setEnabled(false);
				lblMarca4.setEnabled(false);
				lblMarca5.setEnabled(false);
				lblMarca6.setEnabled(false);
				lblMarca7.setEnabled(false);
			}
		});
		final ImageIcon icono2 = new ImageIcon(
				foto2.getImage().getScaledInstance(lblFoto2.getWidth(), lblFoto2.getHeight(), Image.SCALE_DEFAULT));
		lblFoto2.setIcon(icono2);

		lblMarca2 = new JLabel("");
		lblMarca2.setBounds(170, 179, 150, 125);
		panel_3.add(lblMarca2);
		lblMarca2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdb2.setSelected(true);
				lblMarca1.setEnabled(false);
				lblMarca2.setEnabled(true);
				lblMarca3.setEnabled(false);
				lblMarca4.setEnabled(false);
				lblMarca5.setEnabled(false);
				lblMarca6.setEnabled(false);
				lblMarca7.setEnabled(false);
			}
		});
		lblMarca2.setEnabled(false);
		final ImageIcon icono9 = new ImageIcon(fotoMarca.getImage().getScaledInstance(lblMarca2.getWidth(),
				lblMarca2.getHeight(), Image.SCALE_DEFAULT));
		lblMarca2.setIcon(icono9);

		rdb2 = new JRadioButton("Seleccionar");
		rdb2.setBounds(179, 182, 144, 23);
		panel_3.add(rdb2);
		rdb2.setFont(new Font("Arial", Font.BOLD, 15));
		rdb2.setHorizontalAlignment(SwingConstants.CENTER);
		rdb2.setVisible(false);
		rdbGrupo.add(rdb2);

		lblNombre_1_1 = new JLabel("Nombre 1");
		lblNombre_1_1.setForeground(Color.WHITE);
		lblNombre_1_1.setBounds(10, 11, 150, 23);
		panel_3.add(lblNombre_1_1);
		lblNombre_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNombre_1_1.setHorizontalAlignment(SwingConstants.CENTER);

		lblNombre_3 = new JLabel("Nombre 3");
		lblNombre_3.setForeground(Color.WHITE);
		lblNombre_3.setBounds(330, 11, 150, 23);
		panel_3.add(lblNombre_3);
		lblNombre_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre_3.setFont(new Font("Arial", Font.BOLD, 15));

		lblFoto3 = new JLabel("");
		lblFoto3.setBounds(330, 32, 150, 170);
		panel_3.add(lblFoto3);
		lblFoto3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdb3.setSelected(true);
				lblMarca1.setEnabled(false);
				lblMarca2.setEnabled(false);
				lblMarca3.setEnabled(true);
				lblMarca4.setEnabled(false);
				lblMarca5.setEnabled(false);
				lblMarca6.setEnabled(false);
				lblMarca7.setEnabled(false);
			}
		});
		final ImageIcon icono3 = new ImageIcon(
				foto3.getImage().getScaledInstance(lblFoto3.getWidth(), lblFoto3.getHeight(), Image.SCALE_DEFAULT));
		lblFoto3.setIcon(icono3);

		lblMarca3 = new JLabel("");
		lblMarca3.setBounds(330, 179, 150, 125);
		panel_3.add(lblMarca3);
		lblMarca3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdb3.setSelected(true);
				lblMarca1.setEnabled(false);
				lblMarca2.setEnabled(false);
				lblMarca3.setEnabled(true);
				lblMarca4.setEnabled(false);
				lblMarca5.setEnabled(false);
				lblMarca6.setEnabled(false);
				lblMarca7.setEnabled(false);
			}
		});
		lblMarca3.setEnabled(false);
		final ImageIcon icono10 = new ImageIcon(fotoMarca.getImage().getScaledInstance(lblMarca3.getWidth(),
				lblMarca3.getHeight(), Image.SCALE_DEFAULT));
		lblMarca3.setIcon(icono10);

		rdb3 = new JRadioButton("Seleccionar");
		rdb3.setBounds(341, 182, 144, 23);
		panel_3.add(rdb3);
		rdb3.setFont(new Font("Arial", Font.BOLD, 15));
		rdb3.setHorizontalAlignment(SwingConstants.CENTER);
		rdb3.setVisible(false);
		rdbGrupo.add(rdb3);

		lblNombre_4 = new JLabel("Nombre 4");
		lblNombre_4.setForeground(Color.WHITE);
		lblNombre_4.setBounds(490, 11, 150, 23);
		panel_3.add(lblNombre_4);
		lblNombre_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre_4.setFont(new Font("Arial", Font.BOLD, 15));

		lblFoto4 = new JLabel("");
		lblFoto4.setBounds(490, 32, 150, 170);
		panel_3.add(lblFoto4);
		lblFoto4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdb4.setSelected(true);
				lblMarca1.setEnabled(false);
				lblMarca2.setEnabled(false);
				lblMarca3.setEnabled(false);
				lblMarca4.setEnabled(true);
				lblMarca5.setEnabled(false);
				lblMarca6.setEnabled(false);
				lblMarca7.setEnabled(false);
			}
		});
		final ImageIcon icono4 = new ImageIcon(
				foto4.getImage().getScaledInstance(lblFoto4.getWidth(), lblFoto4.getHeight(), Image.SCALE_DEFAULT));
		lblFoto4.setIcon(icono4);

		lblMarca4 = new JLabel("");
		lblMarca4.setBounds(490, 179, 150, 125);
		panel_3.add(lblMarca4);
		lblMarca4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdb4.setSelected(true);
				lblMarca1.setEnabled(false);
				lblMarca2.setEnabled(false);
				lblMarca3.setEnabled(false);
				lblMarca4.setEnabled(true);
				lblMarca5.setEnabled(false);
				lblMarca6.setEnabled(false);
				lblMarca7.setEnabled(false);
			}
		});
		lblMarca4.setEnabled(false);
		final ImageIcon icono11 = new ImageIcon(fotoMarca.getImage().getScaledInstance(lblMarca4.getWidth(),
				lblMarca4.getHeight(), Image.SCALE_DEFAULT));
		lblMarca4.setIcon(icono11);

		rdb4 = new JRadioButton("Seleccionar");
		rdb4.setBounds(495, 182, 144, 23);
		panel_3.add(rdb4);
		rdb4.setFont(new Font("Arial", Font.BOLD, 15));
		rdb4.setHorizontalAlignment(SwingConstants.CENTER);
		rdb4.setVisible(false);
		rdbGrupo.add(rdb4);

		lblNombre_5 = new JLabel("Nombre 5");
		lblNombre_5.setForeground(Color.WHITE);
		lblNombre_5.setBounds(649, 11, 150, 23);
		panel_3.add(lblNombre_5);
		lblNombre_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre_5.setFont(new Font("Arial", Font.BOLD, 15));

		lblFoto5 = new JLabel("");
		lblFoto5.setBounds(650, 32, 150, 170);
		panel_3.add(lblFoto5);
		lblFoto5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdb5.setSelected(true);
				lblMarca1.setEnabled(false);
				lblMarca2.setEnabled(false);
				lblMarca3.setEnabled(false);
				lblMarca4.setEnabled(false);
				lblMarca5.setEnabled(true);
				lblMarca6.setEnabled(false);
				lblMarca7.setEnabled(false);
			}
		});
		final ImageIcon icono5 = new ImageIcon(
				foto5.getImage().getScaledInstance(lblFoto5.getWidth(), lblFoto5.getHeight(), Image.SCALE_DEFAULT));
		lblFoto5.setIcon(icono5);

		lblMarca5 = new JLabel("");
		lblMarca5.setBounds(650, 179, 150, 125);
		panel_3.add(lblMarca5);
		lblMarca5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdb5.setSelected(true);
				lblMarca1.setEnabled(false);
				lblMarca2.setEnabled(false);
				lblMarca3.setEnabled(false);
				lblMarca4.setEnabled(false);
				lblMarca5.setEnabled(true);
				lblMarca6.setEnabled(false);
				lblMarca7.setEnabled(false);
			}
		});
		lblMarca5.setEnabled(false);
		final ImageIcon icono12 = new ImageIcon(fotoMarca.getImage().getScaledInstance(lblMarca5.getWidth(),
				lblMarca5.getHeight(), Image.SCALE_DEFAULT));
		lblMarca5.setIcon(icono12);

		rdb5 = new JRadioButton("Seleccionar");
		rdb5.setBounds(649, 182, 144, 23);
		panel_3.add(rdb5);
		rdb5.setFont(new Font("Arial", Font.BOLD, 15));
		rdb5.setHorizontalAlignment(SwingConstants.CENTER);
		rdb5.setVisible(false);
		rdbGrupo.add(rdb5);

		lblNombre_6 = new JLabel("Nombre 6");
		lblNombre_6.setForeground(Color.WHITE);
		lblNombre_6.setBounds(809, 11, 150, 23);
		panel_3.add(lblNombre_6);
		lblNombre_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre_6.setFont(new Font("Arial", Font.BOLD, 15));

		lblFoto6 = new JLabel("");
		lblFoto6.setBounds(810, 32, 150, 170);
		panel_3.add(lblFoto6);
		lblFoto6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdb6.setSelected(true);
				lblMarca1.setEnabled(false);
				lblMarca2.setEnabled(false);
				lblMarca3.setEnabled(false);
				lblMarca4.setEnabled(false);
				lblMarca5.setEnabled(false);
				lblMarca6.setEnabled(true);
				lblMarca7.setEnabled(false);
			}
		});
		final ImageIcon icono6 = new ImageIcon(
				foto6.getImage().getScaledInstance(lblFoto6.getWidth(), lblFoto6.getHeight(), Image.SCALE_DEFAULT));
		lblFoto6.setIcon(icono6);

		lblMarca6 = new JLabel("");
		lblMarca6.setBounds(810, 179, 150, 125);
		panel_3.add(lblMarca6);
		lblMarca6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdb6.setSelected(true);
				lblMarca1.setEnabled(false);
				lblMarca2.setEnabled(false);
				lblMarca3.setEnabled(false);
				lblMarca4.setEnabled(false);
				lblMarca5.setEnabled(false);
				lblMarca6.setEnabled(true);
				lblMarca7.setEnabled(false);
			}
		});
		lblMarca6.setEnabled(false);
		final ImageIcon icono13 = new ImageIcon(fotoMarca.getImage().getScaledInstance(lblMarca6.getWidth(),
				lblMarca6.getHeight(), Image.SCALE_DEFAULT));
		lblMarca6.setIcon(icono13);

		rdb6 = new JRadioButton("Seleccionar");
		rdb6.setBounds(803, 182, 144, 23);
		panel_3.add(rdb6);
		rdb6.setFont(new Font("Arial", Font.BOLD, 15));
		rdb6.setHorizontalAlignment(SwingConstants.CENTER);
		rdb6.setVisible(false);
		rdbGrupo.add(rdb6);

		lblNombre_7 = new JLabel("Nombre 7");
		lblNombre_7.setForeground(Color.WHITE);
		lblNombre_7.setBounds(969, 11, 150, 23);
		panel_3.add(lblNombre_7);
		lblNombre_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre_7.setFont(new Font("Arial", Font.BOLD, 15));

		lblFoto7 = new JLabel("");
		lblFoto7.setBounds(969, 32, 150, 170);
		panel_3.add(lblFoto7);
		lblFoto7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdb7.setSelected(true);
				lblMarca1.setEnabled(false);
				lblMarca2.setEnabled(false);
				lblMarca3.setEnabled(false);
				lblMarca4.setEnabled(false);
				lblMarca5.setEnabled(false);
				lblMarca6.setEnabled(false);
				lblMarca7.setEnabled(true);
			}
		});
		final ImageIcon icono7 = new ImageIcon(
				foto7.getImage().getScaledInstance(lblFoto7.getWidth(), lblFoto7.getHeight(), Image.SCALE_DEFAULT));
		lblFoto7.setIcon(icono7);

		lblMarca7 = new JLabel("");
		lblMarca7.setBounds(969, 179, 150, 125);
		panel_3.add(lblMarca7);
		lblMarca7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdb7.setSelected(true);
				lblMarca1.setEnabled(false);
				lblMarca2.setEnabled(false);
				lblMarca3.setEnabled(false);
				lblMarca4.setEnabled(false);
				lblMarca5.setEnabled(false);
				lblMarca6.setEnabled(false);
				lblMarca7.setEnabled(true);
			}
		});
		lblMarca7.setEnabled(false);
		final ImageIcon icono14 = new ImageIcon(fotoMarca.getImage().getScaledInstance(lblMarca7.getWidth(),
				lblMarca7.getHeight(), Image.SCALE_DEFAULT));
		lblMarca7.setIcon(icono14);

		rdb7 = new JRadioButton("Seleccionar");
		rdb7.setBounds(957, 182, 144, 23);
		panel_3.add(rdb7);
		rdb7.setFont(new Font("Arial", Font.BOLD, 15));
		rdb7.setHorizontalAlignment(SwingConstants.CENTER);
		rdb7.setVisible(false);
		rdbGrupo.add(rdb7);

		panel_5 = new JPanel();
		panel_5.setBackground(new Color(34, 139, 34));
		panel_5.setBorder(new LineBorder(Color.WHITE, 2));
		panel_5.setBounds(10, 86, 123, 139);
		panel.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(0, 0, 123, 139);
		panel_5.add(lblLogo);
		final ImageIcon icono100 = new ImageIcon(
				logoIPM.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_DEFAULT));
		lblLogo.setIcon(icono100);

		panel_4 = new JPanel();
		panel_4.setBackground(new Color(34, 139, 34));
		panel_4.setBorder(new LineBorder(Color.WHITE, 2));
		panel_4.setBounds(10, 11, 1130, 64);
		panel.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblTitulo = new JLabel("GOBIERNO ESTUDIANTIL 2024");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBounds(10, 11, 1110, 42);
		panel_4.add(lblTitulo);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 30));
		final ImageIcon logo1 = new ImageIcon(getClass().getResource("/recursos/logo_ipm.png"));

		btnVotar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdb1.isSelected() || rdb2.isSelected() || rdb3.isSelected() || rdb4.isSelected()
						|| rdb5.isSelected() || rdb6.isSelected() || rdb7.isSelected()) {
					consultarCandidatoSeleccionado();
					candidatos clase = new candidatos();
					consultas_candidatos consulta = new consultas_candidatos();
					votantes clase2 = new votantes();
					consultas_votantes consulta2 = new consultas_votantes();
					consultarVotos();
					votosConsultados = votosConsultados + 1;
					clase.setVotos_candidato(votosConsultados);
					clase.setId_candidato(candidatoSeleccionado);
					clase2.setEstado_votante(1);
					clase2.setDni_votante(lblDni.getText().toString());
					if (consulta.agregarVotos(clase) && consulta2.actualizarEstado(clase2)) {

						JOptionPane.showMessageDialog(null, "Felicidades, su voto esta hecho!");
						ventana_login login = new ventana_login();
						login.setLocationRelativeTo(null);
						login.setVisible(true);
						Timer time = new Timer();
						time.schedule(login.tarea, 0, 1000);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Ha ocurrido un error!");
						ventana_login login = new ventana_login();
						login.setLocationRelativeTo(null);
						login.setVisible(true);
						Timer time = new Timer();
						time.schedule(login.tarea, 0, 1000);
						dispose();
					}

				} else {

					JOptionPane.showMessageDialog(null, "No ha seleccionado un candidato.");
				}

			}
		});

	}

	public void consultarCandidato1() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.conectar().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM candidatos WHERE id_candidato = 1");
			if (rs.next()) {
				nombre1 = (rs.getString("nombre_candidato"));
				fotoc1 = (rs.getString("foto_candidato"));
			}
			rs.close();
			estatuto.close();
			conex.desconectar();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void consultarCandidato2() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.conectar().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM candidatos WHERE id_candidato = 2");
			if (rs.next()) {
				nombre2 = (rs.getString("nombre_candidato"));
				fotoc2 = (rs.getString("foto_candidato"));
			}
			rs.close();
			estatuto.close();
			conex.desconectar();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void consultarCandidato3() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.conectar().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM candidatos WHERE id_candidato = 3");
			if (rs.next()) {
				nombre3 = (rs.getString("nombre_candidato"));
				fotoc3 = (rs.getString("foto_candidato"));
			}
			rs.close();
			estatuto.close();
			conex.desconectar();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void consultarCandidato4() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.conectar().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM candidatos WHERE id_candidato = 4");
			if (rs.next()) {
				nombre4 = (rs.getString("nombre_candidato"));
				fotoc4 = (rs.getString("foto_candidato"));
			}
			rs.close();
			estatuto.close();
			conex.desconectar();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void consultarCandidato5() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.conectar().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM candidatos WHERE id_candidato = 5");
			if (rs.next()) {
				nombre5 = (rs.getString("nombre_candidato"));
				fotoc5 = (rs.getString("foto_candidato"));
			}
			rs.close();
			estatuto.close();
			conex.desconectar();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void consultarCandidato6() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.conectar().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM candidatos WHERE id_candidato = 6");
			if (rs.next()) {
				nombre6 = (rs.getString("nombre_candidato"));
				fotoc6 = (rs.getString("foto_candidato"));
			}
			rs.close();
			estatuto.close();
			conex.desconectar();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void consultarCandidato7() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.conectar().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM candidatos WHERE id_candidato = 7");
			if (rs.next()) {
				nombre7 = (rs.getString("nombre_candidato"));
				fotoc7 = (rs.getString("foto_candidato"));
			}
			rs.close();
			estatuto.close();
			conex.desconectar();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void establecerCandidatos() {
		lblNombre_1_1.setText(nombre1);
		lblNombre_2.setText(nombre2);
		lblNombre_3.setText(nombre3);
		lblNombre_4.setText(nombre4);
		lblNombre_5.setText(nombre5);
		lblNombre_6.setText(nombre6);
		lblNombre_7.setText(nombre7);
		Image foto1 = getToolkit().getImage(fotoc1);
		foto1 = foto1.getScaledInstance(lblFoto1.getHeight(), lblFoto1.getWidth(), Image.SCALE_DEFAULT);
		lblFoto1.setIcon(new ImageIcon(foto1));
		Image foto2 = getToolkit().getImage(fotoc2);
		foto2 = foto2.getScaledInstance(lblFoto2.getHeight(), lblFoto2.getWidth(), Image.SCALE_DEFAULT);
		lblFoto2.setIcon(new ImageIcon(foto2));
		Image foto3 = getToolkit().getImage(fotoc3);
		foto3 = foto3.getScaledInstance(lblFoto3.getHeight(), lblFoto3.getWidth(), Image.SCALE_DEFAULT);
		lblFoto3.setIcon(new ImageIcon(foto3));
		Image foto4 = getToolkit().getImage(fotoc4);
		foto4 = foto4.getScaledInstance(lblFoto4.getHeight(), lblFoto4.getWidth(), Image.SCALE_DEFAULT);
		lblFoto4.setIcon(new ImageIcon(foto4));
		Image foto5 = getToolkit().getImage(fotoc5);
		foto5 = foto5.getScaledInstance(lblFoto5.getHeight(), lblFoto5.getWidth(), Image.SCALE_DEFAULT);
		lblFoto5.setIcon(new ImageIcon(foto5));
		Image foto6 = getToolkit().getImage(fotoc6);
		foto6 = foto6.getScaledInstance(lblFoto6.getHeight(), lblFoto6.getWidth(), Image.SCALE_DEFAULT);
		lblFoto6.setIcon(new ImageIcon(foto6));
		Image foto7 = getToolkit().getImage(fotoc7);
		foto7 = foto7.getScaledInstance(lblFoto7.getHeight(), lblFoto7.getWidth(), Image.SCALE_DEFAULT);
		lblFoto7.setIcon(new ImageIcon(foto7));

	}

	public void consultarVotos() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.conectar().createStatement();
			ResultSet rs = estatuto
					.executeQuery("SELECT * FROM candidatos WHERE id_candidato =" + candidatoSeleccionado + "");
			if (rs.next()) {
				votosConsultados = (rs.getInt("votos_candidato"));
			}
			rs.close();
			estatuto.close();
			conex.desconectar();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void consultarCandidatoSeleccionado() {
		if (rdb1.isSelected()) {
			candidatoSeleccionado = 1;
		} else {
			if (rdb2.isSelected()) {
				candidatoSeleccionado = 2;
			} else {
				if (rdb3.isSelected()) {
					candidatoSeleccionado = 3;
				} else {
					if (rdb4.isSelected()) {
						candidatoSeleccionado = 4;
					} else {
						if (rdb5.isSelected()) {
							candidatoSeleccionado = 5;
						} else {
							if (rdb6.isSelected()) {
								candidatoSeleccionado = 6;
							} else {
								if (rdb7.isSelected()) {
									candidatoSeleccionado = 7;
								}

							}
						}
					}
				}
			}
		}
	}

	private void close() {
		if (JOptionPane.showConfirmDialog(rootPane, "¿Desea salir del sistema?", "Salir del sistema",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
