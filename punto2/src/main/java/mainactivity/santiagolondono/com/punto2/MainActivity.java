package mainactivity.santiagolondono.com.punto2;

import android.content.Intent;
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

    EditText num1,num2;
    TextView result;
    Button boton;
    RadioButton sum,div,rest,mul;
    float op1,op2,resul;
    String total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1=(EditText) findViewById(R.id.eNum1);
        num2=(EditText) findViewById(R.id.eNum2);

        result=(TextView) findViewById(R.id.tResult);

        boton=(Button) findViewById(R.id.tBoton);
    }

    public  void Operacion(View view){

        boolean checked = ((RadioButton) view ).isChecked();

        switch (view.getId()){

            case R.id.rSum:
                if(checked){
                    suma();}
                break;

            case R.id.rRest:
                if(checked){


                    resta();}
                break;

            case R.id.rMul:
                if(checked){


                    multi();}
                break;

            case R.id.rDiv:
                if(checked){

                    division();}
                break;
        }

    }




    public void suma(){

        op1 = Float.parseFloat(num1.getText().toString());
        op2 = Float.parseFloat(num2.getText().toString());
        resul = op1+op2;


    }

    public void resta(){

        op1 = Float.parseFloat(num1.getText().toString());
        op2 = Float.parseFloat(num2.getText().toString());
        resul = op1-op2;



    }

    public void multi(){

        op1 = Float.parseFloat(num1.getText().toString());
        op2 = Float.parseFloat(num2.getText().toString());
        resul = op1*op2;



    }

    public void division(){

        op1 = Float.parseFloat(num1.getText().toString());
        op2 = Float.parseFloat(num2.getText().toString());
        resul = op1/op2;



    }

    public void Calcular(View view){
        String total= String.valueOf(resul);
        result.setText("Total: "+total);
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
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
