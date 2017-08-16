package mypersona.ngenhocas.pt.mypersona;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static java.security.AccessController.getContext;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Persona> personas = new ArrayList<Persona>();

        // TEST CODES

        /**
         *                        name   age   style   occupation   physicalTraces   personality   biography
         */
        Persona p1 = new Persona("Nhocas von Fueuer", 25, "Steampunk", "Bum",       "Fat",  "Grumpy", "Era uma vez...");
        Persona p2 = new Persona("Von Syco",          40, "Steampunk", "Superstar", "Tall", "Nice",   "Era duas vez...");

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(JSONUtils.jsonifyPersona(p1));
        jsonArray.put(JSONUtils.jsonifyPersona(p2));

        FileUtils.writePersonaFile(this, jsonArray.toString());

        String s = FileUtils.readPersonaFile(this);

        JSONArray getList;
        try {
            getList = new JSONArray(s);

            personas = JSONUtils.deJSONifyArray(getList);

        } catch (JSONException e) {
            e.printStackTrace();
        }



        Log.v("TEST", s);

        //END OF TESTCODE

        PersonaAdapter displayAdapter = new PersonaAdapter(this, personas);

        ListView personaList = (ListView) findViewById(R.id.personaListView);

        personaList.setAdapter(displayAdapter);

        /**************************************
         *      MAIN LAYOUT BUTTONS
         ***************************************/

        Button newPersona = (Button) findViewById(R.id.btn_newPersona);
        newPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PersonaCreate.class);
                startActivity(intent);
            }
        });
    }

}
