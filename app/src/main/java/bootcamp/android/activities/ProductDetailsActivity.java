package bootcamp.android.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import bootcamp.android.R;
import bootcamp.android.fragments.ProductDetailsFragment;
import bootcamp.android.models.Product;

import static bootcamp.android.constants.Constants.PRODUCT_KEY;


public class ProductDetailsActivity extends FragmentActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.product_details_container);

    Bundle extraArguments = getIntent().getExtras();
    ProductDetailsFragment productDetailsFragment = ProductDetailsFragment.newInstance(extraArguments.<Product>getParcelable(PRODUCT_KEY));
    getSupportFragmentManager().beginTransaction().add(R.id.product_details_container, productDetailsFragment).commit();
  }
}
