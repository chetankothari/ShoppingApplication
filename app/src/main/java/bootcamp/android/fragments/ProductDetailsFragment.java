package bootcamp.android.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import bootcamp.android.R;
import bootcamp.android.models.Product;

public class ProductDetailsFragment extends android.support.v4.app.Fragment {
    private static final String ARG_PRODUCT = "product";

    private Product product;

    public ProductDetailsFragment() {
    }

    public static ProductDetailsFragment newInstance(Product product) {
        ProductDetailsFragment fragment = new ProductDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PRODUCT, product);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.product = getArguments().getParcelable(ARG_PRODUCT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View productDetailsView = inflater.inflate(R.layout.product_details, container, false);

        TextView imageTitle = productDetailsView.findViewById(R.id.product_title);
        imageTitle.setText(product.getTitle());

        ImageView imageView = productDetailsView.findViewById(R.id.product_image);
        Picasso.get().load(product.getImageUrl()).into(imageView);

        TextView issueDescription = productDetailsView.findViewById(R.id.product_description);
        issueDescription.setText(product.getDescription());

        return productDetailsView;
    }
}
