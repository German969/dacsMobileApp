package example.german.org.dacs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import example.german.org.dacs.AddActivities.AddProveedorActivity;
import example.german.org.dacs.AddActivities.AddRolActivity;
import example.german.org.dacs.Entities.Proveedor;
import example.german.org.dacs.Entities.Rol;
import example.german.org.dacs.Interfaces.ProveedorAPIInterface;
import example.german.org.dacs.Interfaces.RolAPIInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by germa on 12/7/2017.
 */

public class ProveedorActivity extends Activity {

    public static String BASE_URL ;

    LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proveedor);

        Bundle datos = getIntent().getExtras();

        BASE_URL = datos.getString("BASE_URL");

        linear = (LinearLayout) findViewById(R.id.displayProveedores);
    }

    public void findProveedorByName(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProveedorAPIInterface apiService =
                retrofit.create(ProveedorAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.inputNameProveedor);
        String name = editText.getText().toString();

        Call<Proveedor> call = apiService.getProveedorByName(name);

        call.enqueue(new Callback<Proveedor>() {
            @Override
            public void onResponse(Call<Proveedor> call, Response<Proveedor> response) {
                int statusCode = response.code();

                Proveedor p = response.body();

                String respuesta = new String("Id: "+p.getId()+" ; Nombre: "+p.getNombre()+".");

                TextView textView = new TextView(getBaseContext());
                textView.setText(respuesta);
                linear.addView(textView);
            }

            @Override
            public void onFailure(Call<Proveedor> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = new TextView(getBaseContext());
                textView.setText("fallo");
                linear.addView(textView);
            }
        });

    }

    public void findProveedorById(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProveedorAPIInterface apiService =
                retrofit.create(ProveedorAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.inputIdProveedor);
        int id = Integer.parseInt(editText.getText().toString());

        Call<Proveedor> call = apiService.getProveedor(id);

        call.enqueue(new Callback<Proveedor>() {
            @Override
            public void onResponse(Call<Proveedor> call, Response<Proveedor> response) {
                int statusCode = response.code();

                Proveedor p = response.body();

                String respuesta = new String("Id: "+p.getId()+" ; Nombre: "+p.getNombre()+".");

                TextView textView = new TextView(getBaseContext());
                textView.setText(respuesta);
                linear.addView(textView);
            }

            @Override
            public void onFailure(Call<Proveedor> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = new TextView(getBaseContext());
                textView.setText("fallo");
                linear.addView(textView);
            }
        });

    }

    public void showAllProveedores(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProveedorAPIInterface apiService =
                retrofit.create(ProveedorAPIInterface.class);

        Call<List<Proveedor>> call = apiService.getProveedores();
        call.enqueue(new Callback<List<Proveedor>>() {
            @Override
            public void onResponse(Call<List<Proveedor>> call, Response<List<Proveedor>> response) {
                int statusCode = response.code();

                List<Proveedor> proveedores = response.body();
                for (int i = 0 ; i < proveedores.size() ; i++) {

                    Proveedor proveedor = proveedores.get(i);

                    String respuesta = new String("Id: "+proveedor.getId()+" ; Nombre: "+proveedor.getNombre()+".");

                    TextView textView = new TextView(getBaseContext());
                    textView.setText(respuesta);
                    linear.addView(textView);
                }
            }

            @Override
            public void onFailure(Call<List<Proveedor>> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText("fallo");
            }
        });

    }

    public void deleteProveedor(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProveedorAPIInterface apiService =
                retrofit.create(ProveedorAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.inputIdProveedor);
        int id = Integer.parseInt(editText.getText().toString());

        Call<Proveedor> call = apiService.deleteProveedor(id);

        call.enqueue(new Callback<Proveedor>() {
            @Override
            public void onResponse(Call<Proveedor> call, Response<Proveedor> response) {
                int statusCode = response.code();

                Proveedor p = response.body();

                String respuesta = new String("DELETED: Id: "+p.getId()+" ; Nombre: "+p.getNombre()+".");

                TextView textView = new TextView(getBaseContext());
                textView.setText(respuesta);
                linear.addView(textView);


            }

            @Override
            public void onFailure(Call<Proveedor> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = new TextView(getBaseContext());
                textView.setText("fallo");
                linear.addView(textView);
            }
        });

    }

    public void deleteProveedorByName(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProveedorAPIInterface apiService =
                retrofit.create(ProveedorAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.inputNameProveedor);
        String name = editText.getText().toString();

        Call<Proveedor> call = apiService.deleteProveedorByName(name);

        call.enqueue(new Callback<Proveedor>() {
            @Override
            public void onResponse(Call<Proveedor> call, Response<Proveedor> response) {
                int statusCode = response.code();

                Proveedor proveedor = response.body();

                String respuesta = new String("DELETED: Id: "+proveedor.getId()+" ; Nombre: "+proveedor.getNombre()+".");

                TextView textView = new TextView(getBaseContext());
                textView.setText(respuesta);
                linear.addView(textView);


            }

            @Override
            public void onFailure(Call<Proveedor> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = new TextView(getBaseContext());
                textView.setText("fallo");
                linear.addView(textView);
            }
        });

    }

    public void ejecutar_add_proveedor(View view){

        Intent i = new Intent(this, AddProveedorActivity.class);

        i.putExtra("BASE_URL",BASE_URL);

        startActivity(i);

    }

}
