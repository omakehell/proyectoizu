import java.sql.*;
import java.util.Scanner;

class MysqlCon {
	static int tries = 0;
	public static void main(String args[]) {
		
		conectar();
	}

	static void conectar() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/proyectoizu", "proyectoizu",
					"proyectoizu");
			Statement stmt = con.createStatement();
			Scanner teclado = new Scanner(System.in);
			System.out.println("usuario=>");
			String usuario = teclado.nextLine();
			System.out.println("contraseña=>");
			String password = teclado.nextLine();
			ResultSet rs = stmt.executeQuery(
					"select * from USERS where PASSWORD = '" + password + "' AND NAME = '" + usuario + "'");
			if (rs.next()) {
				System.out.println("conectado! Mostrando las clases!");
				rs = stmt.executeQuery(
						"select * from CLASSES");
				while (rs.next())
					System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " +
					rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " +
					rs.getString(6));
			} else {
				System.out.println("combinacion usuario / contraseña incorrectos. Intentalo de nuevo.");
				tries++;
				if (tries < 3) {
					conectar();
				} else {
					System.out.println("Demasiados intentos. Desconectado...");
				}
			}

			con.close();
			teclado.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// while (rs.next())
		// System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " +
		// rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " +
		// rs.getString(6));

	}
}