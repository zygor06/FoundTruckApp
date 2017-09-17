package foundtruck.com.br.foundtruck.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.lang.reflect.Field;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import foundtruck.com.br.foundtruck.R;
import foundtruck.com.br.foundtruck.fragment.PesquisaFragment;

public class MainActivity extends AppCompatActivity {

    private Unbinder unbinder;

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigation;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemReselectedListener
             = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            switch (item.getItemId()){
                case R.id.action_search:
                    transaction.replace(R.id.fragment_pesquisa, new PesquisaFragment()).commit();
                    Toast.makeText(getApplicationContext(), "Pesquisar", Toast.LENGTH_LONG).show();
                    return true;
                case R.id.action_favoritos:
                    return true;
                case R.id.action_foodtrucks:
                    return true;
                case R.id.action_locais:
                    return true;
            }

            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        disableShiftMode(bottomNavigation);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    // Método para disabilitar o ShiftMode da ButtomNavigationView *
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

}
