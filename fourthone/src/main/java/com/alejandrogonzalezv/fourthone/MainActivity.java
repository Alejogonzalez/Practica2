package com.alejandrogonzalezv.fourthone;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity {
    int flag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourthone);
        //instanciar objetos
        final EditText EdAltura = (EditText) findViewById(R.id.EdAltura);
        final EditText EdBase = (EditText) findViewById(R.id.EdBase);
        final EditText EdLado = (EditText) findViewById(R.id.EdLado);
        final EditText EdRadio = (EditText) findViewById(R.id.EdRadio);
        final TextView TxResul = (TextView) findViewById(R.id.txtresultado);
        Button  BtnCalc = (Button) findViewById(R.id.btnCalc);

        BtnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (flag==1){//cuadrado
                    String sLado = EdLado.getText().toString();
                    if(sLado.isEmpty()){
                        EdLado.setError("Campo Vacio");
                    }
                    else{
                        double dLado = Double.parseDouble(sLado);
                        double Area = dLado*dLado;
                        String Showarea = String.valueOf(Area);
                        TxResul.setText(Showarea+" unidades^2");
                    }
                }
                if (flag==2){//Rectangulo
                    String sAltura = EdAltura.getText().toString();
                    String sBase = EdBase.getText().toString();
                    if(sAltura.isEmpty()){EdAltura.setError("Campo Vacio");}
                    if(sBase.isEmpty()){EdBase.setError("Campo Vacio");}
                    else{
                        double dAltura = Double.parseDouble(sAltura);
                        double dBase = Double.parseDouble(sBase);
                        double Area = dAltura*dBase;
                        String Showarea = String.valueOf(Area);
                        TxResul.setText(Showarea+" unidades^2");
                    }
                }
            }
        });
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        final EditText EdAltura = (EditText) findViewById(R.id.EdAltura);
        final EditText EdBase = (EditText) findViewById(R.id.EdBase);
        final EditText EdLado = (EditText) findViewById(R.id.EdLado);
        final EditText EdRadio = (EditText) findViewById(R.id.EdRadio);
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_cuadro:
                if (checked){
                    flag =1;
                    EdAltura.setEnabled(false);
                    EdBase.setEnabled(false);
                    EdLado.setEnabled(true);
                    EdRadio.setEnabled(false);
                    EdLado.setHintTextColor(getResources().getColor(R.color.green));
                    EdAltura.setHintTextColor(getResources().getColor(R.color.red));
                    EdBase.setHintTextColor(getResources().getColor(R.color.red));
                    EdRadio.setHintTextColor(getResources().getColor(R.color.red));
                    }
                break;
            case R.id.radio_rect:
                if (checked){
                    flag=2;
                    EdAltura.setEnabled(true);
                    EdBase.setEnabled(true);
                    EdLado.setEnabled(false);
                    EdRadio.setEnabled(false);
                    EdLado.setHintTextColor(getResources().getColor(R.color.red));
                    EdAltura.setHintTextColor(getResources().getColor(R.color.green));
                    EdBase.setHintTextColor(getResources().getColor(R.color.green));
                    EdRadio.setHintTextColor(getResources().getColor(R.color.red));}
                break;
            case R.id.radio_triang:
                if (checked){
                    flag=3;
                    EdAltura.setEnabled(true);
                    EdBase.setEnabled(true);
                    EdLado.setEnabled(false);
                    EdRadio.setEnabled(false);
                    EdLado.setHintTextColor(getResources().getColor(R.color.red));
                    EdAltura.setHintTextColor(getResources().getColor(R.color.green));
                    EdBase.setHintTextColor(getResources().getColor(R.color.green));
                    EdRadio.setHintTextColor(getResources().getColor(R.color.red));
                }
                break;
            case R.id.radio_circ:
                if (checked){
                    flag=4;
                    EdAltura.setEnabled(false);
                    EdBase.setEnabled(false);
                    EdLado.setEnabled(false);
                    EdRadio.setEnabled(true);
                    EdLado.setHintTextColor(getResources().getColor(R.color.red));
                    EdAltura.setHintTextColor(getResources().getColor(R.color.red));
                    EdBase.setHintTextColor(getResources().getColor(R.color.red));
                    EdRadio.setHintTextColor(getResources().getColor(R.color.green));}
                break;
        }
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
