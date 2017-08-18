package mypersona.ngenhocas.pt.mypersona;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by N-genhocas on 15/08/2017.
 */

public class JSONUtils {

    /**
     * Takes a persona object and turns it into a JSON object
     * @param p The persona object
     * @return A JSON object
     */
    public static JSONObject personaToJSON(Persona p) {

        JSONObject jsonObject = new JSONObject();

        try {

            jsonObject.put("age", p.getAge());
            jsonObject.put("biography", p.getBiography());
            jsonObject.put("name", p.getName());
            jsonObject.put("occupation", p.getOccupation());
            jsonObject.put("personality", p.getPersonality());
            jsonObject.put("physicalTraces", p.getPhysicalTraces());
            jsonObject.put("style", p.getStyle());

        } catch (JSONException e) {

            e.printStackTrace();
        }

        return jsonObject;
    }


    /**
     * Turns a JSON object into a persona object
     * @param object The JSON object to be parsed
     * @return A Persona object from the JSON file
     */
    public static Persona JSONtoPersona(JSONObject object) {


        Persona persona = new Persona();

        try {

            persona.setAge(object.getInt("age"));
            persona.setBiography(object.getString("biography"));
            persona.setName(object.getString("name"));
            persona.setOccupation(object.getString("occupation"));
            persona.setPersonality(object.getString("personality"));
            persona.setPhysicalTraces(object.getString("physicalTraces"));
            persona.setStyle(object.getString("style"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return persona;
    }


    public static ArrayList<Persona> loadJSONtoPersonaList(Context context, JSONObject json){
        ArrayList<Persona> pl = new ArrayList<>();

        //Check if json is null
        if(json != null) {

            Iterator it = json.keys();

            while (it.hasNext()) {

                String key = (String) it.next();

                try {
                    pl.add(JSONUtils.JSONtoPersona((JSONObject) json.get(key)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return pl;
    }
}
