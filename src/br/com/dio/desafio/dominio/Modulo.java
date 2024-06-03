package br.com.dio.desafio.dominio;

import java.util.ArrayList;
import java.util.List;

public class Modulo extends Conteudo{

    private List<Curso> cursos;

    @Override
    public double calcularXp() {
        double xpTotal = XP_PADRAO; 
        for (Curso curso : cursos) {
            xpTotal += curso.calcularXp();
        }
        return xpTotal;
    }

    public Modulo() {
        this.cursos = new ArrayList<>();
    }

    public void adicionarCurso(Curso curso) {
        cursos.add(curso);
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        StringBuilder modulo = new StringBuilder();
        modulo.append("Modulo: ").append(getTitulo()).append("\n");
    
        for (Curso curso : getCursos()) {
            modulo.append("  Curso:\n")
              .append("    Titulo: ").append(curso.getTitulo()).append("\n")
              .append("    Descrição: ").append(curso.getDescricao()).append("\n")
              .append("    Carga horaria: ").append(curso.getCargaHoraria()).append(" hora(s).\n");
        }
    
        return modulo.toString();
    }
}
