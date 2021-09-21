package br.com.controle;

public class Turma {
private String curso;
private String turma;
private String disciplina;
private String nome;
private String nota1;
private String nota2;

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNota1() {
        return nota1;
    }

    public void setNota1(String nota1) {
        this.nota1 = nota1;
    }

    public String getNota2() {
        return nota2;
    }

    public void setNota2(String nota2) {
        this.nota2 = nota2;
    }
    
    public String media(){
       double md;
       double v1=Double.valueOf(nota1);
       double v2=Double.valueOf(nota2);
       md=(v1+v2)/2;
       String tmd=String.valueOf(md);
        return tmd;
    }
    
}
