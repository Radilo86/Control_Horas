package radilo86.control_horas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BaseDatos {
    // This is the actual database
    private SQLiteDatabase bd;

    /*
        Next we have a public static final string for
        each row/table that we need to refer to both
        inside and outside this class
    */

    public static final String tablaFila_id = "id";
    public static final String tablaFila_dia = "dia";
    public static final String tablaFila_hora = "hora";
    public static final String tablaFila_estado = "estado";

    /*
        Next we have a private static final strings for
        each row/table that we need to refer to just
        inside this class
    */

    private static final String bd_nombre = "controlHoras";
    private static final int bd_version = 1;
    private static final String tablaNombre = "control";

    public BaseDatos(Context context) {
        // Create an instance of our internal CustomSQLiteOpenHelper
        CustomSQLiteOpenHelper helper = new CustomSQLiteOpenHelper(context);

        // Get a writable database
        bd = helper.getWritableDatabase();
    }



    // Here are all our helper methods
    // Insert a record
    public void insertar (String dia, String hora, String estado){
        // Add all the details to the table
        String query = "INSERT INTO " + tablaNombre + " (" +
                tablaFila_dia + ", " +
                tablaFila_hora + ", " +
                tablaFila_estado +
                ") " +
                "VALUES (" +
                "'" + dia + "'" + ", " +
                "'" + hora + "'" + ", " +
                "'" + estado + "'" +
                ");";

        Log.i("insert() = ", query);

        bd.execSQL(query);
    }


    /*
    // Delete a record
    public void delete(String name){
        // Delete the details from the table if already exists
        String query = "DELETE FROM " + tablaNombre +
                " WHERE " + tablaFila_dia +
                " = '" + name + "';";

        Log.i("delete() = ", query);

        bd.execSQL(query);
    }
    */


    // Get all the records
    public Cursor mostrarDatos() {
        Cursor cursor = bd.rawQuery("SELECT *" +" from " + tablaNombre, null);
        return cursor;
    }


    /*
    // Find a specific record
    public Cursor searchName(String name) {
        String query = "SELECT " +
                tablaFila_id + ", " +
                tablaFila_dia +
                ", " + tablaFila_hora +
                " from " +
                tablaNombre + " WHERE " +
                tablaFila_dia + " = '" + name + "';";

        Log.i("searchName() = ", query);

        Cursor c = bd.rawQuery(query, null);

        return c;
    }
     */


    // This class is created when our DataManager is initialized
    private class CustomSQLiteOpenHelper extends SQLiteOpenHelper {
        public CustomSQLiteOpenHelper(Context context) {
            super(context, bd_nombre, null, bd_version);
        }


        // This runs the first time the database is created
        @Override
        public void onCreate(SQLiteDatabase db) {
            // Create a table for photos and all their details
            String consulta = "create table "
                    + tablaNombre + " ("
                    + tablaFila_id
                    + " integer primary key autoincrement not null,"
                    + tablaFila_dia
                    + " text not null,"
                    + tablaFila_hora
                    + " text not null,"
                    + tablaFila_estado
                    + " text not null);";

            db.execSQL(consulta);
        }


        // This method only runs when we increment DB_VERSION
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Not needed in this app
            // but we must still override it
        }
    }
}
