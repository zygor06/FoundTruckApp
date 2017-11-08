package foundtruck.com.br.foundtruck.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import foundtruck.com.br.foundtruck.R;
import foundtruck.com.br.foundtruck.adapters.FavoritoAdapter;
import foundtruck.com.br.foundtruck.helper.FontInteface;
import foundtruck.com.br.foundtruck.helper.Fonts;
import foundtruck.com.br.foundtruck.helper.XmlParser;

public class FavoritosFragment extends Fragment implements FontInteface{

    //teste

    static final String URL = "https://api.androidhive.info/music/music.xml";
    // XML node keys
    public static final String KEY_SONG = "song"; // parent node
    public static final String KEY_ID = "id";
    public static final String KEY_TITLE = "title";
    public static final String KEY_ARTIST = "artist";
    public static final String KEY_DURATION = "duration";
    public static final String KEY_THUMB_URL = "thumb_url";

    @BindView(R.id.list)
    ListView list;
    FavoritoAdapter adapter;

    //fim teste


    private Unbinder unbinder;

    @BindView(R.id.txt_meus_favoritos)
    TextView meusFavoritos;
    @BindView(R.id.tv_favoritos)
    TextView tvFavoritos;
    @BindView(R.id.tv_recomendacoes)
    TextView tvRecomendacoes;
    @BindView(R.id.tv_reviews)
    TextView tvReviews;

    @Override
    public void onStart() {
        super.onStart();
    }

    public FavoritosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favoritos, container, false);
        unbinder = ButterKnife.bind(this, view);
        setFonts();


        ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();

        XmlParser parser = new XmlParser();
        String xml = parser.getXmlFromUrl(URL); // getting XML from URL
        Document doc = parser.getDomElement(xml); // getting DOM element

        NodeList nl = doc.getElementsByTagName(KEY_SONG);
        // looping through all song nodes &lt;song&gt;
        for (int i = 0; i < nl.getLength(); i++) {
            // creating new HashMap
            HashMap<String, String> map = new HashMap<String, String>();
            Element e = (Element) nl.item(i);
            // adding each child node to HashMap key =&gt; value
            map.put(KEY_ID, parser.getValue(e, KEY_ID));
            map.put(KEY_TITLE, parser.getValue(e, KEY_TITLE));
            map.put(KEY_ARTIST, parser.getValue(e, KEY_ARTIST));
            map.put(KEY_DURATION, parser.getValue(e, KEY_DURATION));
            map.put(KEY_THUMB_URL, parser.getValue(e, KEY_THUMB_URL));

            // adding HashList to ArrayList
            songsList.add(map);
        }

        // Getting adapter by passing xml data ArrayList
        adapter=new FavoritoAdapter(getActivity(), songsList);
        list.setAdapter(adapter);

        // Click event for single list row
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

            }
        });



        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void setFonts() {
        meusFavoritos.setTypeface(new Fonts(getActivity()).signatureRegular());
        tvFavoritos.setTypeface(new Fonts(getActivity()).chalkboardRegular());
        tvRecomendacoes.setTypeface(new Fonts(getActivity()).chalkboardRegular());
        tvReviews.setTypeface(new Fonts(getActivity()).chalkboardRegular());
    }
}