package com.qpworld.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.qpworld.app.R;
import com.qpworld.app.models.PriceItem;

import java.util.List;
import java.util.Locale;

public class PriceAdapter extends RecyclerView.Adapter<PriceAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(PriceItem item);
    }

    private Context context;
    private List<PriceItem> priceList;
    private OnItemClickListener listener;
    private String language;

    public PriceAdapter(Context context, List<PriceItem> priceList,
                        OnItemClickListener listener, String language) {
        this.context  = context;
        this.priceList = priceList;
        this.listener = listener;
        this.language = language;
    }

    public void updateData(List<PriceItem> newList) {
        this.priceList = newList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_price, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PriceItem item = priceList.get(position);
        boolean isUrdu = language != null && language.equals("ur");

        // Name
        holder.tvItemName.setText(isUrdu ? item.getItemNameUrdu() : item.getItemName());

        // Price
        holder.tvCurrentPrice.setText(String.format(Locale.getDefault(),
                "%s %.2f / %s", item.getCurrency(), item.getCurrentPrice(), item.getUnit()));

        // Change indicator
        double change = item.getPriceChange();
        double changePct = item.getPriceChangePercent();

        if (item.isMehnga()) {
            String changeText = String.format(Locale.getDefault(),
                    "▲ %.1f%%", changePct);
            holder.tvPriceChange.setText(changeText);
            holder.tvPriceChange.setTextColor(context.getResources().getColor(R.color.colorMehnga));
            holder.tvStatusEmoji.setText("📈");
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.cardMehnga));
        } else if (item.isSasta()) {
            String changeText = String.format(Locale.getDefault(),
                    "▼ %.1f%%", Math.abs(changePct));
            holder.tvPriceChange.setText(changeText);
            holder.tvPriceChange.setTextColor(context.getResources().getColor(R.color.colorSasta));
            holder.tvStatusEmoji.setText("📉");
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.cardSasta));
        } else {
            holder.tvPriceChange.setText("—");
            holder.tvPriceChange.setTextColor(context.getResources().getColor(R.color.colorNeutral));
            holder.tvStatusEmoji.setText("➡️");
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.cardNeutral));
        }

        // Status text
        if (item.isMehnga()) {
            holder.tvStatus.setText(isUrdu ? "مہنگا" : "Up");
        } else if (item.isSasta()) {
            holder.tvStatus.setText(isUrdu ? "سستا" : "Down");
        } else {
            holder.tvStatus.setText(isUrdu ? "مستحکم" : "Stable");
        }

        // Category badge
        holder.tvCategory.setText(getCategoryLabel(item.getCategory(), isUrdu));

        // Click
        holder.cardView.setOnClickListener(v -> listener.onItemClick(item));
    }

    private String getCategoryLabel(String category, boolean isUrdu) {
        switch (category) {
            case "fuel":       return isUrdu ? "⛽ ایندھن" : "⛽ Fuel";
            case "food":       return isUrdu ? "🌾 خوراک"  : "🌾 Food";
            case "vegetables": return isUrdu ? "🥬 سبزیاں" : "🥬 Veggies";
            case "utility":    return isUrdu ? "💡 یوٹیلیٹی" : "💡 Utility";
            default:           return category;
        }
    }

    @Override
    public int getItemCount() { return priceList.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView tvItemName, tvCurrentPrice, tvPriceChange, tvStatus, tvStatusEmoji, tvCategory;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView        = itemView.findViewById(R.id.cardView);
            tvItemName      = itemView.findViewById(R.id.tvItemName);
            tvCurrentPrice  = itemView.findViewById(R.id.tvCurrentPrice);
            tvPriceChange   = itemView.findViewById(R.id.tvPriceChange);
            tvStatus        = itemView.findViewById(R.id.tvStatus);
            tvStatusEmoji   = itemView.findViewById(R.id.tvStatusEmoji);
            tvCategory      = itemView.findViewById(R.id.tvCategory);
        }
    }
}
