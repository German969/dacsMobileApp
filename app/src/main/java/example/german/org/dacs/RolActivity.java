package example.german.org.dacs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import example.german.org.dacs.AddActivities.AddRolActivity;
import example.german.org.dacs.Entities.Rol;
import example.german.org.dacs.Interfaces.RolAPIInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by germa on 12/7/2017.
 */

public class RolActivity extends Activity {

    public static String BASE_URL;

    LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rol);

        Bundle datos = getIntent().getExtras();

        BASE_URL = datos.getString("BASE_URL");

        linear = (LinearLayout) findViewById(R.id.displayRoles);
    }

    public void findRolByName(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RolAPIInterface apiService =
                retrofit.create(RolAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.inputRolName);
        String name = editText.getText().toString();

        Call<Rol> call = apiService.getRolByName(name);

        call.enqueue(new Callback<Rol>() {
            @Override
            public void onResponse(Call<Rol> call, Response<Rol> response) {
                int statusCode = response.code();

                Rol rol = response.body();

                String respuesta = new String("Id: "+rol.getId()+" ; Nombre: "+rol.getNombre()+".");

                TextView textView = new TextView(getBaseContext());
                textView.setText(respuesta);
                linear.addView(textView);
            }

            @Override
            public void onFailure(Call<Rol> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = new TextView(getBaseContext());
                textView.setText("fallo");
                linear.addView(textView);
            }
        });

    }

    public void findRolById(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RolAPIInterface apiService =
                retrofit.create(RolAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.inputIdRol);
        int id = Integer.parseInt(editText.getText().toString());

        Call<Rol> call = apiService.getRol(id);

        call.enqueue(new Callback<Rol>() {
            @Override
            public void onResponse(Call<Rol> call, Response<Rol> response) {
                int statusCode = response.code();

                Rol rol = response.body();

                String respuesta = new String("Id: "+rol.getId()+" ; Nombre: "+rol.getNombre()+".");

                TextView textView = new TextView(getBaseContext());
                textView.setText(respuesta);
                linear.addView(textView);
            }

            @Override
            public void onFailure(Call<Rol> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = new TextView(getBaseContext());
                textView.setText("fallo");
                linear.addView(textView);
            }
        });

    }

    public void showAllRoles(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RolAPIInterface apiService =
                retrofit.create(RolAPIInterface.class);

        Call<List<Rol>> call = apiService.getRoles();
        call.enqueue(new Callback<List<Rol>>() {
            @Override
            public void onResponse(Call<List<Rol>> call, Response<List<Rol>> response) {
                int statusCode = response.code();

                List<Rol> roles = response.body();
                for (int i = 0 ; i < roles.size() ; i++) {

                    Rol rol = roles.get(i);

                    String respuesta = new String("Id: "+rol.getId()+" ; Nombre: "+rol.getNombre()+".");

                    TextView textView = new TextView(getBaseContext());
                    textView.setText(respuesta);
                    linear.addView(textView);
                }
            }

            @Override
            public void onFailure(Call<List<Rol>> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText("fallo");
            }
        });

    }

    public void deleteRol(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RolAPIInterface apiService =
                retrofit.create(RolAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.inputIdRol);
        int id = Integer.parseInt(editText.getText().toString());

        Call<Rol> call = apiService.deleteRol(id);

        call.enqueue(new Callback<Rol>() {
            @Override
            public void onResponse(Call<Rol> call, Response<Rol> response) {
                int statusCode = response.code();

                Rol rol = response.body();

                String respuesta = new String("DELETED: Id: "+rol.getId()+" ; Nombre: "+rol.getNombre()+".");

                TextView textView = new TextView(getBaseContext());
                textView.setText(respuesta);
                linear.addView(textView);


            }

            @Override
            public void onFailure(Call<Rol> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = new TextView(getBaseContext());
                textView.setText("fallo");
                linear.addView(textView);
            }
        });

    }

    public void deleteRolByName(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RolAPIInterface apiService =
                retrofit.create(RolAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.inputRolName);
        String name = editText.getText().toString();

        Call<Rol> call = apiService.deleteRolByName(name);

        call.enqueue(new Callback<Rol>() {
            @Override
            public void onResponse(Call<Rol> call, Response<Rol> response) {
                int statusCode = response.code();

                Rol rol = response.body();

                String respuesta = new String("DELETED: Id: "+rol.getId()+" ; Nombre: "+rol.getNombre()+".");

                TextView textView = new TextView(getBaseContext());
                textView.setText(respuesta);
                linear.addView(textView);


            }

            @Override
            public void onFailure(Call<Rol> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = new TextView(getBaseContext());
                textView.setText("fallo");
                linear.addView(textView);
            }
        });

    }

    public void ejecutar_add_rol(View view){

        Intent i = new Intent(this, AddRolActivity.class);

        i.putExtra("BASE_URL",BASE_URL);

        startActivity(i);

    }

}
