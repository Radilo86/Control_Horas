package radilo86.control_horas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {



    public void obtenerHora(View view) {

        BaseDatos baseDatosSQL = new BaseDatos(getApplicationContext());

        // Obtenemos el día actual
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        /*
            Date fecha = new Date();
            String diaActual = formatoFecha.format(fecha);
         */
        String diaActual = formatoFecha.format(new Date());

        // Obtenemos la hora actual
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        Date fechaActual = new Date(System.currentTimeMillis());
        String horaActual = formatoHora.format(fechaActual);
        // String horaActual = formatoHora.format(new Date(System.currentTimeMillis());

        // Obtenemos el estado
        String estado = "no implementado aun";

        // Obtenemos la posicion (GPS)
        /* https://www.youtube.com/watch?v=4Sk_lrseRa8 */

        baseDatosSQL.insertar(diaActual,horaActual,estado);

        // Mostramos los datos por pantalla
        TextView texto = findViewById(R.id.textView);
        texto.setText("La fecha es: " + diaActual + "\nLa hora es: " + horaActual
                + "\nLa ubicaciones es: ");
    }

    public void consultarDatos (View view){

        BaseDatos baseDatosSQL = new BaseDatos(getApplicationContext());

        // Get a reference to the TextView to show the results in
        TextView textResults = findViewById(R.id.textView);

        // Create and initialize a Cursor with all the results in
        Cursor c = baseDatosSQL.mostrarDatos();

        // A String to hold all the text
        String list = "";

        // Loop through the results in the Cursor
        while (c.moveToNext()){
            // Add the results to the String
            // with a little formatting
            list += c.getString(0) + " - " + (c.getString(1) + " - " + c.getString(2)
                    + " - " + c.getString(3) + "\n");
        }

        // Display the String in the TextView
        textResults.setText(list);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

}