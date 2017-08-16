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
 * Various utilities regarding file operations
 */

public class FileUtils {

    /**
     * Reads the specified file and returns it's contents
     * @param context The context
     * @return The file content
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
     * Writes the specified file with the provided data
     * @param context The context
     * @param data The string to be writen on the file
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
