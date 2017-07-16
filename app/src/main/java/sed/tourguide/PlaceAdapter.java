package sed.tourguide;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {

    public int mColorResourceId;

    public PlaceAdapter(Activity context, ArrayList<Place> place, int colorResourceId) {
        super(context, 0, place);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Creates new place objects and allocates a corresponding position
        Place currentPlace = getItem(position);

        // Gets text from Place objects and sets it to corresponding value
        TextView attractionTextView = (TextView) listItemView.findViewById(R.id.attraction);
        attractionTextView.setText(currentPlace.getAttraction());

        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description);
        descriptionTextView.setText(currentPlace.getDescription());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image_icon);
        iconView.setImageResource(currentPlace.getImageResourceId());

        //Sets color of background changes the background for text containers
        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);
        // Returns a populated list
        return listItemView;
    }
}
