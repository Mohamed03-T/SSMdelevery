/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 04/05/2024, 17:24
 *  * @modified : 04/05/2024, 17:24
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

// Make initMap available globally for Google Maps callback
window.initMap = function() {
    // Check if map container exists
    const mapContainer = document.getElementById("map-container");
    if (!mapContainer) {
        console.log("Map container not found on this page");
        return;
    }

    // Map center coordinates - Algiers, Algeria
    const center = { lat: 36.7538, lng: 3.0588 };

    // Map options
    const options = {
        zoom: 7,
        center: center
    };

    // Create the map object
    const map = new google.maps.Map(mapContainer, options);

    fetch('/home/get_location_agencys', {
        method: 'GET', // or 'POST'
        headers: {
            'Content-Type': 'application/json',
            // 'Content-Type': 'application/x-www-form-urlencoded',
        },
    })
        .then(response => response.json())
        .then(data => {


            const locations = []
            for (const location of data) {
                locations.push({ lat: location.locationPoint.latitude, lng: location.locationPoint.longitude, content: location.agencyName })
            }
            for (const location of locations) {
                const marker = new google.maps.Marker({
                    position: location,
                    map: map,
                    icon: "/home/assets/images/icons/flag.png",
                });

                // Optional: Add info window content
                if (location.content) {
                    const infowindow = new google.maps.InfoWindow({
                        content: location.content
                    });

                    marker.addListener("click", () => {
                        infowindow.open(map, marker);
                    });
                }
            }





            console.log(data)})
        .catch((error) => {
            console.error('Error:', error);
        });




    // Define locations
    // const locations = [
    //     { lat: -33.8688, lng: 151.2093, content: "Sydney, Australia",  },
    //     { lat: -37.8136, lng: 144.9631, content: "Melbourne, Australia",},
    //     { lat: -41.2905, lng: 174.7792, content: "Wellington, New Zealand", }
    // ];

    // Add markers to the map

}


