package foundtruck.com.br.foundtruck.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import foundtruck.com.br.foundtruck.R;
import foundtruck.com.br.foundtruck.helper.FontInteface;
import foundtruck.com.br.foundtruck.helper.Fonts;

public class LoginActivity extends AppCompatActivity implements FontInteface {

    private Unbinder unbinder;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
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

    @OnClick(R.id.btn_login)
    public void login(){
        startActivity(new Intent(getApplicationContext(), InicioActivity.class));
    }

    @OnClick(R.id.btn_criar_conta)
    public void criarConta(){
        startActivity(new Intent(getApplicationContext(), CadastroActivity.class));
    }


}
