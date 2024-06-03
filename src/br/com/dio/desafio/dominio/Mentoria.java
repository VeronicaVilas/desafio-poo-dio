package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.time.LocalTime;

public class Mentoria extends Conteudo{

    private LocalDate data;
        private LocalTime hora;

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }

    public Mentoria() {
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        StringBuilder mentoria = new StringBuilder();
        mentoria.append("Mentoria: ").append(getTitulo()).append("\n")
                .append("    Descrição: ").append(getDescricao()).append("\n")
                .append("    Data: ").append(getData()).append("\n")
                .append("    Hora: ").append(getHora()).append("\n");
    
        return mentoria.toString();
    }
}
