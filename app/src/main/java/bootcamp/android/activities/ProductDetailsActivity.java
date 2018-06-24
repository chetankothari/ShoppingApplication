package bootcamp.android.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import java.util.ArrayList;

import bootcamp.android.R;
import bootcamp.android.fragments.ProductDetailsFragment;
import bootcamp.android.models.Product;

import static bootcamp.android.constants.Constants.CURRENT_PRODUCT_KEY;
import static bootcamp.android.constants.Constants.PRODUCTS_KEY;


public class ProductDetailsActivity extends FragmentActivity {

  private int currentProductPosition;
  private ArrayList<Product> products;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.product_details_container);

    Bundle extraArguments = getIntent().getExtras();
    products = extraArguments.getParcelableArrayList(PRODUCTS_KEY);
    currentProductPosition = extraArguments.getInt(CURRENT_PRODUCT_KEY);
    renderProduct();
  }

  private void renderProduct() {
    Product product = products.get(currentProductPosition);
    ProductDetailsFragment productDetailsFragment = ProductDetailsFragment.newInstance(product);
    getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.product_details_fragment, productDetailsFragment)
            .commit();
  }

  public void next(View view) {
    currentProductPosition++;
    renderProduct();
  }

  public void previous(View view) {
    currentProductPosition--;
    renderProduct();
  }
}
