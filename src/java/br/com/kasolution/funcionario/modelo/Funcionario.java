/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kasolution.funcionario.modelo;

import java.text.NumberFormat;

/**
 *
 * @author igort
 */
public class Funcionario implements Comparable<Funcionario> {

    private int codigo;
    private String nome;
    private char sexo;
    private int idade;
    private String cidade;
    private String estado;
    private double salario;

    public Funcionario() {
        
    }
    
    public Funcionario(int codigo, String nome, char sexo, int idade, String cidade, String estado, double salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.cidade = cidade;
        this.estado = estado;
        this.salario = salario;
    }
    
    @Override
    public int compareTo(Funcionario t) {
        Integer i1 = this.getCodigo();
        Integer i2 = t.getCodigo();
        return i1.compareTo(i2);
    }

     @Override
    public String toString() {
        return "Funcionario {" + "Código: " + codigo + ", Nome: " + nome + ", Sexo: " + sexo + ","
                + " Idade: " + idade + ", Cidade: " + cidade + ", Estado: " + estado + ", Salário: "
                + NumberFormat.getCurrencyInstance().format(salario) + '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
