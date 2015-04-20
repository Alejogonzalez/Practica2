package com.alejandrogonzalezv.thirdone;

import android.content.res.ColorStateList;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_point);
        //Instancio  los Elementos EditTExy, botones y TextView
        final EditText nota1 = (EditText) findViewById(R.id.Ednota1);
        final EditText nota2 = (EditText) findViewById(R.id.Ednota2);
        final EditText nota3 = (EditText) findViewById(R.id.Ednota3);
        final EditText nota4 = (EditText) findViewById(R.id.Ednota4);
        final TextView notaf = (TextView) findViewById(R.id.Ednotafinal); //le puse asi por continuidad
        final TextView showe = (TextView) findViewById(R.id.EdErrors);
        Button btncalc = (Button) findViewById(R.id.btnnotaf);

        //Crear el Listener
        btncalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // crear las variables Strings de los EdTxt
                String snota1 = nota1.getText().toString();
                String snota2 = nota2.getText().toString();
                String snota3 = nota3.getText().toString();
                String snota4 = nota4.getText().toString();
                //Obtengo el número de los Strings
                double dnota1 = Double.parseDouble(snota1);
                double dnota2 = Double.parseDouble(snota2);
                double dnota3 = Double.parseDouble(snota3);
                double dnota4 = Double.parseDouble(snota4);

                if(dnota1<=5.0 && dnota2<=5.0 && dnota3<=5.0 && dnota4<=5.0 && dnota1>=0.0 && dnota2>=0.0 && dnota3>=0.0 && dnota4>=0.0){
                    double dnotaf = dnota1*0.15 + dnota2*0.10 + dnota3*0.4 + dnota4*0.35;
                    String Shownotaf = String.valueOf(dnotaf);
                    notaf.setText(Shownotaf);
                    showe.setText("Notas Correctamente Digitadas");
                    showe.setTextColor(getResources().getColor(R.color.green));
                }
                else{
                    showe.setText("Alguna(s) notas estan mal Digitadas");
                    showe.setTextColor(getResources().getColor(R.color.red));
                }

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.meny, menu);
        return true;
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
