package example.german.org.dacs.Interfaces;

import java.util.List;

import example.german.org.dacs.Entities.Rol;
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

public interface RolAPIInterface {

    @GET("roles/name/{nombre}")
    Call<Rol> getRolByName(@Path("nombre") String nombre);

    @GET("roles/{id}")
    Call<Rol> getRol(@Path("id") int id);

    @GET("roles/")
    Call<List<Rol>> getRoles();

    @FormUrlEncoded
    @POST("roles/")
    Call<Rol> addRol(@Field("nombre") String nombre);

    @FormUrlEncoded
    @POST("roles/delete/")
    Call<Rol> deleteRol(@Field("id") int id);

    @FormUrlEncoded
    @POST("roles/delete2/")
    Call<Rol> deleteRolByName(@Field("nombre") String nombre);

    @FormUrlEncoded
    @PUT("roles/")
    Call<Rol> editRol(@Field("id") int id,@Field("nombre") String nombre);

}
