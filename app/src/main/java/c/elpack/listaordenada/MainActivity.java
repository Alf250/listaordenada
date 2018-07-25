package c.elpack.listaordenada;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    ArrayList<productosvo> listaproductos;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listaproductos=new ArrayList<>();
        recycler=findViewById(R.id.recycleid);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        llenarproductos();

        adaptadorproducto adapter=new adaptadorproducto(listaproductos);
        recycler.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void llenarproductos() {
        listaproductos.add(new productosvo("A",3,23));
        listaproductos.add(new productosvo("B",5,22));
        listaproductos.add(new productosvo("C",4,25));
        listaproductos.add(new productosvo("D",1,24));
        listaproductos.add(new productosvo("E",2,21));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.AZid){
            Collections.sort(listaproductos, new Comparator<productosvo>() {
                @Override
                public int compare(productosvo p1, productosvo p2) {
                    return p1.getNombre().compareTo(p2.getNombre());
                }
            });

            adaptadorproducto adapter=new adaptadorproducto(listaproductos);
            recycler.setAdapter(adapter);

        } else if (id == R.id.ZAid){
            Collections.sort(listaproductos, new Comparator<productosvo>() {
                @Override
                public int compare(productosvo p1, productosvo p2) {
                    return p2.getNombre().compareTo(p1.getNombre());
                }
            });

            adaptadorproducto adapter=new adaptadorproducto(listaproductos);
            recycler.setAdapter(adapter);

        } else if (id == R.id.pmasid){
            Collections.sort(listaproductos, new Comparator<productosvo>() {
                @Override
                public int compare(productosvo p1, productosvo p2) {
                    return new Integer(p2.getPrecio()).compareTo(new Integer(p1.getPrecio()));
                }
            });

            adaptadorproducto adapter=new adaptadorproducto(listaproductos);
            recycler.setAdapter(adapter);

        } else if (id == R.id.pmenid){
            Collections.sort(listaproductos, new Comparator<productosvo>() {
                @Override
                public int compare(productosvo p1, productosvo p2) {
                    return new Integer(p1.getPrecio()).compareTo(new Integer(p2.getPrecio()));
                }
            });

            adaptadorproducto adapter=new adaptadorproducto(listaproductos);
            recycler.setAdapter(adapter);

        } else if (id == R.id.cmasid){
            Collections.sort(listaproductos, new Comparator<productosvo>() {
                @Override
                public int compare(productosvo p1, productosvo p2) {
                    return new Integer(p2.getCantidad()).compareTo(new Integer(p1.getCantidad()));
                }
            });

            adaptadorproducto adapter=new adaptadorproducto(listaproductos);
            recycler.setAdapter(adapter);

        } else if (id == R.id.cmenid){
            Collections.sort(listaproductos, new Comparator<productosvo>() {
                @Override
                public int compare(productosvo p1, productosvo p2) {
                    return new Integer(p1.getCantidad()).compareTo(new Integer(p2.getCantidad()));
                }
            });

            adaptadorproducto adapter=new adaptadorproducto(listaproductos);
            recycler.setAdapter(adapter);

        }

        return super.onOptionsItemSelected(item);
    }
}
