package mypersona.ngenhocas.pt.mypersona;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Persona> personas = new ArrayList<Persona>();

        /**
         *                        name   age   style   occupation   physicalTraces   personality   biography
         */
        Persona p1 = new Persona("Nhocas von Fueuer", 25, "Steampunk", "Bum",       "Fat",  "Grumpy", "Era uma vez...");
        Persona p2 = new Persona("Von Syco",          40, "Steampunk", "Superstar", "Tall", "Nice",   "Era duas vez...");

        JSONArray pList = new JSONArray();
        pList.put(JSONUtils.jsonifyPersona(p1));
        pList.put(JSONUtils.jsonifyPersona(p2));

        FileUtils.writePersonaFile(this, pList.toString());

        String s = FileUtils.readPersonaFile(this);

        JSONArray getList;
        try {
            getList = new JSONArray(s);

            personas = JSONUtils.deJSONifyArray(getList);

        } catch (JSONException e) {
            e.printStackTrace();
        }



        Log.v("TEST", s);

        PersonaAdapter displayAdapter = new PersonaAdapter(this, personas);

        ListView personaList = (ListView) findViewById(R.id.personaListView);

        personaList.setAdapter(displayAdapter);
    }

}
