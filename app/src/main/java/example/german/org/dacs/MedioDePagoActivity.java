package example.german.org.dacs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import example.german.org.dacs.AddActivities.AddMedioDePagoActivity;
import example.german.org.dacs.AddActivities.AddRolActivity;
import example.german.org.dacs.Entities.MedioDePago;
import example.german.org.dacs.Entities.Rol;
import example.german.org.dacs.Interfaces.MedioDePagoAPIInterface;
import example.german.org.dacs.Interfaces.RolAPIInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by germa on 12/7/2017.
 */

public class MedioDePagoActivity extends Activity {

    public static String BASE_URL;

    LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medio_de_pago);

        Bundle datos = getIntent().getExtras();

        BASE_URL = datos.getString("BASE_URL");

        linear = (LinearLayout) findViewById(R.id.displayMediosDePago);
    }

    public void findMedioDePagoByName(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MedioDePagoAPIInterface apiService =
                retrofit.create(MedioDePagoAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.inputMedioDePagoName);
        String name = editText.getText().toString();

        Call<MedioDePago> call = apiService.getMedioDePagoByName(name);

        call.enqueue(new Callback<MedioDePago>() {
            @Override
            public void onResponse(Call<MedioDePago> call, Response<MedioDePago> response) {
                int statusCode = response.code();

                MedioDePago mp = response.body();

                String respuesta = new String("Id: "+mp.getId()+" ; Nombre: "+mp.getNombre()+".");

                TextView textView = new TextView(getBaseContext());
                textView.setText(respuesta);
                linear.addView(textView);
            }

            @Override
            public void onFailure(Call<MedioDePago> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = new TextView(getBaseContext());
                textView.setText("fallo");
                linear.addView(textView);
            }
        });

    }

    public void findMedioDePagoById(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MedioDePagoAPIInterface apiService =
                retrofit.create(MedioDePagoAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.inputIdMedioDePago);
        int id = Integer.parseInt(editText.getText().toString());

        Call<MedioDePago> call = apiService.getMedioDePago(id);

        call.enqueue(new Callback<MedioDePago>() {
            @Override
            public void onResponse(Call<MedioDePago> call, Response<MedioDePago> response) {
                int statusCode = response.code();

                MedioDePago mp = response.body();

                String respuesta = new String("Id: "+mp.getId()+" ; Nombre: "+mp.getNombre()+".");

                TextView textView = new TextView(getBaseContext());
                textView.setText(respuesta);
                linear.addView(textView);
            }

            @Override
            public void onFailure(Call<MedioDePago> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = new TextView(getBaseContext());
                textView.setText("fallo");
                linear.addView(textView);
            }
        });

    }

    public void showAllMediosDePago(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MedioDePagoAPIInterface apiService =
                retrofit.create(MedioDePagoAPIInterface.class);

        Call<List<MedioDePago>> call = apiService.getMediosDePago();
        call.enqueue(new Callback<List<MedioDePago>>() {
            @Override
            public void onResponse(Call<List<MedioDePago>> call, Response<List<MedioDePago>> response) {
                int statusCode = response.code();

                List<MedioDePago> mps = response.body();
                for (int i = 0 ; i < mps.size() ; i++) {

                    MedioDePago mp = mps.get(i);

                    String respuesta = new String("Id: "+mp.getId()+" ; Nombre: "+mp.getNombre()+".");

                    TextView textView = new TextView(getBaseContext());
                    textView.setText(respuesta);
                    linear.addView(textView);
                }
            }

            @Override
            public void onFailure(Call<List<MedioDePago>> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText("fallo");
            }
        });

    }

    public void deleteMedioDePago(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MedioDePagoAPIInterface apiService =
                retrofit.create(MedioDePagoAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.inputIdMedioDePago);
        int id = Integer.parseInt(editText.getText().toString());

        Call<MedioDePago> call = apiService.deleteMedioDePago(id);

        call.enqueue(new Callback<MedioDePago>() {
            @Override
            public void onResponse(Call<MedioDePago> call, Response<MedioDePago> response) {
                int statusCode = response.code();

                MedioDePago mp = response.body();

                String respuesta = new String("DELETED: Id: "+mp.getId()+" ; Nombre: "+mp.getNombre()+".");

                TextView textView = new TextView(getBaseContext());
                textView.setText(respuesta);
                linear.addView(textView);


            }

            @Override
            public void onFailure(Call<MedioDePago> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = new TextView(getBaseContext());
                textView.setText("fallo");
                linear.addView(textView);
            }
        });

    }

    public void deleteMedioDePagoByName(View vista){

        linear.removeAllViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MedioDePagoAPIInterface apiService =
                retrofit.create(MedioDePagoAPIInterface.class);

        EditText editText = (EditText) findViewById(R.id.inputMedioDePagoName);
        String name = editText.getText().toString();

        Call<MedioDePago> call = apiService.deleteMedioDePagoByName(name);

        call.enqueue(new Callback<MedioDePago>() {
            @Override
            public void onResponse(Call<MedioDePago> call, Response<MedioDePago> response) {
                int statusCode = response.code();

                MedioDePago mp = response.body();

                String respuesta = new String("DELETED: Id: "+mp.getId()+" ; Nombre: "+mp.getNombre()+".");

                TextView textView = new TextView(getBaseContext());
                textView.setText(respuesta);
                linear.addView(textView);


            }

            @Override
            public void onFailure(Call<MedioDePago> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = new TextView(getBaseContext());
                textView.setText("fallo");
                linear.addView(textView);
            }
        });

    }

    public void ejecutar_add_mediodepago(View view){

        Intent i = new Intent(this, AddMedioDePagoActivity.class);

        i.putExtra("BASE_URL",BASE_URL);

        startActivity(i);

    }

}
