package Provider;

import com.google.gson.Gson;
import java.util.ArrayList;
import Model.Hero;
import Model.ResponseHero;

/**
 * Created by quentinlogie on 15/04/14.
 */
public class MainProvider {
    private static ArrayList<Hero> heros;

    static {
        heros = new ArrayList<Hero>();
    }

    public static ArrayList<Hero> getHeros() {
        return heros;
    }

    public static void fetchHeroesFromWebservice(String tag) {
        heros = new ArrayList<Hero>();
        //tag = tag.replace("#","-");
        tag="Aspitrine-2547";
        RestProvider client = new RestProvider("http://eu.battle.net/api/d3/profile/"+tag+"/");

        try {
            client.Execute(RequestMethod.GET);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String response = client.getResponse();
        Gson gson = new Gson();
        ResponseHero res = gson.fromJson(response, ResponseHero.class);

        for (Hero h : res.getHero()) {
            heros.add(h);
        }
    }
}
