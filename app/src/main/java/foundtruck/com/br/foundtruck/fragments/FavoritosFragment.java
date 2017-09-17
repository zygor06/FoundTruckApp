package foundtruck.com.br.foundtruck.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import foundtruck.com.br.foundtruck.R;
import foundtruck.com.br.foundtruck.helper.FontInteface;
import foundtruck.com.br.foundtruck.helper.Fonts;

public class FavoritosFragment extends Fragment implements FontInteface{

    private Unbinder unbinder;

    @BindView(R.id.txt_meus_favoritos)
    TextView meusFavoritos;

    @Override
    public void onStart() {
        super.onStart();
        unbinder = ButterKnife.bind(getActivity());
    }

    public FavoritosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favoritos, container, false);


        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void setFonts() {
        meusFavoritos.setTypeface(new Fonts(getActivity()).robotoBold());
    }
}
