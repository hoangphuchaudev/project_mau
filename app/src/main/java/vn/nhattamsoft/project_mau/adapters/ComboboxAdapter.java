package vn.nhattamsoft.project_mau.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import vn.nhattamsoft.project_mau.R;
import vn.nhattamsoft.project_mau.model.Item.ItemCombobox;

public class ComboboxAdapter extends ArrayAdapter<ItemCombobox> {
    private List<ItemCombobox> ListItem;
    private int SoCot;
    public ComboboxAdapter(@NonNull Context context, @NonNull List<ItemCombobox> listItem, @NonNull int soCot) {
        super(context, 0, listItem);
        ListItem = new ArrayList<>(listItem);
        SoCot = soCot;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return countryFilter;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.combobox, parent, false
            );
        }

        TextView textViewName = convertView.findViewById(R.id.noidung);
        TextView code = convertView.findViewById(R.id.code);

        ItemCombobox ComboItem = getItem(position);

        if (ComboItem != null) {
            textViewName.setText(ComboItem.getValue());
            if(SoCot == 2)
            {
                code.setVisibility(View.VISIBLE);
                code.setText(ComboItem.getCode());
            }
            else
                code.setVisibility(View.GONE);
        }

        return convertView;
    }

    private Filter countryFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            List<ItemCombobox> suggestions = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                suggestions.addAll(ListItem);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (ItemCombobox item : ListItem) {
                    if (item.getValue().toLowerCase().contains(filterPattern)) {
                        suggestions.add(item);
                    }
                }
            }

            results.values = suggestions;
            results.count = suggestions.size();

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            clear();
            addAll((List) results.values);
            notifyDataSetChanged();
        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return ((ItemCombobox) resultValue).getValue();
        }
    };
}
