package mx.dezka.ahorramoney;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;

public class AhorrosFragment extends SherlockFragment {
	
	SharedPreferences datos;
	SharedPreferences.Editor editor;
	TextView ahorros_view;
	Button retirar_ahorros;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.ver_ahorros_fragment, container, false);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		datos= this.getActivity().getSharedPreferences("AHORROS", 0);
		ahorros_view = (TextView) getActivity().findViewById(R.id.ahorros_view);
		float ahorrado=datos.getFloat("Dinero", 0.0f);
		ahorros_view.setText(String.valueOf(ahorrado));
		retirar_ahorros= (Button)	 getActivity().findViewById(R.id.boton_eliminar_ahorros);
	}
	
	

}
