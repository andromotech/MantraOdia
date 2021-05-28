package andromo.odiamantra.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import andromo.odiamantra.model.TextModel;


public class TextAdp extends RecyclerView.Adapter<TextAdp.MyViewHolder> {

    private Context mContext;
    private List<TextModel> spllist;

    public TextAdp(Context mContext, List<TextModel> spllist) {
        this.mContext = mContext;
        this.spllist = spllist;
    }

    @Override
    public TextAdp.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cv, viewGroup, false);

        return new TextAdp.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TextAdp.MyViewHolder viewHolder, int i) {
        viewHolder.title.setText(spllist.get(i).getName());
        Picasso.get()
                .load(spllist.get(i).getPic())
                .placeholder(R.drawable.as)
                .into(viewHolder.cpic);

    }

    @Override
    public int getItemCount() {
        return spllist.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView cpic;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            // count = (TextView) view.findViewById(R.id.count);
         //   Typeface ofont = Typeface.createFromAsset(itemView.getContext().getAssets(),"fonts/odia.ttf");
        //    title.setTypeface(ofont);
            cpic = (ImageView) view.findViewById(R.id.cpic);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        TextModel clickedDataItem = spllist.get(pos);
                        String url = spllist.get(pos).getUrl();
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        browserIntent.putExtra("url", spllist.get(pos).getUrl());
                        browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(browserIntent);
                        Toast.makeText(v.getContext(), "You are reading" + clickedDataItem.getName(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}