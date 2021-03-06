package com.example.annie.mm;

import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

public class Busqueda extends AppCompatActivity {
    /*Administra el activity que contiene la lista de busqueda*/
    RecyclerView recyclerView;
    busqAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);

        //Aquí se define la flecha para volver a la ventana principal
        ActionBar actionBar = getSupportActionBar();
        assert actionBar!=null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_36dp);

        //aqui se define el recyclerView del xml
        recyclerView = (RecyclerView)findViewById(R.id.rvItem);
        //aqui se define el adaptador que une la informacion que se mostrará contenida en Datos.java
        //con el recyclerView y la disposición que tendrá, en esta caso LinearLayout
        adapter = new busqAdapter(this, getPDFs());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }

    private ArrayList<Datos_simple> getPDFs() {
        ArrayList<Datos_simple> pdfDocs = new ArrayList<>();
        File downloadsFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        Datos_simple pdfDoc;
        if(downloadsFolder.exists()){
            File[] files = downloadsFolder.listFiles();
            for (int i=0; i<files.length; i++){
                File file=files[i];
                if(file.getPath().endsWith("pdf")){
                    pdfDoc = new Datos_simple();
                    pdfDoc.setName(file.getName());
                    pdfDoc.setPath(file.getAbsolutePath());
                    pdfDocs.add(pdfDoc);
                }
            }
        }
        return pdfDocs;
    }

    public boolean onOptionsItemSelected(MenuItem itm){
        switch (itm.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(itm);
    }
}
