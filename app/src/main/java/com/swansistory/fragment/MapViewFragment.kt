package com.swansistory.fragment

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.swansistory.R
import com.swansistory.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class MapViewFragment : Fragment(), OnMapReadyCallback {

    private val args: MapViewFragmentArgs by navArgs()
    private lateinit var mMap: GoogleMap
    private lateinit var textToSpeech: TextToSpeech

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mapview, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.item_name).text = args.placeData.name
        view.findViewById<TextView>(R.id.item_location).text = args.placeData.address
        view.findViewById<TextView>(R.id.text_about).text = args.placeData.about


        // GoogleMapView
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        //FloatingActionButton
        val fab = view.findViewById<FloatingActionButton>(R.id.fav_btn)
        val place = args.placeData
        val tintList = fab.imageTintList
        if (place.isFav) {
            fab.imageTintList = ColorStateList.valueOf(Color.rgb(229, 43, 80))
        }

        fab.setOnClickListener {
            if (!place.isFav) {
                fab.imageTintList = ColorStateList.valueOf(Color.rgb(229, 43, 80))
                place.isFav = true
                viewModel.setPlaceFavourite(place)
            } else {
                fab.imageTintList = tintList
                place.isFav = false
                viewModel.setPlaceFavourite(place)
            }
        }


        val pab = view.findViewById<Button>(R.id.play_btn)

        var isPlaying = false

        textToSpeech = TextToSpeech(view.context) {

            if (it == TextToSpeech.SUCCESS) {
                textToSpeech.language = Locale.ENGLISH
                textToSpeech.setPitch(0.2F)
            }

            textToSpeech.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                override fun onStart(p0: String?) {
                    lifecycleScope.launch(Dispatchers.Main) {
                        isPlaying = true
                        pab.setCompoundDrawablesWithIntrinsicBounds(
                            null,
                            null,
                            view.resources.getDrawable(R.drawable.ic_baseline_pause_24),
                            null
                        )
                    }
                }

                override fun onDone(p0: String?) {
                    lifecycleScope.launch(Dispatchers.Main) {
                        isPlaying = false
                        pab.setCompoundDrawablesWithIntrinsicBounds(null,null,view.resources.getDrawable(R.drawable.ic_baseline_play_arrow_24),null)

                    }
                }

                override fun onError(p0: String?) {
//                        isPlaying = false
                }

                override fun onStop(utteranceId: String?, interrupted: Boolean) {
                    lifecycleScope.launch(Dispatchers.Main) {
                        isPlaying = false
                        pab.setCompoundDrawablesWithIntrinsicBounds(null,null,view.resources.getDrawable(R.drawable.ic_baseline_play_arrow_24),null)
                    }
                }
            })
        }
        pab.setOnClickListener {
            if (!isPlaying)
                textToSpeech.speak(
                    place.about,
                    TextToSpeech.QUEUE_FLUSH,
                    null,
                    TextToSpeech.ACTION_TTS_QUEUE_PROCESSING_COMPLETED
                )
            else textToSpeech.stop()
        }
    }


    override fun onStop() {
        super.onStop()
        textToSpeech.stop()
        textToSpeech.setOnUtteranceProgressListener(null)
    }

    override fun onDestroy() {
        super.onDestroy()
        textToSpeech.shutdown()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val sydney = LatLng(args.placeData.lat, args.placeData.long)
        mMap.addMarker(
            MarkerOptions()
                .position(sydney)
                .title(args.placeData.name)
        )
        val zoomLvl = 15F
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, zoomLvl))
    }
}