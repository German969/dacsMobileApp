package example.german.org.dacs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import example.german.org.dacs.AddActivities.AddCategoriaActivity;
import example.german.org.dacs.AddActivities.AddRolActivity;
import example.german.org.dacs.Entities.Categoria;
import example.german.org.dacs.Entities.Rol;
import example.german.org.dacs.Interfaces.CategoriaAPIInterface;
import example.german.org.dacs.Interfaces.RolAPIInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by germa on 12/7/2017.
 */

public class CategoriaActivity extends Activity {

    public static String BASE_URL;

    LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categoria);

        Bundle datos = getIntent().getExtras();

        BASE_URL = datos.getString("BASE_URL");

        linear = (LinearLayout) findViewById(R.id.displayCategorias);
    }

    public void findCategoriaByName(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CategoriaAPIInterface apiService =
                retrofit.create(CategoriaAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.inputCategoriaName);
        String name = editText.getText().toString();

        Call<Categoria> call = apiService.getCategoriaByName(name);

        call.enqueue(new Callback<Categoria>() {
            @Override
            public void onResponse(Call<Categoria> call, Response<Categoria> response) {
                int statusCode = response.code();

                Categoria c = response.body();

                String respuesta = new String("Id: "+c.getId()+" ; Nombre: "+c.getNombre()+".");

                TextView textView = new TextView(getBaseContext());
                textView.setText(respuesta);
                linear.addView(textView);
            }

            @Override
            public void onFailure(Call<Categoria> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = new TextView(getBaseContext());
                textView.setText("fallo");
                linear.addView(textView);
            }
        });

    }

    public void findCategoriaById(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CategoriaAPIInterface apiService =
                retrofit.create(CategoriaAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.inputIdCategoria);
        int id = Integer.parseInt(editText.getText().toString());

        Call<Categoria> call = apiService.getCategoria(id);

        call.enqueue(new Callback<Categoria>() {
            @Override
            public void onResponse(Call<Categoria> call, Response<Categoria> response) {
                int statusCode = response.code();

                Categoria c = response.body();

                String respuesta = new String("Id: "+c.getId()+" ; Nombre: "+c.getNombre()+".");

                TextView textView = new TextView(getBaseContext());
                textView.setText(respuesta);
                linear.addView(textView);
            }

            @Override
            public void onFailure(Call<Categoria> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = new TextView(getBaseContext());
                textView.setText("fallo");
                linear.addView(textView);
            }
        });

    }

    public void showAllCategorias(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CategoriaAPIInterface apiService =
                retrofit.create(CategoriaAPIInterface.class);

        Call<List<Categoria>> call = apiService.getCategorias();
        call.enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                int statusCode = response.code();

                List<Categoria> categorias = response.body();
                for (int i = 0 ; i < categorias.size() ; i++) {

                    Categoria c = categorias.get(i);

                    String respuesta = new String("Id: "+c.getId()+" ; Nombre: "+c.getNombre()+".");

                    TextView textView = new TextView(getBaseContext());
                    textView.setText(respuesta);
                    linear.addView(textView);
                }
            }

            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText("fallo");
            }
        });

    }

    public void deleteCategoria(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CategoriaAPIInterface apiService =
                retrofit.create(CategoriaAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.inputIdCategoria);
        int id = Integer.parseInt(editText.getText().toString());

        Call<Categoria> call = apiService.deleteCategoria(id);

        call.enqueue(new Callback<Categoria>() {
            @Override
            public void onResponse(Call<Categoria> call, Response<Categoria> response) {
                int statusCode = response.code();

                Categoria c = response.body();

                String respuesta = new String("DELETED: Id: "+c.getId()+" ; Nombre: "+c.getNombre()+".");

                TextView textView = new TextView(getBaseContext());
                textView.setText(respuesta);
                linear.addView(textView);


            }

            @Override
            public void onFailure(Call<Categoria> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = new TextView(getBaseContext());
                textView.setText("fallo");
                linear.addView(textView);
            }
        });

    }

    public void deleteCategoriaByName(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CategoriaAPIInterface apiService =
                retrofit.create(CategoriaAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.inputCategoriaName);
        String name = editText.getText().toString();

        Call<Categoria> call = apiService.deleteCategoriaByName(name);

        call.enqueue(new Callback<Categoria>() {
            @Override
            public void onResponse(Call<Categoria> call, Response<Categoria> response) {
                int statusCode = response.code();

                Categoria c = response.body();

                String respuesta = new String("DELETED: Id: "+c.getId()+" ; Nombre: "+c.getNombre()+".");

                TextView textView = new TextView(getBaseContext());
                textView.setText(respuesta);
                linear.addView(textView);


            }

            @Override
            public void onFailure(Call<Categoria> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = new TextView(getBaseContext());
                textView.setText("fallo");
                linear.addView(textView);
            }
        });

    }

    public void ejecutar_add_categoria(View view){

        Intent i = new Intent(this, AddCategoriaActivity.class);

        i.putExtra("BASE_URL",BASE_URL);

        startActivity(i);

    }

}
