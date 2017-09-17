package foundtruck.com.br.foundtruck.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
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

public class CadastroActivity extends AppCompatActivity implements FontInteface{


    private Unbinder unbinder;

    @BindView(R.id.edit_cadastro_nome)
    EditText editNome;
    @BindView(R.id.edit_cadastro_email)
    EditText editEmail;
    @BindView(R.id.edit_cadastro_senha)
    EditText editSenha;
    @BindView(R.id.btn_cadastro)
    Button btnCadastrar;
    @BindView(R.id.text_cadastro)
    TextView textoCadastro;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onStart() {
        super.onStart();
        setToolbar();
        getSupportActionBar().hide();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        unbinder = ButterKnife.bind(this);
        setFonts();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        getSupportActionBar().show();
    }

    @Override
    public void setFonts() {
        editNome.setTypeface(new Fonts(this).menuRegular());
        editEmail.setTypeface(new Fonts(this).menuRegular());
        editSenha.setTypeface(new Fonts(this).menuRegular());
        textoCadastro.setTypeface(new Fonts(this).chalkboardRegular());
        btnCadastrar.setTypeface( new Fonts(this).signatureRegular());
    }

    public void setToolbar(){
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.vtr_left_arrow);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportActionBar().hide();
                finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });
    }

    @OnClick(R.id.btn_cadastro)
    public void cadastrar(){
        finish();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }
}
