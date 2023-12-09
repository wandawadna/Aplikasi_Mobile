package com.example.projek;

import androidx.appcompat.app.AppCompatActivity;
//import android.Manifest;
//import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
//import android.widget.Toast;

public class activity_home extends AppCompatActivity {

    private static final int REQUEST_LOCATION_PERMISSION = 1;

    private LocationManager locationManager;
    private LocationListener locationListener;
    private TextView locationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        locationTextView = findViewById(R.id.textViewLok);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                // Dapatkan lokasi saat ini di sini
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();

                // Tampilkan informasi lokasi saat ini pada TextView
                locationTextView.setText("Latitude: " + latitude + "\nLongitude: " + longitude);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {}

            @Override
            public void onProviderEnabled(String provider) {}

            @Override
            public void onProviderDisabled(String provider) {}
        };
    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        // Periksa izin lokasi saat ini
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//                // Jika izin sudah diberikan, dapatkan lokasi saat ini
//                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
//            } else {
//                // Jika izin belum diberikan, minta izin
//                if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)) {
//                    // Tampilkan penjelasan kepada pengguna mengapa izin diperlukan (opsional)
//                    Toast.makeText(this, "Izin lokasi diperlukan untuk mendapatkan lokasi saat ini.", Toast.LENGTH_SHORT).show();
//                }
//                // Minta izin
//                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);
//            }
//        } else {
//            // Jika versi API kurang dari 23, Anda dapat melakukan tindakan lain sesuai kebutuhan aplikasi Anda
//            // Misalnya, Anda dapat menampilkan pesan bahwa fitur ini memerlukan versi Android yang lebih baru
//            Toast.makeText(this, "Aplikasi ini memerlukan versi Android yang lebih baru untuk dapat menggunakan fitur ini.", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        locationManager.removeUpdates(locationListener);
//    }
}
