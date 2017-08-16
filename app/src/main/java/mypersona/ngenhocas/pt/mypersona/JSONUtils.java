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
     * Takes a persona object and turns it into a JSON object
     * @param p The persona object
     * @return A JSON object
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
     * Turns a JSON object into a persona object
     * @param object The JSON object to be parsed
     * @return A Persona object from the JSON file
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

    /**
     * Takes an Array of JSON objects and parses it into an array of Personas
     * @param array JSON Array of objects
     * @return An ArrayList with the parsed persona objects
     */
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
