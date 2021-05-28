package andromo.odiamantra.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LivePrayView
{
@SerializedName("lpr")
@Expose

        private List<LivePrayModel> livepraylist;

        public List<LivePrayModel> getPrayView(){
            return livepraylist;
        }

        public void setPrayView(List<LivePrayModel> livepraylist){
            this.livepraylist = livepraylist;
        }
}