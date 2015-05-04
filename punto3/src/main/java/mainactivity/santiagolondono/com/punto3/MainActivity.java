package mainactivity.santiagolondono.com.punto3;

import android.content.Intent;
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

    EditText quiz,expo,lab,proy;
    TextView result;
    Button boton,boton_about;
    double opq,ope,opl,opp,resul;
    String total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quiz = (EditText) findViewById(R.id.eQuiz);
        expo = (EditText) findViewById(R.id.eExpo);
        lab = (EditText) findViewById(R.id.eLab);
        proy = (EditText) findViewById(R.id.eProy);

        boton= (Button) findViewById(R.id.tBoton);
       // boton_about= (Button) findViewById(R.id.tAbout);

        result=(TextView) findViewById(R.id.tResult);
    }

    public MainActivity() {
        super();
    }






    public void Calcular(View view){

        opq = Float.parseFloat(quiz.getText().toString());
        ope = Float.parseFloat(expo.getText().toString());
        opl = Float.parseFloat(lab.getText().toString());
        opp = Float.parseFloat(proy.getText().toString());
        resul = opq*0.15+ope*0.1+opl*0.4+opp*0.35;
        String total= String.valueOf(resul);
        result.setText(total);
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
      /*  if (id == R.id.action_settings) {
            return  true;

        }*/

        if (id == R.id.about){

            Intent i =new Intent(this,activity_about.class);
            startActivity(i);
        }




        return super.onOptionsItemSelected(item);
    }
}
