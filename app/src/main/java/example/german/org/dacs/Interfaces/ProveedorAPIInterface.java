package example.german.org.dacs.Interfaces;

/**
 * Created by germa on 1/8/2017.
 */

import java.util.List;

import example.german.org.dacs.Entities.Proveedor;
import example.german.org.dacs.Entities.Rol;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProveedorAPIInterface {

    @GET("proveedores/name/{nombre}")
    Call<Proveedor> getProveedorByName(@Path("nombre") String nombre);

    @GET("proveedores/{id}")
    Call<Proveedor> getProveedor(@Path("id") int id);

    @GET("proveedores/")
    Call<List<Proveedor>> getProveedores();

    @FormUrlEncoded
    @POST("proveedores/")
    Call<Proveedor> addProveedor(@Field("nombre") String nombre);

    @FormUrlEncoded
    @POST("proveedores/delete/")
    Call<Proveedor> deleteProveedor(@Field("id") int id);

    @FormUrlEncoded
    @POST("proveedores/delete2/")
    Call<Proveedor> deleteProveedorByName(@Field("nombre") String nombre);

    @FormUrlEncoded
    @PUT("proveedores/")
    Call<Proveedor> editProveedor(@Field("id") int id,@Field("nombre") String nombre);

}
