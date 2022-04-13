package radilo86.control_horas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public void obtenerHora(View view) {
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

        // Obtenemos la posicion (GPS)
        /* https://www.youtube.com/watch?v=4Sk_lrseRa8 */



        // Mostramos los datos por pantalla
        TextView texto = findViewById(R.id.textView);
        texto.setText("La fecha es: " + diaActual + "\nLa hora es: " + horaActual
                + "\nLa ubicaciones es: ");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}