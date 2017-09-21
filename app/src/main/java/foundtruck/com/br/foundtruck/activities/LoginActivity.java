package foundtruck.com.br.foundtruck.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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
    @BindView(R.id.btn_facebook)
    ImageButton btnFacebook;
    @BindView(R.id.btn_google_plus)
    ImageButton btnGooglePlus;

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
        //startActivity(new Intent(getApplicationContext(), CustomizedAndroidListActivity.class));
        this.overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
        finish();
    }

    @OnClick(R.id.btn_criar_conta)
    public void criarConta(){
        startActivity(new Intent(getApplicationContext(), CadastroActivity.class));
        this.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
}