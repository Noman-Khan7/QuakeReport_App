package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Noman on 04-05-2018.
 */

public class EarthquakeAdapter  extends ArrayAdapter<Earthquake>
{
    double magnitud;
    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes)
    {
        super(context,0,earthquakes);
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View listItemView =convertView;
         if(listItemView==null)
        {
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.activity_earthquake_list_item,parent,false);
        }
        Earthquake currentEarthquake=getItem(position);
        String originalLocation = currentEarthquake.getLocation();
        String primaryLocation;
        String locationOffset;
        final String LOCATION_SEPARATOR = " of ";


        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }
        TextView magnitudeView=(TextView)listItemView.findViewById(R.id.magnitude);
        magnitudeView.setText(currentEarthquake.getMagnitude());
        magnitud= Double.parseDouble(currentEarthquake.getMagnitude());
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();


        // Get the appropriate background color based on the current earthquake magnitude

        int magnitudeColor = getMagnitudeColor(Double.parseDouble(currentEarthquake.getMagnitude()));

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        magnitudeView.setText(currentEarthquake.getMagnitude());

        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primary_location);
        primaryLocationView.setText(primaryLocation);

        TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.location_offset);
        locationOffsetView.setText(locationOffset);
        TextView dateView=(TextView)listItemView.findViewById(R.id.date);
        dateView.setText(currentEarthquake.getDate());
        return listItemView;
    }
    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
