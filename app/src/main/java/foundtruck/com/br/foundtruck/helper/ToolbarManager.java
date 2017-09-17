package foundtruck.com.br.foundtruck.helper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import foundtruck.com.br.foundtruck.R;
import foundtruck.com.br.foundtruck.activities.InicioActivity;

/**
 * Created by Aragorn on 17/09/2017.
 */

public class ToolbarManager {

    public static void setToolbar(final AppCompatActivity a, Toolbar toolbar){
        a.setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.vtr_left_arrow);
        a.getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a.getSupportActionBar().hide();
                a.startActivity(new Intent(a, InicioActivity.class));
                a.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });
    }
}
