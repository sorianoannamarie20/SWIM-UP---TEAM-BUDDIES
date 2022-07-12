package com.example.quizleaderboardswimup.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizleaderboardswimup.Model.RankModel;
import com.example.quizleaderboardswimup.R;

import java.util.List;

public class RankAdapter extends RecyclerView.Adapter<RankAdapter.ViewHolder> {
    private List<RankModel> rankModelList;

    public RankAdapter(List<RankModel> rankModelList) {
        this.rankModelList = rankModelList;
    }

    @NonNull
    @Override
    public RankAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rank_item_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RankAdapter.ViewHolder holder, int position) {

        String name = rankModelList.get(position).getName();
        int score = rankModelList.get(position).getScore();
        int rank = rankModelList.get(position).getRank();

        holder.setData(name, score, rank);

    }

    @Override
    public int getItemCount() {
        if (rankModelList.size() > 10)
        {
            return 10;
        }else {
            return rankModelList.size();
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nameRank, rankRank, scoreRank, imageRank;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameRank = itemView.findViewById(R.id.nameRank);
            rankRank = itemView.findViewById(R.id.rankRank);
            scoreRank = itemView.findViewById(R.id.scoreRank);
            imageRank = itemView.findViewById(R.id.imageTextR);



        }
        private void setData(String name, int score, int rank)
        {
            nameRank.setText(name);
            scoreRank.setText("Score: " + score);
            rankRank.setText("Rank: " + rank );
            imageRank.setText(name.toUpperCase().substring(0,1));

        }
    }
}
