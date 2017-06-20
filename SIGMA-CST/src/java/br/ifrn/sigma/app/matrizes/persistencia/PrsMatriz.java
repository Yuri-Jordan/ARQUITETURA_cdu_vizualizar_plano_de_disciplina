package br.ifrn.sigma.app.matrizes.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ifrn.sigma.dominio.Matriz;

public class PrsMatriz {

    private Connection con = null;
    private static final String driver = "org.postgresql.Driver";
    private static final String user = "postgres";
    private static final String senha = "postgres";
    private static final String url = "jdbc:postgresql://localhost:5432/sigmaDB";

    public PrsMatriz() {
        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, senha);
        } catch (ClassNotFoundException ex) {
            System.err.print(ex.getMessage());
        } catch (SQLException e) {
            System.err.print(e.getMessage());
        }
    }

    public Matriz getMatriz(int idCurso) {
        if (con != null) {
            try {
                PreparedStatement stGetMatriz = con.prepareStatement("SELECT * FROM matriz_curricular WHERE id_curso = ?");
                stGetMatriz.setInt(1, idCurso);
                ResultSet rsMatriz = stGetMatriz.executeQuery();
                if (rsMatriz.next()) {
                    Matriz matriz = new Matriz();
                    matriz.setId(rsMatriz.getInt("id"));
                    matriz.setDescricao(rsMatriz.getString("descricao"));
                    matriz.setAtiva(rsMatriz.getBoolean("ativa"));
                    return matriz;
                } else {
                    System.err.println("consulta não retornou informações");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
