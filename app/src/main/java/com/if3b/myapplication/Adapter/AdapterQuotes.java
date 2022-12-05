package com.if3b.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.if3b.myapplication.Model.QuotesModel;
import com.if3b.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterQuotes extends RecyclerView.Adapter<AdapterQuotes.ViewHolderQuotes>{
    private List<QuotesModel> ListQuotes = new ArrayList<>();
    private Context ctx;

    public AdapterQuotes(List<QuotesModel> listQuotes, Context ctx) {
        ListQuotes = listQuotes;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolderQuotes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View varView = LayoutInflater.from(ctx).inflate(R.layout.item_quotes, parent, false);
        return new ViewHolderQuotes(varView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderQuotes holder, int position) {
        QuotesModel QM = ListQuotes.get(position);
        holder.tvQuotes.setText(QM.getText());
        holder.tvAuthor.setText(QM.getAuthor());
    }

    @Override
    public int getItemCount() {
        return ListQuotes.size();
    }

    public class ViewHolderQuotes extends RecyclerView.ViewHolder{
        TextView tvQuotes, tvAuthor;


        public ViewHolderQuotes(@NonNull View itemView) {
            super(itemView);
            tvQuotes = itemView.findViewById(R.id.tv_quotes);
            tvAuthor = itemView.findViewById(R.id.tv_author);

        }
    }
}