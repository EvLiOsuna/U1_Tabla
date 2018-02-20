package mx.edu.ittepic.tablamultiplicar_u1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button boton;
    //EditText numero;
    TextView mostrar, numero;
    ListView lista;
    SeekBar barrita;
    String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = (Button) findViewById(R.id.button);

        numero = (TextView) findViewById(R.id.editText);

        mostrar = (TextView) findViewById(R.id.mostrar);



        barrita = (SeekBar) findViewById(R.id.barra);

        barrita.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar1,
                                                  int progress, boolean fromUser) {
                        numero.setText(String.valueOf(progress));
                    }

                    public void onStartTrackingTouch(SeekBar seekBar1) {
                    }

                    public void onStopTrackingTouch(SeekBar seekBar1) {
                    }
                }
        );


        a = numero.getText().toString();


        lista = (ListView) findViewById(R.id.LV);

        final String[] tabla = new String[] {
                "TABLA:"
        };

        final List<String> list = new ArrayList<String>(Arrays.asList(tabla));

         final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, list);

        lista.setAdapter(arrayAdapter);



        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                   // String n1 = numero.getText().toString();

                     int n1 = barrita.getProgress();

                    int n2 = n1;

                    String r = "";

                    for(int i = 1; i <= 12; i++){

                        int r1 = i * n2;

                        r = n1 + " x " + i + " = " + String.valueOf(r1) + '\n';

                        list.add(r);

                        arrayAdapter.notifyDataSetChanged();
                    }

                    //mostrar.setText(r);



                }

        });
    }
}
