package example.german.org.dacs.Interfaces;

import java.util.List;

import example.german.org.dacs.Entities.MedioDePago;
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

public interface MedioDePagoAPIInterface {

    @GET("mediosdepago/name/{nombre}")
    Call<MedioDePago> getMedioDePagoByName(@Path("nombre") String nombre);

    @GET("mediosdepago/{id}")
    Call<MedioDePago> getMedioDePago(@Path("id") int id);

    @GET("mediosdepago/")
    Call<List<MedioDePago>> getMediosDePago();

    @FormUrlEncoded
    @POST("mediosdepago/")
    Call<MedioDePago> addMedioDePago(@Field("nombre") String nombre);

    @FormUrlEncoded
    @POST("mediosdepago/delete/")
    Call<MedioDePago> deleteMedioDePago(@Field("id") int id);

    @FormUrlEncoded
    @POST("mediosdepago/delete2/")
    Call<MedioDePago> deleteMedioDePagoByName(@Field("nombre") String nombre);

    @FormUrlEncoded
    @PUT("mediosdepago/")
    Call<MedioDePago> editMedioDePago(@Field("id") int id,@Field("nombre") String nombre);

}
