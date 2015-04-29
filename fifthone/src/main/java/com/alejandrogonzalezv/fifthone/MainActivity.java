package com.alejandrogonzalezv.fifthone;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;


public class MainActivity extends ActionBarActivity {
    final int gyear=0;
    int gmonth=0;
    int gday = 0;
    int flag=0;
    int flagh=0;
    String showh=" ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifthone);

        final EditText nombre = (EditText) findViewById(R.id.EdNombre);
        final EditText correo = (EditText) findViewById(R.id.EdCorreo);
        final EditText telefono = (EditText) findViewById(R.id.EdTelef);
        final TextView txtnombre = (TextView) findViewById(R.id.TxtNombre);
        final TextView txtcorreo = (TextView) findViewById(R.id.Txtcorreo);
        final TextView txttelefono = (TextView) findViewById(R.id.Txttelef);
        final TextView txtsexo = (TextView) findViewById(R.id.Txtsex);
        final TextView hobbies = (TextView) findViewById(R.id.Txthobbies);
        final TextView txciudad = (TextView) findViewById(R.id.Txtciudad);
        Button btnsubmit = (Button) findViewById(R.id.btnok);
        final Spinner spinner = (Spinner) findViewById(R.id.cityspinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                txtnombre.setText(nombre.getText().toString());
                txtcorreo.setText(correo.getText().toString());
                txttelefono.setText(telefono.getText().toString());

                if(flag==1){txtsexo.setText(getResources().getString(R.string.feme));}
                if(flag==2){txtsexo.setText(getResources().getString(R.string.masc));}

                //hobbies.setText(String.valueOf(flagh));
                if(flagh==1){hobbies.setText(getResources().getString(R.string.h1));}
                if(flagh==2){hobbies.setText(getResources().getString(R.string.h2));}
                if(flagh==4){hobbies.setText(getResources().getString(R.string.h4));}
                if(flagh==8){hobbies.setText(getResources().getString(R.string.h8));}
                if(flagh==3){hobbies.setText(getResources().getString(R.string.h3));}
                if(flagh==5){hobbies.setText(getResources().getString(R.string.h5));}
                if(flagh==9){hobbies.setText(getResources().getString(R.string.h9));}
                if(flagh==6){hobbies.setText(getResources().getString(R.string.h6));}
                if(flagh==10){hobbies.setText(getResources().getString(R.string.h10));}
                if(flagh==12){hobbies.setText(getResources().getString(R.string.h12));}
                if(flagh==7){hobbies.setText(getResources().getString(R.string.h7));}
                if(flagh==14){hobbies.setText(getResources().getString(R.string.h14));}
                if(flagh==11){hobbies.setText(getResources().getString(R.string.h11));}
                if(flagh==13){hobbies.setText(getResources().getString(R.string.h13));}
                if(flagh==15){hobbies.setText(getResources().getString(R.string.h15));}
                if(flagh==0){hobbies.setText(getResources().getString(R.string.h0));}

                txciudad.setText(String.valueOf(spinner.getSelectedItem()));

            }
        });

    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker

            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it

            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            final TextView txfecha = (TextView) getActivity().findViewById(R.id.Txtfecha);
            //System.out.println(day);
            String smonth = "";
            final String syear = String.valueOf(year);
            final String sday = String.valueOf(day);
            if(month==0){smonth=getResources().getString(R.string.enero);}
            if(month==1){smonth=getResources().getString(R.string.febrer);}
            if(month==2){smonth=getResources().getString(R.string.marzo);}
            if(month==3){smonth=getResources().getString(R.string.abril);}
            if(month==4){smonth=getResources().getString(R.string.mayo);}
            if(month==5){smonth=getResources().getString(R.string.juni);}
            if(month==6){smonth=getResources().getString(R.string.julio);}
            if(month==7){smonth=getResources().getString(R.string.agosto);}
            if(month==8){smonth=getResources().getString(R.string.septiem);}
            if(month==9){smonth=getResources().getString(R.string.octub);}
            if(month==10){smonth=getResources().getString(R.string.noviem);}
            if(month==11){smonth=getResources().getString(R.string.diciem);}
            Button btnsubmit = (Button) getActivity().findViewById(R.id.btnok);
            final String finalSmonth = smonth;
           // btnsubmit.setOnClickListener(new View.OnClickListener() {
              //  @Override
             //   public void onClick(View v) {
                    txfecha.setText(sday+" / "+ finalSmonth +" / "+syear);
               // }
            //});





        }
    }
    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {


        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
              TextView ciudad = (TextView) findViewById(R.id.Txtciudad);
               parent.getItemAtPosition(pos);
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        final TextView txtsexo = (TextView) findViewById(R.id.Txtsex);
        final TextView hobbies = (TextView) findViewById(R.id.Txthobbies);
        final TextView txciudad = (TextView) findViewById(R.id.Txtciudad);
        final TextView txfecha = (TextView) findViewById(R.id.Txtfecha);
        final TextView txtnombre = (TextView) findViewById(R.id.TxtNombre);
        final TextView txtcorreo = (TextView) findViewById(R.id.Txtcorreo);
        final TextView txttelefono = (TextView) findViewById(R.id.Txttelef);
        outState.putInt("banderacheck",flagh);
        outState.putString("sexo",txtsexo.getText().toString());
        outState.putString("hobb",hobbies.getText().toString());
        outState.putString("ciudad",txciudad.getText().toString());
        outState.putString("fecha",txfecha.getText().toString());

        outState.putString("nomb",txtnombre.getText().toString());
        outState.putString("correo",txtcorreo.getText().toString());
        outState.putString("telef",txttelefono.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        flagh = savedInstanceState.getInt("banderacheck",flagh);
        final TextView txtsexo = (TextView) findViewById(R.id.Txtsex);
        final TextView hobbies = (TextView) findViewById(R.id.Txthobbies);
        final TextView txciudad = (TextView) findViewById(R.id.Txtciudad);
        final TextView txfecha = (TextView) findViewById(R.id.Txtfecha);
        final TextView txtnombre = (TextView) findViewById(R.id.TxtNombre);
        final TextView txtcorreo = (TextView) findViewById(R.id.Txtcorreo);
        final TextView txttelefono = (TextView) findViewById(R.id.Txttelef);
        txtsexo.setText(savedInstanceState.getString("sexo"));
        hobbies.setText(savedInstanceState.getString("hobb"));
        txciudad.setText(savedInstanceState.getString("ciudad"));
        txfecha.setText(savedInstanceState.getString("fecha"));

        txtnombre.setText(savedInstanceState.getString("nomb"));
        txtcorreo.setText(savedInstanceState.getString("correo"));
        txttelefono.setText(savedInstanceState.getString("telef"));

    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
          newFragment.show(getFragmentManager(),"datePicker");

    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_feme:
                if (checked)
                    flag =1;
                break;
            case R.id.radio_masc:
                if (checked)
                    flag=2;
                break;
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_h1:
                if (checked){flagh=flagh+1;}
                // Put some meat on the sandwich
                else{flagh=flagh-1;}
                // Remove the meat
                break;
            case R.id.checkbox_h2:
                if (checked){flagh=flagh+2;}
                // Cheese me
                else{flagh=flagh-2;}
                // I'm lactose intolerant
                break;
            case R.id.checkbox_h3:
                if (checked){flagh=flagh+4;}
                // Cheese me
                else{flagh=flagh-4;}
                // I'm lactose intolerant
                break;
            case R.id.checkbox_h4:
                if (checked){flagh=flagh+8;}
                // Cheese me
                else{flagh=flagh-8;}
                // I'm lactose intolerant
                break;
            // TODO: Veggie sandwich
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
