package sistema;

import java.util.Timer;

import javax.swing.JFrame;

import ventanas.ventana_login;

public class iniciar_sistema extends JFrame {

	public static void main(String[] args) {
		ventana_login login = new ventana_login();
		login.setLocationRelativeTo(null);
		login.setVisible(true);
		Timer time = new Timer();
		time.schedule(login.tarea, 0, 1000);

	}

}
