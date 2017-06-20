package br.ifrn.sigma.app.componentes.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ifrn.sigma.dominio.ComponenteCurricular;

public class PrsComponente {

    private Connection con = null;
    private static final String driver = "org.postgresql.Driver";
    private static final String user = "postgres";
    private static final String senha = "postgres";
    private static final String url = "jdbc:postgresql://localhost:5432/sigmaDB";

    public PrsComponente() {
        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, senha);
        } catch (ClassNotFoundException ex) {
            System.err.print(ex.getMessage());
        } catch (SQLException e) {
            System.err.print(e.getMessage());
        }
    }

    public List<ComponenteCurricular> getComponentes(int id) {
        if (con != null) {
            try {
                PreparedStatement stGetComponentes = con.prepareStatement("SELECT * FROM componente_curricular WHERE id_matriz = ? ORDER BY semestre");
                stGetComponentes.setInt(1, id);
                ResultSet rsComponentes = stGetComponentes.executeQuery();
                List<ComponenteCurricular> lista = new ArrayList<ComponenteCurricular>();
                while (rsComponentes.next()) {
                    ComponenteCurricular cmp = new ComponenteCurricular();
                    cmp.setId(rsComponentes.getInt("id"));
                    cmp.setNome(rsComponentes.getString("nome"));
                    cmp.setCreditos(rsComponentes.getInt("creditos"));
                    cmp.setEmenta(rsComponentes.getString("ementa"));
                    cmp.setSemestre(rsComponentes.getInt("semestre"));
                    lista.add(cmp);
                }
                return lista;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
