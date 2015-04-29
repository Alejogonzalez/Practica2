package com.alejandrogonzalezv.thirdone;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SettingsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        final EditText porcentaje1 = (EditText) findViewById(R.id.Ednota1m);
        final EditText porcentaje2 = (EditText) findViewById(R.id.Ednota2m);
        final EditText porcentaje3 = (EditText) findViewById(R.id.Ednota3m);
        final EditText porcentaje4 = (EditText) findViewById(R.id.Ednota4m);

        Bundle extras = getIntent().getExtras();
        porcentaje1.setText(String.valueOf(extras.getDouble("por1")));
        porcentaje2.setText(String.valueOf(extras.getDouble("por2")));
        porcentaje3.setText(String.valueOf(extras.getDouble("por3")));
        porcentaje4.setText(String.valueOf(extras.getDouble("por4")));

        Button btnmod = (Button) findViewById(R.id.btnmodp);

        btnmod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent();
                j.putExtra("por1ans",Double.valueOf(porcentaje1.getText().toString()));
                j.putExtra("por2ans",Double.valueOf(porcentaje2.getText().toString()));
                j.putExtra("por3ans",Double.valueOf(porcentaje3.getText().toString()));
                j.putExtra("por4ans",Double.valueOf(porcentaje4.getText().toString()));
                setResult(RESULT_OK,j);
                finish();
            }
        });
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
