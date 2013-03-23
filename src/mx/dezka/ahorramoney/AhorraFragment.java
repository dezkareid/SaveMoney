package mx.dezka.ahorramoney;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.actionbarsherlock.app.SherlockFragment;

public class AhorraFragment extends SherlockFragment {
	
	SharedPreferences datos;
	SharedPreferences.Editor editor;
	private String cantidad;
	private float cantidadF;
	EditText cantidad_view;
	Button ahorrar;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.ahorrar_fragment, container, false);
		return view;
	}

	@Override
	public void onActivityCreated (Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		datos= this.getActivity().getSharedPreferences("AHORROS", 0);
		cantidad_view = (EditText) getActivity().findViewById(R.id.cantidad_ahorrar);
		ahorrar= (Button)	 getActivity().findViewById(R.id.boton_ahorrar);
		ahorrar.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				setCantidad(cantidad_view.getText().toString());
				if(Validaciones.es_numero(getCantidad()))
				{
					setCantidadF(Float.parseFloat(getCantidad()));
					float ahorrado= datos.getFloat("Dinero", 0.0f);
					ahorrado+=getCantidadF();
					editor=datos.edit();
					editor.putFloat("Dinero", ahorrado);
					editor.commit();
					cantidad_view.setText("");
				}
			}
		});

	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public float getCantidadF() {
		return cantidadF;
	}

	public void setCantidadF(float cantidadF) {
		this.cantidadF = cantidadF;
	}
	
	
		
}
