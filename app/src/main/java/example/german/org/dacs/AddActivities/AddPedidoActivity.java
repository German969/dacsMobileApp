package example.german.org.dacs.AddActivities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import example.german.org.dacs.Entities.Pedido;
import example.german.org.dacs.Entities.Rol;
import example.german.org.dacs.Interfaces.PedidoAPIInterface;
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

public class AddPedidoActivity extends Activity {

    public static String BASE_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_pedido);

        Bundle datos = getIntent().getExtras();

        BASE_URL = datos.getString("BASE_URL");

    }

    public void addPedido(View vista){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PedidoAPIInterface apiService =
                retrofit.create(PedidoAPIInterface.class);

        EditText fechaEditText = (EditText) findViewById(R.id.fechaNewPedido);
        EditText estadoEditText = (EditText) findViewById(R.id.estadoNewPedido);
        EditText usuarioEditText = (EditText) findViewById(R.id.usuarioNewPedido);
        EditText fechaPagoEditText = (EditText) findViewById(R.id.fechaPagoNewPedido);
        EditText mediodepagoEditText = (EditText) findViewById(R.id.mediodepagoNewPedido);

        /*SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Date fecha = null;
        try {
            fecha = formatter.parse(fechaEditText.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        String fecha = fechaEditText.getText().toString();

        String estado = estadoEditText.getText().toString();
        String usuario = usuarioEditText.getText().toString();

        /*Date fechaPago = null;
        try {
            fechaPago = formatter.parse(fechaPagoEditText.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        String fechaPago = fechaPagoEditText.getText().toString();

        String mediodepago = mediodepagoEditText.getText().toString();

        Call<Pedido> call = apiService.addPedido(fecha,estado,usuario,fechaPago,mediodepago);
        call.enqueue(new Callback<Pedido>() {
            @Override
            public void onResponse(Call<Pedido> call, Response<Pedido> response) {
                int statusCode = response.code();

                Pedido pedido = response.body();

                LinearLayout linear = (LinearLayout) findViewById(R.id.linearAddRol);

                TextView textView = new TextView(getBaseContext());

                String respuesta = new String("Agregado: Id: "+pedido.getId()+"; Fecha: "+pedido.getFecha()+" ; Cliente: "+pedido.getUsuario().getNombre()+".");

                textView.setText(respuesta);

                linear.addView(textView);
            }

            @Override
            public void onFailure(Call<Pedido> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText("fallo");
            }
        });

    }

    public void editPedido(View vista){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PedidoAPIInterface apiService =
                retrofit.create(PedidoAPIInterface.class);

        EditText fechaEditText = (EditText) findViewById(R.id.fechaNewPedido);
        EditText idEditText = (EditText) findViewById(R.id.inputEditPedido);
        EditText estadoEditText = (EditText) findViewById(R.id.estadoNewPedido);
        EditText usuarioEditText = (EditText) findViewById(R.id.usuarioNewPedido);
        EditText fechaPagoEditText = (EditText) findViewById(R.id.fechaPagoNewPedido);
        EditText mediodepagoEditText = (EditText) findViewById(R.id.mediodepagoNewPedido);

        int id = Integer.parseInt(idEditText.getText().toString());

        /*SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Date fecha = null;
        DateFormat df = DateFormat.getDateInstance();
        try {
            fecha = formatter.parse(fechaEditText.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        String fecha = fechaEditText.getText().toString();

        String estado = estadoEditText.getText().toString();
        String usuario = usuarioEditText.getText().toString();

        /*Date fechaPago = null;
        try {
            fechaPago = formatter.parse(fechaPagoEditText.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        String fechaPago = fechaPagoEditText.getText().toString();

        String mediodepago = mediodepagoEditText.getText().toString();

        Call<Pedido> call = apiService.editPedido(id,fecha,estado,usuario,fechaPago,mediodepago);
        call.enqueue(new Callback<Pedido>() {
            @Override
            public void onResponse(Call<Pedido> call, Response<Pedido> response) {
                int statusCode = response.code();

                Pedido pedido = response.body();

                LinearLayout linear = (LinearLayout) findViewById(R.id.linearAddPedido);

                TextView textView = new TextView(getBaseContext());

                String respuesta = new String("ACTUALIZADO: Id: "+pedido.getId()+"; Fecha: "+pedido.getFecha()+" ; Cliente: "+pedido.getUsuario().getNombre()+".");

                textView.setText(respuesta);

                linear.addView(textView);
            }

            @Override
            public void onFailure(Call<Pedido> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText("fallo");
            }
        });

    }

}
