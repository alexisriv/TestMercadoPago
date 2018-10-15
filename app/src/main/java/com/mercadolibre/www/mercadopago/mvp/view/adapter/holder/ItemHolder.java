package com.mercadolibre.www.mercadopago.mvp.view.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mercadolibre.www.mercadopago.R;
import com.mercadolibre.www.mercadopago.mvp.core.GlideApp;
import com.mercadolibre.www.mercadopago.mvp.model.Item;

public class ItemHolder extends CommonViewHolder<Item> {

    private ImageView imageView;
    private TextView textView;
    private CustomOnClickListener onClickListener;

    public ItemHolder(View itemView, CustomOnClickListener onClickListener) {
        super(itemView);
        this.imageView = itemView.findViewById(R.id.imageView);
        this.textView = itemView.findViewById(R.id.textView);
        this.onClickListener = onClickListener;
    }

    @Override
    public void bind(final Item item, int index, int size) {
        this.textView.setText(item.getTitle());
        GlideApp.with(itemView)
                .load(item.getImage()).placeholder(R.drawable.shape_image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(this.imageView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onClick(view, item);
            }
        });
    }

    public interface CustomOnClickListener<T> {
        void onClick(View view, T o);
    }


}
