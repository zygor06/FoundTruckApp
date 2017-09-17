package foundtruck.com.br.foundtruck.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import foundtruck.com.br.foundtruck.R;
import foundtruck.com.br.foundtruck.helper.FontInteface;
import foundtruck.com.br.foundtruck.helper.Fonts;

public class PesquisaFragment extends Fragment implements FontInteface{

    private Unbinder unbinder;

    private EditText editPesquisa;
    private TextView acheFoodTruck;
    private TextView encontre;


    public PesquisaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        unbinder = ButterKnife.bind(getActivity());
        setVariaveis();
        setFonts();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pesquisa, container, false);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void setFonts() {
        acheFoodTruck.setTypeface(new Fonts(getActivity()).chalkboardRegular());
        encontre.setTypeface(new Fonts(getActivity()).robotoRegular());
        editPesquisa.setTypeface(new Fonts(getActivity()).menuRegular());
    }

    public void setVariaveis(){
        acheFoodTruck = (TextView) getActivity().findViewById(R.id.txt_pesquisa_ache);
        encontre = (TextView) getActivity().findViewById(R.id.txt_pesquisa_encontre);
        editPesquisa = (EditText) getActivity().findViewById(R.id.edit_pesquisa);
    }
}
