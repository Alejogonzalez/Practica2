package com.alejandrogonzalezv.secondone;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;



public class MainActivity extends ActionBarActivity {
    int flag=0;
    static final String STATE_resultado = "saveresultad";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_point);

        //Instancio los dos números
        final EditText num1 = (EditText) findViewById(R.id.Ednum1);
        final EditText num2 = (EditText) findViewById(R.id.Ednum2);
        //Instancio los LAbel
        final TextView total = (TextView) findViewById(R.id.LblTotal);
        // instancio los botones
        Button btncalc = (Button) findViewById(R.id.btncalc);


        //listener del boton
        btncalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flag==1){
                    String snum1 = num1.getText().toString();
                    String snum2 = num2.getText().toString();
                    if(snum1.isEmpty() || snum2.isEmpty()){num1.setError(getString(R.string.error));num2.setError(getString(R.string.error));}
                    else{
                    double dnum1 = Double.parseDouble(snum1);
                    double dnum2 = Double.parseDouble(snum2);
                    double dtotal = dnum1 + dnum2;
                    String showtotal = String.valueOf(dtotal);
                    total.setText(showtotal);}
                 }
                if(flag==2){
                    String snum1 = num1.getText().toString();
                    String snum2 = num2.getText().toString();
                    if(snum1.isEmpty() || snum2.isEmpty()){num1.setError(getString(R.string.error));num2.setError(getString(R.string.error));}
                    else{
                    double dnum1 = Double.parseDouble(snum1);
                    double dnum2 = Double.parseDouble(snum2);
                    double dtotal = dnum1 - dnum2;
                    String showtotal = String.valueOf(dtotal);
                    total.setText(showtotal);}
                }
                if(flag==3){
                    String snum1 = num1.getText().toString();
                    String snum2 = num2.getText().toString();
                    if(snum1.isEmpty() || snum2.isEmpty()){num1.setError(getString(R.string.error));num2.setError(getString(R.string.error));}
                    else{
                    double dnum1 = Double.parseDouble(snum1);
                    double dnum2 = Double.parseDouble(snum2);
                    double dtotal = dnum1 * dnum2;
                    String showtotal = String.valueOf(dtotal);
                    total.setText(showtotal);}
                }
                if(flag==4){
                    String snum1 = num1.getText().toString();
                    String snum2 = num2.getText().toString();
                    if(snum1.isEmpty() || snum2.isEmpty()){num1.setError(getString(R.string.error));num2.setError(getString(R.string.error));}
                    else{
                    double dnum1 = Double.parseDouble(snum1);
                    double dnum2 = Double.parseDouble(snum2);
                    if(dnum2==0){
                        total.setText(getString(R.string.div0));
                    }
                    else{
                        double dtotal = dnum1 / dnum2;
                        String showtotal = String.valueOf(dtotal);
                        total.setText(showtotal);
                    }}
                }
            }
        });
    }
    // listener del radio
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_suma:
                if (checked)
                    flag =1;
                break;
            case R.id.radio_resta:
                if (checked)
                    flag=2;
                break;
            case R.id.radio_mult:
                if (checked)
                    flag=3;
                break;
            case R.id.radio_divi:
                if (checked)
                    flag=4;

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        final TextView total = (TextView) findViewById(R.id.LblTotal);
        String t = total.getText().toString();
        outState.putString(STATE_resultado,t);
        outState.putInt("bandera",flag);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        final TextView total = (TextView) findViewById(R.id.LblTotal);
        total.setText(savedInstanceState.getString(STATE_resultado));
        flag = savedInstanceState.getInt("bandera",flag);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
