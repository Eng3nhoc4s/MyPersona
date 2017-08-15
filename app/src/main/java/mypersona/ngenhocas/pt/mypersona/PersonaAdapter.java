package mypersona.ngenhocas.pt.mypersona;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by N-genhocas on 15/08/2017.
 */

public class PersonaAdapter extends ArrayAdapter<Persona> {

    public PersonaAdapter(Context context, ArrayList<Persona> entries) {
        super(context, 0, entries);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.persona_list_entry, parent, false);
        }

        final Persona currentPersonaEntry= getItem(position);

        TextView personaName = (TextView) listItemView.findViewById(R.id.tv_persona_name);
        personaName.setText(currentPersonaEntry.getName());

        TextView personaStyle = (TextView) listItemView.findViewById(R.id.tv_style);
        personaStyle.setText(currentPersonaEntry.getStyle());

        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent intent = new Intent(getContext(), Visualizer.class);
//                intent.putExtra("ACTIVITY_NAME", currentGridDisplayEntry.getmName());
//                intent.putExtra("SONG_TRACK_ID", currentGridDisplayEntry.getmMusicResourceID());
//                intent.putExtra("DISPLAY_IMAGE", currentGridDisplayEntry.getmVisualizerImageID());
//                intent.putExtra("DESCRIPTIVE_TEXT", currentGridDisplayEntry.getmTextResourceID());
//
//                getContext().startActivity(intent);

            }
        });

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }


}