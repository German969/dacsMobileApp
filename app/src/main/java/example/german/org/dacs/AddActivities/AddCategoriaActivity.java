package example.german.org.dacs.AddActivities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import example.german.org.dacs.Entities.Categoria;
import example.german.org.dacs.Entities.Rol;
import example.german.org.dacs.Interfaces.CategoriaAPIInterface;
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

public class AddCategoriaActivity extends Activity {

    public static String BASE_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_categoria);

        Bundle datos = getIntent().getExtras();

        BASE_URL = datos.getString("BASE_URL");

    }

    public void addCategoria(View vista){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CategoriaAPIInterface apiService =
                retrofit.create(CategoriaAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.nameNewCategoria);

        String name = editText.getText().toString();
        Call<Categoria> call = apiService.addCategoria(name);
        call.enqueue(new Callback<Categoria>() {
            @Override
            public void onResponse(Call<Categoria> call, Response<Categoria> response) {
                int statusCode = response.code();

                Categoria c = response.body();

                LinearLayout linear = (LinearLayout) findViewById(R.id.linearAddCategoria);

                TextView textView = new TextView(getBaseContext());

                String respuesta = new String("Agregado: "+ c.getNombre());

                textView.setText(respuesta);

                linear.addView(textView);
            }

            @Override
            public void onFailure(Call<Categoria> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText("fallo");
            }
        });

    }

    public void editCategoria(View vista){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CategoriaAPIInterface apiService =
                retrofit.create(CategoriaAPIInterface.class);

        EditText nameEditText = (EditText) findViewById(R.id.nameNewCategoria);
        EditText idEditText = (EditText) findViewById(R.id.inputEditCategoria);

        String name = nameEditText.getText().toString();
        int id = Integer.parseInt(idEditText.getText().toString());

        Call<Categoria> call = apiService.editCategoria(id,name);
        call.enqueue(new Callback<Categoria>() {
            @Override
            public void onResponse(Call<Categoria> call, Response<Categoria> response) {
                int statusCode = response.code();

                Categoria c = response.body();

                LinearLayout linear = (LinearLayout) findViewById(R.id.linearAddCategoria);

                TextView textView = new TextView(getBaseContext());

                String respuesta = new String("ACTUALIZADO: "+ c.getNombre());

                textView.setText(respuesta);

                linear.addView(textView);
            }

            @Override
            public void onFailure(Call<Categoria> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText("fallo");
            }
        });

    }

}
