package andromo.odiamantra.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import andromo.odiamantra.R;
import andromo.odiamantra.model.LivePrayModel;
import andromo.odiamantra.ytview;

public class LivePrayAdp extends RecyclerView.Adapter<LivePrayAdp.MyViewHolder> {

    private Context mContext;
    private List<LivePrayModel> livepraylist;

    public LivePrayAdp(Context mContext, List<LivePrayModel> livepraylist) {
        this.mContext = mContext;
        this.livepraylist = livepraylist;
    }

    @Override
    public LivePrayAdp.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cv, viewGroup, false);

        return new LivePrayAdp.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final LivePrayAdp.MyViewHolder viewHolder, int i) {
        viewHolder.title.setText(livepraylist.get(i).getName());
        Picasso.get()
                .load(livepraylist.get(i).getPic())
                .placeholder(R.drawable.as)
                .into(viewHolder.cpic);

    }

    @Override
    public int getItemCount() {
        return livepraylist.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView cpic;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            // count = (TextView) view.findViewById(R.id.count);
            // Typeface ofont = Typeface.createFromAsset(itemView.getContext().getAssets(),"fonts/odia.ttf");
            //   title.setTypeface(ofont);
            cpic = (ImageView) view.findViewById(R.id.cpic);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        LivePrayModel clickedDataItem = livepraylist.get(pos);
                        Intent intent = new Intent(mContext, ytview.class);
                        String url = livepraylist.get(pos).getUrl();
                        intent.putExtra("url", livepraylist.get(pos).getUrl());
                        intent.putExtra("pic", livepraylist.get(pos).getPic());
                        intent.putExtra("name", livepraylist.get(pos).getName());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                        Toast.makeText(v.getContext(), "You clicked " + clickedDataItem.getName(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}