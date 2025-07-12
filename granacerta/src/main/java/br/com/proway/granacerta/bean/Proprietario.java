package br.com.proway.granacerta.bean;

public class Proprietario {

    /* Proprietario: id, nome, cpf, email, senha */

    // Atributos (São características)
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;

    // Get e Set métodos que permitem acesso para consultar e definir valor
    // Get é um método que permite obter o valor do atributo privado
    public int getId() {
        return id;
    }

    // Set é um método que permite definir um valor para o o atributo privado
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
