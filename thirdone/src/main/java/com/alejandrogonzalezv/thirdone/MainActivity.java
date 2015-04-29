package com.alejandrogonzalezv.thirdone;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    double p1 = 0.15;
    double p2 = 0.10;
    double p3 = 0.40;
    double p4 = 0.35;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this,"onCreate()",Toast.LENGTH_SHORT).show();
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
                if(snota1.isEmpty()){nota1.setError(getResources().getString(R.string.vacio));}
                if(snota2.isEmpty()){nota2.setError(getResources().getString(R.string.vacio));}
                if(snota3.isEmpty()){nota3.setError(getResources().getString(R.string.vacio));}
                if(snota4.isEmpty()){nota4.setError(getResources().getString(R.string.vacio));}
                if(snota1.isEmpty()==false && snota2.isEmpty()==false && snota3.isEmpty()==false && snota4.isEmpty()==false){
                double dnota1 = Double.parseDouble(snota1);
                double dnota2 = Double.parseDouble(snota2);
                double dnota3 = Double.parseDouble(snota3);
                double dnota4 = Double.parseDouble(snota4);

                if(dnota1<=5.0 && dnota2<=5.0 && dnota3<=5.0 && dnota4<=5.0 && dnota1>=0.0 && dnota2>=0.0 && dnota3>=0.0 && dnota4>=0.0){
                    double dnotaf = dnota1*p1 + dnota2*p2 + dnota3*p3 + dnota4*p4;
                    String Shownotaf = String.valueOf(dnotaf);
                    notaf.setText(Shownotaf);
                    showe.setText(getResources().getString(R.string.correcto));
                    showe.setTextColor(getResources().getColor(R.color.green));
                }
                else{
                    showe.setText(getResources().getString(R.string.incorrecto));
                    showe.setTextColor(getResources().getColor(R.color.red));
                }}

            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        final TextView notaf = (TextView) findViewById(R.id.Ednotafinal); //le puse asi por continuidad
        final TextView showe = (TextView) findViewById(R.id.EdErrors);
        outState.putString("notafinal", notaf.getText().toString());
        outState.putString("errorshow", showe.getText().toString());
        outState.putInt("errorcolor", showe.getCurrentTextColor());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        final TextView notaf = (TextView) findViewById(R.id.Ednotafinal); //le puse asi por continuidad
        final TextView showe = (TextView) findViewById(R.id.EdErrors);
        notaf.setText(savedInstanceState.getString("notafinal"));
        showe.setText(savedInstanceState.getString("errorshow"));
        showe.setTextColor(savedInstanceState.getInt("errorcolor"));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1234 && resultCode==RESULT_OK){
            p1 = data.getExtras().getDouble("por1ans")/100;
            p2 = data.getExtras().getDouble("por2ans")/100;
            p3 = data.getExtras().getDouble("por3ans")/100;
            p4 = data.getExtras().getDouble("por4ans")/100;

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"onPause()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onReStart()",Toast.LENGTH_SHORT).show();
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
        if (id == R.id.aboutus) {
            Intent i = new Intent(this,AboutActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_settings) {
            Intent a = new Intent(this,SettingsActivity.class);
            a.putExtra("por1",p1*100);
            a.putExtra("por2",p2*100);
            a.putExtra("por3",p3*100);
            a.putExtra("por4",p4*100);
            startActivityForResult(a,1234);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
