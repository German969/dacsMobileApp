package example.german.org.dacs;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "http://192.168.0.4:8080/dacsREST/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


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

    public void ejecutar_usuario(View view){

        Intent i = new Intent(this, UsuarioActivity.class);

        i.putExtra("BASE_URL",BASE_URL);

        startActivity(i);

    }

    public void ejecutar_rol(View view){

        Intent i = new Intent(this, RolActivity.class);

        i.putExtra("BASE_URL",BASE_URL);

        startActivity(i);

    }

    public void ejecutar_proveedor(View view){

        Intent i = new Intent(this, ProveedorActivity.class);

        i.putExtra("BASE_URL",BASE_URL);

        startActivity(i);

    }

    public void ejecutar_producto(View view){

        Intent i = new Intent(this, ProductoActivity.class);

        i.putExtra("BASE_URL",BASE_URL);

        startActivity(i);

    }

    public void ejecutar_pedido(View view){

        Intent i = new Intent(this, PedidoActivity.class);

        i.putExtra("BASE_URL",BASE_URL);

        startActivity(i);

    }

    public void ejecutar_medioDePago(View view){

        Intent i = new Intent(this, MedioDePagoActivity.class);

        i.putExtra("BASE_URL",BASE_URL);

        startActivity(i);

    }

    public void ejecutar_categoria(View view){

        Intent i = new Intent(this, CategoriaActivity.class);

        i.putExtra("BASE_URL",BASE_URL);

        startActivity(i);

    }
}
