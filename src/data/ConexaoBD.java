package data;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConexaoBD {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public ConexaoBD() throws Exception {

        String conexaoURL = "jdbc:sqlserver://localhost:1433;" + "databaseName=Outfit";

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(conexaoURL, "sa", "sql12");
    }
    
    public void executaSQL(String sql){
        
        try {
            st = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Erro executaSQL:\n" + ex.getMessage());
        }
    }

    public Connection getConexaoBD() {
        return con;
    }

    public Statement getSt() {
        return st;
    }

    public ResultSet getRs() {
        return rs;
    }
}
