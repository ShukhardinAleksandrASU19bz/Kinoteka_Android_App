package ru.ashukhardin.kinoteka.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.ashukhardin.kinoteka.FilmActivity;
import ru.ashukhardin.kinoteka.R;

public class RV_adapter extends RecyclerView.Adapter<RV_adapter.MovieViewHolder>{
    private int movieItems;
    private static int viewHolderCount;
    private Context parent;
    public RV_adapter(int countOfItems, Context parent)
    {
        movieItems = countOfItems;
        viewHolderCount= 0;
        this.parent = parent;
    }
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForMovieItem = R.layout.movie_list_item;

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForMovieItem,parent, false);
        MovieViewHolder viewHolder = new MovieViewHolder(view);
        viewHolder.viewHolderIndex.setText("viewHolderIdex" + viewHolderCount);
        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return movieItems;
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView listItemMovieView;
        TextView viewHolderIndex;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            listItemMovieView = itemView.findViewById(R.id.tv_movie_item);
            viewHolderIndex = itemView.findViewById(R.id.tv_view_holder_list);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int positionIndex = getAdapterPosition();
                    Toast.makeText(parent, "elemet" + positionIndex + "najat", Toast.LENGTH_SHORT).show();
                }
            });
        }
        void bind(int listIndex) {
            listItemMovieView.setText(String.valueOf(listIndex));
        }
    }
}