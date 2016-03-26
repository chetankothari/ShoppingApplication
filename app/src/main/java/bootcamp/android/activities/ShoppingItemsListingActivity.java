package bootcamp.android.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import bootcamp.android.R;
import bootcamp.android.adapters.ShoppingItemsListAdapter;
import bootcamp.android.models.Product;
import bootcamp.android.repositories.ProductRepository;

public class ShoppingItemsListingActivity extends Activity {

  private ProductRepository productRepository;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    productRepository = new ProductRepository();
    List<Product> products = productRepository.getProducts();
    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    ShoppingItemsListAdapter productArrayAdapter = new ShoppingItemsListAdapter(products);
    recyclerView.setAdapter(productArrayAdapter);
  }
}
