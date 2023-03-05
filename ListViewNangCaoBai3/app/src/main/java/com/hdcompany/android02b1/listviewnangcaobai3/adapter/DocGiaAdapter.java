package com.hdcompany.android02b1.listviewnangcaobai3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hdcompany.android02b1.listviewnangcaobai3.R;
import com.hdcompany.android02b1.listviewnangcaobai3.model.DocGia;

import java.util.List;

public class DocGiaAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<DocGia> listDocGia;

    public DocGiaAdapter(Context context, int layout, List<DocGia> listDocGia) {
        this.context = context;
        this.layout = layout;
        this.listDocGia = listDocGia;
    }

    public DocGiaAdapter() {
    }

    @Override
    public int getCount() {
        return listDocGia.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);

        TextView txt_1 = (TextView) convertView.findViewById(R.id.txt_1);
        TextView txt_2 = (TextView) convertView.findViewById(R.id.txt_2);
        ImageView img_sex = (ImageView) convertView.findViewById(R.id.ic_sex);
        CheckBox chk_1 = (CheckBox) convertView.findViewById(R.id.img_button);

        DocGia docGia = listDocGia.get(position);
        txt_1.setText(docGia.getMaDocGia());
        txt_2.setText("  -  " + docGia.getTenDocGia());
        img_sex.setImageResource(docGia.getGioiTinhDocGia());
        chk_1.setChecked(docGia.isChecked());

        chk_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                docGia.setChecked(chk_1.isChecked());
            }
        });
        chk_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = docGia.getMaDocGia() + " " + docGia.getTenDocGia();
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
