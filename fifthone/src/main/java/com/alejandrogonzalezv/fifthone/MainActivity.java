package com.alejandrogonzalezv.fifthone;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;


public class MainActivity extends ActionBarActivity {
    int gyear=0;
    int gmonth=0;
    int gday = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifthone);

        EditText nombre = (EditText) findViewById(R.id.EdNombre);
        EditText correo = (EditText) findViewById(R.id.EdCorreo);
        EditText telefono = (EditText) findViewById(R.id.EdTelef);
        TextView txtnombre = (TextView) findViewById(R.id.TxtNombre);
        TextView txtcorreo = (TextView) findViewById(R.id.Txtcorreo);
        TextView txttelefono = (TextView) findViewById(R.id.Txttelef);
        TextView txtsexo = (TextView) findViewById(R.id.Txtsex);
        TextView hobbies = (TextView) findViewById(R.id.Txthobbies);

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
            TextView txfecha = (TextView) getActivity().findViewById(R.id.Txtfecha);
            //System.out.println(day);
            String smonth = String.valueOf(month+1);
            String syear = String.valueOf(year);
            String sday = String.valueOf(day);
            txfecha.setText(sday+" / "+smonth+" / "+syear);


        }
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
          newFragment.show(getFragmentManager(),"datePicker");

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
