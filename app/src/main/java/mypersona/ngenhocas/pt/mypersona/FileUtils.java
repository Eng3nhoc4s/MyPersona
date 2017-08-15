package mypersona.ngenhocas.pt.mypersona;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


/**
 * Created by N-genhocas on 15/08/2017.
 */

public class FileUtils {

    /**
     *
     * @param context
     * @return
     */
    public static String readPersonaFile(Context context) {

        String data = "";

        try {
            InputStream inputStream = context.openFileInput(Configurations.PERSONA_FILENAME);

            if (inputStream != null) {

                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                data = stringBuilder.toString();
            }
        } catch (FileNotFoundException e) {
            Log.e("Read persona file", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("Read persona file", "Can not read file: " + e.toString());
        }

        return data;
    }

    /**
     *
     * @param context
     * @param data
     */
    public static void writePersonaFile(Context context, String data) {

        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(Configurations.PERSONA_FILENAME, Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}
