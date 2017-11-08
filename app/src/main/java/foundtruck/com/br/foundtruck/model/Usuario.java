package foundtruck.com.br.foundtruck.model;

import com.google.firebase.database.DatabaseReference;

import foundtruck.com.br.foundtruck.config.FirebaseConfig;

/**
 * Created by Gollum on 08/11/2017.
 */

public class Usuario {

    private String id;
    private String nome;
    private String email;
    private String senha;

    public Usuario(){}

    public void salvar(){
        DatabaseReference referencia = FirebaseConfig.getFirebase();
        referencia.child("usuarios").child(getId()).setValue(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
