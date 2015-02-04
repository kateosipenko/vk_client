package com.vkapi.app.storage;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;

public class CacheProvider {

    public static void writeData(String key, Object data) {
        Gson gson = new Gson();

        byte[] buffer = gson.toJson(data).getBytes();
        File file = new File(Environment.getExternalStorageDirectory() + File.separator + key);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            FileOutputStream stream = new FileOutputStream(file);
            BufferedOutputStream outputStream = new BufferedOutputStream(stream);
            outputStream.write(buffer, 0, buffer.length);
            outputStream.flush();
            outputStream.close();
            stream.close();
        } catch (IOException ex) {
            Log.wtf(ex.getMessage(), ex);
        }
    }

    public static <T> T readData(String key, Type type) {
        File file = new File(Environment.getExternalStorageDirectory() + File.separator + key);
        T result = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder builder = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null && !line.isEmpty()) {
                builder.append(line);
                line = bufferedReader.readLine();
            }

            bufferedReader.close();
            reader.close();

            Gson gson = new Gson();
            result = gson.fromJson(builder.toString(), type);

        } catch (IOException ex) {
            Log.wtf(ex.getMessage(), ex);
        }

        return result;
    }

}
