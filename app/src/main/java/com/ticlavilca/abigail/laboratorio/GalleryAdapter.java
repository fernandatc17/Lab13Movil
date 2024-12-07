package com.ticlavilca.abigail.laboratorio;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ticlavilca.abigail.laboratorio.databinding.ListItemImgBinding;

import java.io.File;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder>{
    private final File[] fileArray;

    public GalleryAdapter(File[] fileArray) {
        this.fileArray = fileArray;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ListItemImgBinding binding;

        public ViewHolder(ListItemImgBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(File file) {
            Glide.with(binding.getRoot().getContext())
                    .load(file)
                    .into(binding.localImg);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListItemImgBinding binding = ListItemImgBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(fileArray[position]);
    }

    @Override
    public int getItemCount() {
        return fileArray.length;
    }
}
