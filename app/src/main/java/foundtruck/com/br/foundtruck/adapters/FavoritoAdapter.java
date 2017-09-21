package foundtruck.com.br.foundtruck.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import foundtruck.com.br.foundtruck.R;
import foundtruck.com.br.foundtruck.helper.ImageLoader;

/**
 * Created by Aragorn on 20/09/2017.
 */

public class FavoritoAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater = null;
    public ImageLoader imageLoader;

    public FavoritoAdapter(Activity a, ArrayList<HashMap<String, String>> d){
        this.activity = a;
        this.data = d;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader = new ImageLoader(activity.getApplicationContext());

    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if(convertView==null) view = inflater.inflate(R.layout.list_row_fav, null);

        TextView nome = (TextView)view.findViewById(R.id.foodtruck_nome);
        TextView status = (TextView)view.findViewById(R.id.foodtruck_status);
        TextView horario = (TextView)view.findViewById(R.id.foodtruck_horario);
        TextView endereco = (TextView)view.findViewById(R.id.foodtruck_endereco);
        ImageView imagem = (ImageView)view.findViewById(R.id.foodtruck_img);

        HashMap<String, String> song = new HashMap<String, String>();
        song = data.get(position);

        // Setting all values in listview
        /*nome.setText(song.get(CustomizedAndroidListActivity.KEY_TITLE));
        status.setText(song.get(CustomizedAndroidListActivity.KEY_ARTIST));
        horario.setText(song.get(CustomizedAndroidListActivity.KEY_DURATION));
        imageLoader.DisplayImage(song.get(CustomizedAndroidListActivity.KEY_THUMB_URL), imagem);*/
        return view;
    }
}
