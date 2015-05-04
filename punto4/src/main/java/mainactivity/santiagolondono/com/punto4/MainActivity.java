package mainactivity.santiagolondono.com.punto4;

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


    RadioButton circle,square,triangle,rectangle;
    double op1,op2,resul;
    String total,valor1,valor2,vacio="",mensaje="Por favor ingrese los valores requeridos";
    TextView result,text1,text2,tit;
    EditText edit1,edit2;
    Button tot;
    String s1,s2="SELECCIONE FIGURA",message="Please input valid values";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circle=(RadioButton)findViewById(R.id.rcirculo);
        square=(RadioButton)findViewById(R.id.rcuadro);
        triangle=(RadioButton)findViewById(R.id.rtriangulo);
        rectangle=(RadioButton)findViewById(R.id.rrectangulo);


        edit1=(EditText) findViewById(R.id.eedit1);
        edit2=(EditText) findViewById(R.id.eedit2);

        text1=(TextView) findViewById(R.id.ttext1);
        text2=(TextView) findViewById(R.id.ttext2);
        result=(TextView) findViewById(R.id.tarea);
        tit=(TextView) findViewById(R.id.titulo);


        tot=(Button) findViewById(R.id.btot);
        s1=tit.getText().toString();


    }



    public  void Operacion(View view){

        boolean checked = ((RadioButton) view ).isChecked();

        switch (view.getId()){

            case R.id.rcuadro:
                if(checked){
                    ver_cuadro();
                }
                break;

            case R.id.rrectangulo:
                if(checked){


                    ver_triangulo();
                }
                break;

            case R.id.rtriangulo:
                if(checked){


                    ver_triangulo();
                }
                break;

            case R.id.rcirculo:
                if(checked){

                    ver_circulo();
                }
                break;
        }

    }

    public void ver_cuadro(){

        if((s2.equals(s1))){
        text1.setText("Lado(cm): ");}
        else text1.setText("Side(cm): ");
        text2.setText("");

    }

    public void area_cuadro(){


        op1 = Float.parseFloat(edit1.getText().toString());
        resul = op1*op1;



    }
    public void ver_circulo(){
        if((s2.equals(s1))){
        text1.setText("Radio(cm): ");}
        else text1.setText("Radius(cm): ");
        text2.setText("");
    }

    public void area_circulo(){


        op1 = Float.parseFloat(edit1.getText().toString());
        resul = 3.14*op1*op1;
    }

    public void ver_triangulo(){
        if((s2.equals(s1))){

        text2.setText("Altura(cm): "); }
        else {text2.setText("Height(cm): ");
    }  text1.setText("Base(cm): ");
}
    public void area_triangulo(){

        op1 = Float.parseFloat(edit1.getText().toString());
        op2 = Float.parseFloat(edit2.getText().toString());
        resul = op1*op2/2;


    }

    public void area_rectangulo(){


        op1 = Float.parseFloat(edit1.getText().toString());
        op2 = Float.parseFloat(edit2.getText().toString());
        resul = op1*op2;

    }




    public void Calcular(View view){

        valor1=edit1.getText().toString();
        valor2=edit2.getText().toString();


        if (square.isChecked()==true) {

            if((vacio.equals(valor1))) {
                if((s2.equals(s1)))
                result.setText(mensaje);
                else result.setText(message);
            }

            else {

                area_cuadro();
                String total = String.valueOf(resul);
                result.setText("Area: " + total + " cm x cm");
            }

        }
        if (circle.isChecked()==true) {

            if((vacio.equals(valor1))) {
                if((s2.equals(s1)))
                    result.setText(mensaje);
                else result.setText(message);}

            else {
                area_circulo();
                String total = String.valueOf(resul);
                result.setText("Area: " + total + " cm x cm");
            }

        }

        if (rectangle.isChecked()==true) {
            if((vacio.equals(valor1)||vacio.equals(valor2))){

                if((s2.equals(s1)))
                    result.setText(mensaje);
                else result.setText(message);}



            else {
                area_rectangulo();
                String total = String.valueOf(resul);
                result.setText("Area: " + total + " cm x cm");
            }

        }
        if (triangle.isChecked()==true) {
            if((vacio.equals(valor1)||vacio.equals(valor2)))
                if((s2.equals(s1)))
                    result.setText(mensaje);
                else result.setText(message);


            else {
                area_triangulo();
                String total = String.valueOf(resul);
                result.setText("Area: " + total + " cm x cm");
            }

        }

        // result.setText("Area: "+total+" cm x cm");


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
