package c.elpack.listaordenada;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class adaptadorproducto extends RecyclerView.Adapter<adaptadorproducto.ViewHolderProductos> {

    ArrayList<productosvo> listaproductos;

    public adaptadorproducto(ArrayList<productosvo> listaproductos) {
        this.listaproductos = listaproductos;
    }

    @NonNull
    @Override
    public ViewHolderProductos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lis,null,false);

        return new ViewHolderProductos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProductos holder, int position) {
        holder.tenombre.setText(listaproductos.get(position).getNombre());
        holder.tecantidad.setText(listaproductos.get(position).getCantidad()+" Piezas");
        holder.teprecio.setText("$"+listaproductos.get(position).getPrecio());
    }

    @Override
    public int getItemCount() {
        return listaproductos.size();
    }

    public class ViewHolderProductos extends RecyclerView.ViewHolder {

        TextView tenombre,tecantidad,teprecio;

        public ViewHolderProductos(View itemView) {
            super(itemView);

            tenombre=(TextView) itemView.findViewById(R.id.idnombre);
            tecantidad=(TextView) itemView.findViewById(R.id.idcantidad);
            teprecio=(TextView) itemView.findViewById(R.id.idprecio);
        }
    }
}
