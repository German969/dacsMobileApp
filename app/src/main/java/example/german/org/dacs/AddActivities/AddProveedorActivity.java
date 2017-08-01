package example.german.org.dacs.AddActivities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import example.german.org.dacs.Entities.Proveedor;
import example.german.org.dacs.Entities.Rol;
import example.german.org.dacs.Interfaces.ProveedorAPIInterface;
import example.german.org.dacs.Interfaces.RolAPIInterface;
import example.german.org.dacs.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by germa on 1/8/2017.
 */

public class AddProveedorActivity extends Activity {

    public static String BASE_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_proveedor);

        Bundle datos = getIntent().getExtras();

        BASE_URL = datos.getString("BASE_URL");

    }

    public void addProveedor(View vista){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProveedorAPIInterface apiService =
                retrofit.create(ProveedorAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.nameNewProveedor);

        String name = editText.getText().toString();
        Call<Proveedor> call = apiService.addProveedor(name);
        call.enqueue(new Callback<Proveedor>() {
            @Override
            public void onResponse(Call<Proveedor> call, Response<Proveedor> response) {
                int statusCode = response.code();

                Proveedor p = response.body();

                LinearLayout linear = (LinearLayout) findViewById(R.id.linearAddProveedor);

                TextView textView = new TextView(getBaseContext());

                String respuesta = new String("Agregado: "+ p.getNombre());

                textView.setText(respuesta);

                linear.addView(textView);
            }

            @Override
            public void onFailure(Call<Proveedor> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText("fallo");
            }
        });

    }

    public void editProveedor(View vista){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProveedorAPIInterface apiService =
                retrofit.create(ProveedorAPIInterface.class);

        EditText nameEditText = (EditText) findViewById(R.id.nameNewProveedor);
        EditText idEditText = (EditText) findViewById(R.id.inputEditProveedor);

        String name = nameEditText.getText().toString();
        int id = Integer.parseInt(idEditText.getText().toString());

        Call<Proveedor> call = apiService.editProveedor(id,name);
        call.enqueue(new Callback<Proveedor>() {
            @Override
            public void onResponse(Call<Proveedor> call, Response<Proveedor> response) {
                int statusCode = response.code();

                Proveedor p = response.body();

                LinearLayout linear = (LinearLayout) findViewById(R.id.linearAddProveedor);

                TextView textView = new TextView(getBaseContext());

                String respuesta = new String("ACTUALIZADO: "+ p.getNombre());

                textView.setText(respuesta);

                linear.addView(textView);
            }

            @Override
            public void onFailure(Call<Proveedor> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText("fallo");
            }
        });

    }

}
