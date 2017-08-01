package example.german.org.dacs.AddActivities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import example.german.org.dacs.Entities.Rol;
import example.german.org.dacs.Interfaces.RolAPIInterface;
import example.german.org.dacs.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by germa on 12/7/2017.
 */

public class AddRolActivity extends Activity {

    public static String BASE_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_rol);

        Bundle datos = getIntent().getExtras();

        BASE_URL = datos.getString("BASE_URL");

    }

    public void addRol(View vista){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RolAPIInterface apiService =
                retrofit.create(RolAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.nameNewRol);

        String name = editText.getText().toString();
        Call<Rol> call = apiService.addRol(name);
        call.enqueue(new Callback<Rol>() {
            @Override
            public void onResponse(Call<Rol> call, Response<Rol> response) {
                int statusCode = response.code();

                Rol rol = response.body();

                LinearLayout linear = (LinearLayout) findViewById(R.id.linearAddRol);

                TextView textView = new TextView(getBaseContext());

                String respuesta = new String("Agregado: "+ rol.getNombre());

                textView.setText(respuesta);

                linear.addView(textView);
            }

            @Override
            public void onFailure(Call<Rol> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText("fallo");
            }
        });

    }

    public void editRol(View vista){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RolAPIInterface apiService =
                retrofit.create(RolAPIInterface.class);

        EditText nameEditText = (EditText) findViewById(R.id.nameNewRol);
        EditText idEditText = (EditText) findViewById(R.id.inputEditRol);

        String name = nameEditText.getText().toString();
        int id = Integer.parseInt(idEditText.getText().toString());

        Call<Rol> call = apiService.editRol(id,name);
        call.enqueue(new Callback<Rol>() {
            @Override
            public void onResponse(Call<Rol> call, Response<Rol> response) {
                int statusCode = response.code();

                Rol rol = response.body();

                LinearLayout linear = (LinearLayout) findViewById(R.id.linearAddRol);

                TextView textView = new TextView(getBaseContext());

                String respuesta = new String("ACTUALIZADO: "+ rol.getNombre());

                textView.setText(respuesta);

                linear.addView(textView);
            }

            @Override
            public void onFailure(Call<Rol> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText("fallo");
            }
        });

    }

}
