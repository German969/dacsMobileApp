package example.german.org.dacs.Interfaces;

import java.util.List;

import example.german.org.dacs.Entities.Categoria;
import example.german.org.dacs.Entities.Rol;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by germa on 1/8/2017.
 */

public interface CategoriaAPIInterface {

    @GET("categorias/name/{nombre}")
    Call<Categoria> getCategoriaByName(@Path("nombre") String nombre);

    @GET("categorias/{id}")
    Call<Categoria> getCategoria(@Path("id") int id);

    @GET("categorias/")
    Call<List<Categoria>> getCategorias();

    @FormUrlEncoded
    @POST("categorias/")
    Call<Categoria> addCategoria(@Field("nombre") String nombre);

    @FormUrlEncoded
    @POST("categorias/delete/")
    Call<Categoria> deleteCategoria(@Field("id") int id);

    @FormUrlEncoded
    @POST("categorias/delete2/")
    Call<Categoria> deleteCategoriaByName(@Field("nombre") String nombre);

    @FormUrlEncoded
    @PUT("categorias/")
    Call<Categoria> editCategoria(@Field("id") int id,@Field("nombre") String nombre);

}
