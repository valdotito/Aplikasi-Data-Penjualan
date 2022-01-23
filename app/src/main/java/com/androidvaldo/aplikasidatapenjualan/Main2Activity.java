package com.androidvaldo.aplikasidatapenjualan;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private EditText editnamapel,editnamabar,
            editjumlahbar, editharga,edituangbay;
    private Button btnproses;
    private Button btnhapus;
    private Button btnexit;
    private TextView txtnamapel;
    private TextView txtnamabar;
    private TextView txtjumlahbar;
    private TextView txtharga;
    private TextView txtuangbay;
    private TextView txtbonus;
    private TextView txttotalbelanja;
    private TextView txtkembali;
    private TextView txtketerangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getSupportActionBar().setTitle("Aplikasi Data Penjualan");
        editnamapel = (EditText) findViewById(R.id.nama_pelanggan);
        editnamabar = (EditText) findViewById(R.id.nama_barang);
        editjumlahbar = (EditText) findViewById(R.id.jml_barang);
        editharga = (EditText) findViewById(R.id.harga_barang);
        edituangbay = (EditText) findViewById(R.id.jml_uang);

        btnproses = (Button)findViewById(R.id.proses);
        btnhapus = (Button)findViewById(R.id.reset);
        btnexit = (Button)findViewById(R.id.exit);

        txtnamapel = (TextView) findViewById(R.id.nama_pelanggan);
        txtnamabar = (TextView) findViewById(R.id.nama_barang);
        txtjumlahbar = (TextView) findViewById(R.id.jml_barang);
        txtharga = (TextView) findViewById(R.id.harga_barang);
        txtuangbay = (TextView) findViewById(R.id.jml_uang);
        txtbonus = (TextView) findViewById(R.id.total);
        txttotalbelanja = (TextView) findViewById(R.id.kembalian);
        txtkembali = (TextView) findViewById(R.id.keterangan);
        txtketerangan =(TextView)  findViewById(R.id.bonus);

        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namapelanggan = editnamapel.getText().toString().trim();
                String namabarang = editnamabar.getText().toString().trim();
                String jumlahbarang = editjumlahbar.getText().toString().trim();
                String hargabarang = editharga.getText().toString().trim();
                String uangbayar = edituangbay.getText().toString().trim();

                double jb = Double.parseDouble(jumlahbarang);
                double h = Double.parseDouble(hargabarang);
                double ub = Double.parseDouble(uangbayar);
                double total = (jb*h);

                txttotalbelanja.setText("Total Belanja  : "+total);

                if (total >= 200000) {
                    txtbonus.setText("Bonus : HardDisk");
                } else if (total >= 50000) {
                    txtbonus.setText("Bonus : Keyboard Gaming");
                } else if (total >= 40000) {
                    txtbonus.setText("Bonus : Mouse Gaming");
                } else {
                    txtbonus.setText("Bonus : Tidak ada bonus!");
                }
                double uangkembalian = (ub - total);
                if (ub<total) {
                    txtketerangan.setText("Keterangan : Uang bayar kurang Rp. " + (-uangkembalian));
                    txtkembali.setText("Uang Kembalian : Rp. ");
                } else {
                    txtketerangan.setText("Keterangan : Tunggu kembalian");
                    txtkembali.setText("Uang Kembalian :  "+uangkembalian);
                }

            }
        });
        btnhapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtnamapel.setText("");
                txtnamabar.setText("");
                txtjumlahbar.setText("");
                txtharga.setText("");
                txtuangbay.setText("");
                txtkembali.setText("");
                txtketerangan.setText("");
                txtbonus.setText("");
                txttotalbelanja.setText("");

                Toast.makeText(getApplicationContext(), "Data sudah dihapus", Toast.LENGTH_SHORT).show();
            }
        });

        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
            }
        });

    }
}
