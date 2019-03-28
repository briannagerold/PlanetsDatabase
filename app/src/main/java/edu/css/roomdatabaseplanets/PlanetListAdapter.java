package edu.css.roomdatabaseplanets;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PlanetListAdapter extends RecyclerView.Adapter<PlanetListAdapter.PlanetViewHolder>  {
    class PlanetViewHolder extends RecyclerView.ViewHolder {
        private final TextView PlanetNameItemView;
        private final TextView PlanetGravityItemView;

        private PlanetViewHolder(View itemView) {
            super(itemView);
            PlanetNameItemView = itemView.findViewById(R.id.txtName);
            PlanetGravityItemView = itemView.findViewById(R.id.txtGravity);
        }
    }

    private final LayoutInflater mInflater;
    private List<Planet> mPlanets; // Cached copy of words

    PlanetListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public PlanetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new PlanetViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PlanetViewHolder holder, int position) {
        if (mPlanets != null) {
            Planet current = mPlanets.get(position);
            holder.PlanetNameItemView.setText(current.getName());
        } else {
            // Covers the case of data not being ready yet.
            holder.PlanetNameItemView.setText("No Word");
        }
    }

    void setPlanets(List<Planet> planets){
        mPlanets = planets;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mPlanets != null)
            return mPlanets.size();
        else return 0;
    }
}
