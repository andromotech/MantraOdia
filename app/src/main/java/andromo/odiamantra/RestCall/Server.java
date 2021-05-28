package andromo.odiamantra.RestCall;
import andromo.odiamantra.model.LivePrayView;
import andromo.odiamantra.model.MantraView;
import andromo.odiamantra.model.TextView;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Server {
    @GET("/bhakti/om.json")
    Call<TextView> getText();
    @GET("/bhakti/omantra.json")
    Call<MantraView> getMantraView();
    @GET("/bhakti/olp.json")
    Call<LivePrayView> getPrayView();
}

