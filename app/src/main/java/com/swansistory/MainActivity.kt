package com.swansistory

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.swansistory.room.Place
import com.swansistory.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("init", Context.MODE_PRIVATE)
        if(sharedPreferences.getBoolean("initialize", true)) {
            sharedPreferences.edit().putBoolean("initialize",false).apply()

            val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
            viewModel.addPlace(
                Place(
                    "Three Cliff Bay",
                    "Southgate SA3 2HD, United Kingdom",
                    "three_cliffs_bay",
                    51.56845939497022,
                    -4.113292576887413,
                    false,
                    "This breathtakingly beautiful bay is situated on the south coast of the Gower Peninsula. So named for the three cliffs that jut into the bay, it's a perfect place for a walk or picnic.\n Although getting down to the beach can be a bit steep and cumbersome, the view is worth every step. Many tourists enjoy the spot so much, they park caravans nearby to enjoy a camping holiday. Others bring their dogs along to frolic in the water."
                )
            )
            viewModel.addPlace(
                Place(
                    "Clyne Gardens",
                    "Mayals, Swansea SA3 5BW, United Kingdom",
                    "clyne_gardens",
                    51.596054545699616,
                    -4.003003159823835,
                    false,
                    "Swansea boasts many magnificent parks, but its Clyne Gardens are perhaps the city's most popular green space. Famed for its colorful displays of rhododendrons and azaleas, this superb botanical garden – once part of the old Swansea Castle – consists of 47 acres of parkland and gardens. All told, the grounds feature more than 2,000 species of plants, including over 800 varieties of the aforementioned rhododendrons.\n" +
                            "A lovely gazebo is a park highlight and was built by an old admiral in order to keep an eye on ships entering Swansea Bay. Other features to check out are the bamboo-filled Japanese garden, an artificial lake and waterfall, the bog garden and bluebell wood, as well as the 1908 Clyne Chapel."
                )
            )
            viewModel.addPlace(
                Place(
                    "Mumbles and Swansea Bay",
                    "Mumbles, SA3, United Kingdom",
                    "mumbles_and_swansea_bay",
                    51.57632093263695,
                    -3.999902508130473,
                    false,
                    "The Mumbles, a headland that is part of wide Swansea Bay, is a wonderful place to walk and explore. Called \"Mwmbwls\" in Welsh, this fishing village sits at the western edge of the bay. Thanks to its long promenade, piers, cafés, restaurants, and numerous entertainment facilities, it's a popular destination for locals and tourists alike.\n" +
                            "The Mumbles is a great place to cycle, rest, or wander while soaking up the refreshing atmosphere. With a bevy of play areas throughout, kids love coming here, too.\n" +
                            "On a hill above the Mumbles lie the ruins of 13th-century Oystermouth Castle with its gatehouse, great hall, and chapel. A prominent lighthouse stands on Mumbles Head, the two cliffs from which the area gained its name."
                )
            )
            viewModel.addPlace(
                Place(
                    "National Waterfront Museum",
                    "Oystermouth Rd, Maritime Quarter, Swansea SA1 3RD, United Kingdom",
                    "national_waterfront_museum",
                    51.616397724610714,
                    -3.9390385309840297,
                    false,
                    "A mere 10-minute walk from the Glynn Vivian Art Gallery, the architecturally stunning National Waterfront Museum (Amgueddfa Genedlaethol y Glannau) is a must-see when in Swansea. Highlighting over 300 years of industry and innovation in Wales, this fun museum uses hi-tech displays and exhibits to show just how important the region was to the development of Britain.\n" +
                            "Highlights of the museum's 15 themed galleries are old steam-powered machines and engines, as well as maritime-related artifacts. Once you've had your fill of innovation, walk by the Swansea Docks to the Swansea Marina, where you can gawk at sailing vessels and inhale the deep-sea air."
                )
            )
            viewModel.addPlace(
                Place(
                    "Museum and Dylan Thomas Center",
                    "6 Somerset Pl, Swansea SA1 1RR, United Kingdom",
                    "d1",
                    51.61936232276159,
                    -3.9356777021477507,
                    false,
                    "No visit to this Welsh city is complete without taking a look at the Swansea Museum. The oldest museum in Wales, Swansea Museum was established in 1841.\n" +
                            "Today a visit to this fine establishment is undoubtedly one of the best things to do for free in Swansea. Among its six galleries are everything from ancient Egyptian mummies to fascinating exhibits dealing with life in the city during two World Wars.\n" +
                            "Swansea Museum also has a number of interesting annexes. Located in the city's Maritime Quarter are a number of historic vessels, including a lightship and a tugboat, as well as a large collection of memorabilia and artefacts related to public transit housed in the city's former tram shed.\n" +
                            "Also worth seeing, the Dylan Thomas Centre houses a great exhibition focussing on the work and life of the great Welsh poet. It also serves as a focal point for a variety of literary events and festivals – including the annual Dylan Thomas Festival held each autumn – as well as performances and book readings"
                )
            )
            viewModel.addPlace(
                Place(
                    "Swansea Castle",
                    "8 Castle St, Swansea SA1 1DW, United Kingdom",
                    "swansea_castle",
                    51.62116596267943,
                    -3.942221873311552,
                    false,
                    "Swansea Castle (Welsh: Castell Abertawe) is located in the city centre of Swansea, Wales, UK. It was founded by Henry de Beaumont in 1107 as the caput of the lordship of Gower. The castle is now ruined and only two blocks remain, though the site has been improved in the 2010s for use as a public space. \n" +
                            "Swansea Castle is located on the east side of the city centre, facing Castle Square (the River Tawe used to flow a short distance east on what is now the Strand).[2] Originally covering 4.6 acres (1.9 ha), the surviving remains of the square castle include residential blocks, together with a section of parapet wall forming an L-shape to the southeast. There are five tunnel-vaulted basement rooms."
                )
            )
            viewModel.addPlace(
                Place(
                    "Rhossili Downs",
                    "Rhossili Bay, United Kingdom",
                    "rhosilli",
                    51.56423417261302,
                    -4.307032110285456,
                    false,
                    "Rhossili is located in the most Western part of the Gower Peninsula. The most photographed part of Gower, The Worms Head, stretches out to sea and becomes an island when the tide comes in. The breathtaking view is completed by the long sandy beach and the towering cliffs and this makes it a popular destination throughout the year with surfers, paragliders and ramblers. However, Rhossili still manages to maintain its tranquillity and unspoilt beauty"
                )
            )
        }
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        //ActionBarConfiguration
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.tab1Fragment,
                R.id.tab2Fragment,
                R.id.tab3Fragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        //BottomNavigationView
        bottomNavigationView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, nd: NavDestination, _ ->
            if (nd.id == R.id.tab1Fragment || nd.id == R.id.tab2Fragment || nd.id == R.id.tab3Fragment) {
                bottomNavigationView.visibility = View.VISIBLE
            } else {
                bottomNavigationView.visibility = View.GONE
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}