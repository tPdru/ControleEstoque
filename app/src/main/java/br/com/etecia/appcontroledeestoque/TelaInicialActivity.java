package br.com.etecia.appcontroledeestoque;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class TelaInicialActivity extends AppCompatActivity {

    BottomNavigationView idBarraDeNavegacao;
    AdapterTelaInicial adapterTelaInicial;
    ViewPager2 idViewPagerTelaInicia;

    BarraHomeFragment homeFragment = new BarraHomeFragment();
    BarraMenuFragment menuFragment = new BarraMenuFragment();
    BarraCarrinhoFragment carrinhoFragment = new BarraCarrinhoFragment();
    BarraUsuarioFragment usuarioFragment = new BarraUsuarioFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.tela_inicial_layout);

        idBarraDeNavegacao = findViewById(R.id.idBarraDeNavegacao);

        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.idBarraDeNavegacao, homeFragment).commit();

        BadgeDrawable badgeDrawable = idBarraDeNavegacao.getOrCreateBadge(R.id.idBarraMenu);
        badgeDrawable.setVisible(true);

        idBarraDeNavegacao.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return false;
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        idViewPagerTelaInicia = findViewById(R.id.idViewPagerTelaInicia);

        adapterTelaInicial = new AdapterTelaInicial(this);

        idViewPagerTelaInicia.setAdapter(adapterTelaInicial);




    }
}