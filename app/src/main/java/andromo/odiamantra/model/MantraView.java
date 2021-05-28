package andromo.odiamantra.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MantraView {
    @SerializedName("mantra")
    @Expose

    private List<MantraModel> mantralist;

    public List<MantraModel> getMantraView(){
        return mantralist;
    }

    public void setMantraView(List<MantraModel> mantralist){
        this.mantralist = mantralist;
    }
}