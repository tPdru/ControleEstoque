package br.com.etecia.appcontroledeestoque;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class AdapterTelaInicial extends FragmentStateAdapter {


    public AdapterTelaInicial(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new BarraHomeFragment();
            case 1:
                return new BarraMenuFragment();
            case 2:
                return new BarraCarrinhoFragment();
            case 3:
                return new BarraUsuarioFragment();
            default:
                return new BarraHomeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
