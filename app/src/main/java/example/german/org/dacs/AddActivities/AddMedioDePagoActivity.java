package example.german.org.dacs.AddActivities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import example.german.org.dacs.Entities.MedioDePago;
import example.german.org.dacs.Entities.Rol;
import example.german.org.dacs.Interfaces.MedioDePagoAPIInterface;
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

public class AddMedioDePagoActivity extends Activity {

    public static String BASE_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_mediodepago);

        Bundle datos = getIntent().getExtras();

        BASE_URL = datos.getString("BASE_URL");

    }

    public void addMedioDePago(View vista){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MedioDePagoAPIInterface apiService =
                retrofit.create(MedioDePagoAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.nameNewMedioDePago);

        String name = editText.getText().toString();
        Call<MedioDePago> call = apiService.addMedioDePago(name);
        call.enqueue(new Callback<MedioDePago>() {
            @Override
            public void onResponse(Call<MedioDePago> call, Response<MedioDePago> response) {
                int statusCode = response.code();

                MedioDePago mp = response.body();

                LinearLayout linear = (LinearLayout) findViewById(R.id.linearAddMedioDePago);

                TextView textView = new TextView(getBaseContext());

                String respuesta = new String("Agregado: "+ mp.getNombre());

                textView.setText(respuesta);

                linear.addView(textView);
            }

            @Override
            public void onFailure(Call<MedioDePago> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText("fallo");
            }
        });

    }

    public void editMedioDePago(View vista){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MedioDePagoAPIInterface apiService =
                retrofit.create(MedioDePagoAPIInterface.class);

        EditText nameEditText = (EditText) findViewById(R.id.nameNewMedioDePago);
        EditText idEditText = (EditText) findViewById(R.id.inputEditMedioDePago);

        String name = nameEditText.getText().toString();
        int id = Integer.parseInt(idEditText.getText().toString());

        Call<MedioDePago> call = apiService.editMedioDePago(id,name);
        call.enqueue(new Callback<MedioDePago>() {
            @Override
            public void onResponse(Call<MedioDePago> call, Response<MedioDePago> response) {
                int statusCode = response.code();

                MedioDePago mp = response.body();

                LinearLayout linear = (LinearLayout) findViewById(R.id.linearAddMedioDePago);

                TextView textView = new TextView(getBaseContext());

                String respuesta = new String("ACTUALIZADO: "+ mp.getNombre());

                textView.setText(respuesta);

                linear.addView(textView);
            }

            @Override
            public void onFailure(Call<MedioDePago> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText("fallo");
            }
        });

    }

}
