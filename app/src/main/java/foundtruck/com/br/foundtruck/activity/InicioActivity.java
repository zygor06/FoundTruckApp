package foundtruck.com.br.foundtruck.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;

import butterknife.BindView;
import butterknife.ButterKnife;
import foundtruck.com.br.foundtruck.R;
import foundtruck.com.br.foundtruck.fragment.PesquisaFragment;

public class InicioActivity extends AppCompatActivity {

    private TextView mTextMessage;
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.action_search:
                    getTransaction().replace(R.id.content, new PesquisaFragment()).commit();
                    Toast.makeText(getApplicationContext(), "Pesquisar", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_favoritos:
                    Toast.makeText(getApplicationContext(), "Favoritos", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_foodtrucks:
                    Toast.makeText(getApplicationContext(), "Foodtrucks", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_locais:
                    Toast.makeText(getApplicationContext(), "Locais", Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        }

    };


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.action_search).setChecked(true);
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        ButterKnife.bind(this);

        getTransaction().replace(R.id.content, new PesquisaFragment()).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        disableShiftMode(navigation);
    }


    private void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                item.setChecked(item.getItemData().isChecked());

                /* Modificar tamanho dos icones */

                final View iconView = menuView.getChildAt(i).findViewById(android.support.design.R.id.icon);
                final ViewGroup.LayoutParams layoutParams = iconView.getLayoutParams();
                final DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                // set your height here
                layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, displayMetrics);
                // set your width here
                layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, displayMetrics);
                iconView.setLayoutParams(layoutParams);

            }



        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }

    private FragmentTransaction getTransaction(){
        return getSupportFragmentManager().beginTransaction();
    }
}