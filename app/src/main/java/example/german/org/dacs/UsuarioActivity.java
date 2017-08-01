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
import example.german.org.dacs.AddActivities.AddUsuarioActivity;
import example.german.org.dacs.Entities.Rol;
import example.german.org.dacs.Entities.Usuario;
import example.german.org.dacs.Interfaces.RolAPIInterface;
import example.german.org.dacs.Interfaces.UsuarioAPIInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by germa on 12/7/2017.
 */

public class UsuarioActivity extends Activity {

    public static String BASE_URL;

    LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usuario);

        Bundle datos = getIntent().getExtras();

        BASE_URL = datos.getString("BASE_URL");

        linear = (LinearLayout) findViewById(R.id.displayUsuarios);
    }

    public void findUsuarioByName(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UsuarioAPIInterface apiService =
                retrofit.create(UsuarioAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.inputNameUsuario);
        String name = editText.getText().toString();

        Call<Usuario> call = apiService.getUsuarioByName(name);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                int statusCode = response.code();

                Usuario usuario = response.body();

                String respuesta = new String("Id: "+usuario.getId()+" ; Nombre: "+usuario.getNombre()+".");

                TextView textView = new TextView(getBaseContext());
                textView.setText(respuesta);
                linear.addView(textView);
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = new TextView(getBaseContext());
                textView.setText("fallo");
                linear.addView(textView);
            }
        });

    }

    public void findUsuarioById(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UsuarioAPIInterface apiService =
                retrofit.create(UsuarioAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.inputIdUsuario);
        int id = Integer.parseInt(editText.getText().toString());

        Call<Usuario> call = apiService.getUsuario(id);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                int statusCode = response.code();

                Usuario usuario = response.body();

                String respuesta = new String("Id: "+usuario.getId()+" ; Nombre: "+usuario.getNombre()+".");

                TextView textView = new TextView(getBaseContext());
                textView.setText(respuesta);
                linear.addView(textView);
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = new TextView(getBaseContext());
                textView.setText("fallo");
                linear.addView(textView);
            }
        });

    }

    public void showAllUsuarios(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UsuarioAPIInterface apiService =
                retrofit.create(UsuarioAPIInterface.class);

        Call<List<Usuario>> call = apiService.getUsuarios();
        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                int statusCode = response.code();

                List<Usuario> usuarios = response.body();
                for (int i = 0 ; i < usuarios.size() ; i++) {

                    Usuario usuario = usuarios.get(i);

                    String respuesta = new String("Id: "+usuario.getId()+" ; Nombre: "+usuario.getNombre()+".");

                    TextView textView = new TextView(getBaseContext());
                    textView.setText(respuesta);
                    linear.addView(textView);
                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText("fallo");
            }
        });

    }

    public void deleteUsuario(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UsuarioAPIInterface apiService =
                retrofit.create(UsuarioAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.inputIdUsuario);
        int id = Integer.parseInt(editText.getText().toString());

        Call<Usuario> call = apiService.deleteUsuario(id);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                int statusCode = response.code();

                Usuario usuario = response.body();

                String respuesta = new String("DELETED: Id: "+usuario.getId()+" ; Nombre: "+usuario.getNombre()+".");

                TextView textView = new TextView(getBaseContext());
                textView.setText(respuesta);
                linear.addView(textView);


            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = new TextView(getBaseContext());
                textView.setText("fallo");
                linear.addView(textView);
            }
        });

    }

    public void deleteUsuarioByName(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UsuarioAPIInterface apiService =
                retrofit.create(UsuarioAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.inputIdUsuario);
        String nombre = editText.getText().toString();

        Call<Usuario> call = apiService.deleteUsuarioByName(nombre);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                int statusCode = response.code();

                Usuario usuario = response.body();

                String respuesta = new String("DELETED: Id: "+usuario.getId()+" ; Nombre: "+usuario.getNombre()+".");

                TextView textView = new TextView(getBaseContext());
                textView.setText(respuesta);
                linear.addView(textView);


            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = new TextView(getBaseContext());
                textView.setText("fallo");
                linear.addView(textView);
            }
        });

    }

    public void ejecutar_add_usuario(View view){

        Intent i = new Intent(this, AddUsuarioActivity.class);

        i.putExtra("BASE_URL",BASE_URL);

        startActivity(i);

    }

}
