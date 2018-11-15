#!/bin/bash

GEOURL=https://www.ipinfodb.com/my_ip_location.php
WEAURL=http://forecast.weather.gov/zipcity.php?inputstring=

# Get zip code
wget -q -O /tmp/geo.html $GEOURL
ZIPCODE=$(grep -A 1 Postcode /tmp/geo.html | tail -n 1 | cut -d' ' -f1)

# Get temperature
wget -q -O /tmp/weather.html $WEAURL$ZIPCODE
TEMP=$(grep 'myforecast-current-lrg' /tmp/weather.html| cut -d'&' -f1 | cut -d'>' -f2)
echo "Current Temp: ${TEMP}F"