package example.german.org.dacs.Interfaces;

import java.util.List;

import example.german.org.dacs.Entities.Rol;
import example.german.org.dacs.Entities.Usuario;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by germa on 12/7/2017.
 */

public interface UsuarioAPIInterface {

    @GET("usuarios/name/{nombre}")
    Call<Usuario> getUsuarioByName(@Path("nombre") String nombre);

    @GET("usuarios/{id}")
    Call<Usuario> getUsuario(@Path("id") int id);

    @GET("usuarios/")
    Call<List<Usuario>> getUsuarios();

    @FormUrlEncoded
    @POST("usuarios/")
    Call<Usuario> addUsuario(@Field("nombre") String nombre,
                             @Field("apellido") String apellido,
                             @Field("cuit") String cuit,
                             @Field("email") String email,
                             @Field("user") String user,
                             @Field("password") String password,
                             @Field("telefono") String telefono,
                             @Field("pais") String pais,
                             @Field("provincia") String provincia,
                             @Field("localidad") String localidad,
                             @Field("codigoPostal") String codigoPostal,
                             @Field("direccion") String direccion,
                             @Field("rol") String rol);

    @FormUrlEncoded
    @POST("usuarios/delete/")
    Call<Usuario> deleteUsuario(@Field("id") int id);

    @FormUrlEncoded
    @POST("usuarios/delete2/")
    Call<Usuario> deleteUsuarioByName(@Field("nombre") String nombre);

    @FormUrlEncoded
    @PUT("usuarios/")
    Call<Usuario> editUsuario(@Field("id") int id,
                              @Field("nombre") String nombre,
                              @Field("apellido") String apellido,
                              @Field("cuit") String cuit,
                              @Field("email") String email,
                              @Field("user") String user,
                              @Field("password") String password,
                              @Field("telefono") String telefono,
                              @Field("pais") String pais,
                              @Field("provincia") String provincia,
                              @Field("localidad") String localidad,
                              @Field("codigoPostal") String codigoPostal,
                              @Field("direccion") String direccion,
                              @Field("rol") String rol);

}
