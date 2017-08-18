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

        Intent intent = getIntent();
        String id = intent.getStringExtra("NAME");

        try {
            p = JSONUtils.JSONtoPersona((JSONObject) personaListJSON.get(id));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        TextView name = (TextView) findViewById(R.id.tv_name);
        name.setText(p.getName());

        TextView age = (TextView) findViewById(R.id.tv_age);
        age.setText(p.getAge());

        TextView style = (TextView) findViewById(R.id.tv_style);
        style.setText(p.getStyle());

        TextView occupation = (TextView) findViewById(R.id.tv_occupation);
        occupation.setText(p.getOccupation());

        TextView physical = (TextView) findViewById(R.id.tv_physicaltraces);
        physical.setText(p.getPhysicalTraces());

        TextView personality = (TextView) findViewById(R.id.tv_personality);
        personality.setText(p.getPersonality());

        TextView bio = (TextView) findViewById(R.id.tv_biography);
        bio.setText(p.getBiography());


    }
}
