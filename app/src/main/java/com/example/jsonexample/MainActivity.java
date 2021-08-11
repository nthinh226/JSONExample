package com.example.jsonexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;

import java.io.IOException;
import java.io.StringWriter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText outputText;
    private Button btnReadJson, btnWriteJSON;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputText = findViewById(R.id.editText);
        btnReadJson = findViewById(R.id.btn_read_json);
        btnWriteJSON = findViewById(R.id.btn_write_json);

        btnReadJson.setOnClickListener(this);

        btnWriteJSON.setOnClickListener(this);
    }

    private void runWriteJSONExample() {
        StringWriter output = new StringWriter();
        Company company = WriterJSONExample.createCompany();

        try {
            WriterJSONExample.writeJsonStream(output, company);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String jsonText = output.toString();
        outputText.setText(jsonText);
    }

    private void runReadJSONExample() {
        try {
            Company company = ReadJSONExample.readCompanyJSONFile(this);
            outputText.setText(company.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_read_json:
                runReadJSONExample();
                break;
            case R.id.btn_write_json:
                runWriteJSONExample();
                break;
        }
    }
}