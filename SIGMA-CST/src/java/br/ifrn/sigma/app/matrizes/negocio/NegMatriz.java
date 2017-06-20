package br.ifrn.sigma.app.matrizes.negocio;

import java.util.List;

import br.ifrn.sigma.app.componentes.persistencia.PrsComponente;
import br.ifrn.sigma.dominio.ComponenteCurricular;
import br.ifrn.sigma.dominio.Matriz;
import br.ifrn.sigma.app.matrizes.persistencia.PrsMatriz;

public class NegMatriz {

	public Matriz getMatriz(int idCurso) {
		
		// Instancia as classes de acesso a dados 
		PrsMatriz prsMatriz = new PrsMatriz();
		PrsComponente prsComponente = new PrsComponente();
		
		// Recupera a matriz curricular
		Matriz matriz = prsMatriz.getMatriz(idCurso);
		
		// Recupera, na sequência, a lista de componentes curriculares associados
		List<ComponenteCurricular> componentes = prsComponente.getComponentes(matriz.getId());
		matriz.setComponentesCurriculares(componentes);
		
		// Retorna a matriz curricular
		return matriz;
	}

}
