package bootcamp.android.activities;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import bootcamp.android.R;
import bootcamp.android.adapters.ProductViewPagerAdapter;
import bootcamp.android.models.Product;

import static bootcamp.android.constants.Constants.CURRENT_PRODUCT_KEY;
import static bootcamp.android.constants.Constants.PRODUCTS_KEY;


public class ProductDetailsActivity extends FragmentActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.product_details_container);
    Bundle extraArguments = getIntent().getExtras();

    ArrayList<Product> products = extraArguments.getParcelableArrayList(PRODUCTS_KEY);
    int currentProductPosition = extraArguments.getInt(CURRENT_PRODUCT_KEY);

    ProductViewPagerAdapter productViewPagerAdapter = new ProductViewPagerAdapter(getSupportFragmentManager(), products);

    ViewPager viewPager = findViewById(R.id.view_pager);
    viewPager.setAdapter(productViewPagerAdapter);
    viewPager.setCurrentItem(currentProductPosition);
  }
}
