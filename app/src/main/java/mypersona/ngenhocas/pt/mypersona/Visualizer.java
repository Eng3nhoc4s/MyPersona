package mypersona.ngenhocas.pt.mypersona;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import static mypersona.ngenhocas.pt.mypersona.MainActivity.personaListJSON;

/**
 * Visualize Persona Data
 */

public class Visualizer extends AppCompatActivity {

    Persona p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.persona_visualizer);

        //GET THE PERSON ID
        Intent intent = getIntent();
        String id = intent.getStringExtra("NAME");

        //PARSE PERSON OBJECT
        try {
            p = JSONUtils.JSONtoPersona((JSONObject) personaListJSON.get(id));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //NAME - Always shows
        TextView name = (TextView) findViewById(R.id.tv_name);
        name.setText(p.getName());

        //AGE
        TextView age = (TextView) findViewById(R.id.tv_age);
        int tmpInt;
        if((tmpInt = p.getAge()) != 0)
            age.setText(Integer.toString(p.getAge()));
        else
            age.setText(getString(R.string.info_not_set));


        String tmpStr;

        //STYLE
        TextView style = (TextView) findViewById(R.id.tv_style);
        tmpStr = p.getStyle();
        if(tmpStr != null && !tmpStr.isEmpty())
            style.setText(tmpStr);
        else
            style.setText(getString(R.string.info_not_set));


        //OCCUPATION
        TextView occupation = (TextView) findViewById(R.id.tv_occupation);
        tmpStr = p.getOccupation();
        if(tmpStr != null && !tmpStr.isEmpty())
            occupation.setText(tmpStr);
        else
            occupation.setText(getString(R.string.info_not_set));


        //PHYSICAL TRACES
        TextView physical = (TextView) findViewById(R.id.tv_physicaltraces);
        tmpStr = p.getPhysicalTraces();
        if(tmpStr != null && !tmpStr.isEmpty())
            physical.setText(tmpStr);
        else
            physical.setText(getString(R.string.info_not_set));


        //PERSONALITY
        TextView personality = (TextView) findViewById(R.id.tv_personality);
        tmpStr = p.getPersonality();
        if(tmpStr != null && !tmpStr.isEmpty())
            personality.setText(tmpStr);
        else
            personality.setText(getString(R.string.info_not_set));


        //BIOGRAPHY
        TextView bio = (TextView) findViewById(R.id.tv_biography);
        tmpStr = p.getBiography();
        if(tmpStr != null && !tmpStr.isEmpty())
            bio.setText(tmpStr);
        else
            bio.setText(getString(R.string.info_not_set));


        //TODO: RIG THE EDIT PERSONA BUTTON

        //TODO: RIG THE DELETE PERSONA BUTTON
    }
}
