package foundtruck.com.br.foundtruck.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import foundtruck.com.br.foundtruck.R;
import foundtruck.com.br.foundtruck.config.FirebaseConfig;
import foundtruck.com.br.foundtruck.helper.FontInteface;
import foundtruck.com.br.foundtruck.helper.Fonts;
import foundtruck.com.br.foundtruck.model.Usuario;

public class LoginActivity extends AppCompatActivity implements FontInteface {

    @BindView(R.id.edit_login)
    EditText editLogin;
    @BindView(R.id.edit_senha)
    EditText editSenha;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_nao_possui_conta)
    TextView tvNaoPossuiConta;
    @BindView(R.id.btn_criar_conta)
    Button btnCriarConta;
    @BindView(R.id.btn_facebook)
    ImageButton btnFacebook;
    @BindView(R.id.btn_google_plus)
    ImageButton btnGooglePlus;

    private Unbinder unbinder;

    private FirebaseAuth authenticator;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        unbinder = ButterKnife.bind(this);
        setFonts();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    public void setFonts(){
        editLogin.setTypeface(new Fonts(this).menuRegular());
        editSenha.setTypeface(new Fonts(this).menuRegular());
        btnLogin.setTypeface( new Fonts(this).signatureRegular());
        btnCriarConta.setTypeface(new Fonts(this).robotoRegular());
        tvNaoPossuiConta.setTypeface(new Fonts(this).menuRegular());
    }

    @OnClick({R.id.btn_login, R.id.btn_facebook, R.id.btn_google_plus})
    public void login(){
        startActivity(new Intent(getApplicationContext(), InicioActivity.class));
        this.overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
        finish();
    }

    @OnClick(R.id.btn_criar_conta)
    public void criarConta(){
        startActivity(new Intent(getApplicationContext(), CadastroActivity.class));
        this.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }


    // Métodos

    public boolean verificaDados(){
        if(editLogin.getText().toString().isEmpty() || editLogin.getText().toString().equals("")
                ||editSenha.getText().toString().isEmpty() || editSenha.getText().toString().equals("")){
            return false;
        }else{
            return true;
        }
    }

    @OnClick(R.id.btn_login)
    public void logar(View view){

        if(verificaDados()){
            usuario = new Usuario();
            usuario.setEmail(editLogin.getText().toString());
            usuario.setSenha(editSenha.getText().toString());

            validarLogin();
        }else{
            Toast.makeText(LoginActivity.this, "Por favor, preencha todos os campos", Toast.LENGTH_LONG).show();
        }
    }

    private void validarLogin(){

        authenticator = FirebaseConfig.getFirebaseAuth();
        authenticator.signInWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {

                String errMessage = "";

                if(task.isSuccessful()){
                    //Sucesso ao logar

                    abrirTelaPrincipal();
                }else{
                    try{
                        throw task.getException();
                    } catch (Exception e) {
                        e.printStackTrace();
                        errMessage = "Erro ao logar";
                    }
                    Toast.makeText(LoginActivity.this, errMessage, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void abrirTelaPrincipal(){
        Intent intent = new Intent(LoginActivity.this, InicioActivity.class);
        startActivity(intent);
        finish();
    }
}