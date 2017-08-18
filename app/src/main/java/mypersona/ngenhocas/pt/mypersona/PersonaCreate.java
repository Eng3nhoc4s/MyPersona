package mypersona.ngenhocas.pt.mypersona;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
        p = new Persona();

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

                //Hide the keyboard on save
                try {
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {

                }

                //TODO: GET THE VALUES FROM FIELD TO POPULATE PERSONA

                String a = age.getText().toString();

                if (age.length() != 0)
                    p.setAge(Integer.parseInt(a));
                else
                    p.setAge(0);

                p.setBiography(biography.getText().toString());

                p.setName(name.getText().toString());

                p.setOccupation(occupation.getText().toString());

                p.setPersonality(personality.getText().toString());

                p.setPhysicalTraces(physicalTraces.getText().toString());

                //ERROR - No name
                if (p.getName().length() == 0) {

                    Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.error_no_name_provided), Toast.LENGTH_LONG);
                    toast.show();

                    //ERROR - Persona with that name already exists
                } else if (personaListJSON != null && personaListJSON.has(p.getName())) {

                    personaListJSON.remove(p.getName());

                    //TODO: Warn user there is already a persona with same name and is gonna be overwritten

                    try {
                        personaListJSON.put(p.getName(), JSONUtils.personaToJSON(p));
                        FileUtils.writePersonaFile(getApplicationContext(), personaListJSON.toString());

                        Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.persona_saved_successfully), Toast.LENGTH_LONG);
                        toast.show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


//                    Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.error_persona_already_exists), Toast.LENGTH_LONG);
//                    toast.show();

                } else {
                    try {
                        personaListJSON.put(p.getName(), JSONUtils.personaToJSON(p));
                        FileUtils.writePersonaFile(getApplicationContext(), personaListJSON.toString());

                        Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.persona_saved_successfully), Toast.LENGTH_LONG);
                        toast.show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }


            }
        });

    }

}