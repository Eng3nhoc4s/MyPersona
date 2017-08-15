package mypersona.ngenhocas.pt.mypersona;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by N-genhocas on 15/08/2017.
 */

public class JSONUtils {

    /**
     * @param p
     * @return
     */
    public static JSONObject jsonifyPersona(Persona p) {

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
     * @param object
     * @return
     */
    public static Persona personifyJSON(JSONObject object) {


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

    public static ArrayList<Persona> deJSONifyArray(JSONArray array){

        ArrayList<Persona> list = new ArrayList<Persona>();

        for(int i = 0; i < array.length(); i++){
            try {
                Persona p = personifyJSON(array.getJSONObject(i));
                list.add(p);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}
