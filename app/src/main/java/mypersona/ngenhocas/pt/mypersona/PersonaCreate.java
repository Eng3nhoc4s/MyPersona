package mypersona.ngenhocas.pt.mypersona;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import static mypersona.ngenhocas.pt.mypersona.MainActivity.personaListJSON;

/**
 * Creating a persona
 */
public class PersonaCreate extends AppCompatActivity {

    private Persona p;

    EditText age;
    EditText biography;
    EditText name;
    EditText occupation;
    EditText personality;
    EditText physicalTraces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona_edit);

        //The persona
        p = new Persona("Rodrigo", 25, "STeampunk", "Student", "Fat", "Annoying", "Era uma vez...");

        //Age
        age = (EditText) findViewById(R.id.txt_persona_age);

        //Biography
        biography = (EditText) findViewById(R.id.txt_persona_biography);

        //Name
        name = (EditText) findViewById(R.id.txt_persona_name);

        //Occupation
        occupation = (EditText) findViewById(R.id.txt_persona_occupation);

        //Personality
        personality = (EditText) findViewById(R.id.txt_persona_personality);

        //Physical Traces
        physicalTraces = (EditText) findViewById(R.id.txt_physical_traces);




        //Get the save button
        Button save_btn = (Button) findViewById(R.id.btn_save_persona);
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                String b = biography.toString();
//            if (b != null && b != "")
//                p.setBiography(b);
//
//                String n = name.toString();
//            if (n != null && n != "")
//                p.setName(n);
//
//                String o = occupation.toString();
//            if (o != null && o != "")
//                p.setOccupation(o);
//
//                String pe = personality.toString();
//            if (pe != null && pe != "")
//                p.setPersonality(pe);
//
//                String ph = physicalTraces.toString();
//            if (ph != null && ph != "")
//                p.setPhysicalTraces(ph);

                //ERROR
                if(p.getName() == null){

                    Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.error_no_name_provided), Toast.LENGTH_LONG);
                    toast.show();

                //ERROR - Persona with that name already exists
                }else if(personaListJSON != null && personaListJSON.has(p.getName())){

                    Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.error_persona_already_exists), Toast.LENGTH_LONG);
                    toast.show();

                }else{
                    try {
                        personaListJSON.put(p.getName(), JSONUtils.personaToJSON(p));
                        Log.e("PERSONAS",  personaListJSON.toString());
                        FileUtils.writePersonaFile(getApplicationContext(), personaListJSON.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }


            }
        });

    }

}