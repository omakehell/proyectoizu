import java.sql.*;


class MysqlCon {
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/proyectoizu", "proyectoizu", "proyectoizu");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from CLASSES");
			
			
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getString(6));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}