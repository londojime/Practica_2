package mainactivity.santiagolondono.com.punto5;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;


public class MainActivity extends ActionBarActivity {

    TextView tvDisplayDate, nombre,telefono,correo,hobbies,sexo,text_spin,cities,fecha,nom;
    EditText name,phone,mail;
    DatePicker dpResult;
    Button botf;
    DatePicker date;
    DateFormat formate=DateFormat.getDateInstance();
    Calendar calendar= Calendar.getInstance();
    String total,hd,hb,hm,ho,sex="",sp,s1,s2="Nombre";
    CheckBox sport,music,dance,other;
    RadioButton female,male;
    Spinner spinner;


    int year;
    int month;
    int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.eNombre);
        phone = (EditText) findViewById(R.id.eTel);
        mail = (EditText) findViewById(R.id.eCorreo);

        nombre=(TextView) findViewById(R.id.tNombre);
        telefono=(TextView) findViewById(R.id.tTel);
        correo=(TextView) findViewById(R.id.tCorreo);
        hobbies=(TextView) findViewById(R.id.tHobbies);
        sexo=(TextView) findViewById(R.id.tsex);
        cities=(TextView) findViewById(R.id.tcity);
        nom=(TextView) findViewById(R.id.tname);


        sport=(CheckBox)findViewById(R.id.cdeporte);
        music=(CheckBox)findViewById(R.id.cmusica);
        dance=(CheckBox)findViewById(R.id.cbailar);
        other=(CheckBox)findViewById(R.id.cotro);

        male=(RadioButton)findViewById(R.id.rMale);
        female=(RadioButton) findViewById(R.id.rFemale);

        spinner = (Spinner) findViewById(R.id.spinner1);

        fecha=(TextView) findViewById(R.id.tfecha);

        botf=(Button) findViewById(R.id.bDate);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.ciudades,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        s1=nom.getText().toString();

    }

    DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            calendar.set(Calendar.YEAR,year);
            calendar.set(Calendar.MONTH,monthOfYear);
            calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);


        }
    };



    public void Fijar(View v){
        new DatePickerDialog(MainActivity.this,d,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();

    }

    public void onItemSelected(AdapterView<?> parent, View view,int position,long id){

        text_spin=(TextView) view;
        sp=String.valueOf((TextView) view);
    }

    public  void Operacion(View view){

        boolean checked = ((RadioButton) view ).isChecked();

        switch (view.getId()){

            case R.id.rMale:
                if(checked){
                    if((s2.equals(s1)))
                    sex="Masculino";
                else sex="Male";}
                break;

            case R.id.rFemale:
                if(checked){
                    if((s2.equals(s1)))
                        sex="Femenino";
                else
                    sex="Female";}
                break;

        }

    }

    public void Listo(View view){

        if (sport.isChecked()==true) {
            if((s2.equals(s1)))
            hd="Deporte ";
            else hd="Sports ";

        }
        else hd="";

        if (music.isChecked()==true) {
            if((s2.equals(s1)))
            hm="Musica ";
            else hm="Music ";

        }
        else hm="";

        if (dance.isChecked()==true) {
            if((s2.equals(s1)))
            hb="Bailar ";
            else hb="Dance ";

        }
        else hb="";

        if (other.isChecked()==true) {
            if((s2.equals(s1)))
            ho="Otro ";
            else ho="Other ";

        }
        else ho="";

        if((s2.equals(s1))){
        total=name.getText().toString();
        nombre.setText("Nombre: "+total);
        total=phone.getText().toString();
        telefono.setText("Telefono: "+total);
        total=mail.getText().toString();
        correo.setText("Correo: "+total);
        hobbies.setText("Hobbies: "+hd+hm+hb+ho);
        sexo.setText("Sexo: "+sex);
        sp=spinner.getSelectedItem().toString();
        cities.setText("Ciudad: "+sp);
        fecha.setText("Fecha de nacimiento: "+formate.format(calendar.getTime()));}

        else{
            total=name.getText().toString();
            nombre.setText("Name: "+total);
            total=phone.getText().toString();
            telefono.setText("Phone: "+total);
            total=mail.getText().toString();
            correo.setText("Mail: "+total);
            hobbies.setText("Hobbies: "+hd+hm+hb+ho);
            sexo.setText("Sex: "+sex);
            sp=spinner.getSelectedItem().toString();
            cities.setText("City: "+sp);
            fecha.setText("Date of birth: "+formate.format(calendar.getTime()));
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
        if (id == R.id.about) {
            Intent i =new Intent(this,activity_about.class);
            startActivity(i);        }

        return super.onOptionsItemSelected(item);
    }
}
