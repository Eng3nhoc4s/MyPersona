package mypersona.ngenhocas.pt.mypersona;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static JSONObject personaListJSON;
    private ArrayList<Persona> personas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DEBUG CODE TO RESET FILE
//        FileUtils.writePersonaFile(this, "");


        personaListJSON = new JSONObject();

        //The Persona object array list
        personas = new ArrayList<Persona>();

        //Load the persona list in JSON form
        try {
            personaListJSON = new JSONObject(FileUtils.readPersonaFile(this));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //Parse the persona list from JSOn to Array List
        personas = JSONUtils.loadJSONtoPersonaList(this, personaListJSON);

        //Initialize the persona custom adapter
        PersonaAdapter displayAdapter = new PersonaAdapter(this, personas);

        //Get the view to populate
        ListView personaList = (ListView) findViewById(R.id.personaListView);

        //Set the adapter
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
