package com.example.myapplication55;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class userAdapter extends RecyclerView.Adapter<userAdapter.userHolder> {

    apiActivity apiActivity;
    List<userModel> allUsersList;

    public userAdapter(com.example.myapplication55.apiActivity apiActivity, List<userModel> allUsersList) {
        this.apiActivity = apiActivity;
        this.allUsersList = allUsersList;
    }

    @NonNull
    @Override
    public userHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new userHolder(LayoutInflater.from(apiActivity).inflate(R.layout.item_uset,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull userHolder holder, int position) {
        holder.itemTxt.setText(allUsersList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return allUsersList.size();
    }

    public class userHolder extends RecyclerView.ViewHolder {
        TextView itemTxt;

        public userHolder(@NonNull View itemView) {
            super(itemView);
            itemTxt=itemView.findViewById(R.id.itemTxt);

        }
    }
}
