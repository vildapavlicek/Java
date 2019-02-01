// JavaScript Document
//script that runs when site is ready
$(document).ready(function(){
//communication with controller on server side to get or post new data from/to viewport
     $("#submit_comment").click(function(){
        $.post("http://localhost:8080/",
        {
        },
        function(data,status){
            alert("Server: " + data);
        });
    });
    
    $("#submit_code").click(function(){
        $.post("http://localhost:8080/",
        {
        },
        function(data,status){
            alert("Server: " + data);
        });
    });
    
    $("#add_new_toilet_location").click(function(){
        $.post("http://localhost:8080/",
        {
        },
        function(data,status){
            alert("Server: " + data);
        });
    });  
});
//global variables

var map;
var src = 'https://storage.googleapis.com/toilet_codes/test_kml.kml';
var failSafety = {lat:49.7856229, lng:15.3653244};
var popup, Popup;

// Close function for close button in Marker menu
function hide(){
   document.getElementById('markerMenu').style.display="none";
}

// add My location Button, search box, add new toilet location
function addButtons (map) {
    var input = document.getElementById('pac-input'); 
    var controlDiv = document.createElement('div');
    var etimeout;
    var myMarker = new google.maps.Marker({
        position: failSafety// JavaScript Document
//script that runs when site is ready
$(document).ready(function(){
//communication with controller on server side to get or post new data from/to viewport
     $("#submit_comment").click(function(){
        $.post("http://localhost:8080/",
        {
        },
        function(data,status){
            alert("Server: " + data);
        });
    });
    
    $("#submit_code").click(function(){
        $.post("http://localhost:8080/",
        {
        },
        function(data,status){
            alert("Server: " + data);
        });
    });
    
    $("#add_new_toilet_location").click(function(){
        $.post("http://localhost:8080/",
        {
        },
        function(data,status){
            alert("Server: " + data);
        });
    });  
});
//global variables

var map;
var src = 'https://storage.googleapis.com/toilet_codes/test_kml.kml';
var failSafety = {lat:49.7856229, lng:15.3653244};
var popup, Popup;

// Close function for close button in Marker menu
function hide(){
   document.getElementById('markerMenu').style.display="none";
}

// add My location Button, search box, add new toilet location
function addButtons (map) {
    var input = document.getElementById('pac-input'); 
    var controlDiv = document.createElement('div');
    var etimeout;
    var myMarker = new google.maps.Marker({
        position: failSafety
    });
    var markers = [];
    var infowindow = new google.maps.InfoWindow();
    var imgX, animationInterval;
    
    //add search box for user to pinpoint his location manualy    
    var searchBox = new google.maps.places.SearchBox(input);
    searchBox.setBounds(map.getBounds());
    // Bias the SearchBox results towards current map's viewport.
    map.addListener('bounds_changed', function() {
        searchBox.setBounds(map.getBounds());
    });
    
    // Listen for the event fired when the user selects a prediction and retrieve
    // more details for that place.
    
    searchBox.addListener('places_changed', function() {
        var places = searchBox.getPlaces();
        if (places.length == 0) {
            return;
        }
        // Clear out the old markers.
        markers.forEach(function(marker) {
            marker.setMap(null);
        });
        markers = [];
        // For each place, get the icon, name and location.
        var bounds = new google.maps.LatLngBounds();
        places.forEach(function(place) {
            if (!place.geometry) {
                console.log("Returned place contains no geometry");
                return;
            }
            var icon = {
                url: place.icon,
                size: new google.maps.Size(71, 71),
                origin: new google.maps.Point(0, 0),
                anchor: new google.maps.Point(17, 34),
                scaledSize: new google.maps.Size(25, 25)
            };
            // Create a marker for each place.
            markers.push(new google.maps.Marker({
                map: map,
                icon: icon,
                title: place.name,
                position: place.geometry.location,
                animation: google.maps.Animation.DROP
            }));
            
            if (place.geometry.viewport) {
                // Only geocodes have viewport.
                bounds.union(place.geometry.viewport);
            }
            else {
                bounds.extend(place.geometry.location);
            }
        });
        map.fitBounds(bounds);
    });
    //creates my location button
    var firstChild = document.createElement('button');
    firstChild.style.backgroundColor = '#fff';
    firstChild.style.border = 'none';
    firstChild.style.outline = 'none';
    firstChild.style.width = '28px';
    firstChild.style.height = '28px';
    firstChild.style.borderRadius = '2px';
    firstChild.style.boxShadow = '0 1px 4px -1px rgba(0,0,0,0.3)';
    firstChild.style.cursor = 'pointer';
    firstChild.style.marginBottom = '14px';
    firstChild.style.marginRight = '10px';
    firstChild.style.padding = '0';
    firstChild.title = 'Your Location';
    controlDiv.appendChild(firstChild);
    //add My location icon to the button   
    var secondChild = document.createElement('div');
    secondChild.style.margin = '5px';
    secondChild.style.width = '18px';
    secondChild.style.height = '18px';
    secondChild.style.backgroundImage = 'url(https://maps.gstatic.com/tactile/mylocation/mylocation-sprite-2x.png)';
    secondChild.style.backgroundSize = '180px 18px';
    secondChild.style.backgroundPosition = '0 0';
    secondChild.style.backgroundRepeat = 'no-repeat';
    firstChild.appendChild(secondChild);
    
    controlDiv.appendChild(input);
    //creates new toilet location button
    var thirdChild = document.createElement('button');
    thirdChild.id = 'add_new_toilet_location';
    thirdChild.className = 'add_new_toilet_location';
    thirdChild.style.color = 'black';
    thirdChild.innerHTML = 'ADD NEW TOILET';
    thirdChild.style.fontWeight = 'bold';
    thirdChild.style.backgroundColor = '#fff';
    thirdChild.style.border = 'none';
    thirdChild.style.outline = 'none';
    thirdChild.style.width = '125px';
    thirdChild.style.verticalAlign = 'bottom';  
    thirdChild.style.height = '28px';
    thirdChild.style.borderRadius = '2px';
    thirdChild.style.boxShadow = '0 1px 4px -1px rgba(0,0,0,0.3)';
    thirdChild.style.cursor = 'pointer';
    thirdChild.style.marginBottom = '14px';
    thirdChild.style.marginRight = '10px';
    thirdChild.style.padding = '0';
    thirdChild.title = 'New Toilet Location';
    controlDiv.appendChild(thirdChild);
        
    google.maps.event.addListener(map, 'center_changed', function () {
        secondChild.style['background-position'] = '0 0';
    });

    //click event for new toilet button
    thirdChild.addEventListener('click', function (){
        if(navigator.geolocation) {
            etimeout = setTimeout(function(){
                geo_Error(10);
                }, 30000
            );
            navigator.geolocation.getCurrentPosition(geo_new_toilet,geo_Error,geo_options);
        } 
        else {
            clearTimeout(etimeout);             
            geo_Error(11);            
        }
        
        
    });
    // click event for my location button
    firstChild.addEventListener('click', function () {
        imgX = '0';
        animationInterval = setInterval(function () {
            imgX = imgX === '-18' ? '0' : '-18';
            secondChild.style['background-position'] = imgX+'px 0';
        }, 500);

        if(navigator.geolocation) {
            etimeout = setTimeout(function(){
                geo_Error(10);
                }, 30000
            );
            navigator.geolocation.getCurrentPosition(geo_position,geo_Error,geo_options);
        } 
        else {
            clearTimeout(etimeout);
            clearInterval(animationInterval);
            secondChild.style['background-position'] = '0 0';
            myMarker.setMap(null);            
            geo_Error(11);            
        }
    });
    controlDiv.index = 1;
    map.controls[google.maps.ControlPosition.BOTTOM_CENTER].push(controlDiv);
    //handles errors for geolocation
    function geo_Error(error) {
        var checktimeout
        if (error==10){
            clearTimeout(etimeout);
            myMarker.setMap(null);
            clearInterval(animationInterval);
            secondChild.style['background-position'] = '0 0';
            popup.setPosition(map.getCenter());
            popup.setContent("The request to get user location timed out. Try again or answer prompt. Depending on your configuration refresh webpage or change settings.")
            popup.draw();
            $('#content').fadeIn(0);
            $('#content').delay(8000).fadeOut(400);
        }
        else if (error==11){
            clearTimeout(etimeout);
            myMarker.setMap(null);
            clearInterval(animationInterval);
            secondChild.style['background-position'] = '0 0';
            popup.setPosition(map.getCenter());
            popup.setContent("Error: Your browser doesn\'t support geolocation.")
            popup.draw();
            $('#content').fadeIn(0);
            $('#content').delay(8000).fadeOut(400);
        }
        else{
            switch(error.code) {
            case error.PERMISSION_DENIED:
                clearTimeout(etimeout);
                myMarker.setMap(null);
                clearInterval(animationInterval);
                secondChild.style['background-position'] = '0 0';
                popup.setPosition(map.getCenter());
                popup.setContent("User denied the request for Geolocation.")
                popup.draw();
                $('#content').fadeIn(0);
                $('#content').delay(3000).fadeOut(400);
                break;
            case error.POSITION_UNAVAILABLE:
                clearTimeout(etimeout);
                myMarker.setMap(null);
                clearInterval(animationInterval);
                secondChild.style['background-position'] = '0 0';
                popup.setPosition(map.getCenter());
                popup.setContent("Location information is unavailable.")
                popup.draw();
                $('#content').fadeIn(0);
                $('#content').delay(3000).fadeOut(400);
                break;
            case error.TIMEOUT:
                clearTimeout(etimeout);
                myMarker.setMap(null);
                clearInterval(animationInterval);
                secondChild.style['background-position'] = '0 0';
                popup.setPosition(map.getCenter());
                popup.setContent("The request to get user location timed out. Try again. Depending on your configuration refresh webpage or change settings.")
                popup.draw();
                $('#content').fadeIn(0);
                $('#content').delay(3000).fadeOut(400);
                break;    
            case error.UNKNOWN_ERROR:
                clearTimeout(etimeout);
                myMarker.setMap(null);
                clearInterval(animationInterval);
                secondChild.style['background-position'] = '0 0';
                popup.setPosition(map.getCenter());
                popup.setContent("An unknown error occurred.")
                popup.draw();
                $('#content').fadeIn(0);
                $('#content').delay(3000).fadeOut(400);
                break;   
            }
        }    
    }
    //handles my location positive result from geolocation
    function geo_position(position) {
        var latlng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude); 
        map.setCenter(latlng);
        map.setZoom(16);                  
        myMarker.setPosition(latlng);
        myMarker.setMap(map);
        myMarker.setAnimation(google.maps.Animation.DROP);
        clearInterval(animationInterval);
        secondChild.style['background-position'] = '-144px 0';
        clearTimeout(etimeout);
    }
    // geolocation options
    var geo_options = {
        enableHighAccuracy: true, 
        maximumAge        : 30000, 
        timeout           : 27000
    }
    //handles new toilet positive result from geolocation
    function geo_new_toilet(position){
        clearTimeout(etimeout);
        myMarker.setMap(null);
        
        var info;
        var service = new google.maps.places.PlacesService(map);
        var latlng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
        document.getElementById('comments').innerHTML="";
        // search for nearby places
        service.nearbySearch({
          location: latlng,
          radius: 15,
          type: ['restaurant']
        }, callback);
        // handles the result of search of nearby place
        function callback(results, status) {
            if (status === google.maps.places.PlacesServiceStatus.OK && results.length>0) {
                for (var i = 0; i < results.length; i++) {
                    create_Result_div(results[i]);
                }
            }
            else {
                service.nearbySearch({
                    location: latlng,
                    radius: 500,
                    type: ['restaurant']
                    }, callback);       
            }
        }
        // creates div´s with information about places
        function create_Result_div(place) {
            var place_origin=place;
            var info = document.createElement('button');
            info.setAttribute("data-toggle", "modal");
            info.setAttribute("data-target", "#myModal");
            info.style.display="none";
            info.className = 'resultBox order-1';
            info.innerHTML = place.name;
            info.id = place.geometry.location;
            service.getDetails({
                placeId: place_origin.place_id    
            },get_address);
            function get_address(place,status){
              if (status === google.maps.places.PlacesServiceStatus.OK) {
                    info.innerHTML = info.innerHTML + " <br> " + place.formatted_address;
                    info.style.display="block";                    
                }
                else if (status === google.maps.GeocoderStatus.OVER_QUERY_LIMIT)
                    setTimeout(function() {
                        service.getDetails({
                            placeId: place_origin.place_id    
                        },get_address);
                    }, 200);
            }
            info.addEventListener("click", function(){  
             document.getElementById('NewToiletTitle').innerHTML = this.innerHTML;
             document.getElementById('code').value = "";
             document.getElementById('comment').value = "";
             $("#myModal").modal();   
            });
            document.getElementById('comments').appendChild(info);
              
        }
        document.getElementById('capture').style.display = "none";
        document.getElementById('submit_comment').style.display="none";
        document.getElementById('submit_code').style.display="none";
        document.getElementById('markerMenu').style.display="block";  
    
    }
}

/** Defines the Popup class. "Custom infowindow" */
function definePopupClass() {
  /**
   * A customized popup on the map.
   * @param {!google.maps.LatLng} position
   * @param {!Element} content
   * @constructor
   * @extends {google.maps.OverlayView}
   */
  var container;  
  Popup = function(position, content, map) {
    this.position = position;
    
    container = document.createElement("div");
    container.id="content";
    container.innerHTML = content;
    container.classList.add('popup-bubble-content');

    var pixelOffset = document.createElement('div');
    pixelOffset.classList.add('popup-bubble-anchor');
    pixelOffset.appendChild(container);

    this.anchor = document.createElement('div');
    this.anchor.classList.add('popup-tip-anchor');
    this.anchor.appendChild(pixelOffset);
    this.setMap(map);
    // Optionally stop clicks, etc., from bubbling up to the map.
    this.stopEventPropagation();
  };
  // NOTE: google.maps.OverlayView is only defined once the Maps API has
  // loaded. That is why Popup is defined inside initMap().
  Popup.prototype = Object.create(google.maps.OverlayView.prototype);

  //Popup set position
  Popup.prototype.setPosition = function(position){
    this.position = position;
  };
  //Popup set content
  Popup.prototype.setContent = function(content){
    container.innerHTML = content;
  };
  
  /** Called when the popup is added to the map. */
  Popup.prototype.onAdd = function() {
    this.getPanes().floatPane.appendChild(this.anchor);
  };

  /** Called when the popup is removed from the map. */
  Popup.prototype.onRemove = function() {
    if (this.anchor.parentElement) {
      this.anchor.parentElement.removeChild(this.anchor);
    }
  };

  /** Called when the popup needs to draw itself. */
  Popup.prototype.draw = function() {
    var divPosition = this.getProjection().fromLatLngToDivPixel(this.position);
    // Hide the popup when it is far out of view.
    var display =
        Math.abs(divPosition.x) < 4000 && Math.abs(divPosition.y) < 4000 ?
        'block' :
        'none';

    if (display === 'block') {
      this.anchor.style.left = divPosition.x + 'px';
      this.anchor.style.top = divPosition.y + 'px';
    }
    if (this.anchor.style.display !== display) {
      this.anchor.style.display = display;
    }
  };

  /** Stops clicks/drags from bubbling up to the map. */
  Popup.prototype.stopEventPropagation = function() {
    var anchor = this.anchor;
    anchor.style.cursor = 'auto';

    ['click', 'dblclick', 'contextmenu', 'wheel', 'mousedown', 'touchstart',
     'pointerdown']
        .forEach(function(event) {
          anchor.addEventListener(event, function(e) {
            e.stopPropagation();
          });
        });
  };
}

// initialize map
function initMap() {
    definePopupClass();
    
    var input = document.getElementById('pac-input'); 
    map = new google.maps.Map(document.getElementById('map'), {
        center: new google.maps.LatLng(49.7856229,15.3653244),
        zoom: 8,
        mapTypeId: 'roadmap',
        mapTypeControl: true,
        mapTypeControlOptions: {
            style: google.maps.MapTypeControlStyle.DROPDOWN_MENU,
            position: google.maps.ControlPosition.TOP_LEFT
        },
        zoomControl: true,
        zoomControlOptions: {
        position: google.maps.ControlPosition.RIGHT_CENTER
        },
        streetViewControl: true,
        streetViewControlOptions: {
            position: google.maps.ControlPosition.TOP_RIGHT
        },
        fullscreenControl: false,
        scaleControl: false  
    });

    popup = new Popup(
        new google.maps.LatLng(-33.866, 151.196),
        "haha",map);
    
    addButtons(map);
       
    // adds KML data of toilet markers with data to map
    var kmlLayer = new google.maps.KmlLayer(src, {
        suppressInfoWindows: true,
        preserveViewport: true,
        map: map
    });
    kmlLayer.addListener('click', function(event) {
        var content = event.featureData.infoWindowHtml;
        var testimonial = document.getElementById('capture');
        testimonial.innerHTML = content;
        document.getElementById('capture').style.display = "block";
        document.getElementById('comments').innerHTML = "";
        document.getElementById('submit_comment').style.display="block";
        document.getElementById('submit_code').style.display="block";
        document.getElementById('markerMenu').style.display="block";
        
    });
}

    });
    var markers = [];
    var infowindow = new google.maps.InfoWindow();
    var imgX, animationInterval;
    
    //add search box for user to pinpoint his location manualy    
    var searchBox = new google.maps.places.SearchBox(input);
    searchBox.setBounds(map.getBounds());
    // Bias the SearchBox results towards current map's viewport.
    map.addListener('bounds_changed', function() {
        searchBox.setBounds(map.getBounds());
    });
    
    // Listen for the event fired when the user selects a prediction and retrieve
    // more details for that place.
    
    searchBox.addListener('places_changed', function() {
        var places = searchBox.getPlaces();
        if (places.length == 0) {
            return;
        }
        // Clear out the old markers.
        markers.forEach(function(marker) {
            marker.setMap(null);
        });
        markers = [];
        // For each place, get the icon, name and location.
        var bounds = new google.maps.LatLngBounds();
        places.forEach(function(place) {
            if (!place.geometry) {
                console.log("Returned place contains no geometry");
                return;
            }
            var icon = {
                url: place.icon,
                size: new google.maps.Size(71, 71),
                origin: new google.maps.Point(0, 0),
                anchor: new google.maps.Point(17, 34),
                scaledSize: new google.maps.Size(25, 25)
            };
            // Create a marker for each place.
            markers.push(new google.maps.Marker({
                map: map,
                icon: icon,
                title: place.name,
                position: place.geometry.location,
                animation: google.maps.Animation.DROP
            }));
            
            if (place.geometry.viewport) {
                // Only geocodes have viewport.
                bounds.union(place.geometry.viewport);
            }
            else {
                bounds.extend(place.geometry.location);
            }
        });
        map.fitBounds(bounds);
    });
    //creates my location button
    var firstChild = document.createElement('button');
    firstChild.style.backgroundColor = '#fff';
    firstChild.style.border = 'none';
    firstChild.style.outline = 'none';
    firstChild.style.width = '28px';
    firstChild.style.height = '28px';
    firstChild.style.borderRadius = '2px';
    firstChild.style.boxShadow = '0 1px 4px -1px rgba(0,0,0,0.3)';
    firstChild.style.cursor = 'pointer';
    firstChild.style.marginBottom = '14px';
    firstChild.style.marginRight = '10px';
    firstChild.style.padding = '0';
    firstChild.title = 'Your Location';
    controlDiv.appendChild(firstChild);
    //add My location icon to the button   
    var secondChild = document.createElement('div');
    secondChild.style.margin = '5px';
    secondChild.style.width = '18px';
    secondChild.style.height = '18px';
    secondChild.style.backgroundImage = 'url(https://maps.gstatic.com/tactile/mylocation/mylocation-sprite-2x.png)';
    secondChild.style.backgroundSize = '180px 18px';
    secondChild.style.backgroundPosition = '0 0';
    secondChild.style.backgroundRepeat = 'no-repeat';
    firstChild.appendChild(secondChild);
    
    controlDiv.appendChild(input);
    //creates new toilet location button
    var thirdChild = document.createElement('button');
    thirdChild.id = 'add_new_toilet_location';
    thirdChild.className = 'add_new_toilet_location';
    thirdChild.style.color = 'black';
    thirdChild.innerHTML = 'ADD NEW TOILET';
    thirdChild.style.fontWeight = 'bold';
    thirdChild.style.backgroundColor = '#fff';
    thirdChild.style.border = 'none';
    thirdChild.style.outline = 'none';
    thirdChild.style.width = '150px';
    thirdChild.style.verticalAlign = 'bottom';  
    thirdChild.style.height = '28px';
    thirdChild.style.borderRadius = '2px';
    thirdChild.style.boxShadow = '0 1px 4px -1px rgba(0,0,0,0.3)';
    thirdChild.style.cursor = 'pointer';
    thirdChild.style.marginBottom = '14px';
    thirdChild.style.marginRight = '10px';
    thirdChild.style.padding = '0';
    thirdChild.title = 'New Toilet Location';
    controlDiv.appendChild(thirdChild);
        
    google.maps.event.addListener(map, 'center_changed', function () {
        secondChild.style['background-position'] = '0 0';
    });

    //click event for new toilet button
    thirdChild.addEventListener('click', function (){
        if(navigator.geolocation) {
            etimeout = setTimeout(function(){
                geo_Error(10);
                }, 30000
            );
            navigator.geolocation.getCurrentPosition(geo_new_toilet,geo_Error,geo_options);
        } 
        else {
            clearTimeout(etimeout);            
            myMarker.setMap(null);  
            geo_Error(11);            
        }
        
        
    });
    // click event for my location button
    firstChild.addEventListener('click', function () {
        imgX = '0';
        animationInterval = setInterval(function () {
            imgX = imgX === '-18' ? '0' : '-18';
            secondChild.style['background-position'] = imgX+'px 0';
        }, 500);

        if(navigator.geolocation) {
            etimeout = setTimeout(function(){
                geo_Error(10);
                }, 30000
            );
            navigator.geolocation.getCurrentPosition(geo_position,geo_Error,geo_options);
        } 
        else {
            clearTimeout(etimeout);
            clearInterval(animationInterval);
            secondChild.style['background-position'] = '0 0';
            myMarker.setMap(null);            
            geo_Error(11);            
        }
    });
    controlDiv.index = 1;
    map.controls[google.maps.ControlPosition.BOTTOM_CENTER].push(controlDiv);
    //handles errors for geolocation
    function geo_Error(error) {
        var checktimeout
        if (error==10){
            clearTimeout(etimeout);
            myMarker.setMap(null);
            clearInterval(animationInterval);
            secondChild.style['background-position'] = '0 0';
            popup.setPosition(map.getCenter());
            popup.setContent("The request to get user location timed out. Try again or answer prompt. Depending on your configuration refresh webpage or change settings.")
            popup.draw();
            $('#content').fadeIn(0);
            $('#content').delay(8000).fadeOut(400);
        }
        else if (error==11){
            clearTimeout(etimeout);
            myMarker.setMap(null);
            clearInterval(animationInterval);
            secondChild.style['background-position'] = '0 0';
            popup.setPosition(map.getCenter());
            popup.setContent("Error: Your browser doesn\'t support geolocation.")
            popup.draw();
            $('#content').fadeIn(0);
            $('#content').delay(8000).fadeOut(400);
        }
        else{
            switch(error.code) {
            case error.PERMISSION_DENIED:
                clearTimeout(etimeout);
                myMarker.setMap(null);
                clearInterval(animationInterval);
                secondChild.style['background-position'] = '0 0';
                popup.setPosition(map.getCenter());
                popup.setContent("User denied the request for Geolocation.")
                popup.draw();
                $('#content').fadeIn(0);
                $('#content').delay(3000).fadeOut(400);
                break;
            case error.POSITION_UNAVAILABLE:
                clearTimeout(etimeout);
                myMarker.setMap(null);
                clearInterval(animationInterval);
                secondChild.style['background-position'] = '0 0';
                popup.setPosition(map.getCenter());
                popup.setContent("Location information is unavailable.")
                popup.draw();
                $('#content').fadeIn(0);
                $('#content').delay(3000).fadeOut(400);
                break;
            case error.TIMEOUT:
                clearTimeout(etimeout);
                myMarker.setMap(null);
                clearInterval(animationInterval);
                secondChild.style['background-position'] = '0 0';
                popup.setPosition(map.getCenter());
                popup.setContent("The request to get user location timed out. Try again. Depending on your configuration refresh webpage or change settings.")
                popup.draw();
                $('#content').fadeIn(0);
                $('#content').delay(3000).fadeOut(400);
                break;    
            case error.UNKNOWN_ERROR:
                clearTimeout(etimeout);
                myMarker.setMap(null);
                clearInterval(animationInterval);
                secondChild.style['background-position'] = '0 0';
                popup.setPosition(map.getCenter());
                popup.setContent("An unknown error occurred.")
                popup.draw();
                $('#content').fadeIn(0);
                $('#content').delay(3000).fadeOut(400);
                break;   
            }
        }    
    }
    //handles my location positive result from geolocation
    function geo_position(position) {
        var latlng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude); 
        map.setCenter(latlng);
        map.setZoom(16);                  
        myMarker.setPosition(latlng);
        myMarker.setMap(map);
        myMarker.setAnimation(google.maps.Animation.DROP);
        clearInterval(animationInterval);
        secondChild.style['background-position'] = '-144px 0';
        clearTimeout(etimeout);
    }
    // geolocation options
    var geo_options = {
        enableHighAccuracy: true, 
        maximumAge        : 30000, 
        timeout           : 27000
    }
    //handles new toilet positive result from geolocation
    function geo_new_toilet(position){
        clearTimeout(etimeout);
        myMarker.setMap(null);
        var info;
        var service = new google.maps.places.PlacesService(map);
        var latlng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude); 
        // search for nearby places
        service.nearbySearch({
          location: latlng,
          radius: 5,
          type: ['restaurant']
        }, callback);
        // handles the result of search of nearby place
        function callback(results, status) {
            if (status === google.maps.places.PlacesServiceStatus.OK && results.length>0) {
                for (var i = 0; i < results.length; i++) {
                    create_Result_div(results[i],i);
                }
            }
            else {
                service.nearbySearch({
                    location: latlng,
                    radius: 5,
                    type: ['restaurant']
                    }, callback);
            }
        }
        function create_Result_div(place,num) {
            info = document.createElement('div');
            info.className = 'order-1';
            info.innerHTML = place.name;
            document.getElementById('comments').appendChild(info);
              
        }
        document.getElementById('capture').innerHTML = "";
        document.getElementById('submit_comment').style.display="none";
        document.getElementById('submit_code').style.display="none";
        document.getElementById('submit_new_toilet_location').style.display="block";
        document.getElementById('markerMenu').style.display="block";  
    }
}

/** Defines the Popup class. "Custom infowindow" */
function definePopupClass() {
  /**
   * A customized popup on the map.
   * @param {!google.maps.LatLng} position
   * @param {!Element} content
   * @constructor
   * @extends {google.maps.OverlayView}
   */
  var container;  
  Popup = function(position, content, map) {
    this.position = position;
    
    container = document.createElement("div");
    container.id="content";
    container.innerHTML = content;
    container.classList.add('popup-bubble-content');

    var pixelOffset = document.createElement('div');
    pixelOffset.classList.add('popup-bubble-anchor');
    pixelOffset.appendChild(container);

    this.anchor = document.createElement('div');
    this.anchor.classList.add('popup-tip-anchor');
    this.anchor.appendChild(pixelOffset);
    this.setMap(map);
    // Optionally stop clicks, etc., from bubbling up to the map.
    this.stopEventPropagation();
  };
  // NOTE: google.maps.OverlayView is only defined once the Maps API has
  // loaded. That is why Popup is defined inside initMap().
  Popup.prototype = Object.create(google.maps.OverlayView.prototype);

  //Popup set position
  Popup.prototype.setPosition = function(position){
    this.position = position;
  };
  //Popup set content
  Popup.prototype.setContent = function(content){
    container.innerHTML = content;
  };
  
  /** Called when the popup is added to the map. */
  Popup.prototype.onAdd = function() {
    this.getPanes().floatPane.appendChild(this.anchor);
  };

  /** Called when the popup is removed from the map. */
  Popup.prototype.onRemove = function() {
    if (this.anchor.parentElement) {
      this.anchor.parentElement.removeChild(this.anchor);
    }
  };

  /** Called when the popup needs to draw itself. */
  Popup.prototype.draw = function() {
    var divPosition = this.getProjection().fromLatLngToDivPixel(this.position);
    // Hide the popup when it is far out of view.
    var display =
        Math.abs(divPosition.x) < 4000 && Math.abs(divPosition.y) < 4000 ?
        'block' :
        'none';

    if (display === 'block') {
      this.anchor.style.left = divPosition.x + 'px';
      this.anchor.style.top = divPosition.y + 'px';
    }
    if (this.anchor.style.display !== display) {
      this.anchor.style.display = display;
    }
  };

  /** Stops clicks/drags from bubbling up to the map. */
  Popup.prototype.stopEventPropagation = function() {
    var anchor = this.anchor;
    anchor.style.cursor = 'auto';

    ['click', 'dblclick', 'contextmenu', 'wheel', 'mousedown', 'touchstart',
     'pointerdown']
        .forEach(function(event) {
          anchor.addEventListener(event, function(e) {
            e.stopPropagation();
          });
        });
  };
}

// initialize map
function initMap() {
    definePopupClass();
    
    var input = document.getElementById('pac-input'); 
    map = new google.maps.Map(document.getElementById('map'), {
        center: new google.maps.LatLng(49.7856229,15.3653244),
        zoom: 8,
        mapTypeId: 'roadmap',
        mapTypeControl: true,
        mapTypeControlOptions: {
            style: google.maps.MapTypeControlStyle.DROPDOWN_MENU,
            position: google.maps.ControlPosition.TOP_LEFT
        },
        zoomControl: true,
        zoomControlOptions: {
        position: google.maps.ControlPosition.RIGHT_CENTER
        },
        streetViewControl: true,
        streetViewControlOptions: {
            position: google.maps.ControlPosition.TOP_RIGHT
        },
        fullscreenControl: false,
        scaleControl: false  
    });

    popup = new Popup(
        new google.maps.LatLng(-33.866, 151.196),
        "haha",map);
    
    addButtons(map);
       
    // adds KML data of toilet markers with data to map
    var kmlLayer = new google.maps.KmlLayer(src, {
        suppressInfoWindows: true,
        preserveViewport: true,
        map: map
    });
    kmlLayer.addListener('click', function(event) {
        var content = event.featureData.infoWindowHtml;
        var testimonial = document.getElementById('capture');
        testimonial.innerHTML = content;
        document.getElementById('submit_comment').style.display="block";
        document.getElementById('submit_code').style.display="block";
        document.getElementById('submit_new_toilet_location').style.display="none";
        document.getElementById('markerMenu').style.display="block";
        
    });
}
