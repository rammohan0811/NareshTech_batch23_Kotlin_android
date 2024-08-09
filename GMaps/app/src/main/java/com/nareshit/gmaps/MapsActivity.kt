package com.nareshit.gmaps

import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.tasks.Task
import com.nareshit.gmaps.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    // TODO 1: To Request Location access from the user
    val activityResultLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){
        permissions ->
        var permissionsGranted = true
        permissions.entries.forEach {
            if(it.key in REQUIRED_PERMISSIONS && it.value == false){
                permissionsGranted = false
            }

            if(!permissionsGranted){
                Toast.makeText(this,"Location Permission is not granted", Toast.LENGTH_LONG).show()
            }
        }
    }

    companion object{
        private val REQUIRED_PERMISSIONS = mutableListOf(
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        ).toTypedArray()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO 2: Throw the permission pop up to the user
        activityResultLauncher.launch(REQUIRED_PERMISSIONS)

        fusedLocationProviderClient  = LocationServices.getFusedLocationProviderClient(this)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        /*val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))*/

        val charminar = LatLng(17.3616, 78.4747)
        mMap.addMarker(MarkerOptions().position(charminar).title("Marker in Charminar"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(charminar,11F))

        val tankBund = LatLng(17.4239, 78.4738)
        mMap.addMarker(MarkerOptions().position(tankBund).title("Marker in Charminar"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tankBund,11F))

        // TODO 3: get the last known location
        if(checkCallingOrSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION)==PackageManager.PERMISSION_GRANTED){
            val la:Task<Location> = fusedLocationProviderClient.getLastLocation()
            la.addOnSuccessListener {
                mMap.addMarker(MarkerOptions().position(LatLng(it.latitude,it.longitude)).title("My Location"))
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(it.latitude,it.longitude),11f))
            }
        }

    }
}