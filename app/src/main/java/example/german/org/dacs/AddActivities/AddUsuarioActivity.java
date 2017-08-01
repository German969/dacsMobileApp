package example.german.org.dacs.AddActivities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import example.german.org.dacs.Entities.Rol;
import example.german.org.dacs.Entities.Usuario;
import example.german.org.dacs.Interfaces.RolAPIInterface;
import example.german.org.dacs.Interfaces.UsuarioAPIInterface;
import example.german.org.dacs.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static example.german.org.dacs.R.layout.rol;

/**
 * Created by germa on 12/7/2017.
 */

public class AddUsuarioActivity extends Activity {

    public static String BASE_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_usuario);

        Bundle datos = getIntent().getExtras();

        BASE_URL = datos.getString("BASE_URL");

    }

    public void addUsuario(View vista){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UsuarioAPIInterface apiService =
                retrofit.create(UsuarioAPIInterface.class);

        EditText nameEditText = (EditText) findViewById(R.id.nameNewUsuario);
        EditText apellidoEditText = (EditText) findViewById(R.id.apellidoNewUsuario);
        EditText cuitEditText = (EditText) findViewById(R.id.cuitNewUsuario);
        EditText emailEditText = (EditText) findViewById(R.id.emailNewUsuario);
        EditText userEditText = (EditText) findViewById(R.id.userNewUsuario);
        EditText passwordEditText = (EditText) findViewById(R.id.passwordNewUsuario);
        EditText telefonoEditText = (EditText) findViewById(R.id.telefonoNewUsuario);
        EditText paisEditText = (EditText) findViewById(R.id.paisNewUsuario);
        EditText provinciaEditText = (EditText) findViewById(R.id.provinciaNewUsuario);
        EditText localidadEditText = (EditText) findViewById(R.id.localidadNewUsuario);
        EditText codigoPostalEditText = (EditText) findViewById(R.id.codigoPostalNewUsuario);
        EditText direccionEditText = (EditText) findViewById(R.id.direccionNewUsuario);
        EditText rolEditText = (EditText) findViewById(R.id.rolNewUsuario);

        String name = nameEditText.getText().toString();
        String apellido = apellidoEditText.getText().toString();
        String cuit = cuitEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String user = userEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String telefono = telefonoEditText.getText().toString();
        String pais = paisEditText.getText().toString();
        String provincia = provinciaEditText.getText().toString();
        String localidad = localidadEditText.getText().toString();
        String codigoPostal = codigoPostalEditText.getText().toString();
        String direccion = direccionEditText.getText().toString();
        String nrol = rolEditText.getText().toString();


        Call<Usuario> call = apiService.addUsuario(name,apellido,cuit,email,user,password,telefono,pais,provincia,localidad,codigoPostal,direccion,nrol);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                int statusCode = response.code();

                Usuario usuario = response.body();

                LinearLayout linear = (LinearLayout) findViewById(R.id.linearAddUsuario);

                TextView textView = new TextView(getBaseContext());

                String respuesta = new String("AGREGADO: "+ usuario.getNombre());

                textView.setText(respuesta);

                linear.addView(textView);
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText("fallo");
            }
        });

    }

    public void editUsuario(View vista){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UsuarioAPIInterface apiService =
                retrofit.create(UsuarioAPIInterface.class);

        EditText idEditText = (EditText) findViewById(R.id.inputEditUsuario);

        EditText nameEditText = (EditText) findViewById(R.id.nameNewUsuario);
        EditText apellidoEditText = (EditText) findViewById(R.id.apellidoNewUsuario);
        EditText cuitEditText = (EditText) findViewById(R.id.cuitNewUsuario);
        EditText emailEditText = (EditText) findViewById(R.id.emailNewUsuario);
        EditText userEditText = (EditText) findViewById(R.id.userNewUsuario);
        EditText passwordEditText = (EditText) findViewById(R.id.passwordNewUsuario);
        EditText telefonoEditText = (EditText) findViewById(R.id.telefonoNewUsuario);
        EditText paisEditText = (EditText) findViewById(R.id.paisNewUsuario);
        EditText provinciaEditText = (EditText) findViewById(R.id.provinciaNewUsuario);
        EditText localidadEditText = (EditText) findViewById(R.id.localidadNewUsuario);
        EditText codigoPostalEditText = (EditText) findViewById(R.id.codigoPostalNewUsuario);
        EditText direccionEditText = (EditText) findViewById(R.id.direccionNewUsuario);
        EditText rolEditText = (EditText) findViewById(R.id.rolNewUsuario);

        int id = Integer.parseInt(idEditText.getText().toString());

        String name = nameEditText.getText().toString();
        String apellido = apellidoEditText.getText().toString();
        String cuit = cuitEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String user = userEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String telefono = telefonoEditText.getText().toString();
        String pais = paisEditText.getText().toString();
        String provincia = provinciaEditText.getText().toString();
        String localidad = localidadEditText.getText().toString();
        String codigoPostal = codigoPostalEditText.getText().toString();
        String direccion = direccionEditText.getText().toString();
        String nrol = rolEditText.getText().toString();


        Call<Usuario> call = apiService.editUsuario(id,name,apellido,cuit,email,user,password,telefono,pais,provincia,localidad,codigoPostal,direccion,nrol);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                int statusCode = response.code();

                Usuario usuario = response.body();

                LinearLayout linear = (LinearLayout) findViewById(R.id.linearAddUsuario);

                TextView textView = new TextView(getBaseContext());

                String respuesta = new String("ACTUALIZADO: "+ usuario.getNombre());

                textView.setText(respuesta);

                linear.addView(textView);
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                System.out.println("fallo");
                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText("fallo");
            }
        });

    }

}
