package example.german.org.dacs.Interfaces;

import java.util.Date;
import java.util.List;

import example.german.org.dacs.Entities.Pedido;
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

public interface PedidoAPIInterface {

    @GET("pedidos/{id}")
    Call<Pedido> getPedido(@Path("id") int id);

    @GET("pedidos/")
    Call<List<Pedido>> getPedidos();

    @FormUrlEncoded
    @POST("pedidos/")
    Call<Pedido> addPedido(@Field("fecha") String fecha,
                           @Field("estado") String estado,
                           @Field("usuario") String usuario,
                           @Field("fechapago") String fechapago,
                           @Field("mediodepago") String mediodepago);

    @FormUrlEncoded
    @POST("pedidos/delete/")
    Call<Pedido> deletePedido(@Field("id") int id);

    @FormUrlEncoded
    @PUT("pedidos/")
    Call<Pedido> editPedido(@Field("id") int id,
                            @Field("fecha") String fecha,
                            @Field("estado") String estado,
                            @Field("usuario") String usuario,
                            @Field("fechapago") String fechapago,
                            @Field("mediodepago") String mediodepago);

}
