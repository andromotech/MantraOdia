package andromo.odiamantra;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import andromo.odiamantra.RestCall.Client;
import andromo.odiamantra.RestCall.Server;
import andromo.odiamantra.adapter.LivePrayAdp;
import andromo.odiamantra.model.LivePrayModel;
import andromo.odiamantra.model.LivePrayView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YpActivity extends Fragment {
    private List<LivePrayModel> spllist;
    private View myFragmentView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myFragmentView = inflater.inflate(
                R.layout.audio_play, container, false);

        try {
            Client Clt = new Client();
            Server apiServer =
                    Clt.getClient().create(Server.class);
            Call<LivePrayView> call = apiServer.getPrayView();
            call.enqueue(new Callback<LivePrayView>() {
                @Override
                public void onResponse(Call<LivePrayView> call, Response<LivePrayView> response) {
                    List<LivePrayModel> items = response.body().getPrayView();
                    spllist = new ArrayList<>();
                    LivePrayAdp firstAdapter = new LivePrayAdp(getContext(), items);
                    RecyclerView firstRecyclerView = (RecyclerView) myFragmentView.findViewById(R.id.recycler_view1);
                    RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
                    firstRecyclerView.setLayoutManager(mLayoutManager);
                    firstRecyclerView.setAdapter(firstAdapter);
                }

                @Override
                public void onFailure(Call<LivePrayView> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                    Toast.makeText(getContext(), "Error Fetching Data!", Toast.LENGTH_SHORT).show();
//                    pogrd.hide();

                }
            });
        } catch (Exception e) {
            Log.d("Error", e.getMessage());
            Toast.makeText(getContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }

        return myFragmentView;
    }


}