package example.german.org.dacs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import example.german.org.dacs.AddActivities.AddPedidoActivity;
import example.german.org.dacs.AddActivities.AddRolActivity;
import example.german.org.dacs.Entities.Pedido;
import example.german.org.dacs.Entities.Rol;
import example.german.org.dacs.Interfaces.PedidoAPIInterface;
import example.german.org.dacs.Interfaces.RolAPIInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by germa on 12/7/2017.
 */

public class PedidoActivity extends Activity {

    public static String BASE_URL ;

    LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedido);

        Bundle datos = getIntent().getExtras();

        BASE_URL = datos.getString("BASE_URL");

        linear = (LinearLayout) findViewById(R.id.displayPedidos);

    }

    public void findPedidoById(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PedidoAPIInterface apiService =
                retrofit.create(PedidoAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.inputIdPedido);
        int id = Integer.parseInt(editText.getText().toString());

        Call<Pedido> call = apiService.getPedido(id);

        call.enqueue(new Callback<Pedido>() {
            @Override
            public void onResponse(Call<Pedido> call, Response<Pedido> response) {
                int statusCode = response.code();

                Pedido pedido = response.body();

                String respuesta = new String("Id: "+pedido.getId()+".");

                TextView textView = new TextView(getBaseContext());
                textView.setText(respuesta);
                linear.addView(textView);
            }

            @Override
            public void onFailure(Call<Pedido> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = new TextView(getBaseContext());
                textView.setText("fallo");
                linear.addView(textView);
            }
        });

    }

    public void showAllPedidos(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PedidoAPIInterface apiService =
                retrofit.create(PedidoAPIInterface.class);

        Call<List<Pedido>> call = apiService.getPedidos();
        call.enqueue(new Callback<List<Pedido>>() {
            @Override
            public void onResponse(Call<List<Pedido>> call, Response<List<Pedido>> response) {
                int statusCode = response.code();

                List<Pedido> pedidos = response.body();
                for (int i = 0 ; i < pedidos.size() ; i++) {

                    Pedido pedido = pedidos.get(i);

                    String respuesta = new String("Id: "+pedido.getId()+"; Fecha: "+pedido.getFecha()+".");

                    TextView textView = new TextView(getBaseContext());
                    textView.setText(respuesta);
                    linear.addView(textView);
                }
            }

            @Override
            public void onFailure(Call<List<Pedido>> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText("fallo");
            }
        });

    }

    public void deletePedido(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PedidoAPIInterface apiService =
                retrofit.create(PedidoAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.inputIdPedido);
        int id = Integer.parseInt(editText.getText().toString());

        Call<Pedido> call = apiService.deletePedido(id);

        call.enqueue(new Callback<Pedido>() {
            @Override
            public void onResponse(Call<Pedido> call, Response<Pedido> response) {
                int statusCode = response.code();

                Pedido pedido = response.body();

                String respuesta = new String("DELETED: Id: "+pedido.getId()+"; Fecha: "+pedido.getFecha()+" ; Cliente: "+pedido.getUsuario().getNombre()+".");

                TextView textView = new TextView(getBaseContext());
                textView.setText(respuesta);
                linear.addView(textView);


            }

            @Override
            public void onFailure(Call<Pedido> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = new TextView(getBaseContext());
                textView.setText("fallo");
                linear.addView(textView);
            }
        });

    }

    public void ejecutar_add_pedido(View view){

        Intent i = new Intent(this, AddPedidoActivity.class);

        i.putExtra("BASE_URL",BASE_URL);

        startActivity(i);

    }

}
