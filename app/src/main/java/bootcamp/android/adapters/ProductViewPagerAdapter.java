package bootcamp.android.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import bootcamp.android.fragments.ProductDetailsFragment;
import bootcamp.android.models.Product;

public class ProductViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<Product> products;

    public ProductViewPagerAdapter(FragmentManager fragmentManager, List<Product> products) {
        super(fragmentManager);
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Fragment getItem(int position) {
        return ProductDetailsFragment.newInstance(products.get(position));
    }
}