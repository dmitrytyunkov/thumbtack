package com.example.dmitry.hws_android_school.ui.hw7;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dmitry.hws_android_school.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SaveInFileFragment extends Fragment {


    public static final String FILE_NAME = "fileForSaveText.txt";

    File file;

    @Bind(R.id.edit_text_for_save)
    EditText editTextForSave;

    public SaveInFileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_save_text, container, false);
        file = new File(getContext().getFilesDir(), FILE_NAME);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @Override
    public void onPause() {
        super.onPause();
        try {
            OutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(outputStream);
            osw.write(editTextForSave.getText().toString());
            osw.close();
            outputStream.close();
        } catch (Throwable t) {
            Toast.makeText(getContext(),
                    "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(isr);
            editTextForSave.setText(reader.readLine());
            reader.close();
            isr.close();
            inputStream.close();
        } catch (Throwable t) {
            Toast.makeText(getContext(),
                    "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
