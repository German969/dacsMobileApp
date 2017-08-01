package example.german.org.dacs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import example.german.org.dacs.AddActivities.AddProductoActivity;
import example.german.org.dacs.AddActivities.AddRolActivity;
import example.german.org.dacs.Entities.Producto;
import example.german.org.dacs.Entities.Rol;
import example.german.org.dacs.Interfaces.ProductoAPIInterface;
import example.german.org.dacs.Interfaces.RolAPIInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by germa on 12/7/2017.
 */

public class ProductoActivity extends Activity {

    public static String BASE_URL;

    LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.producto);

        Bundle datos = getIntent().getExtras();

        BASE_URL = datos.getString("BASE_URL");

        linear = (LinearLayout) findViewById(R.id.displayProductos);

    }

    public void findProductoByName(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProductoAPIInterface apiService =
                retrofit.create(ProductoAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.inputNameProducto);
        String name = editText.getText().toString();

        Call<Producto> call = apiService.getProductoByName(name);

        call.enqueue(new Callback<Producto>() {
            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {
                int statusCode = response.code();

                Producto producto = response.body();

                String respuesta = new String("Id: "+producto.getId()+" ; Nombre: "+producto.getNombre()+".");

                TextView textView = new TextView(getBaseContext());
                textView.setText(respuesta);
                linear.addView(textView);
            }

            @Override
            public void onFailure(Call<Producto> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = new TextView(getBaseContext());
                textView.setText("fallo");
                linear.addView(textView);
            }
        });

    }

    public void findProductoById(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProductoAPIInterface apiService =
                retrofit.create(ProductoAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.inputIdProducto);
        int id = Integer.parseInt(editText.getText().toString());

        Call<Producto> call = apiService.getProducto(id);

        call.enqueue(new Callback<Producto>() {
            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {
                int statusCode = response.code();

                Producto producto = response.body();

                String respuesta = new String("Id: "+producto.getId()+" ; Nombre: "+producto.getNombre()+".");

                TextView textView = new TextView(getBaseContext());
                textView.setText(respuesta);
                linear.addView(textView);
            }

            @Override
            public void onFailure(Call<Producto> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = new TextView(getBaseContext());
                textView.setText("fallo");
                linear.addView(textView);
            }
        });

    }

    public void showAllProductos(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProductoAPIInterface apiService =
                retrofit.create(ProductoAPIInterface.class);

        Call<List<Producto>> call = apiService.getProductos();
        call.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                int statusCode = response.code();

                List<Producto> productos = response.body();
                for (int i = 0 ; i < productos.size() ; i++) {

                    Producto producto = productos.get(i);

                    String respuesta = new String("Id: "+producto.getId()+" ; Nombre: "+producto.getNombre()+".");

                    TextView textView = new TextView(getBaseContext());
                    textView.setText(respuesta);
                    linear.addView(textView);
                }
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText("fallo");
            }
        });

    }

    public void deleteProductoById(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProductoAPIInterface apiService =
                retrofit.create(ProductoAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.inputIdProducto);
        int id = Integer.parseInt(editText.getText().toString());

        Call<Producto> call = apiService.deleteProducto(id);

        call.enqueue(new Callback<Producto>() {
            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {
                int statusCode = response.code();

                Producto producto = response.body();

                String respuesta = new String("DELETED: Id: "+producto.getId()+" ; Nombre: "+producto.getNombre()+".");

                TextView textView = new TextView(getBaseContext());
                textView.setText(respuesta);
                linear.addView(textView);


            }

            @Override
            public void onFailure(Call<Producto> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = new TextView(getBaseContext());
                textView.setText("fallo");
                linear.addView(textView);
            }
        });

    }

    public void deleteProductoByName(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProductoAPIInterface apiService =
                retrofit.create(ProductoAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.inputNameProducto);
        String name = editText.getText().toString();

        Call<Producto> call = apiService.deleteProductoByName(name);

        call.enqueue(new Callback<Producto>() {
            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {
                int statusCode = response.code();

                Producto producto = response.body();

                String respuesta = new String("DELETED: Id: "+producto.getId()+" ; Nombre: "+producto.getNombre()+".");

                TextView textView = new TextView(getBaseContext());
                textView.setText(respuesta);
                linear.addView(textView);


            }

            @Override
            public void onFailure(Call<Producto> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = new TextView(getBaseContext());
                textView.setText("fallo");
                linear.addView(textView);
            }
        });

    }

    public void ejecutar_add_producto(View view){

        Intent i = new Intent(this, AddProductoActivity.class);

        i.putExtra("BASE_URL",BASE_URL);

        startActivity(i);

    }

}
