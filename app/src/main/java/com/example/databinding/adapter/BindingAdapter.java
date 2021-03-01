package com.example.databinding.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.example.databinding.BR;
import com.example.databinding.model.BindingModel;
import java.util.ArrayList;
import java.util.List;

public class BindingAdapter<T> extends RecyclerView.Adapter<BindingAdapter.MyViewHolder> {
    private BindingAdapter.OnItemClickListener<T> onItemClickListener;
    int layoutValue;
    Context context;
    ArrayList<BindingModel> rawdata;


    @Override
    public BindingAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), viewType, parent, false);
        return new MyViewHolder(binding);
    }

    public BindingAdapter(Context context, ArrayList<BindingModel> articles) {
        this.context = context;
        this.rawdata = articles;
    }




    @Override
    public void onBindViewHolder(BindingAdapter.MyViewHolder holder, int position) {
        holder.getBinding().setVariable(BR.model,rawdata.get(position));
        holder.getBinding().setVariable(BR.itemClickListener, onItemClickListener);

    }

    @Override
    public int getItemCount() {
        return rawdata.size();
    }

    /*public T getItem(final int position) {
        return mObjects.get(position);
    }*/
    public interface OnItemClickListener<T> {
        void onItemClick(View view, int position, T object);
    }
    public BindingAdapter(final List<T> objects) {
        this(objects, null,0);
    }

    public BindingAdapter(final List<T> objects , int layoutValue) {
        this(objects, null,layoutValue);
    }


    public BindingAdapter(final List<T> objects, BindingAdapter.OnItemClickListener onItemClickListener, int layoutValue) {
          rawdata = (ArrayList<BindingModel>) objects;
        this.onItemClickListener = onItemClickListener;
        this.layoutValue=layoutValue;
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ViewDataBinding binding;

        public MyViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.binding.executePendingBindings();
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }


}
