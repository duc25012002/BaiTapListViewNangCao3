package com.hdcompany.android02b1.listviewnangcaobai3;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hdcompany.android02b1.listviewnangcaobai3.adapter.DocGiaAdapter;
import com.hdcompany.android02b1.listviewnangcaobai3.model.DocGia;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    EditText edt_ma, edt_ten;
    RadioButton radio_nam, radio_nu;
    Button btn_nhap;
    ListView lv_doc_gia;


    ImageButton img_delete;
    int gioiTinh;
    DocGiaAdapter docGiaAdapter;

    ArrayList<DocGia> arrDocGia = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        xuLy();
    }

    private void xuLy() {
        arrDocGia.add(new DocGia("01X", "Nguyễn Văn Bản", R.drawable.ic_man, false));
        arrDocGia.add(new DocGia("02X", "Nguyễn Văn Thôn", R.drawable.ic_man, false));
        arrDocGia.add(new DocGia("03X", "Nguyễn Văn Xóm", R.drawable.ic_woman, false));
        docGiaAdapter = new DocGiaAdapter(this, R.layout.item_doc_gia, arrDocGia);
        lv_doc_gia.setAdapter(docGiaAdapter);

        addData();

        checkGioiTinh();


    }

    private void xoaCheckBox() {
        img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Iterator<DocGia> iterator = arrDocGia.iterator();
                while (iterator.hasNext()) {
                    DocGia docGia = iterator.next();
                    if (docGia.isChecked()) {
                        iterator.remove();
                    }
                }
                docGiaAdapter.notifyDataSetChanged();
            }
        });

    }


    private void checkGioiTinh() {
        if (radio_nam.isChecked()) {
            gioiTinh = R.drawable.ic_man;
        } else {
            gioiTinh = R.drawable.ic_woman;
        }
    }

    private void addData() {
        btn_nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(edt_ma.getText().toString()) || TextUtils.isEmpty(edt_ten.getText().toString())) {
                    edt_ma.setError("Chưa nhập mã");
                    edt_ten.setError("Chưa nhập tên");
                } else {
                    Toast.makeText(MainActivity.this, "Đã nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                }


                checkGioiTinh();
                arrDocGia.add(new DocGia(edt_ma.getText().toString(), edt_ten.getText().toString(), gioiTinh, false));
                Toast.makeText(MainActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                docGiaAdapter.notifyDataSetChanged();
            }
        });
    }

    private void anhXa() {

        edt_ma = findViewById(R.id.edt_ma);
        edt_ten = findViewById(R.id.edt_ten);
        radio_nam = findViewById(R.id.radio_nam);
        radio_nu = findViewById(R.id.radio_nu);
        btn_nhap = findViewById(R.id.btn_nhap);
        lv_doc_gia = findViewById(R.id.lv_doc_gia);
        img_delete = findViewById(R.id.img_delete);
        xoaCheckBox();
    }
}