package example.german.org.dacs.Interfaces;

import java.util.List;

import example.german.org.dacs.Entities.Producto;
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

public interface ProductoAPIInterface {

    @GET("productos/name/{nombre}")
    Call<Producto> getProductoByName(@Path("nombre") String nombre);

    @GET("productos/{id}")
    Call<Producto> getProducto(@Path("id") int id);

    @GET("productos/")
    Call<List<Producto>> getProductos();

    @FormUrlEncoded
    @POST("productos/")
    Call<Producto> addProducto(@Field("nombre") String nombre,
                               @Field("marca") String marca,
                               @Field("descripcion") String descripcion,
                               @Field("precio") float precio,
                               @Field("comision") float comision,
                               @Field("stock") int stock,
                               @Field("categoria") String categoria,
                               @Field("proveedor") String proveedor);

    @FormUrlEncoded
    @POST("productos/delete/")
    Call<Producto> deleteProducto(@Field("id") int id);

    @FormUrlEncoded
    @POST("productos/delete2/")
    Call<Producto> deleteProductoByName(@Field("nombre") String nombre);

    @FormUrlEncoded
    @PUT("productos/")
    Call<Producto> editProducto(@Field("id") int id,
                                @Field("nombre") String nombre,
                                @Field("marca") String marca,
                                @Field("descripcion") String descripcion,
                                @Field("precio") float precio,
                                @Field("comision") float comision,
                                @Field("stock") int stock,
                                @Field("categoria") String categoria,
                                @Field("proveedor") String proveedor);

}
