package Adapter;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.diablo3connect.app.R;

import java.util.List;

import Model.Hero;

/**
 * Created by quentinlogie on 15/04/14.
 */
public class ListHeroAdapter extends ArrayAdapter<Hero>{
    Activity activity;
    final String EXTRA_ID = "id";
    final String EXTRA_BATTLE_TAG = "tag";

    public ListHeroAdapter(Activity context, int resource, List<Hero> objects){
        super(context, resource, objects);
        this.activity = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view = activity.getLayoutInflater().inflate(R.layout.list_hero_adapter, null);

        final Hero currentHero = getItem(position);

        TextView name = (TextView)view.findViewById(R.id.nom);
        name.setText(currentHero.getName());

        TextView level = (TextView)view.findViewById(R.id.level);
        level.setText(" " + currentHero.getLevel());

        TextView paragon = (TextView)view.findViewById(R.id.paragon);
        paragon.setText(" (" + currentHero.getParagonLevel()+ ")");
        paragon.setTextColor(Color.parseColor("#55BBFF"));

        TextView id = (TextView) view.findViewById(R.id.id);
        id.setText(String.valueOf(currentHero.getId()));

        ImageView img = (ImageView) view.findViewById(R.id.imageView);
        if(currentHero.getType().equals("demon-hunter")){
            if(currentHero.getGender() == 0){
                img.setImageResource(R.drawable.chasseurdedemonm);
            }else{
                img.setImageResource(R.drawable.chasseurdedemonf);
            }
        }else if(currentHero.getType().equals("barbarian")){
            if(currentHero.getGender() == 0){
                img.setImageResource(R.drawable.barbarem);
            }else{
                img.setImageResource(R.drawable.barbarem);
            }
        }else if(currentHero.getType().equals("monk")){
            if(currentHero.getGender()== 0){
                img.setImageResource(R.drawable.moinem);
            }else{
                img.setImageResource(R.drawable.moinef);
            }
        }else if(currentHero.getType().equals("wizard")){
            if(currentHero.getGender()== 0){
                img.setImageResource(R.drawable.sorcierm);
            }else{
                img.setImageResource(R.drawable.sorcierf);
            }
        }else if(currentHero.getType().equals("crusader")){
            if(currentHero.getGender()== 0){

            }else{

            }
        }

        return view;
    }
}
