/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 04/05/2024, 23:22
 *  * @modified : 04/05/2024, 23:22
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

var map;
var marker;

// Make initMap available globally for Google Maps callback
window.initMap = function() {
    // Check if map element exists
    const mapElement = document.getElementById('map');
    if (!mapElement) {
        console.log("Map element not found on this page");
        return;
    }

    map = new google.maps.Map(mapElement, {
        center: {lat: 36.7538, lng: 3.0588}, // Algiers, Algeria
        zoom: 6
    });

    // Add a click event listener to the map
    map.addListener('click', function(event) {
        var latitude = event.latLng.lat();
        var longitude = event.latLng.lng();
        updateMarkerAndInputs(latitude, longitude);
    });

    // Add onchange event listeners to the latitude and longitude input fields
    document.getElementById('latitude').addEventListener('change', updateMarkerFromInputs);
    document.getElementById('longitude').addEventListener('change', updateMarkerFromInputs);
}

function updateMarkerAndInputs(latitude, longitude) {
    // Update the latitude and longitude input fields
    document.getElementById('latitude').value = latitude;
    document.getElementById('longitude').value = longitude;

    if (marker) {
        marker.setMap(null);
    }

    marker = new google.maps.Marker({
        position: {lat: latitude, lng: longitude},
        map: map,
        icon: '/home/assets/images/icons/flag.png' // replace with the URL of your icon
    });

    // Move the map to the new marker
    map.panTo(marker.getPosition());

    // Do something with the latitude and longitude
    console.log('Latitude: ' + latitude + ', Longitude: ' + longitude);
}

function updateMarkerFromInputs() {
    var latitude = parseFloat(document.getElementById('latitude').value);
    var longitude = parseFloat(document.getElementById('longitude').value);
    updateMarkerAndInputs(latitude, longitude);
}


function searchLocationProvance(address) {

    fetch('https://maps.googleapis.com/maps/api/geocode/json?address=' + encodeURIComponent(address) + '&key=AIzaSyCCMuVVf83R6O5bfajZud_clhLYfMLYNKg')
        .then(function(response) {
            return response.json();
        })
        .then(function(data) {
            if (data.results && data.results.length > 0) {
                var location = data.results[0].geometry.location;
                map.panTo(new google.maps.LatLng(location.lat, location.lng));

                map.setZoom(9);

            } else {
                console.error('No results found for address: ' + address);
            }
        })
        .catch(function(error) {
            console.error('Error fetching geocoding data: ' + error);
        });
}

function searchLocationCity(address) {

    fetch('https://maps.googleapis.com/maps/api/geocode/json?address=' + encodeURIComponent(address) + '&key=AIzaSyCCMuVVf83R6O5bfajZud_clhLYfMLYNKg')
        .then(function(response) {
            return response.json();
        })
        .then(function(data) {
            if (data.results && data.results.length > 0) {
                var location = data.results[0].geometry.location;
                map.panTo(new google.maps.LatLng(location.lat, location.lng));

                map.setZoom(14);

            } else {
                console.error('No results found for address: ' + address);
            }
        })
        .catch(function(error) {
            console.error('Error fetching geocoding data: ' + error);
        });
}
