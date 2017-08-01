package example.german.org.dacs.AddActivities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import example.german.org.dacs.Entities.Producto;
import example.german.org.dacs.Entities.Rol;
import example.german.org.dacs.Interfaces.ProductoAPIInterface;
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

public class AddProductoActivity extends Activity {

    public static String BASE_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_producto);

        Bundle datos = getIntent().getExtras();

        BASE_URL = datos.getString("BASE_URL");

    }

    public void addProducto(View vista){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProductoAPIInterface apiService =
                retrofit.create(ProductoAPIInterface.class);

        EditText nameEditText = (EditText) findViewById(R.id.nameNewProducto);
        EditText marcaEditText = (EditText) findViewById(R.id.marcaNewProducto);
        EditText descripcionEditText = (EditText) findViewById(R.id.descripcionNewProducto);
        EditText precioEditText = (EditText) findViewById(R.id.precioNewProducto);
        EditText comisionEditText = (EditText) findViewById(R.id.comisionNewProducto);
        EditText stockEditText = (EditText) findViewById(R.id.stockNewProducto);
        EditText categoriaEditText = (EditText) findViewById(R.id.categoriaNewProducto);
        EditText proveedorEditText = (EditText) findViewById(R.id.proveedorNewProducto);

        String name = nameEditText.getText().toString();
        String marca = marcaEditText.getText().toString();
        String descripcion = descripcionEditText.getText().toString();
        float precio = Float.parseFloat(precioEditText.getText().toString());
        float comision = Float.parseFloat(comisionEditText.getText().toString());
        int stock = Integer.parseInt(stockEditText.getText().toString());
        String categoria = categoriaEditText.getText().toString();
        String proveedor = proveedorEditText.getText().toString();

        Call<Producto> call = apiService.addProducto(name,marca,descripcion,precio,comision,stock,categoria,proveedor);
        call.enqueue(new Callback<Producto>() {
            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {
                int statusCode = response.code();

                Producto producto = response.body();

                LinearLayout linear = (LinearLayout) findViewById(R.id.linearAddProducto);

                TextView textView = new TextView(getBaseContext());

                String respuesta = new String("Agregado: "+ producto.getNombre());

                textView.setText(respuesta);

                linear.addView(textView);
            }

            @Override
            public void onFailure(Call<Producto> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText("fallo");
            }
        });

    }

    public void editProducto(View vista){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProductoAPIInterface apiService =
                retrofit.create(ProductoAPIInterface.class);

        EditText nameEditText = (EditText) findViewById(R.id.nameNewProducto);
        EditText idEditText = (EditText) findViewById(R.id.inputEditProducto);
        EditText marcaEditText = (EditText) findViewById(R.id.marcaNewProducto);
        EditText descripcionEditText = (EditText) findViewById(R.id.descripcionNewProducto);
        EditText precioEditText = (EditText) findViewById(R.id.precioNewProducto);
        EditText comisionEditText = (EditText) findViewById(R.id.comisionNewProducto);
        EditText stockEditText = (EditText) findViewById(R.id.stockNewProducto);
        EditText categoriaEditText = (EditText) findViewById(R.id.categoriaNewProducto);
        EditText proveedorEditText = (EditText) findViewById(R.id.proveedorNewProducto);

        String name = nameEditText.getText().toString();
        int id = Integer.parseInt(idEditText.getText().toString());
        String marca = marcaEditText.getText().toString();
        String descripcion = descripcionEditText.getText().toString();
        float precio = Float.parseFloat(precioEditText.getText().toString());
        float comision = Float.parseFloat(comisionEditText.getText().toString());
        int stock = Integer.parseInt(stockEditText.getText().toString());
        String categoria = categoriaEditText.getText().toString();
        String proveedor = proveedorEditText.getText().toString();

        Call<Producto> call = apiService.editProducto(id,name,marca,descripcion,precio,comision,stock,categoria,proveedor);
        call.enqueue(new Callback<Producto>() {
            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {
                int statusCode = response.code();

                Producto producto = response.body();

                LinearLayout linear = (LinearLayout) findViewById(R.id.linearAddProducto);

                TextView textView = new TextView(getBaseContext());

                String respuesta = new String("ACTUALIZADO: "+ producto.getNombre());

                textView.setText(respuesta);

                linear.addView(textView);
            }

            @Override
            public void onFailure(Call<Producto> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText("fallo");
            }
        });

    }

}
