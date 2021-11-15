package com.example.rm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

//import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
//import com.smarteist.autoimageslider.SliderAnimations;
//import com.smarteist.autoimageslider.SliderView;

public class Dashboard extends AppCompatActivity {
    //SliderView sliderView;
  //  int[] images={
          //  R.drawable.slider1,
          //  R.drawable.slider2,
          //  R.drawable.slider3,
          //  R.drawable.slider4,
          //  R.drawable.slider5
  //  };

private FrameLayout frameLayout;
   /* RecyclerView catRecyclerview;
    //Category recyclerview
    CategoryAdapter categoryAdapter;
    List<CategoryModel> categoryModelList;*/
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    androidx.appcompat.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
      //  sliderView=findViewById(R.id.image_slider);
       // SliderAdapter sliderAdapter=new SliderAdapter(images);
      //  sliderView.setSliderAdapter(sliderAdapter);
       // sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
       // sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
       // sliderView.startAutoCycle();
        /*catRecyclerview=findViewById(R.id.rec_category);
        ImageSlider imageSlider=findViewById(R.id.image_slider);
        List<SlideModel> slideModels=new ArrayList<>();
       // slideModels.add(new SlideModel(R.drawable.slider2, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.slider3, ScaleTypes.CENTER_CROP));
       slideModels.add(new SlideModel(R.drawable.slider6, ScaleTypes.CENTER_CROP));
       slideModels.add(new SlideModel(R.drawable.slider5, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.banner10, ScaleTypes.CENTER_CROP));

        slideModels.add(new SlideModel(R.drawable.banner12, ScaleTypes.CENTER_CROP));

        imageSlider.setImageList(slideModels);*/
       // catRecyclerview.setLayoutManager(new LinearLayoutManager(new activity(position,str)));
        toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nav=(NavigationView)findViewById(R.id.nav_menu);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
    drawerLayout.addDrawerListener(toggle);
    toggle.syncState();
  //  getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
  // nav.setCheckedItem(R.id.my_home);

 //   nav.getMenu().getItem(0).setChecked(true);
    nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
        Fragment temp;
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
          //  Fragment temp;
            switch (item.getItemId())
            { 
                case R.id.my_cart:
                 //   Toast.makeText(getApplicationContext(),"Cart is empty",Toast.LENGTH_SHORT).show();
                    temp=new MyCartFragment();
                   // Intent intent=new Intent(Dashboard.this,Login.class);
                 //   startActivity(intent);
                   // finish();
                    drawerLayout.closeDrawer(GravityCompat.START);

                    break;
                case R.id.my_wishlist:
                    temp=new WishlistFragment();
                   // Toast.makeText(getApplicationContext()," empty",Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case R.id.my_orders:
                    temp=new orderFragment();
                   // Toast.makeText(getApplicationContext(),"empty",Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case R.id.my_rewards:
                    Toast.makeText(getApplicationContext(),"empty1",Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case R.id.my_account:
                    Toast.makeText(getApplicationContext(),"empty2",Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case R.id.my_notification:
                    Toast.makeText(getApplicationContext(),"empty3",Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case R.id.my_home:
                    temp=new HomeFragment();
                  //  Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;

            }
             getSupportFragmentManager().beginTransaction().replace(R.id.container,temp).commit();
            return true;
        }
    });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.icon_menu, menu);
        return true;
    }
  //  Fragment temp;
    @Override
    public  boolean onOptionsItemSelected(MenuItem item){

        int id =item.getItemId();
        if (id==R.id.main_search_icon)
        {
            //for search icon
            Toast.makeText(Dashboard.this,"working...",Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(id==R.id.main_notification_icon)
        {
            Toast.makeText(Dashboard.this,"working...",Toast.LENGTH_SHORT).show();
           // drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id==R.id.main_cart_icon)
        {

            Toast.makeText(Dashboard.this,"working...",Toast.LENGTH_SHORT).show();


            return true;
        }
     //   getSupportFragmentManager().beginTransaction().replace(R.id.container,temp).commit();
        return super.onOptionsItemSelected(item);
    }

}